package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.ManutencaoRepository;
import com.manutencaolabs.models.Manutencao;
import com.manutencaolabs.models.Reclamacao;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @Autowired
    private ReclamacaoService reclamacaoService; //

    public List<Manutencao> listManutencoes() {
        return this.manutencaoRepository.findAll();
    }

    public Optional<Manutencao> searchManutencaoPorId(Long id) {
        return this.manutencaoRepository.findById(id);
    }

    public Manutencao saveManutencao(Manutencao manutencao) {
        // Salvar a manutenção
        Manutencao savedManutencao = this.manutencaoRepository.save(manutencao);

        // Buscar a reclamação pelo ID fornecido
        Optional<Reclamacao> optionalReclamacao = reclamacaoService
                .searchReclamacaoById(manutencao.getReclamacao().getCodreclamacao());
        if (optionalReclamacao.isPresent()) {
            Reclamacao reclamacao = optionalReclamacao.get();
            // Alterar o status da reclamação para "Concluída"
            reclamacao.setStatus("Concluida");
            // Salvar a reclamação atualizada
            reclamacaoService.saveReclamacao(reclamacao);
        }

        return savedManutencao;
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

    public Manutencao buscarManutencaoPorReclamacao(Long codreclamacao) {
        return manutencaoRepository.findByReclamacaoCodreclamacao(codreclamacao);
    }

}
