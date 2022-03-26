<%-- 
    Document   : reporte2
    Created on : 25-ene-2019, 14:54:22
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
        <h1>Reporte N°2</h1>
        
        Porcentaje de Asistentes que llegaron "Temprano" = ${lista} %
        <br>
        Porcentaje de Asistentes que llegaron "Tarde" = ${lista2} %
        <br>
        Porcentaje de Asistentes que llegaron "Muy Tarde" = ${lista3}%
        
        <br>
        <a href="index.html">Volver</a>
    </body>
</html>
