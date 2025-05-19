package controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Productos;
import services.ProductoService;
import services.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
        ProductoService service = new ProductoServiceImplement();
        List<Productos> productos = service.listar();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Listar Productos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listar Productos</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th> ID PRODUCTO </th>");
        out.println("<th> NOMBRE </th>");
        out.println("<th> TIPO </th>");
        out.println("<th> PRECIO </th>");
        out.println("</tr>");
        productos.forEach(p-> {
            out.println("<tr>");
            out.println("<td>"+p.getId()+"</td>");
            out.println("<td>"+p.getNombre()+"</td>");
            out.println("<td>"+p.getTipo()+"</td>");
            out.println("<td>"+p.getPrecio()+"</td>");
            out.println("</tr>");
        });
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}

