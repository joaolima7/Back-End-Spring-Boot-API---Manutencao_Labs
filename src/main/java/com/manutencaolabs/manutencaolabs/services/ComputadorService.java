package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.ComputadorRepository;
import com.manutencaolabs.models.Computador;


@Service
public class ComputadorService {
    
    @Autowired
    private ComputadorRepository computadorRepository;

    //Métodos do servço

    public List<Computador> listComputadores() {
        return this.computadorRepository.findAll();
    }

    public Optional<Computador> searchComputadorPorId(Long id) {
        return this.computadorRepository.findById(id);
    }

    public Computador saveComputador(Computador computador) {
        return this.computadorRepository.save(computador);
    }

    public void deleteComputador(Long id) {
        try {
            this.computadorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }   

    public Computador createComputador(Computador computador) {
        computador.setCodcomputador(null);
        return this.computadorRepository.save(computador);
    }

    public Computador updateComputador(Computador computador) {
        Computador newObj = this.computadorRepository.findById(computador.getCodcomputador())
                .orElseThrow(() -> new RuntimeException("Computador não encontrado!"));
        // Atualize os campos necessários
        newObj.setPatrimonio(computador.getPatrimonio());
        newObj.setSituacao(computador.getSituacao());
        newObj.setLaboratorio(computador.getLaboratorio());
        // Adicione mais campos conforme necessário

        return this.computadorRepository.save(newObj);
    }
}
