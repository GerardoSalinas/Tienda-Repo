
public class Producto{
    private String nombre;
    private int precio;
    private String codigo;

    //Contructor
    public Producto(String codigo,String nombre,int precio){
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return "\n[codigo]: "+ this.codigo +"\n[nombre]: " + this.nombre + "\n[precio]: " + this.precio + "\n";
    }

}