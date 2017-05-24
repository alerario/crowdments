<!DOCTYPE html>
<html ng-app="Crowd">
    <head>        
        <title>Crowdsourcing: participe você também - Ricardo Alvim</title>
        <jsp:include page="head.jsp"></jsp:include>
        </head>
        <body ng-controller="CrowdController">
            <header>
            <jsp:include page="header.jsp"></jsp:include>
        </header>
        <article id="responda">
            <div id="one">
                <h1>Algumas informações básicas sobre você.</h1>
                <h3>1. Responda a seguir algumas informações para que possamos entender melhor quem é você</h3>
                <!--<div class="form-group">
                    <label for="name" class="col-lg-2 control-label">Seu nome (obrigatório)</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control options" id="name" placeholder="Preencha seu nome, não precisa ser ele todo, mas se preferir, iremos agradecer!">
                    </div>
                </div>-->

                <div class="form-group">
                    <label for="email" class="col-lg-2 control-label">Seu email (obrigatório)</label>
                    <div class="col-lg-10">
                        <input maxlength="60" type="email" class="form-control options" id="email" placeholder="Preencha seu email" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="state" class="col-lg-2 control-label">Seu estado (obrigatório)</label>
                    <div class="col-lg-10">
                        <select class="form-control options" id="state" required>
                            <option>Escolha um estado válido</option>
                            <option ng-repeat="e in estados" value="{{ e.id}}">{{ e.nome}}</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="city" class="col-lg-2 control-label">Sua cidade (obrigatório)</label>
                    <div class="col-lg-10">
                        <select class="form-control options" id="city" required>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="age" class="col-lg-2 control-label">Faixa etaria (obrigatório)</label>
                    <div class="col-lg-10">
                        <select class="form-control options" id="agerange" required>
                            <option>Escolha uma faixa de idade válida</option>
                            <option value="17">Menos de 18 anos</option>
                            <option value="18">Entre 18 e 22 anos</option>
                            <option value="22">Entre 22 e 30 anos</option>
                            <option value="30">Entre 30 e 40 anos</option>
                            <option value="40">Entre 40 e 50 anos</option>
                            <option value="50">Mais de 50 anos</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="sex" class="col-lg-2 control-label">Sexo (obrigatório)</label>
                    <div class="col-lg-10">
                        <div class="radio options">
                            <label>
                                <input type="radio" name="sex" id="sex" value="F" checked="">
                                Feminino
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="sex" id="sex" value="M">
                                Masculino
                            </label>
                        </div>
                    </div>
                </div> 
                <div class="form-group">
                    <label for="studies" class="col-lg-2 control-label">Escolaridade (obrigatório)</label>
                    <div class="col-lg-10">
                        <select class="form-control options" id="studies" required>
                            <option value="Escolha uma opção">Escolha uma opção</option>
                            <option value="emi">Ensino Médio (Incompleto</option>
                            <option value="emc">Ensino Médio (Completo)</option>
                            <option value="esi">Ensino Superior (Incompleto)</option>
                            <option value="esc">Ensino Superior (Completo)</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="position" class="col-lg-2 control-label">Profissão (obrigatório)</label>
                    <div class="col-lg-10">
                        <input maxlength="60" required type="position" class="form-control options" id="position" placeholder="Informe sua profissão (ex. Analista de Sistemas)">
                    </div>
                </div>
                <button id="submitOne" type="submit" class="btn btn-primary">Próxima página</button>
            </div>
            <div id="two">
                <h1>{{ quest.question}}</h1>
                <div class="input_fields_wrap">
                    <button class="addMoreAwnswer btn btn-success btAws">+</button>
                    <input maxlength="60" class="form-control options inputAw" type="text" id="awnser[]" name="awnser[]">                    
                </div>      

                <div class="col-sm-12 enviar">
                    <hr>
                    <button id="submitAws" type="submit" class="btn btn-primary">Enviar seu crowd!</button>
                </div>
            </div>

            <div id="three">
                <h1>Obrigado!</h1> 
                <h4>Agradecemos por sua opinião, que é muito importante para nós! <br>
                    Esperamos que em breve ter novos questionários para que você responda</h4>  
            </div>

            <div class="modal" id="verifique" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Atenção!</h4>
                        </div>
                        <div class="modal-body">
                            <p>Você se esqueceu de algum campo! Por favor, verifique e responda novamente!</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

        </article>
    </body>
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/controller.responda.js"></script>
</html>
