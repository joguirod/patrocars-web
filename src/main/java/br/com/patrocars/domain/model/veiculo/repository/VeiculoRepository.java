package br.com.patrocars.domain.model.veiculo.repository;

import br.com.patrocars.domain.model.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
}
