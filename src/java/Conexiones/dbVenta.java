
package Conexiones;

import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbVenta {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
    public String GenerarSerie(){
        int numeroserie=0;
        sSQL="select max(numero) from Venta";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                numeroserie = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Integer.toString(numeroserie);
    }
    
    public int IDVenta(){
        int idventa=0;
        sSQL="select max(idVenta) from Venta";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                idventa = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return idventa; 
    }
    
    public boolean insertVenta(Venta v){
        sSQL="insert into Venta (fechaVenta,monto,estado,numero,Cliente_idCliente)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.setString(1, v.getFechaVenta());
            ps.setInt(2, v.getMonto());
            ps.setString(3, v.getEstado());
            ps.setInt(4, v.getNumero());
            ps.setInt(5, v.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    
    public boolean InsertarDetalleVenta(Venta v){
        sSQL="insert into ventaDetalle (subTotal,cantidad,Venta_idVenta,Producto_idProducto) values (?,?,?,?)";      
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.setInt(1, v.getSubTotal());
            ps.setInt(2, v.getCantidad());
            ps.setInt(3, v.getIdVenta());
            ps.setInt(4,v.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
