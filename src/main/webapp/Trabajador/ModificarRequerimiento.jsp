<%-- 
    Document   : NuevoProyecto
    Created on : 6 abr. 2022, 05:30:32
    Author     : Alfiery Furlong
--%>

<%@page import="BEANS.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Nuevo Requerimiento</title>
    </head>
    <body class="position-relative">
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="col-md-8 order-md-1 w-50">
            <h1 class="mb-3 text-center">Registro de Requerimiento</h1>
            <hr class="mb-4">
            <form class="needs-validation" novalidate="" method="post" action="RequerimientosServlet?Dato=2">
                <div class="mb-3">
                    <label>Nombre del Requerimiento</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="username" name="nom">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Codigo</label>
                        <input type="text" class="form-control" id="firstName" name="cod">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Estado</label>
                        <div class="d-flex">
                            <div class="custom-control custom-radio m-1">
                                <input id="credit" name="tip" value="P" type="radio" class="custom-control-input">
                                <label class="custom-control-label" for="credit">Pendiente</label>
                            </div>
                            <div class="custom-control custom-radio m-1">
                                <input id="debit" name="tip" value="E" type="radio" class="custom-control-input">
                                <label class="custom-control-label" for="debit">En progreso</label>
                            </div>
                            <div class="custom-control custom-radio m-1">
                                <input id="debit" name="tip" value="T" type="radio" class="custom-control-input">
                                <label class="custom-control-label" for="debit">Terminado</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="country">Descripcion</label>
                        <textarea class="custom-control custom-radio m-1" id="id" name="des" rows="10" cols="90"></textarea>
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
