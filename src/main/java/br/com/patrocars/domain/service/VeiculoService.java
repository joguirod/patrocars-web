package br.com.patrocars.domain.service;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.modeloVeiculo.repository.ModeloVeiculoRepository;
import br.com.patrocars.domain.model.veiculo.Veiculo;
import br.com.patrocars.domain.model.veiculo.repository.VeiculoRepository;
import br.com.patrocars.exception.ModeloVeiculoNotFoundException;
import br.com.patrocars.exception.VeiculoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculoPorId(UUID id) throws VeiculoNotFoundException {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);

        if (veiculo.isEmpty()) {
            throw new VeiculoNotFoundException("O veículo com id " + id + " não foi encontrada");
        }

        return veiculo.get();
    }

    public Veiculo atualizar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void remover(Veiculo veiculo) {
        veiculoRepository.delete(veiculo);
    }
}
