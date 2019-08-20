
package Conexiones;

import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class dbProducto {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    int r;
    
    
    public List Listar (){
        sSQL="select * from Producto";
        List<Producto> lista = new ArrayList<>();
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCodigo(rs.getString(3));
                p.setStock(rs.getInt(4));
                p.setPrecio(rs.getInt(5));
                
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    
    
    
    public boolean actualizarStock (int id, int cantidad){
        sSQL="update producto set Stock=? where idProducto=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.setInt(1, cantidad);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return true;
    }
    
    
    public Producto buscar (int codigo){
        Producto p = new Producto();
        sSQL="select * from Producto where codigo="+codigo;
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCodigo(rs.getString(3));
                p.setStock(rs.getInt(4));
                p.setPrecio(rs.getInt(5));     
            }
        } catch (Exception e) {
            System.out.println(e);
        }
      return p;
    }
    
    
    public int insertar(Producto p){
        sSQL="insert into Producto (nombre,codigo,stock,precio) values (?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCodigo());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
    
     public Producto listarID(int id){
        Producto p = new Producto();
        sSQL="select * from Producto where idProducto="+id;
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCodigo(rs.getString(3));
                p.setStock(rs.getInt(4));
                p.setPrecio(rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;   
    }
    
    public int editar (Producto p){
        sSQL="Update Producto nombre=?, codigo=?, stock=?, precio=? where idProducto=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCodigo());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getPrecio());
            ps.setInt(5, p.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
    
    
    public void eliminar (int id){
        sSQL="delete from Producto where idProducto="+id;
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
