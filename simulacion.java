
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Simulacion {

    public static void main(String[] args) {
        Random variable = new Random();
        Lista listaProductos = new Lista("listaProductos");//lista vacia
        //lectura del archivo productos.txt
        leerProductos(listaProductos);
           
        //Generando las pilas de productos
        Pila[] pilaProductos;
        pilaProductos = new Pila[listaProductos.tamLista()];
        Nodo auxiliar = listaProductos.getPrimerNodo();
        for(int i = 0;i < pilaProductos.length;i++){
            Producto temporal = (Producto)auxiliar.getDato();
            String nombreProduco = temporal.getNombre();
            pilaProductos[i] = new Pila(nombreProduco);

            for(int j = 0;j < (15+variable.nextInt(25-15));j++){
              pilaProductos[i].apilar(temporal);
            }

          auxiliar = auxiliar.getSiguienteNodo();
        }

       //Generando cajas registradoras(colas) con sus clientes
      Cola[] cajas = new Cola[2];
      Clientes nuevoCliente;

        for(int i = 0; i < 2; i++){
            cajas[i] = new Cola("caja "+(i+1));

            for(int j = 0;j < (5+variable.nextInt(10-5));j++){
                nuevoCliente = new Clientes(variable.nextInt(250));
                nuevoCliente.GenerarListaCliente(listaProductos);
                cajas[i].encolar(nuevoCliente);
            }

        }
       
    

       //Clientes atendidos por cada caja 
       int[] clientesAtendidos = new int[2];  //lo usaremos para registrar cuantos clientes tiene suficiente efectivo
       Nodo auxiliar3;
       Clientes cliTemporal;
       int cantidadProductosVendidos = 0;
       double[] montoVentas = new double[listaProductos.tamLista()];//cada posicion para el mismo orden de productos en la lista de todos los productos
       int[] cantidadPorProducto = new int[listaProductos.tamLista()];//almacena la cantidad de productos vendidos en el mismo orden de la lista de productos 

       for(int i = 0;i < 2;i++){
            clientesAtendidos[i] = 0;
            auxiliar3 = cajas[i].getPrimerNodo();

            for(int j = 0;j < (cajas[i].tamCola());j++){

                cliTemporal = (Clientes)auxiliar3.getDato(); 

                if(cliTemporal.efectivoSuficiene()){
                    clientesAtendidos[i]++; 
                    cantidadProductosVendidos += cliTemporal.getListaProductos().tamLista();
                    Nodo iteradorProductos = cliTemporal.getListaProductos().getPrimerNodo();

                    for (int h = 0; h < cliTemporal.getListaProductos().tamLista(); h++){//recorremos la lista del cliente y conseguimos el precio de cada producto y lo sumamos a montoVentas
                        Producto productoTemp = (Producto)iteradorProductos.getDato();
                        asginarMontoVenta(productoTemp,montoVentas,cantidadPorProducto,pilaProductos);
                        iteradorProductos = iteradorProductos.getSiguienteNodo();
                    }
                }
                auxiliar3 = auxiliar3.getSiguienteNodo();   
                        
            }
        }  

        
        System.out.println("***Reporte General***");
        for(int i = 0;i < 2;i++){
            System.out.println("La cantidad de clientes atendida por la caja "+(i+1)+" fue de: "+ clientesAtendidos[i]);
        }
        System.out.println("Cantidad de productos vendidos: "+ cantidadProductosVendidos);
        //monto vendido por cada producto
        montoPorProducto(listaProductos, montoVentas,cantidadPorProducto);
        System.out.printf("Total en ventas: %.2f\n",totalMonto(montoVentas));
       

        System.out.println("Grupo :\n 20211020592 Gerardo Salinas\n 20161006291 Guillermo Valladares\n 20211030861 Emilio Molina");
    }

    //asignar valores a los atributos
    public static void leerProductos(Lista listaProductos){
        try{
            File productos = new File("C:/Users/Gerardo/Downloads/Proyecto bueno/productos.txt");//cambia segun cada usuario
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

    public static void asginarMontoVenta(Producto productoTemp, double[] montoVentas, int[] cantidadPorProducto,Pila[] pilaProductos){
       for(int i=0; i<pilaProductos.length;i++){
        if (productoTemp.getNombre().equalsIgnoreCase(pilaProductos[i].getNombrePila())){
            montoVentas[i] += productoTemp.getPrecio();
            cantidadPorProducto[i]++;
            pilaProductos[i].desapilar();
         }
        }
        
    }

    public static double totalMonto(double[] montoVentas){
        double total = 0.00;
        for (int j = 0; j<montoVentas.length; j++)
            total += montoVentas[j];
        return total;
    }

    public static void montoPorProducto(Lista listaProductos, double[] montoVentas, int[] cantidadPorProducto){
        Nodo nodoIterador = listaProductos.getPrimerNodo();
        for (int j = 0; j < montoVentas.length; j++){
            Producto productoIterador = (Producto)nodoIterador.getDato();
            System.out.printf("Total de %s vendido [%d]: %.2f \n",productoIterador.getNombre(),cantidadPorProducto[j],montoVentas[j]);
            nodoIterador = nodoIterador.getSiguienteNodo();
        }
    }
}
