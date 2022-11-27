public class Cola {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private String nombreCola;

    public Cola(String nombreCola) {
        this.nombreCola = nombreCola;
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

    public Object eliminarAlFrente(){
        if(estaVacia())
            throw new ColaExcepcion(this.nombreCola);
        
        Object dato = this.primerNodo.getDato();
        if(this.primerNodo == this.ultimoNodo)
            this.primerNodo = this.ultimoNodo = null;
        else
            this.primerNodo = this.primerNodo.getSiguienteNodo();

        return dato;
        
    }

    public void imprimirCola(){
        if(estaVacia())
            System.out.println("La cola: " + this. nombreCola +  " está vacía");
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
