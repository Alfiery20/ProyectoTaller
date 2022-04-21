<%-- 
    Document   : NuevoProyecto
    Created on : 6 abr. 2022, 05:30:32
    Author     : Alfiery Furlong
--%>

<%@page import="LOGIC.ProyectoServiceImpl"%>
<%@page import="BEANS.Proyecto"%>
<%@page import="BEANS.Requerimiento"%>
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
            ProyectoServiceImpl impl = new ProyectoServiceImpl();
            Proyecto tempo = impl.view((String) request.getSession().getAttribute("proyectoTempo"));
            Modulo modulo = (Modulo) request.getSession().getAttribute("modte");
            List<Requerimiento> listReq = (List<Requerimiento>) request.getSession().getAttribute("listReq");
        %>
        <%@include file="../Partes/Menu.jspf" %>
        <div id="proyectoN" class="col-md-8 order-md-1 w-50">
            <h1 class="mb-3 text-center"><%=Objects.equals(usu.getTipo(), "A") ? "Modificar" : ""%> Modulo</h1>
            <hr class="mb-4">
            <form class="needs-validation" novalidate="" method="post" action="ModuloServlet?Dato=6">
                <div class="mb-3">
                    <label>Nombre del Modulo</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="username" name="nom" value="<%=modulo.getNombre()%>" <%=Objects.equals(usu.getTipo(), "A") ? "required" : "readonly"%> >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Codigo</label>
                        <input type="text" class="form-control" id="firstName" name="cod" value="<%=modulo.getId()%>" <%=Objects.equals(usu.getTipo(), "A") ? "required" : "readonly"%> >
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Duracion</label>
                        <input type="text" class="form-control" id="lastName" name="dur" value="<%=modulo.getDuracion()%>" <%=Objects.equals(usu.getTipo(), "A") ? "required" : "readonly"%> >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="country">Tipo</label>
                        <select class="form-control custom-select d-block w-100 dropdown-menu" id="country" required="" name="tip" <%=Objects.equals(usu.getTipo(), "A") ? "required" : ""%>>

                            <%                                if (Objects.equals(tempo.getTipo(), "S")) {
                            %>
                            <option value="C" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "C") ? "SELECTED" : ""%>>Capacitacion</option>
                            <option value="B" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "B") ? "SELECTED" : ""%>>CORRECION DE BUG</option>
                            <option value="R" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "R") ? "SELECTED" : ""%>>REVISION</option>
                            <option value="O" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "O") ? "SELECTED" : ""%>>OTROS</option>
                            <%
                            } else {
                            %>
                            <option value="P" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "P") ? "SELECTED" : ""%>>NUEVO PROYECTO</option>
                            <option value="M" class="dropdown-item" <%=Objects.equals(modulo.getTipo(), "M") ? "SELECTED" : ""%>>MANTENIMIENTO</option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="mb-4">
                        <h2 class="mt-5 text-center">Requerimientos</h2>
                        <table class="table" border="1">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Requerimiento requerimiento : listReq) {
                                %>
                                <tr>
                                    <td><%=requerimiento.getNombre()%></td>
                                    <td><%=requerimiento.getEstado()%></td>
                                    <td><%=requerimiento.getDescripcion()%></td>
                                    <td>
                                        <a href="RequerimientosServlet?Dato=3&id=<%=requerimiento.getId()%>" class="btn btn-lg btn-primary"><%=Objects.equals(usu.getTipo(), "A") ? "Editar" : "Observar"%></a>
                                        <%
                                            if (Objects.equals(usu.getTipo(), "A")) {
                                        %>
                                        <a href="RequerimientosServlet?Dato=4&id=<%=requerimiento.getId()%>" class="btn btn-lg btn-danger">Eliminar</a>
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
                    <%
                        if (Objects.equals(usu.getTipo(), "A")) {
                    %>
                    <div class="col-md-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Modificar</button>
                    </div>
                    <div class="col-md-5">
                        <a href="RequerimientosServlet?Dato=1&id=<%=modulo.getId()%>" class="btn btn-primary btn-lg btn-block">Añadir Requerimiento</a>
                    </div>
                    <%
                        }
                    %>
                    <div class="col-md-5">
                        <a href="ProyectoServlet?Dato=2" class="btn btn-danger btn-lg btn-block">Regresar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
