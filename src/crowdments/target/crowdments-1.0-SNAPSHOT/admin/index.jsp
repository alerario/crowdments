<%-- 
    Document   : index
    Created on : 27/05/2017, 19:04:12
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Crowd</title>
        <jsp:include page="head.jsp"></jsp:include>
    </head>
    <header>
        <jsp:include page="header.jsp"></jsp:include>
    </header>
    <body>
        <h1>Login!</h1>
        <form id="login">
            <div class="col-lg-10">
                <input type="text" class="form-control options" id="email" placeholder="Email!">
            </div>
            <div class="col-lg-10">
                <input type="text" class="form-control options" id="password" placeholder="Senha">
            </div>
            <button id="login" type="submit" class="btn btn-primary">Entrar</button>
        </form>
    </body>
</html>
