package com.manutencaolabs.manutencaolabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacaoComponenteRepository extends JpaRepository<ReclamacaoRepository, Long> {
    
}
