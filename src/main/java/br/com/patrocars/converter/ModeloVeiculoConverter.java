package br.com.patrocars.converter;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.montadora.Montadora;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ModeloVeiculoConverter implements Converter<String, ModeloVeiculo> {
    @Override
    public ModeloVeiculo convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        UUID uuid = UUID.fromString(source);
        // Criando uma Montadora apenas com o UUID (proxy)
        ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
        modeloVeiculo.setId(uuid);
        return modeloVeiculo;
    }
}
