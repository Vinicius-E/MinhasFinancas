package com.projeto.minhasfinancas.service;

import com.projeto.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);	
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
}
