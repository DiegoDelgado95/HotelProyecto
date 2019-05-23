
package proyectohotel;

public class Datos {
    public boolean validarUsuario (String usuario, String clave){
        if ((!"Admin".equals(usuario)) && (!"Admin".equals(clave))){
            return false;
    }else{
            return true;
        }
    }
}
