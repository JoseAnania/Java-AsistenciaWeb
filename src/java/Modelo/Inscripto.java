
package Modelo;

public class Inscripto {
    
    private int idI;
    private String nombreI;

    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public Inscripto() {
    }

    public Inscripto(int idI, String nombreI) {
        this.idI = idI;
        this.nombreI = nombreI;
    }
    
}
