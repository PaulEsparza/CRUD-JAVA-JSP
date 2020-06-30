<%-- 
    Document   : Buscar
    Author     : Paul Esparza
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD</title>
    </head>
    <body>
        <div>
            <h1>USUARIOS REGISTRADOS</h1>
            <a href="Controlador?accion=crear">Agregar Nuevo Usuario</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>USUARIO</th>
                        <th>TIPO USUARIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao = new UsuarioDAO();
                    List<Usuario> list = dao.listar();
                    Iterator<Usuario> i = list.iterator();
                    Usuario usu = null;
                    while (i.hasNext()) {
                            usu = i.next();
                %>
                <tbody>
                    <tr>
                        <td><%= usu.getId() %></td>
                        <td><%= usu.getUsuario()%></td>
                        <td><%= usu.getTipo()%></td>
                        <td>
                            <a href="Controlador?accion=consultar&id=<%= usu.getId() %>">Consultar</a>
                            <a href="Controlador?accion=editar&id=<%= usu.getId() %>">Editar</a>
                            <a href="Controlador?accion=eliminar&id=<%= usu.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
