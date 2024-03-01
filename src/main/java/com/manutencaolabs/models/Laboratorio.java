package com.manutencaolabs.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


    public Laboratorio() {
    }


    public Laboratorio(Long codlaboratorio, Integer numerolaboratorio) {
        this.codlaboratorio = codlaboratorio;
        this.numerolaboratorio = numerolaboratorio;
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

    
}

  
