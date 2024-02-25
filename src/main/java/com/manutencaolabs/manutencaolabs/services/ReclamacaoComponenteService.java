package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.ReclamacaoComponenteRepository;
import com.manutencaolabs.models.ReclamacaoComponente;

@Service
public class ReclamacaoComponenteService {

    @Autowired
    private ReclamacaoComponenteRepository reclamacaoComponenteRepository;

    // Métodos do Serviço

    public ReclamacaoComponente saveReclamacaoComponente(ReclamacaoComponente reclamacaoComponente) {
        return this.reclamacaoComponenteRepository.save(reclamacaoComponente);
    }

    public void deleteReclamacaoComponente(ReclamacaoComponente reclamacaoComponente) {
        try {
            this.reclamacaoComponenteRepository.delete(reclamacaoComponente);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }

    public Optional<ReclamacaoComponente> searchReclamacaoComponentePorIds(Long codreclamacao, Long codcomponente) {
        return this.reclamacaoComponenteRepository.findByIds(codreclamacao, codcomponente);
    }

    public List<ReclamacaoComponente> listReclamacaoComponente(){
        return this.reclamacaoComponenteRepository.findAll();
    }

}
