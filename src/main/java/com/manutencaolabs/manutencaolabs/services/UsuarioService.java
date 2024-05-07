package com.manutencaolabs.manutencaolabs.services;

import java.util.List;
import java.util.Random;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manutencaolabs.manutencaolabs.repositories.UsuarioRepository;
import com.manutencaolabs.models.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> listUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> searchUsuarioById(Long id) {
        return this.usuarioRepository.findById(id);
    }

    public Usuario generateTokenForUser(String email) {
        Optional<Usuario> usuarioOptional = buscarPorEmail(email);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            String token = generateRandomToken();
            usuario.setToken(token);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    private String generateRandomToken() {
        Random rand = new Random();
        return String.format("%05d", rand.nextInt(100000));
    }

    public Usuario saveUsuario(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hashedSenha = encoder.encode(usuario.getSenha());

        usuario.setSenha(hashedSenha);

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
        newObj.setLogin(usuario.getLogin());
        newObj.setSenha(usuario.getSenha());
        newObj.setNome_usuario(usuario.getNome_usuario());
        newObj.setEmail(usuario.getEmail());
        newObj.setToken(usuario.getToken());
        newObj.setNivelAcesso(usuario.getNivelAcesso());

        return this.usuarioRepository.save(newObj);
    }

    public Optional<Usuario> buscarPorLoginESenha(String login, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByLogin(login);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            if (passwordEncoder.matches(senha, usuario.getSenha())) {
                return usuarioOptional;
            }
        }
        return Optional.empty();
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }
}
