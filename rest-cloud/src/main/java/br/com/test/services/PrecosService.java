package br.com.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.test.domain.Preco;
import br.com.test.repository.PrecosRepository;
import br.com.test.services.exceptions.PrecoNaoEncontradoException;

@Service
public class PrecosService {

	@Autowired
	private PrecosRepository precosRepository;

	public List<Preco> listar() {
		return precosRepository.findAll();
	}

	public Preco salvar(Preco preco) {
		preco.setId(null);
		return precosRepository.save(preco);
	}

	public Preco buscar(Long id) {
		Preco preco = precosRepository.findOne(id);

		if (preco == null) {
			throw new PrecoNaoEncontradoException("O preco não pôde ser encontrado.");
		}
		return preco;
	}
}