package com.manutencaolabs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = ReclamacaoComponente.TABLE_NAME)
public class ReclamacaoComponente {

    public interface CreateReclamacaoComponente {
    }

    public interface UpdateReclamacaoComponente {
    }

    public static final String TABLE_NAME = "reclamacao_componente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codreclamacao", nullable = false)
    private Reclamacao reclamacao;

    @ManyToOne
    @JoinColumn(name = "codcomponente", nullable = false)
    private Componente componente;


    public ReclamacaoComponente() {
    }


    public ReclamacaoComponente(Long id, Reclamacao reclamacao, Componente componente) {
        this.id = id;
        this.reclamacao = reclamacao;
        this.componente = componente;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reclamacao getReclamacao() {
        return this.reclamacao;
    }

    public void setReclamacao(Reclamacao reclamacao) {
        this.reclamacao = reclamacao;
    }

    public Componente getComponente() {
        return this.componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

}
