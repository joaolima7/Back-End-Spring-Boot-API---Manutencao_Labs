package com.manutencaolabs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "nome", nullable = true, unique = true)
    private String nome;

    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Column(name = "token", nullable = true)
    private String token;

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

    public Usuario(Long codusuario) {
        this.codusuario = codusuario;
    }

    public Usuario(Long codusuario, String login, String senha, String nome, String email,
            String token, NivelAcesso nivelAcesso, Set<Manutencao> manutencoes,
            Set<Reclamacao> reclamacoesUser) {
        this.codusuario = codusuario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.token = token;
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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
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
    // throw new UnsupportedOperationException("Unimplemented method
    // 'getAuthorities'");
    // }

    // @Override
    // public String getPassword() {
    // return senha;
    // }

    // @Override
    // public String getUsername() {
    // return login;
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    // return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    // return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    // return true;
    // }

    // @Override
    // public boolean isEnabled() {
    // return true;
    // }

}
