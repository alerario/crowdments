angular.module("Crowd").
        controller("CrowdController", ["$scope", "$http", function ($scope, $http) {
                //scope é um serviço do angular
                //ao declarar ele acima, é feito uma dep injection para uso do mesmo
                //para uso de scopes do angular

                $scope.estados = {};
                $scope.cidades = {};

                $scope.userResponse = {};
                $scope.people = {};
                $scope.awnsers = {};
                $scope.estadoSel = '';
                $scope.typeProfile = {'id': 2};
                $scope.quest = {};

                function obterEstados() {
                    $http.get("js/estados-cidades.json").success(
                            function (response) {
                                $scope.estados = response.estados;
                                $scope.cidades = $scope.estados[0].cidades;
                            }
                    );
                }

                function obterQuestao() {
                    $http.get("v1/question/1").success(
                            function (response) {
                                $scope.quest = response;
                            }
                    );
                }

                

                $('#state').change(function () {
                    $scope.estadoSel = $(this).val();
                    $cidades = $scope.estados[$scope.estadoSel].cidades;

                    $.each($cidades, function (i, d) {
                        $('<option>').val(d).text(d).appendTo('#city');
                    });
                });

                $('#submitOne').click(function () {
                    //$scope.people.name = $('#name').val();
                    $scope.people.mail = $('#email').val();
                    $scope.people.state = $('#state').val();
                    $scope.people.sex = $('input[name=sex]:checked').val();
                    $scope.people.position = $('#position').val();
                    $scope.people.city = $('#city').val();
                    $scope.people.age = $('#agerange').val();
                    $scope.people.studies = $('#studies').val();
                    $scope.people.typeprofile = $scope.typeProfile;

                    if (    $scope.people.email != "" &&
                            $scope.people.position != "" &&
                            $scope.people.age != "Escolha uma faixa de idade válida" &&
                            $scope.people.state != "Escolha um estado válido" &&
                            $scope.people.studies != "Escolha uma opção" && 
                            $scope.people.city != "Escolha uma cidade válida"
                            ) {
                        $("#one").hide();
                        $("#two").show();

                        var id = 0;
                        $http({
                            url: 'v1/profile',
                            method: "POST",
                            data: $scope.people
                        }).success(function (data, status, headers, config) {
                            $scope.people = data.object;
                        }).error(function (data, status, headers, config) {
                            $scope.status = status;
                        });

                        console.log($scope.people);
                        obterQuestao();
                    } else {
                        $('#verifique').modal('toggle');
                        $('#verifique').show();
                    }
                });

                $('#submitAws').click(function () {
                    var count = -1;
                    var values = $("input[id='awnser[]']").map(function () {
                        count++;

                        var aw = {'anwser': $(this).val(),
                            'score': 1};

                        var awnser = {
                            'anwser': aw,
                            'profile': $scope.people,
                            'question': $scope.quest};

                        $http({
                            url: 'v1/anwser',
                            method: "POST",
                            data: awnser
                        })
                                .then(function (response) {
                                    $("#two").hide();
                                    $("#three").show();
                                },
                                        function (response) { // optional
                                            console.log(response);
                                        });

                        return awnser;
                    }).get();
                    console.log(values);
                });


                obterEstados();

                var max_fields = 5; //maximum input boxes allowed
                var wrapper = $(".input_fields_wrap"); //Fields wrapper
                var add_button = $(".addMoreAwnswer"); //Add button ID

                var x = 1; //initlal text box count
                $(add_button).click(function (e) { //on add input button click
                    e.preventDefault();
                    var length = wrapper.find("input:text").length;

                    if (x < max_fields) { //max input box allowed
                        x++; //text box increment
                        $(wrapper).append('<div><input class="form-control options inputAw" type="text" id="awnser[]" name="awnser[]"' + (length + 1) + '" /><a href="#" class="btn btn-danger inputAw removeAws btAws">-</a></div>'); //add input box
                    }
                    //Fazendo com que cada uma escreva seu name
                    /*wrapper.find("input:text").each(function () {
                     $(this).val($(this).attr('name'))
                     }); */
                });

                $(wrapper).on("click", ".removeAws", function (e) { //user click on remove text
                    e.preventDefault();
                    $(this).parent('div').remove();
                    x--;
                })
            }]);