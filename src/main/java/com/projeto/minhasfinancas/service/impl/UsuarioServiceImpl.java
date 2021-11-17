package com.projeto.minhasfinancas.service.impl;
import org.springframework.stereotype.Service;

import com.projeto.minhasfinancas.exceptions.RegraNegocioException;
import com.projeto.minhasfinancas.model.entity.Usuario;
import com.projeto.minhasfinancas.model.repository.UsuarioRepository;
import com.projeto.minhasfinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;

	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return null;
	}

	@Override
	public void validarEmail(String email) {
		Boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse email.");
		}
	}

}
