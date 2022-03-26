
package Modelo;

public class Reunion {
    
    private int idR;
    private String descripcionR;
    private String fecha;

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getDescripcionR() {
        return descripcionR;
    }

    public void setDescripcionR(String descripcionR) {
        this.descripcionR = descripcionR;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Reunion() {
    }

    public Reunion(int idR, String descripcionR, String fecha) {
        this.idR = idR;
        this.descripcionR = descripcionR;
        this.fecha = fecha;
    }
    
}
