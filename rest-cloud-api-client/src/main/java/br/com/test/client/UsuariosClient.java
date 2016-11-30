package br.com.test.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.test.client.domain.Usuario;

public class UsuariosClient {

private RestTemplate restTemplate;
	
	private String URI_BASE;
	
	private String URN_BASE = "/usuarios";
	
	private String credencial = null;
	
	public UsuariosClient(String url, String usuario, String senha) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
		
		String credencialAux = usuario + ":" + senha;
		
		credencial = "Basic " + Base64.getEncoder()
				.encodeToString(credencialAux.getBytes());
	}
	
	public UsuariosClient(String url) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
	}

	public List<Usuario> listar() {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE))
				.header("Authorization", credencial).build();
		
		ResponseEntity<Usuario[]> response = restTemplate.exchange(request, Usuario[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Usuario usuario) {		
		RequestEntity<Usuario> request = RequestEntity
				.post(URI.create(URI_BASE))
				.header("Authorization", credencial)
				.body(usuario);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	public Usuario buscar(String uri) {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credencial)
				.build();
		
		ResponseEntity<Usuario> response = restTemplate.exchange(request, Usuario.class);
		
		return response.getBody();
	}
 }