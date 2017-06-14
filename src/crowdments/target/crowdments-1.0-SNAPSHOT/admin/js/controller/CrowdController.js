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
                $scope.profiles = {};
                $scope.profileSelected = "";
                $scope.questionSelected = 1;
                $scope.awnProfile = {};
                $scope.projects = {};
                $scope.project = {};
                $scope.awnsersUsers = {};
                $scope.projectsTodo = {};
                $scope.projectsDoing = {};
                $scope.projectsDone = {};
                $scope.task = {};
                $scope.taskid = 0;

                function obterQuestions() {
                    $http.get("../v1/questionary").success(
                            function (response) {
                                $scope.questions = response;
                            }
                    );
                }

                function obterProjects() {
                    $http.get("../v1/project").success(
                            function (response) {
                                $scope.projects = response;
                            }
                    );
                }

                obterQuestions();
                obterProjects();

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

                function obterRespostas(id) {
                    $http.get("../v1/anwser/byQuestionary/" + id).success(
                            function (response) {
                                $scope.awnsersUsers = response;
                            }
                    );
                }

                function obterEmails(id) {
                    $http.get("../v1/questionary/" + id + "/emails").success(
                            function (response) {
                                $scope.profiles = response;
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

                function projectsTodo(id) {
                    $http.get("../v1/project/" + id + "/tasks/todo").success(
                            function (response) {
                                $scope.projectsTodo = response;
                            }
                    );
                }

                function projectsDoing(id) {
                    $http.get("../v1/project/" + id + "/tasks/doing").success(
                            function (response) {
                                $scope.projectsDoing = response;
                            }
                    );
                }

                function projectsDone(id) {
                    $http.get("../v1/project/" + id + "/tasks/done").success(
                            function (response) {
                                $scope.projectsDone = response;
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

                function obterAwsProfile(id, mail) {
                    $http.get("../v1/anwser/byQuestionary/" + id + "/" + mail).success(
                            function (response) {
                                $scope.awnProfile = response;
                                console.log(response);
                            }
                    );
                }

                function obterProject(id) {
                    $http.get("../v1/project/" + id).success(
                            function (response) {
                                $scope.project = response;
                            }
                    );
                }

                $('#questions').change(function () {
                    $("#infos").hide();
                    obterQtdRespostas($(this).val());
                    obterQtdPerfis($(this).val());

                    $("#infos").show();
                });

                $('#questionProfile').change(function () {
                    $scope.questionSelected = $(this).val();
                    obterEmails($(this).val());
                });

                $('#projectTask').change(function () {
                    obterRespostas($(this).val());

                });

                $('#projectSelect').change(function () {
                    $("#infos").show();
                    projectsTodo($(this).val());
                    projectsDoing($(this).val());
                    projectsDone($(this).val());
                });

                $(document).on('show.bs.modal', '#editTaskModal', function () {
                    $http.get("../v1/task/" + $scope.taskid).success(
                            function (response) {
                                $scope.task = response;
                            }
                    );
                });
                
                $(document).on('click', '#verMais', function () {
                    $scope.taskid = $(this).val();
                });

                $('#profileMail').change(function () {
                    $scope.profileSelected = $(this).val();
                    obterAwsProfile($scope.questionSelected, $(this).val());

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

                $('.tagEx').click(function () {
                    alert('');
                    $tag = $('.tagEx').val();

                    console.log('Value: ' + $tag);
                });

                $('#projectSelect').change(function () {
                    obterProject($(this).val());
                });
                //http://localhost:8084/crowdments/v1/tag/tags
            }]);