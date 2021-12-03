package com.projeto.minhasfinancas.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.projeto.minhasfinancas.model.entity.Usuario;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;

	@Test
	public void deveVerficiarAExistenciaDeUmEmail() {
		// CENÁRIO
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").senha("usuario123").build();
		repository.save(usuario);

		// AÇÃO x EXECUÇÃO s
		Boolean result = repository.existsByEmail("usario@email.com");

		// VERIFICAÇÃO
		Assertions.assertThat(result).isTrue();
	}

	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		// CENÁRIO
		repository.deleteAll();
		
		// AÇÃO x EXECUÇÃO 
		Boolean result = repository.existsByEmail("usario@email.com");

		// VERIFICAÇÃO
		Assertions.assertThat(result).isFalse();		
	}

}
