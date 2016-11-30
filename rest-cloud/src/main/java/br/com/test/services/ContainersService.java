package br.com.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.test.domain.Container;
import br.com.test.repository.ContainersRepository;
import br.com.test.services.exceptions.ContainerNaoEncontradoException;

@Service
public class ContainersService {

	@Autowired
	private ContainersRepository containersRepository;
	
	public List<Container> listar() {
		return containersRepository.findAll();
	}
	
	public Container buscar(Long id) {
		Container container = containersRepository.findOne(id);
		
		if(container == null) {
			throw new ContainerNaoEncontradoException("O container container pôde ser encontrado.");
		}
		
		return container;
	}
	
	public Container salvar(Container container) {
		container.setId(null);
		return containersRepository.save(container);
	}
	
	public void deletar(Long id) {
		try {
			containersRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ContainerNaoEncontradoException("O container não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Container container) {
		verificarExistencia(container);
		containersRepository.save(container);
	}
	
	private void verificarExistencia(Container container) {
		buscar(container.getId());
	}
}
