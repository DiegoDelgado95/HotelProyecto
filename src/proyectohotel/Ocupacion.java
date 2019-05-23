
package proyectohotel;


public class Ocupacion {
    String DiaIngreso;
    String DiaSalida;
    String HoraIngreso;
    String HoraSalida;
    
    
    public Ocupacion (String DiaIngreso, String DiaSalida, String HoraIngreso, String HoraSalida){
        this.DiaIngreso = DiaIngreso;
        this.DiaSalida = DiaSalida;
        this.HoraIngreso = HoraIngreso;
        this.HoraSalida = HoraSalida;
    }

    public String getDiaIngreso() {
        return DiaIngreso;
    }

    public void setDiaIngreso(String DiaIngreso) {
        this.DiaIngreso = DiaIngreso;
    }

    public String getDiaSalida() {
        return DiaSalida;
    }

    public void setDiaSalida(String DiaSalida) {
        this.DiaSalida = DiaSalida;
    }

    public String getHoraIngreso() {
        return HoraIngreso;
    }

    public void setHoraIngreso(String HoraIngreso) {
        this.HoraIngreso = HoraIngreso;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }
    
    
}
