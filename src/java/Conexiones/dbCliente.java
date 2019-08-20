
package Conexiones;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class dbCliente {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    int r;
    
    
    public List listar(){
        sSQL="select * from Cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDni(rs.getInt(3));
                c.setDireccion(rs.getString(4));
                
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    return lista;
    }
    
    public Cliente buscar (int dni){
        Cliente cl = new Cliente();
        sSQL= "select * from Cliente where dni="+dni;
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cl.setIdCliente(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setDni(rs.getInt(3));
                cl.setDireccion(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cl;
    }
    
        public Cliente buscarID (int id){
        Cliente cl = new Cliente();
        sSQL= "select * from Cliente where idCliente="+id;
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cl.setIdCliente(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setDni(rs.getInt(3));
                cl.setDireccion(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cl;
    }
    
    public int insert (Cliente c){
        sSQL = "insert into Cliente (nombre,dni,direccion) values (?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.setString(1,c.getNombre());
            ps.setInt(2,c.getDni());
            ps.setString(3, c.getDireccion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }

    
    
    public int editar (Cliente c){
        sSQL="update Cliente set nombre=?, dni=?, direccion=? where idCliente=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.setString(1,c.getNombre());
            ps.setInt(2, c.getDni());
            ps.setString(3, c.getDireccion());
            ps.setInt(4,c.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
    
    public void eliminar (int id){
        sSQL="delete from Cliente where idCliente="+id;
        try {
            PreparedStatement ps = cn.prepareStatement(sSQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
