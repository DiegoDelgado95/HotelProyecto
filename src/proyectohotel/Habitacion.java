
package proyectohotel;

public class Habitacion {
    int Numero;
    String Tipo;
    Boolean Matrimoñal;
    Boolean CamaSola;
    String Estado;
    int Precio;
    
    public Habitacion (int Numero, String Tipo, Boolean Matrimoñal, Boolean CamaSola, int Precio,String Estado){
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.Matrimoñal = Matrimoñal;
        this.CamaSola = CamaSola;
        this.Precio = Precio;
        this.Estado = Estado;
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

    public Boolean getMatrimoñal() {
        return Matrimoñal;
    }

    public void setMatrimoñal(Boolean Matrimoñal) {
        this.Matrimoñal = Matrimoñal;
    }

    public Boolean getCamaSola() {
        return CamaSola;
    }

    public void setCamaSola(Boolean CamaSola) {
        this.CamaSola = CamaSola;
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
    
    
}
