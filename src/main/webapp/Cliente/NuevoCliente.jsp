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
        <title>Nuevo Proyecto</title>
    </head>
    <body class="position-relative">
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="col-md-8 order-md-1 w-50">
            <h1 class="mb-3 text-center">Registro de Cliente</h1>
            <hr class="mb-4">
            <form class="needs-validation" novalidate="" method="post" action="ClienteServlet?Dato=3">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Nombre:</label>
                        <input type="text" class="form-control" name="nom" placeholder="Ingrese Nombre..." required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Apellido:</label>
                        <input type="text" class="form-control" name="ape" placeholder="Ingrese Apellidos...">
                    </div>
                </div>
                <div class="mb-3">
                    <label>Direccion</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="dir" placeholder="Ingrese Direccion...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>DNI:</label>
                        <input type="text" class="form-control" name="dni" placeholder="Ingrese DNI...">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Correo</label>
                        <input type="email" class="form-control" name="cor" placeholder="Ingrese Correo...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Telefono: </label>
                        <input type="text" class="form-control" name="tel" placeholder="Ingrese Telefono...">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Estado</label>
                        <div class="d-flex">
                            <div class="custom-control custom-radio m-2">
                                <input name="tip" value="N" type="radio" class="custom-control-input">
                                <label class="custom-control-label" for="credit">Nuevo </label>
                            </div>
                            <div class="custom-control custom-radio m-2">
                                <input name="tip" value="A" type="radio" class="custom-control-input">
                                <label class="custom-control-label" for="debit">Antiguo</label>
                            </div>
                        </div>
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
