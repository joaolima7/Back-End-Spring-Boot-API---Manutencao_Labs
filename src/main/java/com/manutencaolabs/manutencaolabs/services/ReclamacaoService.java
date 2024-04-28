package com.manutencaolabs.manutencaolabs.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manutencaolabs.manutencaolabs.repositories.ReclamacaoRepository;
import com.manutencaolabs.models.Reclamacao;

@Service
public class ReclamacaoService {

    @Autowired
    private ReclamacaoRepository reclamacaoRepository;

    public List<Reclamacao> listReclamacoes() {
        return this.reclamacaoRepository.findAll();
    }

    public Optional<Reclamacao> searchReclamacaoById(Long id) {
        return this.reclamacaoRepository.findById(id);
    }

    // ESSE METODO ABAIXO É SEM CAMPO IMAGEM NO BANCO
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

    // ESSE METODO ABAIXO É SEM CAMPO IMAGEM NO BANCO
    public Reclamacao updateReclamacao(Reclamacao reclamacao) {
        Reclamacao newObj = this.reclamacaoRepository.findById(reclamacao.getCodreclamacao())
                .orElseThrow(() -> new RuntimeException("Reclamação não encontrada!"));
        // Atualize os campos necessários
        newObj.setDescricao(reclamacao.getDescricao());
        newObj.setStatus(reclamacao.getStatus());
        newObj.setComputador(reclamacao.getComputador());
        newObj.setLaboratorio(reclamacao.getLaboratorio());
        newObj.setUsuario(reclamacao.getUsuario());

        return this.reclamacaoRepository.save(newObj);
    }

    public List<Reclamacao> buscarReclamacoesPorUsuario(Long codusuario) {
        return reclamacaoRepository.findByUsuarioCodusuario(codusuario);
    }

    // ESSES METODOS É COM CAMPO IMAGEM
    // public Reclamacao saveReclamacao(Reclamacao reclamacao, MultipartFile imagem)
    // {
    // // Converta a imagem para bytes e atribua ao campo
    // try {
    // reclamacao.setImagem(imagem.getBytes());
    // } catch (IOException e) {
    // // Lide com a exceção, se necessário
    // }
    // return this.reclamacaoRepository.save(reclamacao);
    // }

    // public Reclamacao updateReclamacao(Reclamacao reclamacao, MultipartFile
    // imagem) {
    // Reclamacao newObj =
    // this.reclamacaoRepository.findById(reclamacao.getCodreclamacao())
    // .orElseThrow(() -> new RuntimeException("Reclamação não encontrada!"));

    // // Atualize os campos necessários
    // newObj.setDescricao(reclamacao.getDescricao());
    // newObj.setStatus(reclamacao.getStatus());
    // newObj.setDataHoraReclamacao(reclamacao.getDataHoraReclamacao());
    // newObj.setComputador(reclamacao.getComputador());
    // newObj.setLaboratorio(reclamacao.getLaboratorio());
    // newObj.setUsuario(reclamacao.getUsuario());

    // // Converta a imagem para bytes e atribua ao campo
    // try {
    // newObj.setImagem(imagem.getBytes());
    // } catch (IOException e) {
    // // Lide com a exceção, se necessário
    // }

    // // Adicione mais campos conforme necessário

    // return this.reclamacaoRepository.save(newObj);
    // }
}
