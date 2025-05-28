package org.esteban.ManejoDeSesiones.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.esteban.ManejoDeSesiones.services.LoginService;
import org.esteban.ManejoDeSesiones.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login" , "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME ="admin";
    final static String PASSWORD ="12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
        //Implementamos el obj de tipo sesion
        LoginService auth = new LoginServiceSessionImplement();
        //creramos una variable Optionalpara obtener el nombre de usuario
        Optional<String> usernameOptional = auth.getUsername(req);
        //Si el username esta presente queiro que  eustre la infomracion de login exitoso
        if(usernameOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Hola " + usernameOptional.get() + "</title>");
                out.println("<link href=\"" + req.getContextPath() + "/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("</head>");
                out.println("<body class=\"bg-light\">");
                out.println("<div class=\"container mt-5\">");
                out.println("<h1 class=\"display-4 text-primary\">Hola " + usernameOptional.get() + ", ya iniciaste sesión anteriormente!</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/index.html\" class=\"btn btn-primary mt-3\">Volver al inicio</a></p>");
                out.println("<p><a href=\"" + req.getContextPath() + "/logout\" class=\"btn btn-danger mt-2\">Cerrar Sesión</a></p>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals(USERNAME) && password.equals(PASSWORD)){
            HttpSession session = req.getSession();
            //seteo los valores de la sesion
            session.setAttribute("username" , username);

            resp.sendRedirect(req.getContextPath()+"/login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo Siento no tiene acceso" );
        }
    }
}
