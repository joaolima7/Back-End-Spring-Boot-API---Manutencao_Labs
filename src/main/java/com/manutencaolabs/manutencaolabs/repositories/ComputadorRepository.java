package com.manutencaolabs.manutencaolabs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutencaolabs.models.Computador;

@Repository
public interface ComputadorRepository extends JpaRepository<Computador, Long> {
    List<Computador> findByLaboratorio_CodlaboratorioOrderByCodcomputadorAsc(Long codlaboratorio);
}
