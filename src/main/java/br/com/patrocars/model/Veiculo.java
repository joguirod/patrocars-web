package br.com.patrocars.model;

import java.time.Year;
import java.util.Objects;
import java.util.UUID;

public class Veiculo {
    private UUID id;
    private String cor;
    private Year anoFabricacao;
    private Year anoModelo;
    private String placa;
    private ModeloVeiculo modelo;

    public Veiculo() {
    }

    public Veiculo(UUID id, String cor, Year anoFabricacao, Year anoModelo, String placa, ModeloVeiculo modelo) {
        this.id = id;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.placa = placa;
        this.modelo = modelo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Year getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Year anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Year getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Year anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ModeloVeiculo getModelo() {
        return modelo;
    }

    public void setModelo(ModeloVeiculo modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
