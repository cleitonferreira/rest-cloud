package br.com.test.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.test.client.ContainersClient;
import br.com.test.client.domain.Comando;
import br.com.test.client.domain.Container;
import br.com.test.client.domain.SO;
import br.com.test.client.domain.Usuario;

public class MainContainer {

	public static void main(String[] args) throws ParseException {
		ContainersClient cliente = 
				new ContainersClient("http://localhost:8080");
		
		List<Container> listaContainers = cliente.listar();
		
		for(Container container : listaContainers) {
			System.out.println("Sistema Operacional: " + container.getSistema_operacional().getDescricao());
		}
		
//		Usuario usuario = new Usuario();
//		usuario.setNome("Cleiton Ferreira");
//		usuario.setEmail("teste@gmail.com");
//		usuario.setSenha("admin");
//		usuario.setAtivo(true);
		
		Usuario usuario = cliente.buscarPorUsuario("http://localhost:8080/usuarios/1");
		System.out.println(usuario.getNome());
		
		Container container = new Container();
		container.setComando(Comando.CRIAR);
		container.setSistema_operacional(SO.LINUX);
		container.setMemoria("512MB");
		container.setProcessador("1 Core");
		container.setArmazenamento("20GB");
		container.setQuantidade_armazenamento("SSD");
		container.setTransferencia("1TB");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		container.setData_criacao(format.parse("01/01/2016"));
		
		container.setUsuario(usuario);
				

		
		String localizacao = cliente.salvar(container);
		
		System.out.println("URI do container salvo: " + localizacao);
		
		Container containerBuscado = cliente.buscar(localizacao);
		
		System.out.println("Container buscado: " + containerBuscado.getId() + " " + container.getSistema_operacional().getDescricao());
	}
}
