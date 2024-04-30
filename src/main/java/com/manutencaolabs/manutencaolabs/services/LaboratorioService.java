package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.LaboratorioRepository;
import com.manutencaolabs.models.Laboratorio;

@Service
public class LaboratorioService {

    // Instacia com constructor Autowired
    @Autowired
    private LaboratorioRepository laboratorioRepository;

    // Métodos de Serviço

    public List<Laboratorio> listLaboratorios() {
        Sort sort = Sort.by(Sort.Direction.ASC, "numerolaboratorio");
        return laboratorioRepository.findAll(sort);
    }

    // Procurar dado pelo ID.
    public Optional<Laboratorio> findById(Long id) {
        return laboratorioRepository.findById(id);
    }

    public Laboratorio saveLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    public void deleteLaboratorio(Long id) {
        laboratorioRepository.deleteById(id);
    }

    public Laboratorio createLaboratorio(Laboratorio laboratorio) {
        // Zera o Id pra confirmar que vai criar um novo dado em vez de atualizar outro
        laboratorio.setCodlaboratorio(null);
        return laboratorioRepository.save(laboratorio);
    }

    // Não usada nessa Tabela, somente para aprendizado.
    public Laboratorio updateLaboratorio(Laboratorio laboratorio) {
        // Verifica se o laboratório existe pelo ID
        Laboratorio existingLaboratorio = laboratorioRepository.findById(laboratorio.getCodlaboratorio())
                .orElseThrow(() -> new RuntimeException("Laboratório não encontrado!"));

        // Atualiza os campos necessários
        existingLaboratorio.setNumerolaboratorio(laboratorio.getNumerolaboratorio());

        // Salva as alterações no repository
        return laboratorioRepository.save(existingLaboratorio);
    }
}
