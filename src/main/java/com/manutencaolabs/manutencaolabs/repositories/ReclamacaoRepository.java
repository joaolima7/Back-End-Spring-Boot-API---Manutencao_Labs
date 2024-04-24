package com.manutencaolabs.manutencaolabs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutencaolabs.models.Reclamacao;

@Repository
public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Long> {
    List<Reclamacao> findByUsuarioCodusuario(Long codusuario);
}
