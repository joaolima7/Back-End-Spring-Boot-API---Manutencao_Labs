package com.manutencaolabs.models;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = NivelAcesso.TABLE_NAME)
public class NivelAcesso {

    public interface CreateNivelAcesso {
    }

    public interface UpdateNivelAcesso {
    }

    public static final String TABLE_NAME = "nivel_acesso";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codnivel_acesso")
    @NotNull(groups = CreateNivelAcesso.class)
    @NotEmpty(groups = CreateNivelAcesso.class)
    private Long codnivel_acesso;

    @Column(name = "tipo_acesso", nullable = false)
    @NotNull(groups = { CreateNivelAcesso.class, UpdateNivelAcesso.class })
    @NotEmpty(groups = { CreateNivelAcesso.class, UpdateNivelAcesso.class })
    private String tipo_acesso;
    

    public NivelAcesso() {
    }


    public NivelAcesso(Long codnivel_acesso, String tipo_acesso) {
        this.codnivel_acesso = codnivel_acesso;
        this.tipo_acesso = tipo_acesso;
    }


    public Long getCodnivel_acesso() {
        return this.codnivel_acesso;
    }

    public void setCodnivel_acesso(Long codnivel_acesso) {
        this.codnivel_acesso = codnivel_acesso;
    }

    public String getTipo_acesso() {
        return this.tipo_acesso;
    }

    public void setTipo_acesso(String tipo_acesso) {
        this.tipo_acesso = tipo_acesso;
    }
    
}
