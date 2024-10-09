package br.com.patrocars.model;

import java.util.Objects;
import java.util.UUID;

public class Montadora {
    private UUID id;
    private String nome;
    private String pais;
    private int anoFundacao;

    public Montadora() {
    }

    public Montadora(UUID id, String nome, String pais, int anoFundacao) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.anoFundacao = anoFundacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Montadora montadora = (Montadora) o;
        return Objects.equals(id, montadora.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
