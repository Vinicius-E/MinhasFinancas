package com.projeto.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
