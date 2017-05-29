<%-- 
    Document   : index
    Created on : 27/05/2017, 19:04:12
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="Crowd">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard - Crowd</title>
        <jsp:include page="head.jsp"></jsp:include>
        </head>
        <header>
        <jsp:include page="header.jsp"></jsp:include>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript" src="js/controller.responda.js"></script>
    </header>
    <body ng-controller="CrowdController">
        <h1>Projeto</h1>
        
        <div class="col-lg-12">
            <select class="form-control options" id="project" required>
                <option>Escolha um projeto</option>
                <option ng-repeat="p in project" value="{{ p.id}}">{{ p.mail }}</option>
            </select>
        </div>
        <div class="col-lg-3">
            <h1>Para fazer</h1>
        </div>
        <div class="col-lg-3">
            <h1>Sendo feito</h1>
        </div>
        <div class="col-lg-3">
            <h1>Feito</h1>
        </div>
    </body>
</html>
