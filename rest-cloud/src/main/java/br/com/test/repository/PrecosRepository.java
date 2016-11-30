package br.com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.test.domain.Preco;

public interface PrecosRepository extends JpaRepository<Preco, Long>{

}
