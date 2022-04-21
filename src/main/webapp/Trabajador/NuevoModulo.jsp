<%-- 
    Document   : NuevoProyecto
    Created on : 6 abr. 2022, 05:30:32
    Author     : Alfiery Furlong
--%>

<%@page import="LOGIC.ProyectoServiceImpl"%>
<%@page import="java.util.Objects"%>
<%@page import="BEANS.Proyecto"%>
<%@page import="BEANS.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Nuevo Modulo</title>
    </head>
    <%
        ProyectoServiceImpl impl = new ProyectoServiceImpl();
        Proyecto tempo = impl.view((String) request.getSession().getAttribute("proyectoTempo"));
    %>
    <body class="position-relative">
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="col-md-8 order-md-1 w-50">
            <h1 class="mb-3 text-center">Registro de Modulo</h1>
            <hr class="mb-4">
            <form class="needs-validation" novalidate="" method="post" action="ModuloServlet?Dato=2">
                <div class="mb-3">
                    <label>Nombre del Modulo</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="username" name="nom" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Codigo</label>
                        <input type="text" class="form-control" id="firstName" name="cod" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Duracion</label>
                        <input type="text" class="form-control" id="lastName" name="dur" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="country">Tipo</label>
                        <select class="custom-select d-block w-100 dropdown-menu" id="country" required="" name="tip" required>
                            <%                                if (Objects.equals(tempo.getTipo(), "S")) {
                            %>
                            <option value="C" class="dropdown-item">CAPACITACION</option>
                            <option value="B" class="dropdown-item">CORRECION DE BUG</option>
                            <option value="R" class="dropdown-item">REVISION</option>
                            <option value="O" class="dropdown-item">OTROS</option>
                            <%
                            } else {
                            %>
                            <option value="P" class="dropdown-item">NUEVO PROYECTO</option>
                            <option value="M" class="dropdown-item">MANTENIMIENTO</option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <hr class="mb-4">
                <div class="d-flex">
                    <div class="col-md-6">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Registrar</button>
                    </div>
                    <div class="col-md-6">
                        <a href="ProyectoServlet?Dato=2" class="btn btn-danger btn-lg btn-block">Regresar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
