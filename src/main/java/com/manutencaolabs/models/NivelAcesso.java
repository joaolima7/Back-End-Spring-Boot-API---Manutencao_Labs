package com.manutencaolabs.models;

import java.util.Set;

import org.hibernate.annotations.Collate;

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
    private Long codnivel_acesso;

    @Column(name = "tipo_acesso", nullable = false)
    private String tipo_acesso;
    
    @OneToMany(mappedBy = "nivelAcesso")
    @JsonIgnore
    private Set<Usuario> usuarios;

    public NivelAcesso() {
    }


    public NivelAcesso(Long codnivel_acesso, String tipo_acesso, Set<Usuario> usuarios) {
        this.codnivel_acesso = codnivel_acesso;
        this.tipo_acesso = tipo_acesso;
        this.usuarios = usuarios;
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

    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
