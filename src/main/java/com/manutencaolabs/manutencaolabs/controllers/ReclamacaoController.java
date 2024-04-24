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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    // ESSE METODO É SEM O CAMPO IMAGEM
    @PostMapping("/add")
    @Validated(Reclamacao.CreateReclamacao.class)
    public void create(@Valid @RequestBody Reclamacao obj) {
        this.reclamacaoService.saveReclamacao(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        this.reclamacaoService.deleteReclamacao(id);
    }

    // ESSE METODO É SEM O CAMPO IMAGEM
    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Reclamacao obj, @PathVariable Long id) {
        obj.setCodreclamacao(id);
        this.reclamacaoService.updateReclamacao(obj);
    }

    @GetMapping("/usuario/{codusuario}")
    public ResponseEntity<List<Reclamacao>> buscarReclamacoesPorUsuario(@PathVariable Long codusuario) {
        List<Reclamacao> reclamacoes = reclamacaoService.buscarReclamacoesPorUsuario(codusuario);
        return ResponseEntity.ok().body(reclamacoes);
    }

    // ESSE METODO É COM IMAGEM
    // @PostMapping("/add")
    // @Validated(Reclamacao.CreateReclamacao.class)
    // public void create(@Valid @RequestBody Reclamacao obj,
    // @RequestParam("imagem") MultipartFile imagem) {
    // this.reclamacaoService.saveReclamacao(obj, imagem);
    // }
}
