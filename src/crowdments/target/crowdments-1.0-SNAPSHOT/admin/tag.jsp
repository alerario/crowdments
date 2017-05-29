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
        <script type="text/javascript" src="js/tags.graph.js"></script>
    </header>
    <body ng-controller="CrowdController">
        <h1>Tag!</h1>
        <div class="col-lg-12">
            <select class="form-control options" id="questionTag" required>
                <option>Escolha um questionário válido</option>
                <option ng-repeat="q in questions" value="{{ q.id}}">{{ q.name}}</option>
            </select>
        </div>
        <div id="infos">
            <div class="row">
                <h1>Tags</h1>
                <div class="col-lg-2">
                    <h2>Geral</h2>
                    <p>Já cadastradas: {{qtdTagsCreated}}</p>
                    <p>Número de participantes: {{qtdProfiles}}</p>
                    <!--<p>Respostas sem tags: {{qtdProfiles}}</p> -->
                    <h2>Ações</h2>
                    <div class="row">
                        <div class="col-lg-3">
                            <a class="btn btn-default" data-toggle="modal" data-target="#createTag">Criar nova tag</a>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="col-lg-3">                        
                            <a class="btn btn-success" data-toggle="modal" data-target="#matchTag">Vincular tag</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <h2>Respostas</h2>
                    <ul>
                        <li ng-repeat="a in anwsers">{{a.anwser}}</li>
                    </ul>
                </div>
                <div class="col-lg-4">
                    <h2>Gráfico</h2>
                    <button id="tagEx" class="btn btn-info" data-toggle="modal" data-target="#graphicTagsModal">Ver</button>
                    
                    
                </div>
                <div class="col-lg-3">
                    <h2>Tags existentes</h2>
                    <ul>
                        <button id="tagEx" class="btn btn-info tagEx" data-toggle="modal" data-target="#showTag" value={{t.id}} ng-repeat="t in tags">R{{t.id}} - {{t.description}}</button>
                    </ul>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="matchTag" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Vincular tags</h4>
                        </div>
                        <div class="modal-body">
                            <div class="matchTag">
                                <div class="col-lg-12">
                                    <select class="form-control options" id="tagMatchDesc" required>
                                        <option>Escolha uma tag válida</option>
                                        <option ng-repeat="t in tags" value="{{ t.id}}">R{{ t.id}} - {{ t.description}}</option>
                                    </select>
                                </div>    
                                <div class="col-lg-12">                        
                                    <select multiple id="tagMatchAw" class="form-control">
                                        <option ng-repeat="a in anwsers" value="{{ a.id}}">{{ a.anwser}}</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="vincular" class="btn btn-sucess" data-dismiss="modal">Vincular</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="createTag" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Criar Tag</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="control-label" for="descTag">Descrição</label>
                                <input class="form-control" id="descTag" type="text" placeholder="Descreva aqui os requisitos da tag">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-sucess" data-dismiss="modal">Salvar</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            
            <!-- Modal -->
            <div class="modal fade" id="graphicTagsModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Ver tags</h4>
                        </div>
                        <div class="modal-body">
                            <div id="tagsGraph"></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>

                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="showTags" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Criar Tag</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="control-label" for="descTag">Descrição</label>
                                <input class="form-control" id="descTag" type="text" placeholder="Descreva aqui os requisitos da tag">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-sucess" data-dismiss="modal">Salvar</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            
            <!-- Modal -->
            <div class="modal fade" id="showTag" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">{{ tag.id }} - {{ tag.description }}</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="control-label" for="descTag">Descrição</label>
                                <input class="form-control" id="descTag" type="text" placeholder="Descreva aqui os requisitos da tag">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-sucess" data-dismiss="modal">Salvar</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
    </body>
</html>
