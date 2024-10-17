package br.com.patrocars.dto;

import br.com.patrocars.domain.model.montadora.Montadora;
import lombok.*;

import java.util.UUID;

@Data
public class MontadoraRequestDTO{
    private String nome;
    private String pais;
    private int anoFundacao;
    private UUID id;

    public MontadoraRequestDTO() {
    }

    public MontadoraRequestDTO(String nome, String pais, int anoFundacao) {
        this.nome = nome;
        this.pais = pais;
        this.anoFundacao = anoFundacao;
    }

    public Montadora toMontadora() {
        Montadora montadora = new Montadora();
        montadora.setNome(nome);
        montadora.setPais(pais);
        montadora.setAnoFundacao(anoFundacao);
        montadora.setId(id);

        return montadora;
    }
}
