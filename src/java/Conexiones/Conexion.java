
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public String db="JT1KdeNT3z";
    public String url="jdbc:mysql://remotemysql.com/"+db;
    public String user="JT1KdeNT3z";
    public String pass="paxZ3uj0yY";
    
    
    public Conexion(){
    }
    
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
        
        return link;
    }

    
    
}
