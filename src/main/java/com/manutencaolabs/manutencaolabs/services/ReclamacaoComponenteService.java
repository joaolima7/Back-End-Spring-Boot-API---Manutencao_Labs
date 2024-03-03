package com.manutencaolabs.manutencaolabs.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.ReclamacaoComponenteRepository;
import com.manutencaolabs.models.ReclamacaoComponente;

@Service
public class ReclamacaoComponenteService {

    @Autowired
    private ReclamacaoComponenteRepository reclamacaoComponenteRepository;

    public List<ReclamacaoComponente> listReclamacaoComponentes() {
        return this.reclamacaoComponenteRepository.findAll();
    }

    public Optional<ReclamacaoComponente> searchReclamacaoComponentePorId(Long id) {
        return this.reclamacaoComponenteRepository.findById(id);
    }

    public ReclamacaoComponente saveReclamacaoComponente(ReclamacaoComponente reclamacaoComponente) {
        return this.reclamacaoComponenteRepository.save(reclamacaoComponente);
    }

    public void deleteReclamacaoComponente(Long id) {
        try {
            this.reclamacaoComponenteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }

    public ReclamacaoComponente createReclamacaoComponente(ReclamacaoComponente reclamacaoComponente) {
        reclamacaoComponente.setId(null);
        return this.reclamacaoComponenteRepository.save(reclamacaoComponente);
    }

}
