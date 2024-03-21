package com.manutencaolabs.models;

import java.security.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manutencaolabs.models.Componente.CreateComponente;
import com.manutencaolabs.models.Componente.UpdateComponente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {

    public interface CreateUsuario {
    }

    public interface UpdateUsuario {
    }

    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codusuario", unique = true)
    private Long codusuario;

    @Column(name = "login", nullable = false, unique = true)
    @NotNull(groups = { CreateUsuario.class, UpdateUsuario.class })
    @NotEmpty(groups = { CreateUsuario.class, UpdateUsuario.class })
    private String login;

    @Column(name = "senha", nullable = false)
    @NotNull(groups = { CreateUsuario.class, UpdateUsuario.class })
    @NotEmpty(groups = { CreateUsuario.class, UpdateUsuario.class })
    private String senha;

    @Column(name = "nome_usuario", nullable = true, unique = true)
    private String nome_usuario;

    @Column(name = "email_usuario", nullable = true, unique = true)
    private String email_usuario;

    @Column(name = "reset_token", nullable = true)
    private String reset_token;

    @Column(name = "token", nullable = true)
    private String token;

    @Column(name = "reset_expires", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reset_expires;

    @ManyToOne
    @JoinColumn(name = "nivelacesso_fk", nullable = false, updatable = false)
    private NivelAcesso nivelAcesso;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<Manutencao> manutencoes;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<Reclamacao> reclamacoesUser;

    public Usuario() {
    }

    public Usuario(Long codusuario){
        this.codusuario = codusuario;
    }


    public Usuario(Long codusuario, String login, String senha, String nome_usuario, String email_usuario, String reset_token, String token, LocalDateTime reset_expires, NivelAcesso nivelAcesso, Set<Manutencao> manutencoes, Set<Reclamacao> reclamacoesUser) {
        this.codusuario = codusuario;
        this.login = login;
        this.senha = senha;
        this.nome_usuario = nome_usuario;
        this.email_usuario = email_usuario;
        this.reset_token = reset_token;
        this.token = token;
        this.reset_expires = reset_expires;
        this.nivelAcesso = nivelAcesso;
        this.manutencoes = manutencoes;
        this.reclamacoesUser = reclamacoesUser;
    }


    public Long getCodusuario() {
        return this.codusuario;
    }

    public void setCodusuario(Long codusuario) {
        this.codusuario = codusuario;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_usuario() {
        return this.nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail_usuario() {
        return this.email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getReset_token() {
        return this.reset_token;
    }

    public void setReset_token(String reset_token) {
        this.reset_token = reset_token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getReset_expires() {
        return this.reset_expires;
    }

    public void setReset_expires(LocalDateTime reset_expires) {
        this.reset_expires = reset_expires;
    }

    public NivelAcesso getNivelAcesso() {
        return this.nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public Set<Manutencao> getManutencoes() {
        return this.manutencoes;
    }

    public void setManutencoes(Set<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

    public Set<Reclamacao> getReclamacoesUser() {
        return this.reclamacoesUser;
    }

    public void setReclamacoesUser(Set<Reclamacao> reclamacoesUser) {
        this.reclamacoesUser = reclamacoesUser;
    }



    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    // }

    // @Override
    // public String getPassword() {
    //     return senha;
    // }

    // @Override
    // public String getUsername() {
    //     return login;
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isEnabled() {
    //     return true;
    // }
    
}
