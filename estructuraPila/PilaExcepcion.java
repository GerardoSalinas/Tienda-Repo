package estructuraPila;
public class PilaExcepcion extends RuntimeException{
    public PilaExcepcion(){
        this("genérica");
    }

    public PilaExcepcion(String nombrePila){
        super("La Pila " + nombrePila + " está vacía");
    }
    
    
}
