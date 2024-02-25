package com.manutencaolabs.models;

import jakarta.persistence.Entity;
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
    @ManyToOne
    @JoinColumn(name = "codreclamacao_fk", nullable = false, updatable = false)
    private Reclamacao reclamacao;

    @Id
    @ManyToOne
    @JoinColumn(name = "codcomponente_fk", nullable = false, updatable = false)
    private Componente componente;


    public ReclamacaoComponente() {
    }


    public ReclamacaoComponente(Reclamacao reclamacao, Componente componente) {
        this.reclamacao = reclamacao;
        this.componente = componente;
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
