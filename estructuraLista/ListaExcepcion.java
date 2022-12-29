public class ListaExcepcion extends RuntimeException{
    
    public ListaExcepcion(){
        this("genérica");
    }

    public ListaExcepcion(String nombreLista){
        super("La lista " + nombreLista + " está vacía");
    }

}
