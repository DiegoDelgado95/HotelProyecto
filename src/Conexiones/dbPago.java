package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectohotel.Pago;

public class dbPago {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    
    //Muestro los datos de los pagos
         public DefaultTableModel mostrar (String buscar){
            DefaultTableModel  modelo;
            String [] titulos = {"idPago","idOcupacion","Numero", "Monto","Tipo Pago","Fecha Pago"};
            String [] registro = new String [6];
            
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "Select * from Pago where Ocupacion_idOcupacion="+buscar+" order by idPago asc";
            
            try{
                
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idPago");
                    registro[1] = rs.getString("Ocupacion_idOcupacion");
                    registro[2] = rs.getString("numero");
                    registro[3] = rs.getString("monto");
                    registro[4] = rs.getString("tipoPago");
                    registro[5] = rs.getString("fechaPago");
                    
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
        
        public boolean insertar (Pago p){
            sSQL = "insert into Pago ( numero, monto, tipoPago, fechaPago, Ocupacion_idOcupacion)values(?,?,?,?,?)";
            try{
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setInt(5, p.getIdReserva());
                pst.setInt(1, p.getNumero());
                pst.setDouble(2, p.getMonto());
                pst.setString(3,p.getTipoPago());
                pst.setDate(4, p.getFechaPago());
                
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
        
        
        
        public boolean editar (Pago p){
            sSQL = "update Pago set Ocupacion_idOcupacion=?, numero=?, monto=?, tipoPago=?, fechaPago=? where idPago=?";
            
            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setInt(1, p.getIdReserva());
                pst.setInt(2, p.getNumero());
                pst.setDouble(3, p.getMonto());
                pst.setString(4,p.getTipoPago());
                pst.setDate(5, p.getFechaPago());
                pst.setInt(6, p.getIdPago());
                
                int n=pst.executeUpdate();
                if(n!=0){
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }   
        }
        
        
        public boolean eliminar (Pago p){
            sSQL = "delete from Pago where idPago=?";
            
            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setInt(1, p.getIdPago());
                
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
    
    
    
    
}
