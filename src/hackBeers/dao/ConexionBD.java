package hackBeers.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import hackBeers.dao.exception.ErrorConexionBD;

public class ConexionBD {

    Connection conn;
    Statement stmt;

    static ConexionBD instancia = null;

    private ConexionBD() throws ErrorConexionBD {
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://10.1.3.122:3306/cibercafebd", "ciber", "");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cibercafebd","root","");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new ErrorConexionBD();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static Connection getConnectio() throws ClassNotFoundException, SQLException {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdb");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return cn;
    }

    public Statement getStatement() {
        return stmt;
    }

    public static void crearConexion() throws ErrorConexionBD {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
    }

    public static ConexionBD instancia() {
        return instancia;
    }

    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.stmt.execute("shutdown");
                instancia.stmt.close();
                instancia.conn.close();
                instancia = null;
            } catch (SQLException e) {
            }
        }
    }
}
