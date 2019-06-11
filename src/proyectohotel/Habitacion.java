
package proyectohotel;

public class Habitacion {
    int idHabitacion;
    int Numero;
    String Tipo;
    String Descripcion;
    String Estado;
    int Precio;
    
    public Habitacion (int idHabitacion, int Numero, String Tipo, String Descripcion, int Precio,String Estado){
        this.idHabitacion = idHabitacion;
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Estado = Estado;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    
    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
