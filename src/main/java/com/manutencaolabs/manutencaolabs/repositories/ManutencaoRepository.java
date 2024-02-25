package com.manutencaolabs.manutencaolabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutencaolabs.models.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{
    
}
