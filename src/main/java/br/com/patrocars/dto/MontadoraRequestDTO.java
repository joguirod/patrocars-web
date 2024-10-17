package br.com.patrocars.dto;

import br.com.patrocars.domain.model.montadora.Montadora;
import lombok.*;

@Data
public class MontadoraRequestDTO{
    private String nome;
    private String pais;
    private int anoFundacao;

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

        return montadora;
    }
}
