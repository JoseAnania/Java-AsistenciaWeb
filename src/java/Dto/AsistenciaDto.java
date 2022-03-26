
package Dto;

public class AsistenciaDto {
    
    private String nombreI;
    private String descripcionR;
    private int minutosTarde;

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public String getDescripcionR() {
        return descripcionR;
    }

    public void setDescripcionR(String descripcionR) {
        this.descripcionR = descripcionR;
    }

    public int getMinutosTarde() {
        return minutosTarde;
    }

    public void setMinutosTarde(int minutosTarde) {
        this.minutosTarde = minutosTarde;
    }

    public AsistenciaDto() {
    }

    public AsistenciaDto(String nombreI, String descripcionR, int minutosTarde) {
        this.nombreI = nombreI;
        this.descripcionR = descripcionR;
        this.minutosTarde = minutosTarde;
    }
    
    public String puntualidad()
    {
        String puntualidad="";
        
        if(minutosTarde==0)
        {
            puntualidad="Temprano";
        }
        if(minutosTarde<15 & minutosTarde>0)
        {
            puntualidad="Tarde";
        }
        if(minutosTarde>15)
        {
            puntualidad="Muy Tarde";
        }
        
        return puntualidad;
    }
}
