public class Pila {
    private Nodo primerNodo;

    private Nodo ultimoNodo;

    private String nombrePila;

    public Pila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public void insertarPrimerNodo(Object dato){
        if(estaVacia()){
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        }
    }

    public void insertarAlFinal(Object dato){
        if(estaVacia()){
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        }else{
            Nodo nvoNodo = new Nodo(dato);
            this.ultimoNodo.setSiguienteNodo(nvoNodo);
            this.ultimoNodo = nvoNodo;
        }
    }

    public Object eliminarDelFinal(){
        if(estaVacia())
            throw new PilaExcepcion(this.nombrePila);

        Object dato = this.ultimoNodo.getDato();
        if(this.primerNodo == this.ultimoNodo)
            this.primerNodo = this.ultimoNodo = null;
        else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != this.ultimoNodo){
                temporal = temporal.getSiguienteNodo();
            }
            temporal.setSiguienteNodo(null);
            this.ultimoNodo = temporal;
        }

        return dato;
    }
    

    public void imprimirPila(){
        if(estaVacia())
            System.out.println("La Pila: " + this. nombrePila +  " está vacía");
        else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != null){
                System.out.println(temporal.getDato());
                temporal = temporal.getSiguienteNodo();
            }

            System.out.println(temporal.getDato());
            
        }
    }

    public boolean estaVacia(){        
        return (this.primerNodo == null);
    }

    
}
