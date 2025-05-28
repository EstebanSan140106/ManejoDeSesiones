package org.esteban.ManejoDeSesiones.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.esteban.ManejoDeSesiones.services.LoginService;
import org.esteban.ManejoDeSesiones.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet ("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //Creamos el objeto de tipo sesion
        LoginService auth = new LoginServiceSessionImplement();
        //Creo una variable optional de tipo string
        Optional<String> usernameOptional = auth.getUsername(req);
        if (usernameOptional.isPresent()) {
            HttpSession session = req.getSession();

            session.invalidate();
        }
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<link a href=\"bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("</html>");
        }
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
}