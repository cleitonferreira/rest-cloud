$(function() {
	$(".js-load-usuarios").on('click', function() {
		$.ajax({
				url: "http://localhost:8080/usuarios",
				crossDomain: true,
				type: "get",
				success: function(response) {
					desenhaTabela(response);
				}
		});
	})
});

function desenhaTabela(dados) {
	$(".js-table-body tr").remove();
	for(var i=0; i < dados.length; i++) {
		desenhaLinha(dados[i]);
	}
}

function desenhaLinha(linha) {
	var linhaTabela = $("<tr/>");
	$(".js-table-body").append(linhaTabela);
	linhaTabela.append("<td>" + linha.id + "</td>");
	linhaTabela.append("<td>" + linha.nome + "</td>");
	linhaTabela.append("<td>" + linha.email + "</td>");
	linhaTabela.append("<td>" + linha.senha + "</td>");
	linhaTabela.append("<td>" + linha.ativo + "</td>");
}
