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
        <h1>Projeto</h1>
        <div class="row">
            <div class="col-lg-9">
                <select class="form-control options" id="projectSelect" required>
                    <option>Escolha um projeto</option>
                    <option ng-repeat="p in projects" value="{{ p.id}}">{{ p.name}}</option>
                </select>
            </div>
            <div class="col-lg-3">
                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#addProjectModal">Adicionar projeto</a>
            </div>
        </div>

        <div id="infos">
            <div class="row">            
                <div class="col-lg-3">
                    <a href="#" class="btn btn-success" data-toggle="modal" data-target="#addTaskModal">Adicionar tarefa</a>
                </div>
            </div>
            <div class="col-lg-4">
                <h1>Para fazer</h1>
                <div class="panel panel-primary" ng-repeat="p in projectsTodo" value="{{ p.id}}">
                    <div class="panel-heading">
                        <h3 class="panel-title">{{ p.description}}</h3>
                    </div>
                    <div class="panel-body">
                        <p>Resposta relacionada: {{ p.awnser.anwser}}</p>
                        <hr>    
                        <p>Prazo: {{ p.duedate}}</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <h1>Sendo feito</h1>
                <div class="panel panel-warning" ng-repeat="p in projectsDoing" value="{{ p.id}}">
                    <div class="panel-heading">
                        <h3 class="panel-title">{{ p.description}}</h3>
                    </div>
                    <div class="panel-body">
                        <p>Resposta relacionada: {{ p.awnser.anwser}}</p>
                        <hr>    
                        <p>Prazo: {{ p.duedate}}</p>
                    </div>
                </div>                
            </div>
            <div class="col-lg-4">
                <h1>Feito</h1>
                <div class="panel panel-success" ng-repeat="p in projectsDoing" value="{{ p.id}}">
                    <div class="panel-heading">
                        <h3 class="panel-title">{{ p.description}}</h3>
                    </div>
                    <div class="panel-body">
                        <p>Resposta relacionada: {{ p.awnser.anwser}}</p>
                        <hr>    
                        <p>Prazo: {{ p.duedate}}</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="addProjectModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Criar projeto</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="control-label" for="nameProj">Nome do Projeto</label>
                            <input class="form-control" id="nameProj" type="text">
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="briefProj">Briefing</label>
                            <textarea class="form-control" id="briefProj" type="text"></textarea>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="startProj">Início do Projeto</label>
                            <input class="form-control" id="startProj" type="date"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="startProj">Fim do Projeto</label>
                            <input class="form-control" id="endsProj" type="date"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="questionProject">Questionário</label>
                            <select class="form-control options" id="questionProject" required>
                                <option>Escolha um questionário válido</option>
                                <option ng-repeat="q in questions" value="{{ q.id}}">{{ q.name}}</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-sucess" data-dismiss="modal">Salvar</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal end -->

        <!-- Modal -->
        <div class="modal fade" id="addTaskModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Criar tarefa</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="control-label" for="projectTask">Questionário</label>
                            <select class="form-control options" id="projectTask" required>
                                <option>Escolha um projeto válido</option>
                                <option ng-repeat="p in projects" value="{{ p.id}}">{{ p.name}}</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="descriptionTask">Descrição da Tarefa</label>
                            <input class="form-control" id="descriptionTask" type="text">
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="awTask">Relacionada a resposta</label>
                            <select class="form-control options" id="awTask" required>
                                <option>Escolha um projeto válido</option>
                                <option ng-repeat="a in awnsersUsers" value="{{ a.id}}">{{ a.anwser}}</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="control-label" for="startProj">Data de Termino</label>
                            <input class="form-control" id="duedate" type="date"/>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-sucess" data-dismiss="modal">Salvar</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal end -->
    </body>
</html>
