package com.manutencaolabs.manutencaolabs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutencaolabs.models.Situacao;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
    Optional<Situacao> findByTiposituacao(String tipoSituacao);
}
