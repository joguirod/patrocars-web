package br.com.patrocars.dto;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.montadora.Montadora;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloVeiculoRequestDTO {
    @NotBlank(message="O nome é de preenchimento obrigatório")
    private String nome;
    @NotNull(message="O valor de referência é de preenchimento obrigatório")
    @DecimalMin("0.0")
    private BigDecimal valorReferencia;
    @NotNull(message="A motorização é de preenchimento obrigatório")
    @DecimalMin("1.0")
    private float motorizacao;
    @NotNull(message="O turbo é de preenchimento obrigatório")
    private boolean turbo;
    @NotNull(message="Automático é de preenchimento obrigatório")
    private boolean automatico;
    @NotNull(message="A montadora é de preenchimento obrigatório")
    private Montadora montadora;

    private UUID id;

    public ModeloVeiculo toModeloVeiculo(){
        ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
        modeloVeiculo.setNome(nome);
        modeloVeiculo.setValorReferencia(valorReferencia);
        modeloVeiculo.setMotorizacao(motorizacao);
        modeloVeiculo.setTurbo(turbo);
        modeloVeiculo.setAutomatico(automatico);
        modeloVeiculo.setMontadora(montadora);
        modeloVeiculo.setId(id);

        return modeloVeiculo;
    }
}
