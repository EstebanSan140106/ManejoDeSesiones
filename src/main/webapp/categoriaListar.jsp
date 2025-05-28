<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 28/5/2025
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, org.esteban.ManejoDeSesiones.models.*" %>
<%
    List<Categoría> categorias = (List<Categoría>) request.getAttribute("categorías");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
%>
<html>
<head>
    <title>Listado Categorías</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<h1>Listado Categorías</h1>
<table>
    <thead>
    <th>ID Categoría</th>
    <th>Nombre</th>
    <th>Descripción</th>
    <th>Condición</th>
    <th>Acciones</th>
    </thead>
    <%
        for (Categoría cat : categorias) { %>
    <tbody>
    <td><%cat.getIdCategoria();    %></td>
    <td><%cat.getNombre();%></td>
    <td><%cat.getDescripcion();%></td>
    <td><%cat.getCondicion();%></td>
   <td> <a href="">Editar</a></td>
    <td><a href="">Activar o Desasctivar</a></td>
    </tbody>
    <% }
    %>

</table>
</body>
</html>
