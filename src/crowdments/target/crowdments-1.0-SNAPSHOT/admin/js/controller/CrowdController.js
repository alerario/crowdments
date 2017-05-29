angular.module("Crowd").
        controller("CrowdController", ["$scope", "$http", function ($scope, $http) {

                $scope.questions = {};
                $scope.qtdAwTotal = 0;
                $scope.qtdProfiles = 0;
                $scope.qtdAwProfiles = 0.0;
                $scope.qtdFinished = 0;
                $scope.qtdTagsCreated = 0;
                $scope.tags = {};
                $scope.anwsers = {};

                function obterQuestions() {
                    $http.get("../v1/questionary").success(
                            function (response) {
                                $scope.questions = response;
                            }
                    );
                }
                obterQuestions();

                //http://localhost:8084/crowdments/v1/questionary/1/emails

                $(document).ready(function () {
                    $("#infos").hide();
                });

                function obterQtdRespostas(id) {
                    $http.get("../v1/anwser/byQuestionary/" + id).success(
                            function (response) {
                                $scope.qtdAwTotal = response.length;
                            }
                    );
                }

                function obterAvgPerfis(id) {
                    $http.get("../v1/questionary/" + id + "/emails").success(
                            function (response) {
                                $scope.qtdFinished = response.length;
                                var avg = (parseFloat($scope.qtdAwTotal) / parseFloat($scope.qtdFinished)).toFixed(2);
                                $scope.qtdAwProfiles = avg;
                            }
                    );
                }

                function obterQtdPerfis(id) {
                    $http.get("../v1/profile").success(
                            function (response) {
                                $scope.qtdProfiles = response.length;
                                obterAvgPerfis(id);
                            }
                    );
                }

                function obterQtdTags() {
                    $http.get("../v1/tag/tags").success(
                            function (response) {
                                $scope.qtdTagsCreated = response.length;
                                $scope.tags = response;
                            }
                    );
                }


                function obterAws(id) {
                    $http.get("../v1/anwser/byQuestionary/" + id).success(
                            function (response) {
                                $scope.anwsers = response;
                            }
                    );
                }

                $('#questions').change(function () {
                    $("#infos").hide();
                    obterQtdRespostas($(this).val());
                    obterQtdPerfis($(this).val());

                    $("#infos").show();
                });

                $('#questionTag').change(function () {
                    $("#infos").hide();
                    obterQtdTags();
                    obterAws($(this).val());
                    obterQtdPerfis($(this).val());

                    $("#infos").show();
                });

                $('#vincular').click(function () {
                    $tag = $('#tagMatchDesc').val();

                    var aw = [];
                    $('#tagMatchAw :selected').each(function (i, selected) {
                        var match = {"anwser": {"id": aw[i] = $(selected).val()},
                            "tagpattern": {"id": $tag}
                        };
                        $http({
                            url: '../v1/tag',
                            method: "POST",
                            data: match
                        }).then(function (response) {
                            console.log(response);
                        },
                                function (response) { // optional
                                    console.log(response);
                                });
                    });
                });
                
                $('.tagEx').click( function () {
                    alert('');
                    $tag = $('.tagEx').val();
                    
                    console.log('Value: ' +$tag);
                });

                //http://localhost:8084/crowdments/v1/tag/tags
            }]);