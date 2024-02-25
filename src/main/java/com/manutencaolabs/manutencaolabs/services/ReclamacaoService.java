package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.ReclamacaoRepository;
import com.manutencaolabs.models.Reclamacao;

@Service
public class ReclamacaoService {

    @Autowired
    private ReclamacaoRepository reclamacaoRepository;

    // Metodos de Serviço

    public List<Reclamacao> listReclamacoes() {
        return this.reclamacaoRepository.findAll();
    }

    public Optional<Reclamacao> searchReclamacaoById(Long id) {
        return this.reclamacaoRepository.findById(id);
    }

    public Reclamacao saveReclamacao(Reclamacao reclamacao) {
        return this.reclamacaoRepository.save(reclamacao);
    }

    public void deleteReclamacao(Long id) {
        try {
            this.reclamacaoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }

    public Reclamacao createReclamacao(Reclamacao reclamacao) {
        reclamacao.setCodreclamacao(null);
        return this.reclamacaoRepository.save(reclamacao);
    }

    public Reclamacao updateReclamacao(Reclamacao reclamacao) {
        Reclamacao newObj = this.reclamacaoRepository.findById(reclamacao.getCodreclamacao())
                .orElseThrow(() -> new RuntimeException("Reclamação não encontrada!"));
        // Atualize os campos necessários
        newObj.setDescricao(reclamacao.getDescricao());
        newObj.setStatus(reclamacao.getStatus());
        newObj.setDataHoraReclamacao(reclamacao.getDataHoraReclamacao());
        newObj.setComputador(reclamacao.getComputador());
        newObj.setLaboratorio(reclamacao.getLaboratorio());
        newObj.setUsuario(reclamacao.getUsuario());
        // Adicione mais campos conforme necessário

        return this.reclamacaoRepository.save(newObj);
    }

}
