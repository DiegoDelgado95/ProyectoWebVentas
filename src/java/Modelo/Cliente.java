
package Modelo;

public class Cliente {
    int idCliente;
    String nombre;
    String direccion;
    int dni;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String direccion, int dni) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    
}
