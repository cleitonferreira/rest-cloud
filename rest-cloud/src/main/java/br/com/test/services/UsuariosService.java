package br.com.test.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.test.domain.Container;
import br.com.test.domain.Usuario;
import br.com.test.repository.ContainersRepository;
import br.com.test.repository.UsuariosRepository;
import br.com.test.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired
	private ContainersRepository containersRepository;

	
	public List<Usuario> listar() {
		return usuariosRepository.findAll();
	}
	
	public Usuario buscar(Long id) {
		Usuario usuario = usuariosRepository.findOne(id);
		
		if(usuario == null) {
			throw new UsuarioNaoEncontradoException("O usuário não pôde ser encontrado.");
		}
		
		return usuario;
	}
	
	public Usuario salvar(Usuario usuario) {
		usuario.setId(null);
		return usuariosRepository.save(usuario);
	}
	
	public void deletar(Long id) {
		try {
			usuariosRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException("O usuário não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Usuario usuario) {
		verificarExistencia(usuario);
		usuariosRepository.save(usuario);
	}
	
	private void verificarExistencia(Usuario usuario) {
		buscar(usuario.getId());
	}

	public Container salvarContainers(Long containerId, Container container) {
		Usuario usuario = buscar(containerId);
		
		container.setUsuario(usuario);
		container.setData_criacao(new Date());
		
		return containersRepository.save(container);
		
	}

	public List<Container> listarContainers(Long containerId) {
		Usuario usuario = buscar(containerId);
		
		return usuario.getContainers();
	}
}
