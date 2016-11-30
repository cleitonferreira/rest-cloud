package br.com.test.aplicacao;

import java.text.ParseException;
import java.util.List;

import br.com.test.client.UsuariosClient;
import br.com.test.client.domain.Usuario;

public class MainUsuario {

	public static void main(String[] args) throws ParseException {
		UsuariosClient cliente = 
				new UsuariosClient("http://localhost:8080");
		
		List<Usuario> listaUsuarios = cliente.listar();
		
		for(Usuario usuario : listaUsuarios) {
			System.out.println("Usuário: " + usuario.getNome());
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome("Cleiton Ferreira");
		usuario.setEmail("teste@gmail.com");
		usuario.setSenha("admin");
		usuario.setAtivo(true);
		
		String localizacao = cliente.salvar(usuario);
		
		System.out.println("URI do usuário salvo: " + localizacao);
		
		Usuario usurioBuscado = cliente.buscar(localizacao);
		
		System.out.println("Usuário buscado: " + usurioBuscado.getNome());
	}
}
