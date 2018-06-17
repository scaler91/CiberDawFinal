package hackBeers.modelo;

import hackBeers.dao.ConexionBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hackBeers.dao.exception.ErrorConexionBD;

public class Usuario extends Persona {

    private controlCibercafe ccc;
    private int VIP;
    private int idOrdenador;
    private LinkedList<Pedido> pedido;
    private ArrayList<Conexion> registroConexiones;
    private float precioTotal = 0;

    public Usuario(String nombre, String apellidos, String DNI, String contraseña, int VIP) throws ErrorConexionBD {
        super(nombre, apellidos, DNI, contraseña);
        this.VIP = VIP;

        idOrdenador = (int) (Math.random() * 10) + 1;
        ccc = new controlCibercafe();
        pedido = new LinkedList();
        registroConexiones = new ArrayList<>();
    }

    public void añadirPedido(int ordenadorId, int idConsumible, int cantidad, float precio) throws SQLException {
        ccc.annadirPedido(new Pedido(DNI, ordenadorId, idConsumible, cantidad, precio, false));
        pedido.add(new Pedido(DNI, ordenadorId, idConsumible, cantidad, precio, false));
    }

    public void añadirConexion(Conexion c) {
        registroConexiones.add(c);
    }

    public void añadirPedido(Pedido p) {
        pedido.add(p);
    }

    public String[][] crearArrayConexiones() {
        String[][] misConexiones = new String[registroConexiones.size()][3];
        for (int i = 0; i < registroConexiones.size(); i++) {
            misConexiones[i][0] = registroConexiones.get(i).getDNI();
            misConexiones[i][1] = registroConexiones.get(i).obtenerIdOrdenador();
            misConexiones[i][2] = registroConexiones.get(i).getFecha();
        }
        return misConexiones;
    }

    public int getVIP() {
        return VIP;
    }

    public String getDNI() {
        return DNI;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int isVIP() {
        return VIP;
    }

    public void setVIP(int VIP) {
        this.VIP = VIP;
    }

    public void annadirPedido(Pedido p) {
        pedido.add(p);
    }

    public int getIdOrdenador() {
        return idOrdenador;
    }

    //MÉTODOS
    /**
     * Método para crear un pedido (Bebidas, comida, etc)
     *
     * @param id
     * @param mesa
     * @param cantidad
     * @throws SQLException
     */
    public void crearPedido(int id, int mesa, int cantidad) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "insert into pedidos values ('" + getDNI() + "', '" + mesa + "', '" + id + "', '" + cantidad + "')");
    }

    /**
     * Método para poner una queja en el establecimiento
     */
    public void ponerQueja() {

    }

    public String[][] crearArrayPedidos() {
        precioTotal = 0;
        String[][] misPedidos = new String[pedido.size()][5];
        for (int i = 0; i < pedido.size(); i++) {
            try {
                misPedidos[i][0] = ccc.pedirNombreConsumible(pedido.get(i).getIdConsumible());
                misPedidos[i][1] = pedido.get(i).obtenerCantidad();
                misPedidos[i][2] = pedido.get(i).obtenerPrecio();
                precioTotal += Float.parseFloat(pedido.get(i).obtenerPrecio());
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pedido.clear();
        return misPedidos;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }
    
}
