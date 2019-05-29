
package proyectohotel;

import java.sql.Date;
import java.sql.Time;


public class Ocupacion {
    int idOcupacion;
    Date DiaIngreso;
    Date DiaSalida;
    Time HoraIngreso;
    Time HoraSalida;
    int idPersona;
    int idHabitacion;
    String Estado;
    int idPago;

    public Ocupacion(int idOcupacion, Date DiaIngreso, Date DiaSalida, Time HoraIngreso, Time HoraSalida, int idPersona, int idHabitacion, String Estado, int idPago) {
        this.idOcupacion = idOcupacion;
        this.DiaIngreso = DiaIngreso;
        this.DiaSalida = DiaSalida;
        this.HoraIngreso = HoraIngreso;
        this.HoraSalida = HoraSalida;
        this.idPersona = idPersona;
        this.idHabitacion = idHabitacion;
        this.Estado = Estado;
        this.idPago = idPago;
    }

    public Ocupacion() {
    }

    public int getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(int idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public Date getDiaIngreso() {
        return DiaIngreso;
    }

    public void setDiaIngreso(Date DiaIngreso) {
        this.DiaIngreso = DiaIngreso;
    }

    public Date getDiaSalida() {
        return DiaSalida;
    }

    public void setDiaSalida(Date DiaSalida) {
        this.DiaSalida = DiaSalida;
    }

    public Time getHoraIngreso() {
        return HoraIngreso;
    }

    public void setHoraIngreso(Time HoraIngreso) {
        this.HoraIngreso = HoraIngreso;
    }

    public Time getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(Time HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    
    
    
    
    
}
