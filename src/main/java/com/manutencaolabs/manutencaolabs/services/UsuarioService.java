package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaolabs.manutencaolabs.repositories.UsuarioRepository;
import com.manutencaolabs.models.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Métodos de Serviços

    public List<Usuario> listUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> searchUsuarioById(Long id) {
        return this.usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        try {
            this.usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível Excluir!");
        }
    }

    public Usuario createUsuario(Usuario usuario) {
        usuario.setCodusuario(null);
        return this.usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        Usuario newObj = this.usuarioRepository.findById(usuario.getCodusuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        // Atualize os campos necessários
        newObj.setLogin(usuario.getLogin());
        newObj.setSenha(usuario.getSenha());
        newObj.setNome_usuario(usuario.getNome_usuario());
        newObj.setEmail_usuario(usuario.getEmail_usuario());
        newObj.setReset_token(usuario.getReset_token());
        newObj.setToken(usuario.getToken());
        newObj.setReset_expires(usuario.getReset_expires());
        newObj.setNivelAcesso(usuario.getNivelAcesso());
        // Adicione mais campos conforme necessário

        return this.usuarioRepository.save(newObj);
    }

}
