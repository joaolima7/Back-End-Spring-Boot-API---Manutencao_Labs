package com.manutencaolabs.models;

import com.manutencaolabs.models.Componente.CreateComponente;
import com.manutencaolabs.models.Componente.UpdateComponente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = Computador.TABLE_NAME)
public class Computador {

    public interface CreateComputador {
    }

    public interface UptadeComputador {
    }

    public static final String TABLE_NAME = "computador";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcomputador", unique = true)
    private Long codcomputador;

    @Column(name = "patrimonio", nullable = false, unique = true)
    @NotNull(groups = { CreateComponente.class, UpdateComponente.class })
    @NotEmpty(groups = { CreateComponente.class, UpdateComponente.class })
    private String patrimonio;


    //Chave estrenageira
    @ManyToOne
    @JoinColumn(name = "codsituacao_fk", nullable = false, updatable = false)
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "codlaboratorio_fk", nullable = false, updatable = false)
    private Laboratorio laboratorio;


    public Computador() {
    }


    public Computador(Long codcomputador, String patrimonio, Situacao situacao, Laboratorio laboratorio) {
        this.codcomputador = codcomputador;
        this.patrimonio = patrimonio;
        this.situacao = situacao;
        this.laboratorio = laboratorio;
    }


    public Long getCodcomputador() {
        return this.codcomputador;
    }

    public void setCodcomputador(Long codcomputador) {
        this.codcomputador = codcomputador;
    }

    public String getPatrimonio() {
        return this.patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Situacao getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    
}
