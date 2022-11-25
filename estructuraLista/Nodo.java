package estructuraLista;

public class Nodo{

    private Object dato;

    private Nodo siguienteNodo;

    public Nodo(Object dato){
        this(dato, null);
    }

    public Nodo(Object dato, Nodo siguienteNodo) {
        this.dato = dato;
        this.siguienteNodo = siguienteNodo;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }



}