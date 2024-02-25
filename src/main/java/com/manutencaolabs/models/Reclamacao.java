package com.manutencaolabs.models;

import java.time.LocalDateTime;

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

@Entity
@Table(name = Reclamacao.TABLE_NAME)
public class Reclamacao {

    public interface CreateReclamacao {
    }

    public interface UptadeReclamacao {
    }

    public static final String TABLE_NAME = "reclamacao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codreclamacao", unique = true)
    private Long codreclamacao;

    @Column(name = "descricao", nullable = false, length = 2000)
    @NotNull(groups = { CreateReclamacao.class, UptadeReclamacao.class })
    @NotEmpty(groups = { CreateReclamacao.class, UptadeReclamacao.class })
    private String descricao;

    @Column(name = "status", nullable = false, length = 20)
    private String status = "aberta";

    @Column(name = "datahora_reclamacao")
    private LocalDateTime dataHoraReclamacao;

    @ManyToOne
    @JoinColumn(name = "codcomputador_fk", nullable = false, updatable = false)
    private Computador computador;

    @ManyToOne
    @JoinColumn(name = "codlaboratorio_fk", nullable = false, updatable = false)
    private Laboratorio laboratorio;

    @ManyToOne
    @JoinColumn(name = "codusuario_fk", nullable = false, updatable = false)
    private Usuario usuario;
}
