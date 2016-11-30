package br.com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.test.domain.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

}
