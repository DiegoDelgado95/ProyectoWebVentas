
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public String db="";
    public String url="/"+db;
    public String user="";
    public String pass="";
    
    
    public Conexion(){
    }
    
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
        return link;
    }

    
    
}
