package hackBeers.modelo;

import java.util.ArrayList;

public class Administrador extends Persona {

    private ArrayList<Pedido> pendientes;
    private ArrayList<Pedido> realizados;

    //CONSTRUCTOR
    public Administrador(String nombre, String apellidos, String DNI, String contraseña) {
        super(nombre, apellidos, DNI, contraseña);
        pendientes = new ArrayList<>();
        realizados = new ArrayList<>();
    }

    public void añadirPedido(Pedido p) {
        pendientes.add(p);
    }

    public void añadirPedidoRealizado(Pedido p) {
        realizados.add(p);
    }

    public String[][] crearArrayPedidos() {
        String[][] misPedidos = new String[pendientes.size()][5];
        for (int i = 0; i < pendientes.size(); i++) {
            misPedidos[i][0] = pendientes.get(i).getDni();
            misPedidos[i][1] = pendientes.get(i).obtenerOrdenador();
            misPedidos[i][2] = pendientes.get(i).obtenerIdConsumible();
            misPedidos[i][3] = pendientes.get(i).obtenerCantidad();
            misPedidos[i][4] = pendientes.get(i).obtenerPrecio();
        }
        pendientes.clear();
        return misPedidos;
    }

    public String[][] crearArrayPedidosRealizados() {
        String[][] misPedidos = new String[realizados.size()][5];
        for (int i = 0; i < realizados.size(); i++) {
            misPedidos[i][0] = realizados.get(i).getDni();
            misPedidos[i][1] = realizados.get(i).obtenerOrdenador();
            misPedidos[i][2] = realizados.get(i).obtenerIdConsumible();
            misPedidos[i][3] = realizados.get(i).obtenerCantidad();
            misPedidos[i][4] = realizados.get(i).obtenerPrecio();
        }
        realizados.clear();
        return misPedidos;
    }
}
