package Servlets;

import Controlador.Conexion;
import Modelo.Asistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAltaAsistencia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Conexion C = new Conexion();

            ArrayList lista = C.llenarComboI();
            request.setAttribute("lista", lista);

            ArrayList lista2 = C.llenarComboR();
            request.setAttribute("lista2", lista2);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaAsistencia.jsp");
        rd.forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idI=request.getParameter("cboInscripto");
        String idR=request.getParameter("cboReunion");
        String minutosTarde=request.getParameter("minutosTarde");
        
        Conexion C=new Conexion();
        
        Asistencia A=new Asistencia();
        
        A.setIdI(Integer.parseInt(idI));
        A.setIdR(Integer.parseInt(idR));
        A.setMinutosTarde(Integer.parseInt(minutosTarde));
        
        C.agregarAsistencia(A);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Asistencia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<li><a href=\"index.html\">Volver</a></li>");
            out.println("<h1>Se cargo la Asistencia exitosamente</h1>");
            out.println("</body>");
            out.println("</html>");
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
