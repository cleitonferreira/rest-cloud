var app = angular.module("UserManagement", []);

// Controller Part
app.controller("UserManagementController", function($scope, $http) {

	// Inicializar página com dados padrão que está em branco neste exemplo
	$scope.usuarios = [];
	$scope.form = {
		id : -1,
		nome : "",
		email : "",
		senha : ""
	};

	// Carregar os dados do servidor
	_refreshPageData();

	// HTTP POST/PUT métodos para adicionar / editar usuario
	$scope.submitUsuario = function() {

		var method = "";
		var url = "";
		if ($scope.form.id == -1) {
			// Id está ausente, add usuario - operação POST 
			method = "POST";
			url = 'usuarios';
		} else {
			// Id está pesente, é uma operação - PUT operação
			method = "PUT";
			url = 'usuarios/' + $scope.form.id;
		}

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.form),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);
	};

	// HTTP DELETE- excluir usuário por Id
	$scope.removeUsuario = function(usuario) {
		$http({
			method : 'DELETE',
			url : 'usuarios/' + usuario.id
		}).then(_success, _error);
	};

	// No caso de editar usuário, preencha o formulário com dados do usuário
	$scope.editUsuario = function(usuario) {
		$scope.form.nome = usuario.nome;
		$scope.form.email = usuario.email;
		$scope.form.senha = usuario.senha;
		$scope.form.id = usuario.id;
	};

	/* Métodos Privados */
	// HTTP GET- Obter todos os usuários coleção
	function _refreshPageData() {
		$http({
			method : 'GET',
			url : '/usuarios'
		}).then(function successCallback(response) {
			$scope.usuarios = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	function _success(response) {
		_refreshPageData();
		_clearForm()
	}

	function _error(response) {
		console.log(response.statusText);
	}

	// Limpar o formulário
	function _clearForm() {
		$scope.form.nome = "";
		$scope.form.email = "";
		$scope.form.senha = "";
		$scope.form.id = -1;
	}
	;
});