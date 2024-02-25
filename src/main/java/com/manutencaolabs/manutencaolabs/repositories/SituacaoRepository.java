package com.manutencaolabs.manutencaolabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencaolabs.models.Situacao;

public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
    
}
