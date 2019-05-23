package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectohotel.Persona;


public class dbPersona {
        private Conexion mysql = new Conexion();
        private Connection cn = mysql.Conectar();
        private String sSQL="";
        
        
        // Muestro los Clientes en la Tabla
        
        public DefaultTableModel mostrar (){
            DefaultTableModel  modelo;
            String [] titulos = {"idPersona","Nombre","Apellido", "DNI","Telefono"};
            String [] registro = new String [5];
            
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "Select * from Persona";
            
            try{
                
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idPersona");
                    registro[1] = rs.getString("nombre");
                    registro[2] = rs.getString("apellido");
                    registro[3] = rs.getString("dni");
                    registro[4] = rs.getString("telefono");
                    
                    modelo.addRow(registro);
                }
                return modelo;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
            }
        
        // Agrego un nuevo Cliente a la Base de Datos
        
        public boolean insertar (Persona p){
            sSQL = "insert into Persona (nombre,apellido,dni,telefono)values(?,?,?,?)";
            try{
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setString(1, p.getNombre());
                pst.setString(2, p.getApellido());
                pst.setInt(3, p.getDNI());
                pst.setInt(4,p.getTelefono());
                
                int n = pst.executeUpdate();
                if (n!=0){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        }
}
