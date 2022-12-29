
public class Cola extends Lista{
    
    private String nombreCola;
   
    public Cola(String nombreCola) {
        super(nombreCola);
    }

    public void encolar(Object dato){
        super.insertarAlFinal(dato);
    }

    public Object desencolar(Object dato){
       return super.eliminarAlFrente();
    }

    public String getNombreCola() {
        return super.getNombreLista();
    }

    public void imprimirCola(){
        if(estaVacia())
            System.out.println("La cola: " + this. nombreCola +  " está vacía");
        else{
    
            Nodo temporal = this.getPrimerNodo();
            while(temporal.getSiguienteNodo() != null){
                System.out.println(temporal.getDato());
                temporal = temporal.getSiguienteNodo();
            }

            System.out.println(temporal.getDato());
        }
    }

    public int tamCola(){
        return  super.tamLista();//hace lo mismo que Lista
 
     }

    public boolean estaVacia(){        
        return super.estaVacia();
    }

    
}
