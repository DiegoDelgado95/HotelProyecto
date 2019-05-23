

package Conexiones;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    public String db="JJ4J8aIBJP";
    public String url="jdbc:mysql://remotemysql.com/"+db;
    public String user="JJ4J8aIBJP";
    public String pass="hPulMZ2Dbw";
    
    public Conexion(){
    }
    
    
    public Connection Conectar (){
        Connection cn=null;
        
        try{Class.forName("org.gjt.mm.mysql.Driver");
            cn=DriverManager.getConnection(this.url, this.user,this.pass);
           // JOptionPane.showMessageDialog(null, "Conexion a DB Exitosa");
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "error");
        }
        
        return cn;
    }
    
}
