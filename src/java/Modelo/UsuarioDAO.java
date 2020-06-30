/*

*/
package Modelo;

import BaseDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Conexion cnx = new Conexion();
    Usuario u = new Usuario();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar(){
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContrasena(rs.getString("contrasena"));
                usu.setTipo(rs.getString("tipoUser"));
                list.add(usu);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Usuario list(int id){
        String sql = "SELECT * FROM usuarios WHERE id="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {               
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipo(rs.getString("tipoUser"));
            }
        } catch (Exception e) {
        }
        return u;
    }
    
    public boolean crear(Usuario usu){
        String sql = "INSERT INTO usuarios(usuario,contrasena,tipoUser)"
                + " VALUES('"+usu.getUsuario()+"','"+usu.getContrasena()+"','"
                +usu.getTipo()+"')";
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean editar(Usuario usu){
        String sql = "UPDATE usuarios SET usuario='"+usu.getUsuario()+"',"
                + "contrasena='"+usu.getContrasena()+"',tipoUser='"
                +usu.getTipo()+"' WHERE id="+usu.getId();
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM usuarios WHERE id="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
