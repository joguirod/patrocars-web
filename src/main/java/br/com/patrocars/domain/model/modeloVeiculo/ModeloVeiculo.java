package br.com.patrocars.domain.model.modeloVeiculo;

import br.com.patrocars.domain.model.montadora.Montadora;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ModeloVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private BigDecimal valorReferencia;
    private float motorizacao;
    private boolean turbo;
    private boolean automatico;

    @ManyToOne
    private Montadora montadora;

    public ModeloVeiculo() {
    }

    public ModeloVeiculo(UUID id, String nome, BigDecimal valorReferencia, float motorizacao, boolean turbo, boolean automatico, Montadora montadora) {
        this.id = id;
        this.nome = nome;
        this.valorReferencia = valorReferencia;
        this.motorizacao = motorizacao;
        this.turbo = turbo;
        this.automatico = automatico;
        this.montadora = montadora;
    }

    public ModeloVeiculo(UUID id, String nome, Montadora montadora) {
        this.id = id;
        this.nome = nome;
        this.montadora = montadora;
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

    public BigDecimal getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(BigDecimal valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public float getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(float motorizacao) {
        this.motorizacao = motorizacao;
    }

    public boolean isTurbo() {
        return turbo;
    }

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloVeiculo that = (ModeloVeiculo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
