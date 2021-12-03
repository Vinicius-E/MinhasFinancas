package com.projeto.minhasfinancas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.minhasfinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	//Optional<Usuario> findByEmail(String email);
	Boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
}
