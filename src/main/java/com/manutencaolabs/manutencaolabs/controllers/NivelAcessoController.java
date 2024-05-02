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

import com.manutencaolabs.manutencaolabs.services.NivelAcessoService;
import com.manutencaolabs.models.NivelAcesso;
import com.manutencaolabs.models.Reclamacao;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/nivelacesso")
@Validated
public class NivelAcessoController {

    @Autowired
    private NivelAcessoService nivelAcessoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<NivelAcesso>> findById(@PathVariable Long id) {
        Optional<NivelAcesso> na = this.nivelAcessoService.searchNivelAcessoPorId(id);
        return ResponseEntity.ok().body(na);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NivelAcesso>> findAll() {
        List<NivelAcesso> nas = this.nivelAcessoService.listNiveisAcesso();
        return ResponseEntity.ok().body(nas);
    }

    @PostMapping("/add")
    @Validated(NivelAcesso.CreateNivelAcesso.class)
    public void create(@Valid @RequestBody NivelAcesso obj) {
        this.nivelAcessoService.saveNivelAcesso(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        this.nivelAcessoService.deleteNivelAcesso(id);
    }

    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody NivelAcesso obj, @PathVariable Long id) {
        obj.setCodnivel_acesso(id);
        this.nivelAcessoService.updateNivelAcesso(obj);
    }

    @GetMapping("/tipoacesso/{tipoAcesso}")
    public ResponseEntity<Optional<NivelAcesso>> findByTipoAcesso(@PathVariable String tipoAcesso) {
        Optional<NivelAcesso> na = this.nivelAcessoService.searchNivelAcessoPorTipoAcesso(tipoAcesso);
        if (na.isPresent()) {
            return ResponseEntity.ok().body(na);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
