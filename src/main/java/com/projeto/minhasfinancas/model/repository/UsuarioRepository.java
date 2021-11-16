package com.projeto.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.minhasfinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
