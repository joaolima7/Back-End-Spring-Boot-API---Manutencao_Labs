package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.ComponenteRepository;
import com.manutencaolabs.models.Componente;

@Service
public class ComponenteService {

    @Autowired
    private ComponenteRepository componenteRepository;

    //Métodos de Serviço

    public List<Componente> listComponentes(){
        return this.componenteRepository.findAll();
    }

    public Optional<Componente> searchComponenteById(Long id){
        return this.componenteRepository.findById(id);
    }

    public Componente saveComponente(Componente componente){
        return this.componenteRepository.save(componente);
    }

    public void deleteComponente(Long id){
        this.componenteRepository.deleteById(id);
    }

     
    public Componente createComponente(Componente componente){
        componente.setCodcomponente(null);
        return this.componenteRepository.save(componente);

    } 

    public Componente updateComponente(Componente componente){
        Componente newObj = this.componenteRepository.findById(componente.getCodcomponente())
        .orElseThrow(()-> new RuntimeException("Componente não encontrado!"));
        newObj.setNome_componente(componente.getNome_componente());
        return this.componenteRepository.save(newObj);
    }
    
}
