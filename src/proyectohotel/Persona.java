
package proyectohotel;

public class Persona {
    int idPersona;
    String Nombre;
    String Apellido;
    int DNI;
    int Telefono;
    
    public Persona (int idPersona, String Nombre,String Apellido,int DNI, int Telefono){
        this.idPersona = idPersona;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.DNI = DNI;
        this.Telefono = Telefono;
    }
    
    public Persona (){
    
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
    
}
