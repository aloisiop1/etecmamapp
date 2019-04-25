package br.com.etecmam.etecmamapp;

import java.io.Serializable;

public class Curso implements Serializable {

    private String nome;
    private String eixo;
    private String eixoDescricao;
    private String mercado;

    public Curso(String nome, String eixo) {
        this.nome = nome;
        this.eixo = eixo;
    }

    public Curso(String nome, String eixo, String eixoDescricao, String mercado) {
        this.nome = nome;
        this.eixo = eixo;
        this.eixoDescricao = eixoDescricao;
        this.mercado = mercado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEixo() {
        return eixo;
    }

    public void setEixo(String eixo) {
        this.eixo = eixo;
    }

    public String getEixoDescricao() {
        return eixoDescricao;
    }

    public void setEixoDescricao(String eixoDescricao) {
        this.eixoDescricao = eixoDescricao;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }
}
