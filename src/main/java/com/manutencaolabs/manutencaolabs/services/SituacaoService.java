package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.SituacaoRepository;
import com.manutencaolabs.models.Situacao;

@Service
public class SituacaoService {

    @Autowired
    private SituacaoRepository situacaoRepository;

    // Métodos de Serviços

    public List<Situacao> listSituacoes() {
        return this.situacaoRepository.findAll();
    }

    public Optional<Situacao> searchSituacaoById(Long id) {
        return this.situacaoRepository.findById(id);
    }

    public Situacao saveSituacao(Situacao situacao) {
        return this.situacaoRepository.save(situacao);
    }

    public void deleteSituacao(Long id) {
        try {
            this.situacaoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }

    public Situacao createSituacao(Situacao situacao) {
        situacao.setCodsituacao(null);
        return this.situacaoRepository.save(situacao);
    }

    public Situacao updateSituacao(Situacao situacao) {
        Situacao newObj = this.situacaoRepository.findById(situacao.getCodsituacao())
                .orElseThrow(() -> new RuntimeException("Situação não encontrada!"));
        // Atualize os campos necessários
        newObj.setTiposituacao(situacao.getTiposituacao());
        // Adicione mais campos conforme necessário

        return this.situacaoRepository.save(newObj);
    }

}
