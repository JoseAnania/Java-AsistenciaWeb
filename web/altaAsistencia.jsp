<%-- 
    Document   : altaAsistencia
    Created on : 24-ene-2019, 14:41:24
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Asistencias</title>
    </head>
    <body>
        <h1>Alta de Asistencias</h1>
        
        <form method="post" action="ServletAltaAsistencia">
            
            Inscripto: <select name="cboInscripto" id="cboInscripto" required="requiered">
                <option value="" disabled selected> Seleccione el Nombre </option>
                    <c:forEach items="${lista}" var="I">
                        <option value=${I.idI}>${I.nombreI}</option>
                    </c:forEach>               
            </select>
            <br>
            Reunión: <select name="cboReunion" id="cboReunion" required="requiered">
                <option value="" disabled selected> Seleccione la Reunión </option>
                    <c:forEach items="${lista2}" var="R">
                        <option value=${R.idR}>${R.descripcionR}</option>
                    </c:forEach>               
            </select>
            <br>
            <label form="minutosTarde">Minutos de Demora: </label>
            <input type="text" name="minutosTarde"/>
            <br>
            <input type="submit" value="Agregar"/>
            
            <br>
            <br>
            <a href="index.html">Volver</a>
            
        </form>
    </body>
</html>
