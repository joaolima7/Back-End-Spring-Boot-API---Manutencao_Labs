package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.ManutencaoRepository;
import com.manutencaolabs.models.Manutencao;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public List<Manutencao> listManutencoes() {
        return this.manutencaoRepository.findAll();
    }

    public Optional<Manutencao> searchManutencaoPorId(Long id) {
        return this.manutencaoRepository.findById(id);
    }

    public Manutencao saveManutencao(Manutencao manutencao) {
        return this.manutencaoRepository.save(manutencao);
    }

    public void deleteManutencao(Long id) {
        try {
            this.manutencaoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }

    public Manutencao createManutencao(Manutencao manutencao) {
        manutencao.setCodmanutencao(null);
        return this.manutencaoRepository.save(manutencao);
    }

    public Manutencao updateManutencao(Manutencao manutencao) {
        Manutencao newObj = this.manutencaoRepository.findById(manutencao.getCodmanutencao())
                .orElseThrow(() -> new RuntimeException("Manutencao não encontrada!"));
        // Atualize os campos necessários
        newObj.setDescricao_manutencao(manutencao.getDescricao_manutencao());
        newObj.setDatahora_manutencao(manutencao.getDatahora_manutencao());
        newObj.setUsuario(manutencao.getUsuario());
        newObj.setReclamacao(manutencao.getReclamacao());
        // Adicione mais campos conforme necessário

        return this.manutencaoRepository.save(newObj);
    }

}
