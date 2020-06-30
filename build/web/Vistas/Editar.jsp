<%-- 
    Document   : Editar
    Author     : Paul Esparza
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD EDITAR</title>
    </head>
    <body>
        <div>
            <%
                    UsuarioDAO dao = new UsuarioDAO();
                    int id = Integer.parseInt((String)request.getAttribute("idU"));
                    Usuario u = (Usuario) dao.list(id);
            %>
            <h1>Editar Usuario</h1>
            <form action="Controlador" method="POST">
                <label for="txtUsuario">Nombre Usuario:</label>
                <input type="text" name="txtUsuario" placeholder="Nombre Usuario" value="<%= u.getUsuario() %>">
                </br></br>
                <label for="txtContrasena">Contraseña:</label>
                <input type="password" name="txtContrasena" placeholder="Contraseña" value="<%= u.getContrasena() %>">
                </br></br>
                <label for="tipo">Tipo:</label>
                <select name="tipo" size="1">
                    <option><%= u.getTipo()%></option>
                    <%
                    if(u.getTipo().equalsIgnoreCase("Administrador")){%>
                        <option value="Usuario">Usuario</option>
                    <% } else { %>
                    <option value="Administrador">Administrador</option>
                    <% } %>
                </select>
                </br></br>
                <input type="hidden" name="txtID" value="<%= u.getId() %>">
                <button type="submit" name="btnActualizar" value="actualizar">Editar</button>
                <br>
                <a href="Controlador?accion=listar">Cancelar</a>
            </form>
        </div>
    </body>
</html>