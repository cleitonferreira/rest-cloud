package br.com.test.client.domain;

public enum Comando {

	CRIAR("Criar"), 
	ATUALIZAR("Atualizar"), 
	DELETAR("Deletar");

	private String descricao;

	Comando(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
