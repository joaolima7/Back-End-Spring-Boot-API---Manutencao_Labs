package com.manutencaolabs.models;


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

//Considerar a Classe uma tabela do banco
@Entity

//Definir o nome da tabela do banco
@Table(name= Laboratorio.TABLE_NAME)


public class Laboratorio {

    public interface CreateLaboratorio {
    } 
    public interface UpdateLaboratorio {
    }

    //Variavel final do nome da tabela, público e estatico
    public static final String TABLE_NAME = "laboratorio";

    //Definir vcomo variável de Id
    @Id

    //Pra ser auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Parametros da coluna no Spring
    @Column(name = "codlaboratorio", unique = true, nullable = false)
    private Long codlaboratorio;

    @Column(name = "numerolaboratorio", nullable = false, unique = true) 
    //Paramtros no banco de dados antes de criar um novo    
    @NotNull(groups = {CreateLaboratorio.class})
    private Integer numerolaboratorio;
    
    @OneToMany(mappedBy = "laboratorio")
    @JsonIgnore
    private Set<Computador> computadores;

    @OneToMany(mappedBy = "laboratorio")
    @JsonIgnore
    private Set<Reclamacao> reclamacoesLab;


    public Laboratorio() {
    }


    public Laboratorio(Long codlaboratorio, Integer numerolaboratorio, Set<Computador> computadores, Set<Reclamacao> reclamacoesLab) {
        this.codlaboratorio = codlaboratorio;
        this.numerolaboratorio = numerolaboratorio;
        this.computadores = computadores;
        this.reclamacoesLab = reclamacoesLab;
    }


    public Long getCodlaboratorio() {
        return this.codlaboratorio;
    }

    public void setCodlaboratorio(Long codlaboratorio) {
        this.codlaboratorio = codlaboratorio;
    }

    public Integer getNumerolaboratorio() {
        return this.numerolaboratorio;
    }

    public void setNumerolaboratorio(Integer numerolaboratorio) {
        this.numerolaboratorio = numerolaboratorio;
    }

    public Set<Computador> getComputadores() {
        return this.computadores;
    }

    public void setComputadores(Set<Computador> computadores) {
        this.computadores = computadores;
    }

    public Set<Reclamacao> getReclamacoesLab() {
        return this.reclamacoesLab;
    }

    public void setReclamacoesLab(Set<Reclamacao> reclamacoesLab) {
        this.reclamacoesLab = reclamacoesLab;
    }


    
}

  
