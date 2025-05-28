package org.esteban.ManejoDeSesiones.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.esteban.ManejoDeSesiones.models.Categoría;
import org.esteban.ManejoDeSesiones.services.CategoriaService;
import org.esteban.ManejoDeSesiones.services.CategoriaServiceJdbcImplement;
import org.esteban.ManejoDeSesiones.services.LoginService;
import org.esteban.ManejoDeSesiones.services.LoginServiceSessionImplement;
import org.esteban.ManejoDeSesiones.util.Conexion;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet ("/categoria")
public class CategoríaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //creamos la conexion
        Connection con = (Connection) req.getAttribute("con");
        //Creammos el nuevo objeto de Catgoria
        CategoriaService service = new CategoriaServiceJdbcImplement(con);
        List<Categoría> categorias = service.listar();

        //Obtengo el username
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> username = auth.getUsername(req);
        //seteamos los parametros
        req.setAttribute("categorías" , categorias);
        req.setAttribute("username" ,username);
        //redireccionamos a la  vista de categorias

        getServletContext().getRequestDispatcher("/categoriaListar.jsp").forward(req, resp);
           
    }
}
