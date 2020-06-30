<%-- 
    Document   : Crear
    Author     : Paul Esparza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD AGREGAR</title>
    </head>
    <body>
        <div>
            <h1>Agregar Usuario</h1>
            <form action="Controlador" method="POST">
                <label for="txtUsuario">Nombre Usuario:</label>
                <input type="text" name="txtUsuario" placeholder="Nombre Usuario">
                </br></br>
                <label for="txtContrasena">Contraseña:</label>
                <input type="password" name="txtContrasena" placeholder="Contraseña">
                </br></br>
                <label for="tipo">Tipo:</label>
                <select name="tipo" size="1">
                    <option value="Administrador">Administrador</option>
                    <option value="Usuario">Usuario</option>
                </select>
                </br></br>
                <button type="submit" name="btnAgregarUsuario" value="Agregar">Agregar</button>
            </form>
            <br>
                <a href="Controlador?accion=listar">Cancelar</a>
        </div>
    </body>
</html>
