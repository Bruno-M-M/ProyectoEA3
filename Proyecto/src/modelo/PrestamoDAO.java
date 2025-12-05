/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import bd.Conexion;
import bd.Conexion;
import modelo.Prestamo;
import modelo.Libro;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.MONTHS;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;
import modelo.Usuario;

public class PrestamoDAO {
    
    public boolean insertar(Prestamo prestamo){
        String sql = "INSERT INTO prestamo(idusuario, idlibro, fechaPrestamo, fechaEstimada, fechaDevolucion) VALUES(?,?,?,?,?)";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, prestamo.getIdLibro());
            ps.setInt(2, prestamo.getIdLibro());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDate(4, Date.valueOf(LocalDate.now().plusMonths(2)));
            ps.setString(5, null);
            ps.executeUpdate();
            System.out.println("Prestamo registrado.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar prestamo: " +e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Prestamo> listar(){
        ArrayList<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                Libro libro  = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                Prestamo prestamo = new Prestamo(
                            rs.getInt("idPrestamo"),
                            rs.getInt("idUsuario"),
                            rs.getInt("idLibro"),
                            rs.getDate("fechaPrestamo"),
                            rs.getDate("fechaEstimada"),
                            rs.getDate("FechaDevolucion"));
                lista.add(prestamo);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
    public void actualizar(Prestamo prestamo) {
        String sql = "UPDATE prestamo SET fechaDevolucion=? WHERE idPrestamo=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, prestamo.getIdPrestamo());
            ps.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    
    public ArrayList<Prestamo> pendientes(){
        ArrayList<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo WHERE fechaDevolucion IS NULL";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                Libro libro  = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                Prestamo prestamo = new Prestamo(
                            rs.getInt("idUsuario"),
                            rs.getInt("idLibro"),
                            rs.getDate("fechaPrestamo"),
                            rs.getDate("fechaEstimada"),
                            rs.getDate("FechaDevolucion"));
                lista.add(prestamo);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    public ArrayList<Prestamo> historial(){
        ArrayList<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo WHERE fechaDevolucion IS NOT NULL";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                Libro libro  = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                Prestamo prestamo = new Prestamo(
                            rs.getInt("idUsuario"),
                            rs.getInt("idLibro"),
                            rs.getDate("fechaPrestamo"),
                            rs.getDate("fechaEstimada"),
                            rs.getDate("FechaDevolucion"));
                lista.add(prestamo);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }
    
}
