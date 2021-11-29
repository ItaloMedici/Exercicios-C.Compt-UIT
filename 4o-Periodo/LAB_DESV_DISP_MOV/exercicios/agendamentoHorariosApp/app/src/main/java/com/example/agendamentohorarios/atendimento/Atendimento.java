package com.example.agendamentohorarios.atendimento;

import com.example.agendamentohorarios.usuario.Usuario;

import java.util.Date;

public class Atendimento {
    private Long identificador;
    private String descricao;
    private Double valor;
    private Date horario;
    private String observacao;
    private String nomeCliente;
    private Usuario usuario;

    public Atendimento() {}

    public Atendimento(Long identificador, String descricao, Double valor, Date horario, String observacao, String nomeCliente, Usuario usuario) {
        this.identificador = identificador;
        this.descricao = descricao;
        this.valor = valor;
        this.horario = horario;
        this.observacao = observacao;
        this.nomeCliente = nomeCliente;
        this.usuario = usuario;
    }

    public Atendimento(Long identificador, String descricao, Double valor, Date horario, String observacao, String nomeCliente) {
        this(identificador, descricao, valor, horario, observacao, nomeCliente, null);
    }

    public Atendimento(String descricao, Double valor, Date horario, String observacao, String nomeCliente, Usuario usuario) {
        this(null, descricao, valor, horario, observacao, nomeCliente, usuario);
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
