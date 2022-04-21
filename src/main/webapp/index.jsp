<%-- 
    Document   : index
    Created on : 5 abr. 2022, 00:43:26
    Author     : Alfiery Furlong
--%>

<%@page import="java.util.Objects"%>
<%@page import="BEANS.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Bienvenidos a Garzasoft</title>
    </head>
    <%
        String msj = (String) request.getSession().getAttribute("msj");
        if (!Objects.isNull(request.getSession().getAttribute("msj"))) {
            out.println("<script>alert('" + msj + "');</script>");
        }
    %>
    <body class="text-center">
        <main id="login" class="form-signin">
            <form method="post" action="TrabajadorServlet?Dato=1">
                <img class="mb-4" src="Imgs/login.png" alt="" width="400" height="375">
                <h1 class="h3 mb-3 fw-normal">Ingrese Credenciales</h1>
                <div class="form-floating">
                    <input type="email" class="form-control m-2" name="corr" id="floatingInput" placeholder="name@example.com" required>
                    <label for="floatingInput">Correo Electronico</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="cont" class="form-control m-2" id="floatingPassword" placeholder="Password" required>
                    <label for="floatingPassword">Contraseña</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary m-2" type="submit">Sign in</button>
            </form>
        </main>
    </body>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
