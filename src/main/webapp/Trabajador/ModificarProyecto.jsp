<%-- 
    Document   : NuevoProyecto
    Created on : 6 abr. 2022, 05:30:32
    Author     : Alfiery Furlong
--%>

<%@page import="BEANS.TrabajadorxProyecto"%>
<%@page import="BEANS.Modulo"%>
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
        <title>Modificar Proyecto</title>
    </head>
    <body class="position-relative">
        <%
            Proyecto prote = (Proyecto) request.getSession().getAttribute("prote");
            List<Cliente> list = (List<Cliente>) request.getSession().getAttribute("lisusu");
            List<Modulo> listModu = (List<Modulo>) request.getSession().getAttribute("listmodu");
            List<Trabajador> listTrab = (List<Trabajador>) request.getSession().getAttribute("listTrab");
            TrabajadorxProyecto TXP = (TrabajadorxProyecto) request.getSession().getAttribute("TXP");
        %>
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="col-md-8 order-md-1 w-50">
            <h1 class="mb-3 text-center"><%=usu.getTipo() == "A" ? "Modificar de " : ""%>Proyecto</h1>
            <hr class="mb-4">
            <form class="needs-validation" novalidate="" method="post" action="ProyectoServlet?Dato=4">
                <div class="mb-3">
                    <label>Nombre del Proyecto</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="username" name="nom" value="<%=prote.getNombre()%>" <%=usu.getTipo() == "A" ? "required" : "readonly"%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Codigo</label>
                        <input type="text" class="form-control" id="firstName" name="cod" value="<%=prote.getId()%>" readonly>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Duracion</label>
                        <input type="text" class="form-control" id="lastName" name="dur" value="<%=prote.getDuracion()%>" <%=usu.getTipo() == "A" ? "required" : "readonly"%> >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Presupuesto</label>
                        <input type="number" class="form-control" id="firstName" name="pre" value="<%=prote.getPresupuesto()%>" <%=usu.getTipo() == "A" ? "required" : "readonly"%>>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Estado</label>
                        <div class="d-flex" >
                            <div class="custom-control custom-radio m-2">
                                <input name="est" value="P" type="radio" class="custom-control-input" <%=Objects.equals(prote.getEtado(), "P") ? "checked" : ""%> <%=usu.getTipo() == "A" ? "required" : "disabled"%>>
                                <label class="custom-control-label" for="credit">Pendiente</label>
                            </div>
                            <div class="custom-control custom-radio m-2">
                                <input name="est" value="E" type="radio" class="custom-control-input" <%=Objects.equals(prote.getEtado(), "E") ? "checked" : ""%> <%=usu.getTipo() == "A" ? "required" : "disabled"%>>
                                <label class="custom-control-label" for="debit">En Progreso</label>
                            </div>
                            <div class="custom-control custom-radio m-2">
                                <input name="est" value="T" type="radio" class="custom-control-input" <%=Objects.equals(prote.getEtado(), "T") ? "checked" : ""%> <%=usu.getTipo() == "A" ? "required" : "disabled"%>>
                                <label class="custom-control-label" for="paypal">Terminado</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Fecha Inicio</label>
                        <input type="date" class="form-control" id="firstName" name="fin" value="<%=prote.getFechaIni()%>" <%=usu.getTipo() == "A" ? "required" : "readonly"%>>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Fecha Termino</label>
                        <input type="date" class="form-control" id="lastName" name="fet" value="<%=prote.getFechaTer()%>" <%=usu.getTipo() == "A" ? "required" : "readonly"%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Tipo</label>
                        <div class="d-flex">
                            <div class="custom-control custom-radio m-2">
                                <input id="credit" name="tip" value="D" type="radio" class="custom-control-input" <%=Objects.equals(prote.getTipo(), "D") ? "checked" : ""%> <%=usu.getTipo() == "A" ? "required" : "disabled"%>>
                                <label class="custom-control-label" for="credit">Desarollo</label>
                            </div>
                            <div class="custom-control custom-radio m-2">
                                <input id="debit" name="tip" value="S" type="radio" class="custom-control-input" <%=Objects.equals(prote.getTipo(), "S") ? "checked" : ""%> <%=usu.getTipo() == "A" ? "required" : "disabled"%>>
                                <label class="custom-control-label" for="debit">Soporte</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 mb-3">
                        <label for="country">Cliente</label>
                        <select class="custom-select d-block w-100" id="country" required="" name="cli" <%=usu.getTipo() == "A" ? "required" : "disabled"%>>
                            <option value="">[SELECCIONE]</option>
                            <%
                                for (Cliente cliente : list) {
                            %>
                            <option value="<%=cliente.getDNI()%>" <%=Objects.equals(prote.getClienteDNI(), cliente.getDNI()) ? "selected" : ""%>>
                                <%=cliente.getNombre() + " " + cliente.getApellidos()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="mb-5">
                        <label>Trabajador designado: </label>
                        <select class="custom-select d-block w-100 dropdown-menu" id="country" required="" name="tra" required>
                            <option class="dropdown-item" value="">[SELECCIONE]</option>
                            <%
                                for (Trabajador trabajador : listTrab) {
                            %>
                            <option class="dropdown-item" value="<%=trabajador.getId()%>" <%=Objects.equals(TXP.getTrabajadorId(), trabajador.getId()) ? "selected" : ""%>><%=trabajador.getNombre() + " " + trabajador.getApellidos()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <h2 class="mb-3 text-center">Modulos</h2>
                        <table class="table" border="1">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Duracion</th>
                                    <th scope="col">Tipo</th>
                                    <th scope="col">Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Modulo modulo : listModu) {
                                %>
                                <tr>
                                    <td><%=modulo.getNombre()%></td>
                                    <td><%=modulo.getDuracion()%></td>
                                    <td><%=modulo.getTipo()%></td>
                                    <td>
                                        <a href="ModuloServlet?Dato=4&id=<%=modulo.getId()%>" class="btn btn-lg btn-primary"><%=usu.getTipo() == "A" ? "Editar" : "Observar"%></a>
                                        <%if (usu.getTipo() == "A") {
                                        %>
                                        <a href="ModuloServlet?Dato=5&id=<%=modulo.getId()%>" class="btn btn-lg btn-danger">Eliminar</a>
                                        <%
                                            }
                                        %>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>

                    </div>
                </div>    
                <hr class="mb-4">
                <div class="d-flex">
                    <%if (usu.getTipo() == "A") {
                    %>
                    <div class="col-md-3">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Modificar</button>
                    </div>
                    <div class="col-md-4">
                        <a href="ModuloServlet?Dato=1&id=<%=prote.getId()%>" class="btn btn-primary btn-lg btn-block">Añadir Modulo</a>
                    </div>
                    <div class="col-md-3">
                        <a href="ProyectoServlet?Dato=5&id=<%=prote.getId()%>" class="btn btn-danger btn-lg btn-block">Eliminar</a>
                    </div>
                    <%
                        }
                    %>
                    <div class="col-md-3">
                        <a href="ProyectoServlet?Dato=2" class="btn btn-primary btn-lg btn-block">Regresar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
