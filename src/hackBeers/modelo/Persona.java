package hackBeers.modelo;

import hackBeers.dao.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

public class Persona {

    String DNI;
    private String nombre;
    private String apellidos;
    String contraseña;

    //CONSTRUCTOR
    public Persona(String nombre, String apellidos, String DNI, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.contraseña = contraseña;
    }

    //GETS Y SETS
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Persona crearPersona(Persona p){
        return p;
    }

}
