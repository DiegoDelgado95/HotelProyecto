

package Conexiones;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    public String db="eJ0V6brlwS";
    public String url="jdbc:mysql://remotemysql.com/"+db;
    public String user="eJ0V6brlwS";
    public String pass="bwWZqWd2Hc";
    
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
