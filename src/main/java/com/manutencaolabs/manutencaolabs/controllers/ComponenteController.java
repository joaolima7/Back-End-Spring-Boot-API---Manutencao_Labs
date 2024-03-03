package com.manutencaolabs.manutencaolabs.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutencaolabs.manutencaolabs.services.ComponenteService;
import com.manutencaolabs.models.Componente;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/componente")
@Validated
public class ComponenteController {

    @Autowired
    private ComponenteService componenteService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Componente>> findById(@PathVariable Long id) {
        Optional<Componente> componente = this.componenteService.searchComponenteById(id);
        return ResponseEntity.ok().body(componente);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Componente>> findAll() {
        List<Componente> componentes = this.componenteService.listComponentes();
        return ResponseEntity.ok().body(componentes);
    }

    @PostMapping("/add")
    @Validated(Componente.CreateComponente.class)
    public void create(@Valid @RequestBody Componente obj) {
        this.componenteService.saveComponente(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        this.componenteService.deleteComponente(id);
    }

    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Componente obj, @PathVariable Long id) {
        obj.setCodcomponente(id);
        this.componenteService.updateComponente(obj);
    }

}
