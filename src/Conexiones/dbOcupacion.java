/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectohotel.Ocupacion;

/**
 *
 * @author Diego
 */
public class dbOcupacion {
    
    //Realizo la conexion a la base de datos
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    
    //Funcion para mostrar datos en la tabla
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String [] titulos = {"id","Cliente", "idPersona","Habitacion", "idHabitacion", "Dia Ingreso", "Dia Egreso", "Dia Reserva", "Estado","precio"};
        String [] registro = new String[10];
        
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL = "Select o.idOcupacion,(Select nombre from Persona where idPersona = o.Persona_idPersona)as clienten," +
"                (Select apellido from Persona where idPersona = o.Persona_idPersona)as clienteap, o.Persona_idPersona,h.numero," +
"                o.Habitacion_idHabitacion, o.diaIngreso, o.diaEgreso, o.diaReserva, o.estado, h.precio" +
"                from Ocupacion o inner join Habitacion h on o.Habitacion_idHabitacion = h.idHabitacion where o.diaIngreso like '%"+buscar+"%' order by o.idOcupacion asc";
        
        try {
            Statement at = cn.createStatement();
            ResultSet rs= at.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0] = rs.getString("idOcupacion");
                registro[1] = rs.getString("clienten") + " " + rs.getString("clienteap");
                registro[2] = rs.getString("Persona_idPersona");
                registro[3] = rs.getString("numero");
                registro[4] = rs.getString("Habitacion_idHabitacion");
                registro[5] = rs.getString("diaIngreso");
                registro[6] = rs.getString("diaEgreso");
                registro[7] = rs.getString("diaReserva");
                registro[8] = rs.getString("estado");
                registro[9] = rs.getString("precio");
                
                modelo.addRow(registro);
            }
            
            return modelo;
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }
    
    //Funcion para insetar datos de la ocupacion en la base de datos
    
    public boolean Insertar (Ocupacion o){
        sSQL = "insert into Ocupacion (diaIngreso, diaEgreso, Persona_idPersona, Habitacion_idHabitacion, estado, diaReserva) values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setDate(1,o.getDiaIngreso());
            pst.setDate(2,o.getDiaSalida());
            pst.setInt(3, o.getIdPersona());
            pst.setInt(4, o.getIdHabitacion());
            pst.setString(5, o.getEstado());
            pst.setDate(6, o.getDiaReserva());
            
            int m = pst.executeUpdate();
            if (m != 0){
                return true;
            }else{
                return false;
            }
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    
    }
    
    
    //Funcion para modificar una reserva de la base de datos
    public boolean editar (Ocupacion o){
        sSQL = "update Ocupacion set diaIngreso=?, diaEgreso=?, Persona_idPersona=?, Habitacion_idHabitacion=?, estado=?, diaReserva=? where idOcupacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setDate(1, o.getDiaIngreso());
            pst.setDate(2, o.getDiaSalida());
            pst.setInt(3, o.getIdPersona());
            pst.setInt(4, o.getIdHabitacion());
            pst.setString(5, o.getEstado());
            pst.setDate(6, o.getDiaReserva());
            pst.setInt(7, o.getIdOcupacion());
            
            int m = pst.executeUpdate();
            if(m!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public boolean pagar (Ocupacion o){
        sSQL = "update Ocupacion set estado='Pagado' where  idOcupacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, o.getIdOcupacion());
            
            int m = pst.executeUpdate();
            if(m!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    
    //Funcion para Eliminar una reserva de la base de datos
    public boolean eliminar (Ocupacion o){
        sSQL = "delete from Ocupacion where idOcupacion=?";
        
        try {
            PreparedStatement pst = cn.prepareCall(sSQL);
            pst.setInt(1, o.getIdOcupacion());
            
            int m = pst.executeUpdate();
            if(m != 0){
                return true;
            }else{
                return false;
            }
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        
    }
    
    
    
    
}
