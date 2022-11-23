public class Lista {
    
    private Nodo primerNodo;

    private Nodo ultimoNodo;

    private String nombreLista;

    public Lista(String nombreLista){
        this.nombreLista = nombreLista;

    }


    /**
     * Operación para insertar elementos al inicio de una lista
     * @param dato El dato a insertar
     */
    public void insertarAlFrente(Object dato){
        if(estaVacia()){
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        }else{
            Nodo nvoNodo = new Nodo(dato, this.primerNodo);
            this.primerNodo = nvoNodo;
        }
    }


    /**
     * Operación para insertar elementos al final de la lista
     * @param dato El dato a insertar
     */
    public void insertarAlFinal(Object dato){
        if(estaVacia()){
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        }else{
            Nodo nvoNodo = new Nodo(dato);
            this.ultimoNodo.setSiguienteNodo(nvoNodo);
            this.ultimoNodo = nvoNodo;
        }
    }

    /**
     * Elimina el primer nodo de la lista ligada
     * @return el valor almacenado en el frente de la lista
     */
    public Object eliminarAlFrente(){
        if(estaVacia())
            throw new ListaExcepcion(this.nombreLista);
        
        Object dato = this.primerNodo.getDato();
        if(this.primerNodo == this.ultimoNodo)
            this.primerNodo = this.ultimoNodo = null;
        else
            this.primerNodo = this.primerNodo.getSiguienteNodo();

        return dato;
        
    }

    /**
     * Operación para eliminar el último nodo de una lista
     * @return El dato almacenado en el último nodo
     */
    public Object eliminarDelFinal(){
        if(estaVacia())
            throw new ListaExcepcion(this.nombreLista);

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

    /**
     * Imprime los elementos de la lista
     */
    public void imprimirLista(){
        if(estaVacia())
            System.out.println("La lista: " + this. nombreLista +  " está vacía");
        else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != null){
                System.out.print(temporal.getDato());
                temporal = temporal.getSiguienteNodo();
            }

            System.out.println(temporal.getDato());
        }
    }



    /**
     * Valida si la lista ligada está vacía
     * @return Verdadero si la lista está vacía
     */
    public boolean estaVacia(){        
        return (this.primerNodo == null);
    }

}
