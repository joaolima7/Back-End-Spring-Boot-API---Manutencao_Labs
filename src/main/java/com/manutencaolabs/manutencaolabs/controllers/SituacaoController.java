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

import com.manutencaolabs.manutencaolabs.services.SituacaoService;
import com.manutencaolabs.models.Situacao;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/situacao")
@Validated
public class SituacaoController {

    @Autowired
    private SituacaoService situacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Situacao>> findById(@PathVariable Long id) {
        Optional<Situacao> situacao = this.situacaoService.searchSituacaoById(id);
        return ResponseEntity.ok().body(situacao);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Situacao>> findAll() {
        List<Situacao> situacoes = this.situacaoService.listSituacoes();
        return ResponseEntity.ok().body(situacoes);
    }

    @PostMapping("/add")
    @Validated(Situacao.CreateSituacao.class)
    public void create(@Valid @RequestBody Situacao obj) {
        this.situacaoService.saveSituacao(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        this.situacaoService.deleteSituacao(id);
    }

    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Situacao obj, @PathVariable Long id) {
        obj.setCodsituacao(id);
        this.situacaoService.updateSituacao(obj);
    }

}
