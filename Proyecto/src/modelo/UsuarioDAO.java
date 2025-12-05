/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Conexion;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {
    
    public boolean insertar(Usuario usuario){
        String sql = "INSERT INTO usuario(nombre, apellido, rut, telefono) VALUES(?,?,?,?)";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getRut());
            ps.setInt(4, usuario.getTelefono());
            ps.executeUpdate();
            System.out.println("Usuario agregado correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar usuario: "+ e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Usuario> listar(){
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Usuario usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("rut"),
                        rs.getInt("telefono")
                        );
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
    public boolean actualizar(Usuario usuario){
        String sql = "UPDATE usuario SET nombre=?, apellido=?, rut=?, telefono=? WHERE idUsuario=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getRut());
            ps.setInt(4, usuario.getTelefono());
            ps.setInt(5, usuario.getIdUsuario());
            ps.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int idUsuario){
        String sql = "DELETE FROM usuario WHERE idUsuario=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
