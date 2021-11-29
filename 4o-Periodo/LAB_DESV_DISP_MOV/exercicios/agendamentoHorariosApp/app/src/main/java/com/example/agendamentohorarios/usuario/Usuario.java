package com.example.agendamentohorarios.usuario;

public class Usuario {
    private Long identificador;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){};

    public Usuario(Long identificador, String nome, String email, String senha) {
        this.identificador = identificador;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(Long identificador, String nome, String email) {
        this.identificador = identificador;
        this.nome = nome;
        this.email = email;
    }

    public Usuario(String nome, String email, String senha) {
        this.identificador = identificador;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
