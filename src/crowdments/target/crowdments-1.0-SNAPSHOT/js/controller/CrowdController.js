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

                function obterEstados() {
                    $http.get("js/estados-cidades.json").success(
                            function (response) {
                                $scope.estados = response.estados;
                                $scope.cidades = $scope.estados[0].cidades;
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
                    $scope.people.nome = $('#name').val();
                    $scope.people.email = $('#email').val();
                    $scope.people.state = $('#state').val();
                    $scope.people.sex = $('#sex').val();
                    $scope.people.position = $('#position').val();
                    $scope.people.city = $('#city').val();
                    $scope.people.age = $('#age').val();
                    $scope.people.studies = $('#studies').val();
                    $scope.people.typeProfile = $scope.typeProfile;

                    if ($scope.people.nome != "" &&
                            $scope.people.email != "" &&
                            $scope.people.position != "" &&
                            $scope.people.state != "Escolha um estado válido" &&
                            $scope.people.city != "Escolha uma cidade válida"
                            ) {
                        $("#one").hide();
                        $("#two").show();

                    }
                    console.log($scope.people);
                });
                
                $('#submitAws').click(function () {
                    var count = -1;
                    var values = $("input[id='awnser[]']").map(function(){   
                        count ++;
                        return {'id': count, 'awnser': $(this).val()};                        
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