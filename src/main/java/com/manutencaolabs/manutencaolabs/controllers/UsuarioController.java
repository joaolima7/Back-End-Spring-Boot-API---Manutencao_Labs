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

import com.manutencaolabs.manutencaolabs.services.UsuarioService;
import com.manutencaolabs.models.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id) {
        Optional<Usuario> user = this.usuarioService.searchUsuarioById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
        Optional<Usuario> usuario = this.usuarioService.buscarPorEmail(email);
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/generate-token/{email}")
    public ResponseEntity<Usuario> generateToken(@PathVariable String email) {
        Usuario usuario = usuarioService.generateTokenForUser(email);
        if (usuario != null) {
            return ResponseEntity.ok().body(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> users = this.usuarioService.listUsuarios();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/loginsenha")
    public ResponseEntity<Usuario> findByLoginSenha(@RequestParam String login, @RequestParam String senha) {
        Optional<Usuario> usuario = this.usuarioService.buscarPorLoginESenha(login, senha);
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<Usuario> findByLogin(@PathVariable String login) {
        Optional<Usuario> usuario = this.usuarioService.buscarPorLogin(login);
        // return ResponseEntity.ok().body(usuario);
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Usuario> findByName(@PathVariable String nome) {
        Optional<Usuario> usuario = this.usuarioService.buscarPorNome(nome);
        // return ResponseEntity.ok().body(usuario);
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    @Validated(Usuario.CreateUsuario.class)
    public void create(@Valid @RequestBody Usuario obj) {
        this.usuarioService.saveUsuario(obj);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        this.usuarioService.deleteUsuario(id);
    }

    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Usuario obj, @PathVariable Long id) {
        obj.setCodusuario(id);
        this.usuarioService.updateUsuario(obj);
    }

    @PutMapping("/update")
    public void updateSenha(@Valid @RequestBody Usuario obj) {
        this.usuarioService.updateUsuario(obj);
    }

}
