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
        <%
            List<Cliente> list = (List<Cliente>) request.getSession().getAttribute("lisusu");
        %>
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="col-md-8 order-md-1 w-50">
            <h1 class="mb-3 text-center">Registro de Proyecto</h1>
            <hr class="mb-4">
            <form class="needs-validation" novalidate="" method="post" action="ProyectoServlet?Dato=1">
                <div class="mb-3">
                    <label>Nombre del Proyecto</label>
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
                    <div class="col-md-6 mb-3">
                        <label>Presupuesto</label>
                        <input type="number" class="form-control" id="firstName" name="pre" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Estado</label>
                        <div class="d-flex">
                            <div class="custom-control custom-radio m-2">
                                <input id="credit" name="est" value="P" type="radio" class="custom-control-input" checked="" required>
                                <label class="custom-control-label" for="credit">Pendiente</label>
                            </div>
                            <div class="custom-control custom-radio m-2">
                                <input id="debit" name="est" value="E" type="radio" class="custom-control-input" required>
                                <label class="custom-control-label" for="debit">En Progreso</label>
                            </div>
                            <div class="custom-control custom-radio m-2">
                                <input id="paypal" name="est" value="T" type="radio" class="custom-control-input" required>
                                <label class="custom-control-label" for="paypal">Terminado</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Fecha Inicio</label>
                        <input type="date" class="form-control" id="firstName" name="fin" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Fecha Termino</label>
                        <input type="date" class="form-control" id="lastName" name="fet" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Tipo</label>
                        <div class="d-flex">
                            <div class="custom-control custom-radio m-2">
                                <input id="credit" name="tip" value="D" type="radio" class="custom-control-input" checked="" required>
                                <label class="custom-control-label" for="credit">Desarollo</label>
                            </div>
                            <div class="custom-control custom-radio m-2">
                                <input id="debit" name="tip" value="S" type="radio" class="custom-control-input" required>
                                <label class="custom-control-label" for="debit">Soporte</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 mb-3">
                        <label for="country">Cliente</label>
                        <select class="custom-select d-block w-100" id="country" required="" name="cli" required>
                            <option value="">[SELECCIONE]</option>
                            <%                                for (Cliente cliente : list) {
                            %>
                            <option value="<%=cliente.getDNI()%>"><%=cliente.getNombre() + " " + cliente.getApellidos()%></option>
                            <%
                                }
                            %>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid country.
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
