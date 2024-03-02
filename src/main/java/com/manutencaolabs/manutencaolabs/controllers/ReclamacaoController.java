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

import com.manutencaolabs.manutencaolabs.services.ReclamacaoService;
import com.manutencaolabs.models.Reclamacao;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reclamacao")
@Validated
public class ReclamacaoController {

    @Autowired
    private ReclamacaoService reclamacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reclamacao>> findById(@PathVariable Long id) {
        Optional<Reclamacao> reclamacao = this.reclamacaoService.searchReclamacaoById(id);
        return ResponseEntity.ok().body(reclamacao);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reclamacao>> findAll() {
        List<Reclamacao> reclamacaoes = this.reclamacaoService.listReclamacoes();
        return ResponseEntity.ok().body(reclamacaoes);
    }

    @PostMapping("/add")
    @Validated(Reclamacao.CreateReclamacao.class)
    public void create(@Valid @RequestBody Reclamacao obj) {
        this.reclamacaoService.saveReclamacao(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        this.reclamacaoService.deleteReclamacao(id);
    }

    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Reclamacao obj, @PathVariable Long id) {
        obj.setCodreclamacao(id);
        this.reclamacaoService.updateReclamacao(obj);
    }

}
