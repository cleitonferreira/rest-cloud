package br.com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.test.domain.Container;

public interface ContainersRepository extends JpaRepository<Container, Long>{

}
