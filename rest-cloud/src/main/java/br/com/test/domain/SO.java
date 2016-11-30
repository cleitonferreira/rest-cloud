package br.com.test.domain;

public enum SO {

	WINDOWS("Windows"), 
	LINUX("Linux");

	private String descricao;

	SO(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
