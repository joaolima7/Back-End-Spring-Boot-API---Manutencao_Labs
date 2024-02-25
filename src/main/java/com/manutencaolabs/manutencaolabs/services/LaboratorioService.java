package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.LaboratorioRepository;
import com.manutencaolabs.models.Laboratorio;

@Service
public class LaboratorioService {

    //Instacia com constructor Autierid
    @Autowired
    private LaboratorioRepository laboratorioRepository;


        // Métodos de Serviço

    public List<Laboratorio> listLaboratorios() {
        return laboratorioRepository.findAll();
    }

    public Optional<Laboratorio> searchLaboratorioPorId(Long id) {
        return laboratorioRepository.findById(id);
    }

    public Laboratorio saveLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    public void deleteLaboratorio(Long id) {
        laboratorioRepository.deleteById(id);
    }

    public Laboratorio createLaboratorio(Laboratorio laboratorio) {
        //Zera o Id pra confirmar que vai criar um novo dado em vez de atualizar outro
        laboratorio.setCodlaboratorio(null);
        return laboratorioRepository.save(laboratorio);
    }
  
}
