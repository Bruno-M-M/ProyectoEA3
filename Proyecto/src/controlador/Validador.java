
package controlador;


public class Validador {
    
    public boolean validaVacio(String texto){
        return !texto.isEmpty();
    }
    
    public boolean validaInt(String texto){
        try {
            Integer.valueOf(texto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
