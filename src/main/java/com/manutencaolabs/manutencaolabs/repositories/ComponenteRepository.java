package com.manutencaolabs.manutencaolabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencaolabs.models.Componente;

public interface ComponenteRepository extends JpaRepository<Componente, Long> {
    
}
