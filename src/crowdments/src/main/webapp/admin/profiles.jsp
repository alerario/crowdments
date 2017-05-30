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
    </header>
    <body ng-controller="CrowdController">
        <h1>Perfil</h1>
        <div class="col-lg-12">
            <select class="form-control options" id="questionProfile" required>
                <option>Escolha um questionário válido</option>
                <option ng-repeat="q in questions" value="{{ q.id}}">{{ q.name }}</option>
            </select>
        </div>
        <div class="col-lg-12">
            <select class="form-control options" id="profileMail" required>
                <option>Escolha um perfil</option>
                <option ng-repeat="p in profiles" value="{{ p.mail }}">{{ p.mail }}</option>
            </select>
        </div>
        
        <div id="infos">
            <div class="row">
                <h1>Respostas de {{profileSelected }}</h1>
                
                <ul>
                    <li ng-repeat="a in awnProfile">{{ a.anwser }}</li>
                </ul>
            </div>
    </body>
</html>
