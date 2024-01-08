var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller("professoresController", function ($scope, $http) {
    var urlProfessor = 'http://localhost:8080/Amab/rest/professores';

    function listarProfessores() {
        console.log('Chamando listarProfessores...');
        $http.get(urlProfessor)
            .then(function (response) {
                $scope.professores = response.data;
                console.log('Professores:', $scope.professores);
            })
            .catch(function (error) {
                console.error('Erro ao listar professores:', error.data);
            });
    }

    function limparCampos() {
        $scope.professor = {};
    }

    function mostrarAlerta(mensagem) {
        alert(mensagem);
    }

    $scope.selecionaProfessor = function (professorSelecionado) {
        $scope.professor = professorSelecionado;
    };

    $scope.gravarProfessor = function () {
        var metodoHTTP = $scope.professor.codigo ? $http.put : $http.post;

        metodoHTTP(urlProfessor, $scope.professor)
            .then(function (response) {
                if ($scope.professor.codigo) {
                    $scope.listarProfessores();
                    mostrarAlerta("Professor atualizado com sucesso!");
                } else {
                    $scope.professores.push(response.data);
                    limparCampos();
                    mostrarAlerta("Professor inserido com sucesso!");
                }
            })
            .catch(function (error) {
                console.error('Erro ao manipular professor:', error.data);
                mostrarAlerta("Erro ao manipular professor: " + (error.data || (error.status + ' ' + error.statusText)));
            });
    };

    $scope.excluirProfessor = function () {
        if (!$scope.professor || !$scope.professor.codigo) {
            mostrarAlerta("Escolha o professor");
        } else {
            var confirmacao = confirm("Tem certeza que deseja excluir o professor?");
            if (confirmacao) {
                $http.delete(urlProfessor + '/' + $scope.professor.codigo)
                    .then(function () {
                        var index = $scope.professores.findIndex(p => p.codigo === $scope.professor.codigo);
                        if (index !== -1) {
                            $scope.professores.splice(index, 1);
                        }
                        limparCampos();
                        mostrarAlerta("Professor excluído com sucesso!");
                    })
                    .catch(function (error) {
                        console.error('Erro ao excluir professor:', error);
                        mostrarAlerta("Erro ao excluir professor: " + (error.data || (error.status + ' ' + error.statusText)));
                    });
            }
        }
    };

    // Chamando listarProfessores ao inicializar o controlador
    listarProfessores();
});
