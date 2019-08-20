
package Modelo;

public class Venta {
    int idVenta;
    int idProducto;
    int idCliente;
    String estado;
    String fechaVenta;
    int monto;
    int numero;
    int cantidad;
    int subTotal;
    int item;
    String descripcion;
    int precio;

    public Venta() {
    }

    public Venta(int idVenta, int idProducto, int idCliente, String estado, String fechaVenta, int monto, int numero, int cantidad, int subTotal, int item, String descripcion, int precio) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.estado = estado;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
        this.numero = numero;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.item = item;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
