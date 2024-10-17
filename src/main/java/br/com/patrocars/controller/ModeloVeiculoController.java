package br.com.patrocars.controller;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.model.veiculo.Veiculo;
import br.com.patrocars.domain.service.ModeloVeiculoService;
import br.com.patrocars.domain.service.MontadoraService;
import br.com.patrocars.dto.ModeloVeiculoRequestDTO;
import br.com.patrocars.dto.MontadoraRequestDTO;
import br.com.patrocars.dto.VeiculoRequestDTO;
import br.com.patrocars.exception.ModeloVeiculoNotFoundException;
import br.com.patrocars.exception.MontadoraNotFoundException;
import br.com.patrocars.exception.VeiculoNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class ModeloVeiculoController {
    private final MontadoraService montadoraService;
    private ModeloVeiculoService modeloVeiculoService;

    public ModeloVeiculoController(ModeloVeiculoService modeloVeiculoService, MontadoraService montadoraService) {
        this.modeloVeiculoService = modeloVeiculoService;
        this.montadoraService = montadoraService;
    }

    @GetMapping("/modeloVeiculo")
    public ModelAndView listaModelosVeiculos() {
        List<ModeloVeiculo> modelosVeiculos = modeloVeiculoService.getAllModelosVeiculos();

        ModelAndView mv = new ModelAndView("modeloVeiculo/modelosVeiculos");
        mv.addObject("modelosVeiculos", modelosVeiculos);
        return mv;
    }

    @GetMapping("/modeloVeiculo/adicionar")
    public ModelAndView modeloVeiculoAdicionar() {
        ModelAndView mv = new ModelAndView("modeloVeiculo/adicionar");
        mv.addObject("montadoras", montadoraService.getAllMontadoras());
        return mv;
    }

    @GetMapping("/modeloVeiculo/editar/{id}")
    public ModelAndView modeloVeiculoEditar(@PathVariable UUID id) throws ModeloVeiculoNotFoundException {
        ModelAndView mv = new ModelAndView("modeloVeiculo/editar");

        ModeloVeiculo modeloVeiculo = modeloVeiculoService.getModeloVeiculoPorId(id);

        ModeloVeiculoRequestDTO modeloVeiculoRequestDTO = new ModeloVeiculoRequestDTO();
        modeloVeiculoRequestDTO.setId(id);
        modeloVeiculoRequestDTO.setMontadora(modeloVeiculo.getMontadora());
        modeloVeiculoRequestDTO.setNome(modeloVeiculo.getNome());
        modeloVeiculoRequestDTO.setTurbo(modeloVeiculo.isTurbo());
        modeloVeiculoRequestDTO.setAutomatico(modeloVeiculo.isAutomatico());
        modeloVeiculoRequestDTO.setMotorizacao(modeloVeiculo.getMotorizacao());
        modeloVeiculoRequestDTO.setValorReferencia(modeloVeiculo.getValorReferencia());

        mv.addObject("modeloVeiculoRequestDTO", modeloVeiculoRequestDTO);
        return mv;
    }

    @PostMapping("/modeloVeiculo/editar/{id}")
    public ModelAndView modeloVeiculoEditar(@PathVariable UUID id, ModeloVeiculoRequestDTO modeloVeiculoRequestDTO) throws ModeloVeiculoNotFoundException {
        Montadora montadora = modeloVeiculoService.getModeloVeiculoPorId(id).getMontadora();
        modeloVeiculoRequestDTO.setId(id);
        modeloVeiculoRequestDTO.setMontadora(montadora);
        modeloVeiculoService.atualizar(modeloVeiculoRequestDTO.toModeloVeiculo());

        return new ModelAndView("redirect:/modeloVeiculo");
    }

    @PostMapping("/modeloVeiculo")
    public String cadastrar(@Valid ModeloVeiculoRequestDTO modeloVeiculoRequestoDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "modeloVeiculo/adicionar";
        } else {
            ModeloVeiculo modeloVeiculo = modeloVeiculoRequestoDTO.toModeloVeiculo();
            modeloVeiculoService.salvar(modeloVeiculo);
            return "redirect:/modelosVeiculos";
        }
    }

    @ModelAttribute(value="modeloVeiculoRequestDTO")
    public ModeloVeiculoRequestDTO getModeloVeiculoRequestDTO(){
        return new ModeloVeiculoRequestDTO();
    }
}
