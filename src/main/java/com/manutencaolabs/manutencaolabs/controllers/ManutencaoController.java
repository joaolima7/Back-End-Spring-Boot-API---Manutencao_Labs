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

import com.manutencaolabs.manutencaolabs.services.ManutencaoService;
import com.manutencaolabs.models.Manutencao;
import com.manutencaolabs.models.NivelAcesso;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/manutencao")
@Validated
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Manutencao>> findById(@PathVariable Long id) {
        Optional<Manutencao> manutencao = this.manutencaoService.searchManutencaoPorId(id);
        return ResponseEntity.ok().body(manutencao);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Manutencao>> findAll() {
        List<Manutencao> manutencoes = this.manutencaoService.listManutencoes();
        return ResponseEntity.ok().body(manutencoes);
    }

    @PostMapping("/add")
    @Validated(Manutencao.CreateManutencao.class)
    public void create(@Valid @RequestBody Manutencao obj) {
        this.manutencaoService.saveManutencao(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        this.manutencaoService.deleteManutencao(id);
    }

    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Manutencao obj, @PathVariable Long id) {
        obj.setCodmanutencao(id);
        this.manutencaoService.updateManutencao(obj);
    }

}
