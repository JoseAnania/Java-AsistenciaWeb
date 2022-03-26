
package Controlador;

import Dto.AsistenciaDto;
import Modelo.Asistencia;
import Modelo.Inscripto;
import Modelo.Reunion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
    
    private Connection C;
    private PreparedStatement PS;
    private Statement S;
    private ResultSet RS;
    
    public void abrirConexion()
    {
        try {
            String url="jdbc:sqlserver://DESKTOP-E8FRIUV\\SQLEXPRESS:1433;databaseName=Asistencia";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            C=DriverManager.getConnection(url, "sa","giandjoe");
            System.out.println("Conectado a la BD");
        } catch (Exception e) {
            System.out.println("Error al Conectarse a la BD"+e.getMessage());
        }
    }
    
    public void cerrarConexion()
    {
        try {
            C.close();
            System.out.println("Conexión a la BD cerrada");
        } catch (Exception e) {
            System.out.println("Error al intentar desconectarse a la BD"+e.getMessage());
        }
    }
    
    public void agregarAsistencia(Asistencia nuevaAsistencia)
    {
        try {
            abrirConexion();
            PS=C.prepareStatement("INSERT INTO Asistencia (idI, idR, minutosTarde) VALUES (?,?,?)");
            
            PS.setInt(1, nuevaAsistencia.getIdI());
            PS.setInt(2, nuevaAsistencia.getIdR());
            PS.setInt(3, nuevaAsistencia.getMinutosTarde());
            
            PS.execute();
            
            PS.close();
            cerrarConexion();
            
        } catch (Exception e) {
        }
    }
    
    public ArrayList<Inscripto>llenarComboI()
    {
        ArrayList<Inscripto>lista=new ArrayList<>();
        
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT * FROM Inscripto");
            
            while(RS.next())
            {
                Inscripto I=new Inscripto();
                
                I.setIdI(RS.getInt(1));
                I.setNombreI(RS.getString(2));
                
                lista.add(I);
            }
            
            RS.close();
            S.close();
            cerrarConexion();
            
        } catch (Exception e) {
        }
        return lista;
    }
    public ArrayList<Reunion>llenarComboR()
    {
        ArrayList<Reunion>lista=new ArrayList<>();
        
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT * FROM Reunion");
            
            while(RS.next())
            {
                Reunion R=new Reunion();
                
                R.setIdR(RS.getInt(1));
                R.setDescripcionR(RS.getString(2));
                R.setFecha(RS.getString(3));
                
                lista.add(R);
            }
            
            RS.close();
            S.close();
            cerrarConexion();
            
        } catch (Exception e) {
        }
        return lista;
    }
    
    public ArrayList<AsistenciaDto>listado()
    {
        ArrayList<AsistenciaDto>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT i.nombreI, r.descripcionR, a.minutosTarde FROM Inscripto i INNER JOIN Asistencia a ON i.idI=a.idI INNER JOIN Reunion r ON a.idR=r.idR");
            
            while(RS.next())
            {
                AsistenciaDto A=new AsistenciaDto();
                
                A.setNombreI(RS.getString(1));
                A.setDescripcionR(RS.getString(2));
                A.setMinutosTarde(RS.getInt(3));
                
                lista.add(A);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
    public int reporte1()
    {
        int cantidad=0;
        
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT COUNT(*) FROM Asistencia WHERE minutosTarde=0");
            
            RS.next();
            
            cantidad=RS.getInt(1);
            
            RS.close();
            S.close();
            cerrarConexion();
            
        } catch (Exception e) {
        }
        return cantidad;
    }
    
    public float reporte2(int minMin, int minMax)
    {
        float porcentaje=0;
        
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT (SELECT COUNT(*) FROM Asistencia WHERE minutosTarde BETWEEN "+minMin+" AND "+minMax+" ) * 100 / COUNT(idA) FROM Asistencia");
            
            RS.next();
            
            porcentaje=RS.getFloat(1);
            
            RS.close();
            S.close();
            cerrarConexion();
            
        } catch (Exception e) {
        }
        return porcentaje;
    }
    
    public int reporte3()
    {
        int cantidad=0;
        
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT COUNT(idA) FROM Asistencia");
            
            RS.next();
            
            cantidad=RS.getInt(1);
            
        } catch (Exception e) {
        }
        return cantidad;
    }
        
}
