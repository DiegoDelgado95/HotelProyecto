package proyectohotel;

import java.sql.Date;

public class Pago {
    
    int idPago;
    int idReserva;
    int numero;
    double monto;
    String tipoPago;
    Date fechaPago;
    
    public Pago(){
    }

    public Pago(int idPago, int idReserva, int numero, double monto, String tipoPago, Date fechaPago) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.numero = numero;
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.fechaPago = fechaPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
    
    
}
