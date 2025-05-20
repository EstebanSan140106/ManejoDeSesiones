package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Productos;
import services.LoginService;
import services.LoginServiceSessionImplement;
import services.ProductoService;
import services.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

// Anotación que mapea el servlet a la URL "/productos"
@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {

    // Método que maneja las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Instancia el servicio de login para manejar sesiones
        LoginService session = new LoginServiceSessionImplement();
        // Obtiene el nombre de usuario de la sesión, si existe
        Optional<String> usernameOptional = session.getUsername(req);

        // Instancia el servicio de productos para obtener la lista de productos
        ProductoService service = new ProductoServiceImplement();
        // Obtiene la lista de productos desde el servicio
        List<Productos> productos = service.listar();

        // Verifica si hay un usuario autenticado
        boolean mostrarP = usernameOptional.isPresent();

        // Configura la respuesta HTTP con tipo de contenido HTML y codificación UTF-8
        resp.setContentType("text/html;charset=UTF-8");
        // Obtiene el escritor para enviar la respuesta HTML
        PrintWriter out = resp.getWriter();

        // Comienza a escribir el documento HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Listar Productos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listar Productos</h1>");

        // Si hay un usuario autenticado, muestra un mensaje de bienvenida
        if (mostrarP) {
            out.println("<h2>Hola " + usernameOptional.get() + ", Bienvenido!</h2>");
        }

        // Crea una tabla HTML para mostrar los productos
        out.println("<table>");
        out.println("<tr>");
        out.println("<th> ID PRODUCTO </th>");
        out.println("<th> NOMBRE </th>");
        out.println("<th> TIPO </th>");
        // Si el usuario está autenticado, muestra la columna de precio
        if (mostrarP) {
            out.println("<th> PRECIO </th>");
        }
        out.println("</tr>");

        // Itera sobre la lista de productos y genera una fila por cada producto
        productos.forEach(p -> {
            out.println("<tr>");
            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getNombre() + "</td>");
            out.println("<td>" + p.getTipo() + "</td>");
            // Si el usuario está autenticado, muestra el precio del producto
            if (mostrarP) {
                out.println("<td>" + p.getPrecio() + "</td>");
            }
            out.println("</tr>");
        });

        // Cierra la tabla y el documento HTML
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}