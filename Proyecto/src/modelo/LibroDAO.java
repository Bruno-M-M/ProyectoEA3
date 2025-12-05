/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Conexion;
import modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Vania
 */
public class LibroDAO {
    
    public boolean insertar(Libro libro){
        
        String sql = "INSERT INTO libro(titulo, autor, anio, categoria, disponible) VALUES(?,?,?,?,?)";
        try (Connection cn = Conexion.getConnection();
              PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getCategoria());
            ps.setBoolean(5, true);
            ps.executeUpdate();
            System.out.println("Libro agregado correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar libro: " + e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Libro> listar(){
        ArrayList<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Libro libro = new Libro(
                        rs.getInt("idLibro"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio"),
                        rs.getString("categoria"),
                        rs.getBoolean("disponible"));
                lista.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
    public boolean sidisponible(Libro libro){
        String sql = "UPDATE libro SET disponible = true WHERE idLibro=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, libro.getIdLibro());
            ps.executeUpdate();
            int filas = ps.executeUpdate();
            
            if(filas > 0){
                System.out.println("Libro actualizado con exito.");
                return true;
            }else{
                System.out.println("No se actualizo");
                return false;
            }
        }catch (Exception e){
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean nodisponible(Libro libro){
        String sql = "UPDATE libro SET disponible = false WHERE idLibro=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, libro.getIdLibro());
            int filas = ps.executeUpdate();
            
            if(filas > 0){
                System.out.println("Libro actualizado con exito.");
                return true;
            }else{
                System.out.println("No se actualizo");
                return false;
            }
        }catch (Exception e){
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizar(Libro libro){
        String sql = "UPDATE libro SET titulo=?, autor=?, anio=?, categoria=? WHERE idLibro=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getCategoria());
            ps.setInt(5, libro.getIdLibro());
            System.out.println(libro.getIdLibro() + libro.getTitulo() + libro.getAutor() + libro.getAnio() + libro.getCategoria());
            int filas = ps.executeUpdate();
            
            if(filas > 0){
                System.out.println("Libro actualizado con exito.");
                return true;
            }else{
                System.out.println("No se actualizo");
                return false;
            }
        }catch (Exception e){
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int idLibro){
        String sql = "DELETE FROM libro WHERE idLibro=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idLibro);
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Libro eliminado con exito.");
                return true;
            }else{
                System.out.println("Libro no encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
            return false;
        }
    }
    
}
