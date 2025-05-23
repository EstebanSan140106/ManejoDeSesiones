package controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.LoginService;
import services.LoginServiceSessionImplement;

import java.io.IOException;
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
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
}