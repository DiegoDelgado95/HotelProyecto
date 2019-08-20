
package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectohotel.Habitacion;

public class dbHabitacion {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL="";
    
    
    //Funcion para mostrar los datos de la base de datos en la tabla
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"id","Numero", "Tipo", "Descripcion", "Precio", "Estado"};
        String [] registro = new String [6];
        
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select * from Habitacion where numero like '%"+buscar+"%' order by numero asc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            
            while(rs.next()){
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("precio");
                registro[5] = rs.getString("estado");
                
                modelo.addRow(registro);    
            }
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }   
    }
    
    public DefaultTableModel mostrarInicio (){
        DefaultTableModel modelo;
        String [] titulos = {"id","Numero", "Tipo", "Descripcion", "Precio", "Estado"};
        String [] registro = new String [6];
        
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select * from Habitacion order by numero asc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            
            while(rs.next()){
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("precio");
                registro[5] = rs.getString("estado");
                
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
        sSQL = "insert into Habitacion (numero, tipo, descripcion, precio, estado) values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, h.getNumero());
            pst.setString(2, h.getTipo());
            pst.setString(3, h.getDescripcion());
            pst.setInt(4, h.getPrecio());
            pst.setString(5, h.getEstado());
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
        sSQL = "update Habitacion set numero=?, tipo=?, descripcion=?, precio=?, estado=? where idHabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, h.getNumero());
            pst.setString(2, h.getTipo());
            pst.setString(3, h.getDescripcion());
            pst.setInt(4, h.getPrecio());
            pst.setString(5, h.getEstado());
            pst.setInt(6, h.getIdHabitacion());
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
    
    public boolean desocupar (Habitacion h){
        sSQL = "update Habitacion set estado='Disponible' where idHabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, h.getIdHabitacion());
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
    
    public boolean ocupar (Habitacion h){
        sSQL = "update Habitacion set estado='Ocupado' where idHabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, h.getIdHabitacion());
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
        String [] titulos = {"id", "Numero", "Tipo", "Descripcion", "Precio", "Estado"};
        String [] registro = new String [6];
        
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select * from Habitacion where numero like '%"+buscar+"%' and estado='disponible' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            
            while(rs.next()){
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("precio");
                registro[5] = rs.getString("estado");
                
                modelo.addRow(registro);    
            }
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }   
    }
    
    
}
