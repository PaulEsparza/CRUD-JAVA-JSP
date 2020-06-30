<%-- 
    Document   : Consultar
    Author     : Paul Esparza
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD CONSULTAR</title>
    </head>
    <body>
        <div>
            <%
                    UsuarioDAO dao = new UsuarioDAO();
                    int id = Integer.parseInt((String)request.getAttribute("idU"));
                    Usuario u = (Usuario) dao.list(id);
            %>
            <h1>Consultar Usuario</h1>
            <form action="Controlador">
                <label for="txtUsuario">Nombre Usuario:</label>
                <input type="text" name="txtUsuario" placeholder="Nombre Usuario" value="<%= u.getUsuario() %>" disabled>
                </br></br>
                <!--<label for="txtContrasena">Contraseña:</label>
                <input type="password" name="txtContrasena" placeholder="Contraseña" value="<%= u.getContrasena() %>" disabled>-->
                </br></br>
                <label for="tipo">Tipo:</label>
                <select name="tipo" size="1" disabled>
                    <option><%= u.getTipo()%></option>
                </select>
                </br></br>
                <input type="hidden" name="txtID" value="<%= u.getId() %>">
                <br>
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
