package hackBeers.modelo;

public class Pedido {

    String dni;
    int ordenador;
    int idConsumible;
    int cantidad;
    boolean realizado;
    float precio;

    public Pedido(String dni, int ordenador, int idConsumible, int cantidad, float precio, boolean realizado) {

        this.dni = dni;
        this.ordenador = ordenador;
        this.idConsumible = idConsumible;
        this.cantidad = cantidad;
        this.realizado = realizado;
        this.precio = precio;
        
    }

    public String getDni() {
        return dni;
    }

    public int getOrdenador() {
        return ordenador;
    }
    
    public String obtenerOrdenador(){
        return Integer.toString(ordenador);
    }

    public int getIdConsumible() {
        return idConsumible;
    }
    
    public String obtenerIdConsumible(){
        return Integer.toString(idConsumible);
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public String obtenerCantidad() {
        return Integer.toString(cantidad);
    }

    public boolean isRealizado() {
        return realizado;
    }
    
    public String obtenerIsRealizado(){
        return Boolean.toString(realizado);
    }

    public float getPrecio() {
        return precio;
    }
    
    public String obtenerPrecio(){
        return Float.toString(precio);
    }

}
