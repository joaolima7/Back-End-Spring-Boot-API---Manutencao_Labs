package com.manutencaolabs.manutencaolabs.controllers;


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

import com.manutencaolabs.manutencaolabs.services.ComputadorService;
import com.manutencaolabs.models.Computador;
import java.util.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/computador")
@Validated
public class ComputadorController {

    @Autowired
    private ComputadorService computadorService;

   @GetMapping("/{id}")
    public ResponseEntity<Optional<Computador>> findById(@PathVariable Long id) {
        Optional<Computador> computador = this.computadorService.searchComputadorPorId(id);
        return ResponseEntity.ok().body(computador);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Computador>> findAll() {
        List<Computador> computadores = this.computadorService.listComputadores();
        return ResponseEntity.ok().body(computadores);
    }

    @PostMapping("/add")
    @Validated(Computador.CreateComputador.class)
    public void create(@Valid @RequestBody Computador obj) {
           this.computadorService.saveComputador(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
            this.computadorService.deleteComputador(id);
    }

    @PutMapping("/{id}")
    public void update (@Valid @RequestBody Computador obj, @PathVariable Long id){
        obj.setCodcomputador(id);
        this.computadorService.updateComputador(obj);
    }
    
}
