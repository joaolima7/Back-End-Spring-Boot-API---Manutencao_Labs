package com.manutencaolabs.manutencaolabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutencaolabs.models.Componente;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {
    
}
