package br.com.patrocars.domain.service;

import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.model.montadora.repository.MontadoraRepository;
import br.com.patrocars.exception.MontadoraNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MontadoraService {
    private MontadoraRepository montadoraRepository;

    public MontadoraService(MontadoraRepository montadoraRepository) {
        this.montadoraRepository = montadoraRepository;
    }

    public Montadora salvar(Montadora montadora) {
        return montadoraRepository.save(montadora);
    }

    public List<Montadora> getAllMontadoras() {
        return montadoraRepository.findAll();
    }

    public Montadora getMontadoraPorId(UUID id) throws MontadoraNotFoundException {
        Optional<Montadora> montadora = montadoraRepository.findById(id);

        if (montadora.isEmpty()) {
            throw new MontadoraNotFoundException("A montadora com id " + id + " não foi encontrada");
        }

        return montadora.get();
    }

    public List<Montadora> getMontadorasPorPais(String pais) {
        List<Montadora> montadoras = montadoraRepository.findMontadorasByPais(pais);
        return montadoras;
    }

    public Montadora atualizar(Montadora montadora) {
        return montadoraRepository.save(montadora);
    }

    public void remover(Montadora montadora) {
        montadoraRepository.delete(montadora);
    }
}
