/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Vania
 */
public class Libro {
    
    private int idLibro;
    private String titulo, autor;
    private int anio;
    private String categoria;
    private boolean disponible;

    public Libro() {
    }

    public Libro(int idLibro) {
        this.idLibro = idLibro;
    }
    public Libro(boolean disponible){
        this.disponible = disponible;
    }

    public Libro(String titulo, String autor, int anio, String categoria, int idLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
    }

    public Libro(int idLibro, String titulo, String autor, int anio, String categoria) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
    }

    
    public Libro(String titulo, String autor, int anio, String categoria, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
        this.disponible = disponible;
    }
    

    public Libro(int idLibro, String titulo, String autor, int anio, String categoria, boolean disponible) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", categoria=" + categoria + ", disponible=" + disponible + '}';
    }


}
