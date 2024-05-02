package com.manutencaolabs.manutencaolabs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutencaolabs.models.NivelAcesso;

@Repository
public interface NivelAcessoRepository extends JpaRepository<NivelAcesso, Long> {
    Optional<NivelAcesso> findByTipoAcesso(String tipoacesso);
}
