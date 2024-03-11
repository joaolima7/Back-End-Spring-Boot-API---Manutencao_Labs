package com.manutencaolabs.models;

import java.util.ArrayList;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Situacao.TABLE_NAME)
public class Situacao {

    public interface CreateSituacao {
    }

    public interface UpdateSituacao {
    }

    public static final String TABLE_NAME = "situacao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codsituacao", nullable = false, unique = true)
    private Long codsituacao;

    @Column(name = "tiposituacao", nullable = false)
    @NotNull(groups = { CreateSituacao.class, UpdateSituacao.class })
    @NotEmpty(groups = { CreateSituacao.class, UpdateSituacao.class })
    private String tiposituacao;

    @OneToMany(mappedBy = "situacao")
    @JsonIgnore
    private Set<Computador> computadores;

    public Situacao() {
    }


    public Situacao(Long codsituacao, String tiposituacao, Set<Computador> computadores) {
        this.codsituacao = codsituacao;
        this.tiposituacao = tiposituacao;
        this.computadores = computadores;
    }


    public Long getCodsituacao() {
        return this.codsituacao;
    }

    public void setCodsituacao(Long codsituacao) {
        this.codsituacao = codsituacao;
    }

    public String getTiposituacao() {
        return this.tiposituacao;
    }

    public void setTiposituacao(String tiposituacao) {
        this.tiposituacao = tiposituacao;
    }

    public Set<Computador> getComputadores() {
        return this.computadores;
    }

    public void setComputadores(Set<Computador> computadores) {
        this.computadores = computadores;
    }


}
