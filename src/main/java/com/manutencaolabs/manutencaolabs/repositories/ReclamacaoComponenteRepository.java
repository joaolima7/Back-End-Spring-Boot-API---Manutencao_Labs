package com.manutencaolabs.manutencaolabs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutencaolabs.models.ReclamacaoComponente;

@Repository
public interface ReclamacaoComponenteRepository extends JpaRepository<ReclamacaoComponente, Long> {
    
    Optional<ReclamacaoComponente> findByIds(Long codreclamacao, Long codcomponente);
    
}
