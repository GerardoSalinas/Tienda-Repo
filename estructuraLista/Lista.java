package estructuraLista; 
public class Lista {
    
    private Nodo primerNodo;

    private Nodo ultimoNodo;

    private String nombreLista;

    //Getters
    public Nodo getPrimerNodo() {
        return primerNodo;
    }
    
    public Nodo getUltimoNodo() {
        return ultimoNodo;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    //Setters
    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }

    public void setUltimoNodo(Nodo ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    //Constructor
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
     * Inserta un nuevo nodo en la posicion indicada de la lista. El tamaño de la lista aumenta en una unidad.
     * itera hasta llegar al nodo que se ubica justo antes de la posicion, hace que auxiliar tome el valor del nodo en esa posicion
     * seguidamente hace que el nuevo nodo apunte al nodo que antes estaba en la posicion del nuevo nodo  
     * @param posicion posicion donde se quiere insertar el dato
     * @param dato dato a insertar
     */
    public void insertarEn(int posicion, Object dato){
        if (estaVacia()){
            insertarAlFrente(dato);

        }else if (posicion == 1){
            insertarAlFrente(dato);
            
        }else if (posicion == tamLista()){//verificar si se quiere insertar al final
            insertarAlFinal(dato);
        }else{
            
            Nodo nodoInsertar  = new Nodo(dato);
            Nodo actual = this.primerNodo;
            for (int i = 1; i<posicion-1; i++){//iteramos a traves de los nodos 
                actual = actual.getSiguienteNodo();
            }
            //actual queda en el nodo que esta antes de a posicion a insertar
            Nodo auxiliar  = actual.getSiguienteNodo();
            nodoInsertar.setSiguienteNodo(auxiliar);//el objeto que insertamos apunta al nodo que antes estaba en la posicion que ocupa objeto
            actual.setSiguienteNodo(nodoInsertar); 
        }
    }

    /**
     * Elimina el nodo en la posicion indicada
     * @param posicion posicion del elemento que se quiere eliminar
     */
    public void eliminarEn(int posicion){
        if (estaVacia()){
            System.out.printf("No se puede eliminar en la posicion %d ya que la lista esta vacia",posicion);
        }else if (posicion == 1){
            eliminarAlFrente();
        }else if (posicion == tamLista()){//si se quiere eliminar en la ultima posicion
            eliminarDelFinal();
        }else{
            Nodo actual = this.primerNodo;
            for (int i = 1; i<posicion-1; i++){
                actual = actual.getSiguienteNodo();
                
            }
            //actual queda en el nodo que esta antes de a posicion a eliminar
            Nodo auxiliar = actual.getSiguienteNodo().getSiguienteNodo();//el nodo que esta despues del que vamos a eliminar
            actual.setSiguienteNodo(auxiliar);
            

        }
    }


    /**
     * Valida si la lista ligada está vacía
     * @return Verdadero si la lista está vacía
     */
    public boolean estaVacia(){        
        return (this.primerNodo == null);
    }


    /**
     * Itera a traves de la lista y cuenta la cantidad de nodos en ella
     * @return regresa el tamaño de la lista
     */
    public int tamLista(){
        int contador = 1;
        if (estaVacia()){
            return 0;
        }else{
            Nodo temporal = this.primerNodo;
            while(temporal.getSiguienteNodo() != null){
                temporal = temporal.getSiguienteNodo();
                contador++;
            }
            return contador;
        }

    }

}
