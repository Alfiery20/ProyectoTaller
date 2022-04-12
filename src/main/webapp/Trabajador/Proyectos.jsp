<%-- 
    Document   : inicio
    Created on : 6 abr. 2022, 01:38:02
    Author     : Alfiery Furlong
--%>

<%@page import="java.util.List"%>
<%@page import="BEANS.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Listado de Proyectos</title>
    </head>
    <body class="bg-light">
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="bg-light position-relative">
            <a href="ClienteServlet?Dato=1"><input type="button" class="btn-primary position-relative m-1 float-end" value="Nuevo"></a>
            <div class="bg-light py-5 row col-md-4 position-relative w-100">
                <%                    List<Proyecto> list = (List<Proyecto>) request.getSession().getAttribute("proyectos");
                    for (Proyecto proyecto : list) {
                %>
                <div class="proyectos card border-1 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><%=proyecto.getId() + " " + proyecto.getNombre()%></h5>
                        <h6 class="card-subtitle mb-2 text-muted"><%="Duracion: " + proyecto.getDuracion()%></h6>
                        <p class="card-text"><%="Estado: " + proyecto.getEtado()%></p>
                        <p class="card-text"><%="Tipo " + proyecto.getTipo()%></p>
                        <p class="card-text"><%="Presupuesto " + proyecto.getPresupuesto()%></p>
                        <p class="card-text"><%="Fecha Inicio " + proyecto.getFechaIni()%></p>
                        <p class="card-text"><%="Fecha Termino " + proyecto.getFechaTer()%></p>
                        <a href="ProyectoServlet?Dato=3&id=<%=proyecto.getId()%>"><input class="card-link btn-primary" type="button" value="Editar"></a>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
