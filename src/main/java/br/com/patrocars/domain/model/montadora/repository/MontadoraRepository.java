package br.com.patrocars.domain.model.montadora.repository;

import br.com.patrocars.domain.model.montadora.Montadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MontadoraRepository extends JpaRepository<Montadora, UUID> {
    public List<Montadora> findMontadorasByPais(String pais);
}
