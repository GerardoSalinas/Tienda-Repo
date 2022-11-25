import estructuraLista.Lista;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class simulacion {
    public static void main(String[] args) {
        Lista listaProductos = new Lista("listaProductos");//lista vacia
        Random azar = new Random();
        //lectura del archivo productos.txt
        try{
            File  archivoProductos = new File("productos.txt");
            Scanner input = new Scanner(archivoProductos);
            int indice = 1;
            while (input.hasNextLine()){//entramos en un loop para leer cada linea de
                //falta reconocer los datos de cada linea
                String[] tokens = input.nextLine().split(",");
                String mystring = tokens[0];
                
                /*Pila pila1 = new Pila("nombreProducto");
                for (){

                }
                listaProductos.insertarEn(indice, new Pila(parametros));

                creo que vamos a tener que crear una clase producto, que va a tener como atributos: codigo, nombre, precio .
                de esa forma las pilas van a almacenar objetos de tipo producto  
                */
                indice++;
            }
            

        }catch(FileNotFoundException ex){
            System.out.println("El archivo no existe!");
        }

    }
}
