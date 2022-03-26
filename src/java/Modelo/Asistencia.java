
package Modelo;

public class Asistencia {
    
    private int idA;
    private int idI;
    private int idR;
    private int minutosTarde;

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public int getMinutosTarde() {
        return minutosTarde;
    }

    public void setMinutosTarde(int minutosTarde) {
        this.minutosTarde = minutosTarde;
    }

    public Asistencia() {
    }

    public Asistencia(int idA, int idI, int idR, int minutosTarde) {
        this.idA = idA;
        this.idI = idI;
        this.idR = idR;
        this.minutosTarde = minutosTarde;
    }
    
}
