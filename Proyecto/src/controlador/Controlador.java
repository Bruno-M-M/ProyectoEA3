package controlador;

import java.util.ArrayList;
import modelo.Libro;
import modelo.LibroDAO;
import modelo.Prestamo;
import modelo.PrestamoDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.LibroVista;
import vista.PrestamoVista;
import vista.UsuarioVista;
import vista.VistaPrincipal;


public class Controlador {
    
    
    UsuarioDAO uDAO = new UsuarioDAO();
    LibroDAO lDAO = new LibroDAO();
    PrestamoDAO pDAO = new PrestamoDAO();
    
    public boolean nodisponible(Libro libro){
        lDAO.nodisponible(libro);
        return true;
    }
    
    public boolean sidisponible(Libro libro){
        lDAO.sidisponible(libro);
        return true;
    }
    
    public void vistaprincipal(){
        VistaPrincipal vs = new VistaPrincipal();
        vs.setVisible(true);
    }
    public void libroventana(){
        LibroVista lv = new LibroVista();
        lv.setVisible(true);
    }
    
    public void usuarioventana(){
        UsuarioVista uvista = new UsuarioVista();
        uvista.setVisible(true);
    }
    
    public void prestamoventana(){
        PrestamoVista pvista = new PrestamoVista();
        pvista.setVisible(true);
    }
    public ArrayList<Prestamo> pendientes(){
        return pDAO.pendientes();
    }
    public ArrayList<Prestamo> historial(){
        return pDAO.historial();
    }
    public boolean add(Usuario usuario){
        uDAO.insertar(usuario);
        return true;
    }
    public boolean delusuario(int idUsuario){
        uDAO.eliminar(idUsuario);
        return true;
    }
    public boolean act(Usuario usuario){
        uDAO.actualizar(usuario);
        return true;
    }
    public ArrayList<Usuario> listusuario(){
        return uDAO.listar();
    }
    
    public boolean add(Libro libro){
        lDAO.insertar(libro);
        return true;
    }
    public boolean dellibro(int idLibro){
        lDAO.eliminar(idLibro);
        return true;
    }
    public boolean act(Libro libro){
        lDAO.actualizar(libro);
        return true;
    }
    public ArrayList<Libro> listlibro(){
        return lDAO.listar();
    }
    
    public boolean add(Prestamo prestamo){
        pDAO.insertar(prestamo);
        return true;
    }
    
    public boolean act(Prestamo prestamo){
        pDAO.actualizar(prestamo);
        return true;
    }
    public ArrayList<Prestamo> listprestamo(){
        return pDAO.listar();
    }
    
}
