package br.com.test.services.exceptions;

public class UsuarioExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public UsuarioExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
