    package com.manutencaolabs.models;

    import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
    import jakarta.validation.constraints.NotEmpty;
    import jakarta.validation.constraints.NotNull;

    @Entity
    @Table(name = Manutencao.TABLE_NAME)
    public class Manutencao {

        public interface CreateManutencao {
        }

        public interface UpdateManutencao {
        }

        public static final String TABLE_NAME = "manutencao";

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "codmanutencao", unique = true)
        private Long codmanutencao;

        @Column(name = "descricao_manutencao", nullable = false, length = 2000)
        @NotNull(groups = { CreateManutencao.class, UpdateManutencao.class })
        @NotEmpty(groups = { CreateManutencao.class, UpdateManutencao.class })
        private String descricao_manutencao;

        @Column(name = "datahora_manutencao")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime datahora_manutencao;

        @ManyToOne
        @JoinColumn(name = "codusuario_fk", nullable = false, updatable = false)
        private Usuario usuario;

        @OneToOne
        @JoinColumn(name = "codreclamacao_fk", nullable = false, updatable = false)
        //@JsonIgnore
        private Reclamacao reclamacao;


        public Manutencao() {
        }


        public Manutencao(Long codmanutencao, String descricao_manutencao, LocalDateTime datahora_manutencao, Usuario usuario, Reclamacao reclamacao) {
            this.codmanutencao = codmanutencao;
            this.descricao_manutencao = descricao_manutencao;
            this.datahora_manutencao = datahora_manutencao;
            this.usuario = usuario;
            this.reclamacao = reclamacao;
        }


        public Long getCodmanutencao() {
            return this.codmanutencao;
        }

        public void setCodmanutencao(Long codmanutencao) {
            this.codmanutencao = codmanutencao;
        }

        public String getDescricao_manutencao() {
            return this.descricao_manutencao;
        }

        public void setDescricao_manutencao(String descricao_manutencao) {
            this.descricao_manutencao = descricao_manutencao;
        }

        public LocalDateTime getDatahora_manutencao() {
            return this.datahora_manutencao;
        }

        public void setDatahora_manutencao(LocalDateTime datahora_manutencao) {
            this.datahora_manutencao = datahora_manutencao;
        }

        public Usuario getUsuario() {
            return this.usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Reclamacao getReclamacao() {
            return this.reclamacao;
        }

        public void setReclamacao(Reclamacao reclamacao) {
            this.reclamacao = reclamacao;
        }

    }
