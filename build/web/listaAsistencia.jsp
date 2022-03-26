<%-- 
    Document   : listaAsistencia
    Created on : 24-ene-2019, 15:42:14
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Asistencia</title>
    </head>
    <body>
        <h1>Lista de Asistencia</h1>
        
        <table border="1">
            
            <tr><th>Nombre</th><th>Reunión</th><th>Minutos de Retraso</th><th>Puntualidad</th></tr>
            
            <c:forEach items="${lista}" var="A">
                
                <tr><td>${A.nombreI}</td><td>${A.descripcionR}</td><td>${A.minutosTarde}</td><td>${A.puntualidad()}</td></tr>
                
            </c:forEach>
            
        </table>
        <br>
        <a href="index.html">Volver</a>
        
        
    </body>
</html>
