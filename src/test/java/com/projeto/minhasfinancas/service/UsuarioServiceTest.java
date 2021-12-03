package com.projeto.minhasfinancas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.projeto.minhasfinancas.exceptions.RegraNegocioException;
import com.projeto.minhasfinancas.model.entity.Usuario;
import com.projeto.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test(expected = Test.None.class)
	public void deveValidarEmail() {
		// CENÁRIO
		repository.deleteAll();
		
		// AÇÃO
		service.validarEmail("email@email.com");
	}
	
	@Test(expected = RegraNegocioException.class)
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		// CENÁRTIO
		Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
		repository.save(usuario);
		
		// AÇÃO
		service.validarEmail("email@email.com");
	
	}
}
