package br.com.test.client.domain;

import java.math.BigDecimal;

public class Preco {

	private Long id;
	
	private BigDecimal valor = BigDecimal.ZERO;
	
	private BigDecimal valorDesconto = BigDecimal.ZERO;
	
	private BigDecimal valorTotal = BigDecimal.ZERO;
		
	private Container container;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
}
