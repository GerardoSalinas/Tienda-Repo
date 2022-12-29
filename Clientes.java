import java.util.Random;

public class Clientes {
    private double efectivo_disponible;
    private Lista listaProductos;

    public Clientes(double efectivo_disponible) {
        this.efectivo_disponible = efectivo_disponible;
    }

    public double getEfectivo_disponible() {
        return efectivo_disponible;
    }
    
    public Lista getListaProductos() {
        return listaProductos;
    }
    
    public void setListaProductos(Lista listaProductos) {
        this.listaProductos = listaProductos;
    }
    

    public void setEfectivo_disponible(double efectivo_disponible) {
        this.efectivo_disponible = efectivo_disponible;
    }

public void GenerarListaCliente(Lista listaProductos){
    double total = 0;
    int totalproductos = 0;
    //crear la lista de 3 a 5 productos
    Random variable = new Random();
    Nodo auxiliar;
    this.listaProductos = new Lista("listaCliente");
    int tamanio = 3 + variable.nextInt(3);
    int posicion;
    for(int i = 0;i < tamanio; i++){
        auxiliar = listaProductos.getPrimerNodo();
        
        posicion = variable.nextInt(listaProductos.tamLista() + 1);
        for(int j = 1;j < posicion;j++){// el + 1 hace que genere numeros de 0 a 16, pero sin incluir 16, es decir de 0 a 15, antes generaba de 0 a 14
            auxiliar = auxiliar.getSiguienteNodo();
        }

        //si el dato ya existe en la lista de productos del cliente
        while(repetidos(auxiliar)){//quitar indices
            auxiliar = listaProductos.getPrimerNodo();//restablecemos nodo a la primera posicion
            posicion = variable.nextInt(listaProductos.tamLista() + 1);
            for(int j = 1;j < posicion;j++){// el + 1 hace que genere numeros de 0 a 16, pero sin incluir 16, es decir de 0 a 15, antes generaba de 0 a 14
                auxiliar = auxiliar.getSiguienteNodo();
            }
        }
    
        this.listaProductos.insertarAlFrente(auxiliar.getDato());
        total = total+((Producto)auxiliar.getDato()).getPrecio(); 
        totalproductos = totalproductos+1;       

        
    }

}



public boolean repetidos(Nodo objetivo){
    Nodo buscador = this.listaProductos.getPrimerNodo();

    if (this.listaProductos.tamLista()>0){//si el tamanio de la lista es cero

        for(int i = 0; i < this.listaProductos.tamLista();i++){
            Producto puntero = (Producto)buscador.getDato();
    
            if(puntero.equals( (Producto)objetivo.getDato() ))
                return true; 
            buscador = buscador.getSiguienteNodo();
        }
    }
    return false;
}


public boolean efectivoSuficiene(){
    Nodo auxiliar;
    double total = 0;
    auxiliar = this.listaProductos.getPrimerNodo();
    for(int i = 0; i < (this.listaProductos.tamLista());i++){
        total = total+((Producto)auxiliar.getDato()).getPrecio(); 
        auxiliar = auxiliar.getSiguienteNodo();
    }
    if(this.efectivo_disponible<total)
        return false;
    else
        return true;
}

}



   

    




