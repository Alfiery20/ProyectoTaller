<%-- 
    Document   : NuevoProyecto
    Created on : 6 abr. 2022, 05:30:32
    Author     : Alfiery Furlong
--%>

<%@page import="java.util.Objects"%>
<%@page import="BEANS.Modulo"%>
<%@page import="BEANS.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Modulo</title>
    </head>
    <body class="position-relative">
        <%
            Modulo modulo = (Modulo) request.getSession().getAttribute("modte");
        %>
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="col-md-8 order-md-1 w-50">
            <h1 class="mb-3 text-center">Modificar de Modulo</h1>
            <hr class="mb-4">
            <form class="needs-validation" novalidate="" method="post" action="ModuloServlet?Dato=6">
                <div class="mb-3">
                    <label>Nombre del Modulo</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="username" name="nom" value="<%=modulo.getNombre()%>">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Codigo</label>
                        <input type="text" class="form-control" id="firstName" name="cod" value="<%=modulo.getId()%>">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Duracion</label>
                        <input type="text" class="form-control" id="lastName" name="dur" value="<%=modulo.getDuracion()%>">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="country">Tipo</label>
                        <select class="custom-select d-block w-100 dropdown-menu" id="country" required="" name="tip">
                            <option value="C" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "C") ? "SELECTED" : ""%>>Capacitacion</option>
                            <option value="B" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "B") ? "SELECTED" : ""%>>CORRECION DE BUG</option>
                            <option value="R" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "R") ? "SELECTED" : ""%>>REVISION</option>
                            <option value="P" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "P") ? "SELECTED" : ""%>>NUEVO PROYECTO</option>
                            <option value="M" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "M") ? "SELECTED" : ""%>>MANTENIMIENTO</option>
                            <option value="O" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "O") ? "SELECTED" : ""%>>OTROS</option>
                        </select>
                    </div>
                </div>
                <hr class="mb-4">
                <div class="d-flex">
                    <div class="col-md-6">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Modificar</button>
                    </div>
                    <div class="col-md-6">
                        <a href="ProyectoServlet?Dato=2" class="btn btn-danger btn-lg btn-block">Regresar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
