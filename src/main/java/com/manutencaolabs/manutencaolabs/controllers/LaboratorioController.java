package com.manutencaolabs.manutencaolabs.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manutencaolabs.manutencaolabs.services.LaboratorioService;
import com.manutencaolabs.models.Laboratorio;
import com.manutencaolabs.models.Laboratorio.CreateLaboratorio;
import com.manutencaolabs.models.Laboratorio.UpdateLaboratorio;

import jakarta.validation.Valid;

//Identifica o Controller.
@RestController
//Identifica a Url para chamar metodos relacionados a laboratorio.
@RequestMapping("/laboratorio")
//Valida os metodos de create e update da model.
@Validated
public class LaboratorioController {
    
    //Instancia o Service com Construtor Automatico
    @Autowired
    private LaboratorioService laboratorioService;

    //Usa GetMapping para identificar que é o metodo GET.
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Laboratorio>> findById(@PathVariable Long id){
        Optional<Laboratorio> lab = this.laboratorioService.findById(id);
        return ResponseEntity.ok().body(lab);
    }

    @PostMapping
    @Validated(CreateLaboratorio.class)
    public ResponseEntity<Void> create (@Valid @RequestBody Laboratorio obj){
        this.laboratorioService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/(id)")
        .buildAndExpand(obj.getCodlaboratorio()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /*
    @PutMapping("/{id}")
    @Validated(UpdateLaboratorio.class)
    public ResponseEntity<Void> update (@Valid @ResponseBody Laboratorio obj, @PathVariable Long id) {
        obj.setCodlaboratorio(id);
        this.laboratorioService.Labo

    }
    */

}
