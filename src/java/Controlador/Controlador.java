/*

*/
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    String buscar = "Vistas/Buscar.jsp";
    String consultar = "Vistas/Consultar.jsp";
    String crear = "Vistas/Crear.jsp";
    String editar = "Vistas/Editar.jsp";
    Usuario u = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();
    int id;
    String acceso = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String accion = request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("listar")){
            acceso = buscar;
        } 
//        else if(accion.equalsIgnoreCase("agregar")){
//            String usuario = request.getParameter("txtUsuario");
//            String contra = request.getParameter("txtContrasena");
//            String tipo = request.getParameter("tipo");
//            u.setUsuario(usuario);
//            u.setContrasena(contra);
//            u.setTipo(tipo);
//            dao.crear(u);
//            acceso = buscar;
//            
//        } 
        else if(accion.equalsIgnoreCase("crear")){
            acceso = crear;
        } else if(accion.equalsIgnoreCase("editar")){
            request.setAttribute("idU", request.getParameter("id"));
            acceso = editar;
        } 
//        else if(accion.equalsIgnoreCase("actualizar")){
//            id = Integer.parseInt(request.getParameter("txtID"));
//            String usuario = request.getParameter("txtUsuario");
//            String contra = request.getParameter("txtContrasena");
//            String tipo = request.getParameter("tipo");
//            u.setId(id);
//            u.setUsuario(usuario);
//            u.setContrasena(contra);
//            u.setTipo(tipo);
//            dao.editar(u);
//            acceso = buscar;
//        } 
        else if(accion.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            u.setId(id);
            dao.eliminar(id);
            acceso = buscar;
        } else if(accion.equalsIgnoreCase("consultar")){
            request.setAttribute("idU", request.getParameter("id"));
            acceso = consultar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("btnAgregarUsuario") != null) {
            String usuario = request.getParameter("txtUsuario");
            String contra = request.getParameter("txtContrasena");
            String tipo = request.getParameter("tipo");
            u.setUsuario(usuario);
            u.setContrasena(contra);
            u.setTipo(tipo);
            dao.crear(u);
        }
        if (request.getParameter("btnActualizar") != null) {
            id = Integer.parseInt(request.getParameter("txtID"));
            String usuario = request.getParameter("txtUsuario");
            String contra = request.getParameter("txtContrasena");
            String tipo = request.getParameter("tipo");
            u.setId(id);
            u.setUsuario(usuario);
            u.setContrasena(contra);
            u.setTipo(tipo);
            dao.editar(u);
        }
        RequestDispatcher vista = request.getRequestDispatcher(buscar);
        vista.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}