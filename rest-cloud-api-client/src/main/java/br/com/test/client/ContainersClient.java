package br.com.test.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.test.client.domain.Container;
import br.com.test.client.domain.Usuario;

public class ContainersClient {

	private RestTemplate restTemplate;
	
	private String URI_BASE;
	
	private String URN_BASE = "/containers";
	
	private String credencial = null;
	
	public ContainersClient(String url, String usuario, String senha) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
		
		String credencialAux = usuario + ":" + senha;
		
		credencial = "Basic " + Base64.getEncoder()
				.encodeToString(credencialAux.getBytes());
	}
	
	public ContainersClient(String url) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
	}

	public List<Container> listar() {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE))
				.header("Authorization", credencial).build();
		
		ResponseEntity<Container[]> response = restTemplate.exchange(request, Container[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Container container) {		
		RequestEntity<Container> request = RequestEntity
				.post(URI.create(URI_BASE))
				.header("Authorization", credencial)
				.body(container);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	public Container buscar(String uri) {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credencial)
				.build();
		
		ResponseEntity<Container> response = restTemplate.exchange(request, Container.class);
		
		return response.getBody();
	}
	
	public Usuario buscarPorUsuario(String uri) {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credencial).build();
		
		ResponseEntity<Usuario> response = restTemplate.exchange(request, Usuario.class);
		
		return response.getBody();
	}
 }