package br.com.test.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Container {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Comando comando = Comando.CRIAR;
	
	@JsonInclude(Include.NON_NULL)
	@Enumerated(EnumType.STRING)
	private SO sistema_operacional = SO.LINUX;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "A memória deve ser preenchida.")
	private String memoria;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O processador deve ser preenchido.")
	private String processador;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O armazenamento deve ser preenchido.")
	private String armazenamento;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "A quantidade de armazenamento deve ser preenchido.")
	private String quantidade_armazenamento;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "A transferencia deve ser preenchida.")
	private String transferencia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_criacao;
	
	@OneToMany(mappedBy = "container")
	@JsonIgnore
	private List<Preco> precos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO_ID")
	@JsonIgnore
	private Usuario usuario;
	

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
