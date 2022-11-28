package estructuraPila;
import estructuraLista.Lista;
import estructuraLista.Nodo;


public class Pila extends Lista{

    private String nombrePila;
    
    //Constructor
    public Pila(String nombrePila) {
        super(nombrePila);//se llama al constructor de su super clase (Lista)
    }

    //Getters
    public String getNombrePila() {
        return nombrePila;
    }

    //Setters
    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public void apilar(Object dato){
        super.insertarAlFinal(dato);
    }

    public Object desapilar(){
        return super.eliminarDelFinal();
    }
    

    public void imprimirPila(){//este no se puede cambiar por el metodo de su superclase porque el mensaje no tendria sentido
        if(estaVacia())
            System.out.println("La Pila: " + this. nombrePila +  " está vacía");
        else{
            Nodo temporal = this.getPrimerNodo();
            while(temporal.getSiguienteNodo() != null){
                System.out.println(temporal.getDato());
                temporal = temporal.getSiguienteNodo();
            }

            System.out.println(temporal.getDato());
            
        }
    }

    public boolean estaVacia(){        
        return super.estaVacia();//hace lo mismo que Lista
    }

    public int tamPila(){
       return  super.tamLista();//hace lo mismo que Lista

    }
    
}
