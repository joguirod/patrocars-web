package br.com.patrocars.domain.model.modeloVeiculo.repository;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModeloVeiculoRepository extends JpaRepository<ModeloVeiculo, UUID> {
}
