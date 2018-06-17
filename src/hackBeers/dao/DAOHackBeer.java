/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackBeers.dao;

import hackBeers.modelo.Administrador;
import hackBeers.modelo.Conexion;
import hackBeers.modelo.Consumible;
import hackBeers.modelo.Inventario;
import hackBeers.modelo.Pedido;
import hackBeers.modelo.Usuario;
import hackBeers.jOptionPane.Bienvenido;
import hackBeers.jOptionPane.UoCincorrecto;
import hackBeers.vista.AdministradorV;
import hackBeers.vista.ClienteV;
import hackBeers.vista.ClienteVIP;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import hackBeers.dao.exception.ErrorConexionBD;
import hackBeers.jOptionPane.IdUsado;
import hackBeers.jOptionPane.productoIntroducido;

public class DAOHackBeer {

    static DAOHackBeer instancia = null;

    Usuario u = null;
    private boolean primerLog;
    Administrador a;

    public static DAOHackBeer instancia() {
        if (instancia == null) {
            instancia = new DAOHackBeer();
        }
        return instancia;
    }

    public void annadirConsumibles(Consumible c) throws SQLException, ErrorConexionBD {

        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("select * from consumibles where idConsumible=" + c.getId());

        if (rs.next()) {
            IdUsado iu = new IdUsado(null, true);
            iu.setVisible(true);
        } else {
            ConexionBD.instancia().getStatement().execute(
                    "INSERT INTO consumibles VALUES (" + c.getId() + ", '" + c.getNombre() + "', " + c.getCantidad() + ", " + c.getPrecio() + ")"
            );
            productoIntroducido pi = new productoIntroducido(null, true);
            pi.setVisible(true);
        }
    }

    public void verConsumible(Inventario i) throws SQLException {
        Consumible c = null;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM consumibles");

        while (rs.next()) {
            c = new Consumible(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
            i.annadirConsumible(c);
        }
    }

    /**
     *
     * @param usuario
     * @param contraseña
     * @throws SQLException
     * @throws ErrorConexionBD
     */
    public void pedirUsuarios(String usuario, String contraseña) throws SQLException, ErrorConexionBD {
        String dni = null;
        String nombre;
        String apellidos;
        String contraseñaU;
        int vip;

        int contador = 0;
        if (contador == 0) {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    "SELECT * FROM usuarios WHERE dni='" + usuario + "' AND contraseña='" + contraseña + "'"
            );

            while (rs.next()) {
                dni = rs.getString(1);
                nombre = rs.getString(2);
                apellidos = rs.getString(3);
                contraseñaU = rs.getString(4);
                vip = rs.getInt(5);
                primerLog = rs.getBoolean(6);

                u = new Usuario(nombre, apellidos, dni, contraseñaU, vip);
                contador++;
                if (usuario.equals(dni) && contraseña.equals(contraseñaU)) {
                    Bienvenido b = new Bienvenido (null, true, nombre, apellidos);
                    b.setVisible(true);
                }
            }
            contador++;
        }
        if (contador == 1) {
            contador--;
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    "SELECT * FROM administradores WHERE dni='" + usuario + "' AND contraseña='" + contraseña + "'"
            );
            while (rs.next()) {

                dni = rs.getString(1);
                nombre = rs.getString(2);
                apellidos = rs.getString(3);
                contraseñaU = rs.getString(4);

                if (usuario.equals(dni) && contraseña.equals(contraseñaU)) {
                    a = new Administrador(nombre, apellidos, dni, contraseñaU);
                    AdministradorV adm = new AdministradorV();
                    adm.setVisible(true);
                    contador++;
                }
            }
        }
        if (contador == 0) {
            UoCincorrecto uoc = new UoCincorrecto(null, true);
            uoc.setVisible(true);
        }

    }

    public void añadirConexion(Usuario u) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "INSERT INTO conexiones (dni, idOrdenador) VALUES('" + u.getDNI() + "','" + u.getIdOrdenador() + "')"
        );

    }

    public Usuario buscarConexionesUsuario(String DNI) throws SQLException, ErrorConexionBD {
        String dni;
        String nombre;
        String apellidos;
        String contraseñaU;
        int vip;
        boolean si = false;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM usuarios WHERE dni='" + DNI + "'"
        );

        while (rs.next()) {

            dni = rs.getString(1);
            nombre = rs.getString(2);
            apellidos = rs.getString(3);
            contraseñaU = rs.getString(4);
            vip = rs.getInt(5);
            u = new Usuario(nombre, apellidos, dni, contraseñaU, vip);
            si = true;
        }

        ResultSet rs1 = ConexionBD.instancia().getStatement().executeQuery(
                "Select * from conexiones where dni='" + DNI + "'"
        );

        while (rs1.next()) {
            Conexion c = new Conexion(rs1.getString(1), rs1.getInt(2), rs1.getString(3));
            System.out.println("conexion creada");
            u.añadirConexion(c);
        }

        if (si == false) {
            u = new Usuario("null", "null", DNI, "null", 0);
        }
        return u;
    }

    public void annadirUsuario(Usuario u) throws SQLException {
        try {
            ConexionBD.instancia().getStatement().execute(
                    "Insert into usuarios values ('" + u.getDNI() + "', '" + u.getNombre() + "', '" + u.getApellidos() + "', '" + u.getContraseña() + "', " + u.getVIP() + ", 0)"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario verDatosUsuario() throws SQLException {
        return u;
    }

    public Administrador verDatosAdministrador() {
        return a;
    }

    public void annadirPedido(Pedido p) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "INSERT INTO `pedidos` VALUES ('" + p.getDni() + "'," + p.getOrdenador() + "," + p.getIdConsumible() + "," + p.getCantidad() + "," + p.getPrecio() + "," + p.isRealizado() + ")"
        );
    }

    public void verPedidosUsuario(String dni) throws SQLException {
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from pedidos where dni='" + dni + "'"
        );
        while (rs.next()) {
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            u.annadirPedido(p);
        }
    }

    public void verTodosPedidos() {

    }

    public int pedirIdConsumible(String nombreConsumible) throws SQLException {
        int idConsumible = 0;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT idConsumible FROM consumibles WHERE Nombre ='" + nombreConsumible + "'");
        while (rs.next()) {
            idConsumible = rs.getInt(1);
        }
        return idConsumible;
    }

    public String pedirNombreConsumible(int idConsumible) throws SQLException {
        String nombreConsumible = null;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT Nombre FROM consumibles WHERE idConsumible =" + idConsumible);
        while (rs.next()) {
            nombreConsumible = rs.getString(1);
        }
        return nombreConsumible;
    }

    public void eliminarUsuario(Usuario u) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "delete from usuarios where dni='" + u.getDNI() + "'"
        );
        ConexionBD.instancia().getStatement().execute(
                "delete from conexiones where dni='" + u.getDNI() + "'"
        );
        ConexionBD.instancia().getStatement().execute(
                "delete from pedidos where dni='" + u.getDNI() + "'"
        );
        ConexionBD.instancia().getStatement().execute(
                "delete from almacenamiento where dni='" + u.getDNI() + "'"
        );

    }

    public void actualizarVip(Usuario u, int vip) throws SQLException {
        ConexionBD.instancia().getStatement().executeUpdate(
                "UPDATE usuarios SET vip=" + vip + " WHERE dni='" + u.getDNI() + "'"
        );
    }

    public void actualizarTablaPedidos(Administrador admin) throws SQLException {
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from pedidos where realizado=0"
        );

        while (rs.next()) {
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            admin.añadirPedido(p);
        }
    }

    public void actualizarTablaRealizados(Administrador admin) throws SQLException {
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from pedidos where realizado=1"
        );

        while (rs.next()) {
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            admin.añadirPedidoRealizado(p);
        }
    }

    public void actualizarTablaPedidosU(Usuario u) throws SQLException {
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from pedidos where dni='" + u.getDNI() + "' AND realizado=0"
        );

        while (rs.next()) {
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            u.añadirPedido(p);
        }
    }

    public boolean isPrimerLog() {
        return primerLog;
    }

    public void cambiarContraseña(String dni, String contraseña) throws SQLException {
        ConexionBD.instancia().getStatement().execute("UPDATE `usuarios` SET `Contraseña`='" + contraseña + "',`primerLog`=true WHERE dni='" + dni + "'");
    }

    public void confirmarPedido(int cantidad, int id, String dni) throws SQLException {
        int cantidadNueva = 0;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT cantidad FROM pedidos WHERE idConsumible=" + id);
        while (rs.next()) {
            cantidadNueva = rs.getInt(1) - cantidad;
        }
        ConexionBD.instancia().getStatement().executeUpdate("UPDATE consumibles SET Cantidad=" + cantidadNueva + " where idConsumible=" + id);
        ConexionBD.instancia().getStatement().execute("UPDATE pedidos SET realizado=true where dni='" + dni + "' AND idConsumible=" + id);
    }

    public void modificarConsumible(int idConsumible, int cantidad, float precio) throws SQLException {
        ConexionBD.instancia().getStatement().executeUpdate("UPDATE consumibles SET Cantidad=" + cantidad + ", Precio=" + precio + " where idConsumible=" + idConsumible);
    }

    public void annadirPedidoTiempo(Usuario u) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "Insert into pedidos values('"+u.getDNI()+"', " + u.getIdOrdenador()+", 0, 1, 3, 0)"
        );
        ConexionBD.instancia().getStatement().executeUpdate(
                "Update consumibles set cantidad=9999 where idConsumible=0"
        );
    }

    public void limpiarDao() {
        u = null;
        a = null; 
    }
}
