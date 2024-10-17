package br.com.patrocars.dto;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.veiculo.Veiculo;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequestDTO {
    @NotBlank(message="A cor é de preenchimento obrigatório")
    private String cor;

    @NotNull(message="O Ano de Fabricação é de preenchimento obrigatório")
    private Year anoFabricacao;

    @NotNull(message="O Ano do Modelo é de preenchimento obrigatório")
    private Year anoModelo;

    @NotBlank(message="A Placa é de preenchimento obrigatório")
    private String placa;

    @NotNull(message="O modelo veículo é de preenchimento obrigatório")
    private ModeloVeiculo modeloVeiculo;

    public Veiculo toVeiculo(){
        Veiculo veiculo = new Veiculo();
        veiculo.setCor(cor);
        veiculo.setAnoFabricacao(anoFabricacao);
        veiculo.setAnoModelo(anoModelo);
        veiculo.setPlaca(placa);
        veiculo.setModelo(modeloVeiculo);

        return veiculo;
    }
}
