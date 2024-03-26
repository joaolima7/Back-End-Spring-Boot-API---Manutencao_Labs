package com.manutencaolabs.models;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Reclamacao.TABLE_NAME)
public class Reclamacao {

    public interface CreateReclamacao {
    }

    public interface UpdateReclamacao {
    }

    public static final String TABLE_NAME = "reclamacao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codreclamacao", unique = true)
    private Long codreclamacao;

    @Column(name = "descricao", nullable = false, length = 2000)
    @NotNull(groups = { CreateReclamacao.class, UpdateReclamacao.class })
    @NotEmpty(groups = { CreateReclamacao.class, UpdateReclamacao.class })
    private String descricao;

    @Column(name = "status", nullable = false, length = 20)
    private String status = "aberta";

    @Column(name = "datahora_reclamacao")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHoraReclamacao;

    // @Lob
    // @Column(name = "imagem", columnDefinition = "BLOB")
    // private byte[] imagem;

    @Column(name = "imagem", nullable = true, length = 150000)
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "codcomputador_fk", nullable = false, updatable = false)
    private Computador computador;

    @ManyToOne
    @JoinColumn(name = "codlaboratorio_fk", nullable = false, updatable = false)
    private Laboratorio laboratorio;

    @ManyToOne
    @JoinColumn(name = "codusuario_fk", nullable = false, updatable = false)
    // @JsonIgnore
    private Usuario usuario;

    @OneToOne(mappedBy = "reclamacao")
    @JsonIgnore
    private Manutencao manutencao;

    @ManyToMany
    @JoinTable(name = "reclamacao_componente", joinColumns = @JoinColumn(name = "reclamacao_fk"), inverseJoinColumns = @JoinColumn(name = "componente_fk"))
    private Set<Componente> componentes;

    public Reclamacao() {
    }

    public Reclamacao(Long codreclamacao, String descricao, String status, LocalDateTime dataHoraReclamacao, String imagem, Computador computador, Laboratorio laboratorio, Usuario usuario, Manutencao manutencao, Set<Componente> componentes) {
        this.codreclamacao = codreclamacao;
        this.descricao = descricao;
        this.status = status;
        this.dataHoraReclamacao = dataHoraReclamacao;
        this.imagem = imagem;
        this.computador = computador;
        this.laboratorio = laboratorio;
        this.usuario = usuario;
        this.manutencao = manutencao;
        this.componentes = componentes;
    }


    public Long getCodreclamacao() {
        return this.codreclamacao;
    }

    public void setCodreclamacao(Long codreclamacao) {
        this.codreclamacao = codreclamacao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraReclamacao() {
        return this.dataHoraReclamacao;
    }

    public void setDataHoraReclamacao(LocalDateTime dataHoraReclamacao) {
        this.dataHoraReclamacao = dataHoraReclamacao;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Computador getComputador() {
        return this.computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Manutencao getManutencao() {
        return this.manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public Set<Componente> getComponentes() {
        return this.componentes;
    }

    public void setComponentes(Set<Componente> componentes) {
        this.componentes = componentes;
    }


}
