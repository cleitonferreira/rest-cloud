package br.com.test.services.exceptions;

public class PrecoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public PrecoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PrecoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
