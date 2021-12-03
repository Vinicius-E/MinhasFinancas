package com.projeto.minhasfinancas.service.impl;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.minhasfinancas.exceptions.ErroAutenticacao;
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
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if(!usuario.isPresent()) 
			throw new ErroAutenticacao("Usuário não Encontrado pelo Email Informado.");
		
		if(!usuario.get().getSenha().equals(senha))
			throw new ErroAutenticacao("Senha inválida.");
		
		return null;
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		Boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse email.");
		}
	}

}
