package estructuraLista;

public class PruebaLista {
    

    public static void main(String[] args) {
        
        Lista nvaLista = new Lista("paises");

        
        nvaLista.insertarAlFinal("C");        
        nvaLista.insertarAlFinal("A");        
        nvaLista.insertarAlFinal("T");
        nvaLista.insertarAlFinal("A");
        nvaLista.insertarAlFinal("R");
        nvaLista.imprimirLista();//"CATAR"
       
        nvaLista.insertarEn(2,"Q");
        nvaLista.imprimirLista();//"CQATAR"

        nvaLista.eliminarEn(6);//"CQATA"
        nvaLista.imprimirLista();

        nvaLista.insertarEn(5, "R");
        nvaLista.imprimirLista();//"CQATAR"




       


    }
}
