package br.com.test.client.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Container {
	
	private Long id;
	
	private Comando comando = Comando.CRIAR;
	
	private SO sistema_operacional = SO.LINUX;
	
	private String memoria;
	
	private String processador;
	
	private String armazenamento;
	
	private String quantidade_armazenamento;
	
	private String transferencia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_criacao;
	
	private Usuario usuario;
	
	private List<Preco> precos;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Comando getComando() {
		return comando;
	}
	public void setComando(Comando comando) {
		this.comando = comando;
	}

	public SO getSistema_operacional() {
		return sistema_operacional;
	}
	public void setSistema_operacional(SO sistema_operacional) {
		this.sistema_operacional = sistema_operacional;
	}

	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getArmazenamento() {
		return armazenamento;
	}
	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	public String getQuantidade_armazenamento() {
		return quantidade_armazenamento;
	}
	public void setQuantidade_armazenamento(String quantidade_armazenamento) {
		this.quantidade_armazenamento = quantidade_armazenamento;
	}

	public String getTransferencia() {
		return transferencia;
	}
	public void setTransferencia(String transferencia) {
		this.transferencia = transferencia;
	}

	public Date getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Preco> getPrecos() {
		return precos;
	}
	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}
}
