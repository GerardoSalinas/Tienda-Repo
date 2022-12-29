
public class ColaExcepcion extends RuntimeException{
    
    public ColaExcepcion(){
        this("genérica");
    }

    public ColaExcepcion(String nombreCola){
        super("La lista " + nombreCola + " está vacía");
    }
    
}
