package org.esteban.ManejoDeSesiones.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.esteban.ManejoDeSesiones.models.Productos;
import org.esteban.ManejoDeSesiones.services.LoginService;
import org.esteban.ManejoDeSesiones.services.LoginServiceSessionImplement;
import org.esteban.ManejoDeSesiones.services.ProductoService;
import org.esteban.ManejoDeSesiones.services.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
        ProductoService service = new ProductoServiceImplement();
        List<Productos> productos = service.listar();try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Listar Productos</title>");
            // Include Bootstrap CSS (using CDN for simplicity; replace with local path if needed)
            out.println("<link href=\"bootstrap.min.css\" rel=\"stylesheet\">");
            // Optional: Add custom styles if needed
            out.println("<style>");
            out.println("body { padding-top: 20px; }");
            out.println(".table th, .table td { vertical-align: middle; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1 class=\"mb-4\">Listar Productos</h1>");
            // Use Bootstrap table classes for styling
            out.println("<div class=\"table-responsive\">");
            out.println("<table class=\"table table-striped table-hover table-bordered\">");
            out.println("<thead class=\"table-dark\">");
            out.println("<tr>");
            out.println("<th scope=\"col\">ID Producto</th>");
            out.println("<th scope=\"col\">Nombre</th>");
            out.println("<th scope=\"col\">Tipo</th>");
            out.println("<th scope=\"col\">Precio</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                out.println("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            });
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            // Include Bootstrap JS for interactivity (optional, if needed for components like modals)
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

