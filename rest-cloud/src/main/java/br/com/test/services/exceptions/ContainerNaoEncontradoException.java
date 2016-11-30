package br.com.test.services.exceptions;

public class ContainerNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public ContainerNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ContainerNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
