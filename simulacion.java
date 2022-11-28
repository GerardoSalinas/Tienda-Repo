import estructuraLista.Lista;
import estructuraLista.Nodo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import estructuraPila.Pila;
import estructuraCola.Cola;

public class Simulacion {

    public static void main(String[] args) {
        Lista listaProductos = new Lista("listaProductos");//lista vacia
        //lectura del archivo productos.txt
        
        leerProductos(listaProductos);

        //creacion de Pilas 
        Nodo auxiliar = listaProductos.getPrimerNodo();

        Pila pilaServilletas = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaAguazul = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaLapiz = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaMarcador = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaLeche = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaPan = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaChurro = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaRefresco = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaComidaDeGato = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaComidaDePerro = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaGalleta = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaCloro = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaTomate = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaDetergente = inicializarPila(auxiliar.getDato());
        auxiliar.getSiguienteNodo();

        Pila pilaAtun = inicializarPila(auxiliar.getDato());

        /*Esta es la parte que estaba probando, es la misma idea que inicializar las pilas */ 
        //Cola clientes1 = inicializarCola(); 
        //Cola clientes2 = inicializarCola();

        
        
        

    }

    //asignar valores a los atributos
    public static void leerProductos(Lista listaProductos){
        try{
            File productos = new File("C:/Users/Gerardo/Documents/gerardo/Programacion/programacion II/Tercer Parcial/Proyecto Final/productos.txt");
            Scanner texto = new Scanner(productos);

            while(texto.hasNextLine()) {
                String[] datos = texto.nextLine().split(",");
                Producto producto1 = new Producto(datos[0],datos[1],Integer.parseInt(datos[2]));
                listaProductos.insertarAlFinal(producto1);                
            }
        }catch(FileNotFoundException ex){
            System.out.println("No se encontro el archivo de texto");
        }
        
        
    }

    public static Pila inicializarPila(Object dato){
        Random azar = new Random();
        Pila pila1 = new Pila(((Producto)dato).getNombre());
        int size = 15 + azar.nextInt(11);//tamaño de la pila
        for (int i = 1; i<=size; i++){
            pila1.apilar(dato);
        }
        return pila1;  
    }
    public static Cola inicializarCola(Object dato){
        Random azar = new Random();
        Cola cola1 = new Cola("Cola");
        int size = 5 + azar.nextInt(6);
        for (int i = 1; i<=size; i++){
            //cola1.encolar((Cliente)dato);
        }
        return cola1;
    }

}
