package br.com.patrocars.domain.service;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.modeloVeiculo.repository.ModeloVeiculoRepository;
import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.model.montadora.repository.MontadoraRepository;
import br.com.patrocars.exception.ModeloVeiculoNotFoundException;
import br.com.patrocars.exception.MontadoraNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModeloVeiculoService {
    private ModeloVeiculoRepository modeloVeiculoRepository;

    public ModeloVeiculoService(ModeloVeiculoRepository modeloVeiculoRepository) {
        this.modeloVeiculoRepository = modeloVeiculoRepository;
    }

    public ModeloVeiculo salvar(ModeloVeiculo modeloVeiculo) {
        return modeloVeiculoRepository.save(modeloVeiculo);
    }

    public List<ModeloVeiculo> getAllModelosVeiculos() {
        return modeloVeiculoRepository.findAll();
    }

    public ModeloVeiculo getModeloVeiculoPorId(UUID id) throws ModeloVeiculoNotFoundException {
        Optional<ModeloVeiculo> modeloVeiculo = modeloVeiculoRepository.findById(id);

        if (modeloVeiculo.isEmpty()) {
            throw new ModeloVeiculoNotFoundException("O modeloVeículo com id " + id + " não foi encontrado");
        }

        return modeloVeiculo.get();
    }

    public ModeloVeiculo atualizar(ModeloVeiculo modeloVeiculo) {
        return modeloVeiculoRepository.save(modeloVeiculo);
    }

    public void remover(ModeloVeiculo modeloVeiculo) {
        modeloVeiculoRepository.delete(modeloVeiculo);
    }
}
