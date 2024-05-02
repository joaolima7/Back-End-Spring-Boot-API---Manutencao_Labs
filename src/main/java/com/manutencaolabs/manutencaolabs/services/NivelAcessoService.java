package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.NivelAcessoRepository;
import com.manutencaolabs.models.NivelAcesso;

@Service
public class NivelAcessoService {

    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    // Métodos do Serviço

    public List<NivelAcesso> listNiveisAcesso() {
        return this.nivelAcessoRepository.findAll();
    }

    public Optional<NivelAcesso> searchNivelAcessoPorId(Long id) {
        return this.nivelAcessoRepository.findById(id);
    }

    public NivelAcesso saveNivelAcesso(NivelAcesso nivelAcesso) {
        return this.nivelAcessoRepository.save(nivelAcesso);
    }

    public void deleteNivelAcesso(Long id) {
        try {
            this.nivelAcessoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }

    public NivelAcesso createNivelAcesso(NivelAcesso nivelAcesso) {
        nivelAcesso.setCodnivel_acesso(null);
        return this.nivelAcessoRepository.save(nivelAcesso);
    }

    public NivelAcesso updateNivelAcesso(NivelAcesso nivelAcesso) {
        NivelAcesso newObj = this.nivelAcessoRepository.findById(nivelAcesso.getCodnivel_acesso())
                .orElseThrow(() -> new RuntimeException("Nível de Acesso não encontrado!"));
        // Atualize os campos necessários
        newObj.setTipoAcesso(nivelAcesso.getTipoAcesso());
        // Adicione mais campos conforme necessário

        return this.nivelAcessoRepository.save(newObj);
    }

    public Optional<NivelAcesso> searchNivelAcessoPorTipoAcesso(String tipoAcesso) {
        return this.nivelAcessoRepository.findByTipoAcesso(tipoAcesso);
    }

}
