
package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectohotel.Habitacion;

public class dbHabiitacion {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL="";
    
    
    //Funcion para mostrar los datos de la base de datos en la tabla
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"Numero", "Tipo", "Descripcion", "Precio", "Estado"};
        String [] registro = new String [5];
        
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select * from Habitacion where numero like '%"+buscar+"%' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            
            while(rs.next()){
            
                registro[0] = rs.getString("numero");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("precio");
                registro[4] = rs.getString("estado");
                
                modelo.addRow(registro);    
            }
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }   
    }
    
    
    
    //Agrego una nueva Habitacion a la Base de Datos
    
    public boolean insetar(Habitacion h){
        sSQL = "insert into Habitacion (numero, descripcion, precio, estado) values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, h.getNumero());
            pst.setString(2, h.getDescripcion());
            pst.setInt(3, h.getPrecio());
            pst.setString(4, h.getEstado());
            int n = pst.executeUpdate();
                if (n!=0){
                    return true;
                }else{
                    return false;
                }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //Funcion para editar una Habitacion en la base de datos
    
    public boolean editar (Habitacion h){
        sSQL = "update Habitacion set numero=?, descripcion=?, precio=?, estado=?, idhabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, h.getNumero());
            pst.setString(2, h.getDescripcion());
            pst.setInt(3, h.getPrecio());
            pst.setString(4, h.getEstado());
            pst.setInt(5, h.getIdHabitacion());
            int n = pst.executeUpdate();
                if (n!=0){
                    return true;
                }else{
                    return false;
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //Funcion para eliminar una Habitacion en la base de datos
    
    public boolean eliminar(Habitacion h){
        sSQL = "delete from Habitacion where idHabitacion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setInt(1, h.getIdHabitacion());
                
                int n=pst.executeUpdate();
                
                if(n!=0){
                    return true;
                }else{
                    return false;
                }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
                return false;
        }
    
    }
    
    
    public DefaultTableModel mostrarVista (String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"Numero", "Tipo", "Descripcion", "Precio", "Estado"};
        String [] registro = new String [5];
        
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select * from Habitacion where numero like '%"+buscar+"%' and estado='disponible' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            
            while(rs.next()){
            
                registro[0] = rs.getString("numero");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("precio");
                registro[4] = rs.getString("estado");
                
                modelo.addRow(registro);    
            }
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }   
    }
    
    
}
