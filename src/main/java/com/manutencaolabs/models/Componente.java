package com.manutencaolabs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = Componente.TABLE_NAME)
public class Componente {

    public interface CreateComponente {
    }

    public interface UpdateComponente {
    }

    public static final String TABLE_NAME = "componente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcomponente", unique = true)
    private Long codcomponente;

    @Column(name = "nome_componente", nullable = false, unique = true)
    @NotNull(groups = { CreateComponente.class, UpdateComponente.class })
    @NotEmpty(groups = { CreateComponente.class, UpdateComponente.class })
    private String nome_componente;

    @ManyToMany(mappedBy = "componentes")
    @JsonIgnore
    private Set<Reclamacao> reclamacoes;

    public Componente() {
    }


    public Componente(Long codcomponente, String nome_componente, Set<Reclamacao> reclamacoes) {
        this.codcomponente = codcomponente;
        this.nome_componente = nome_componente;
        this.reclamacoes = reclamacoes;
    }


    public Long getCodcomponente() {
        return this.codcomponente;
    }

    public void setCodcomponente(Long codcomponente) {
        this.codcomponente = codcomponente;
    }

    public String getNome_componente() {
        return this.nome_componente;
    }

    public void setNome_componente(String nome_componente) {
        this.nome_componente = nome_componente;
    }

    public Set<Reclamacao> getReclamacoes() {
        return this.reclamacoes;
    }

    public void setReclamacoes(Set<Reclamacao> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

}
