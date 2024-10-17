package br.com.patrocars.controller;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.service.ModeloVeiculoService;
import br.com.patrocars.domain.service.MontadoraService;
import br.com.patrocars.dto.ModeloVeiculoRequestDTO;
import br.com.patrocars.dto.MontadoraRequestDTO;
import br.com.patrocars.dto.VeiculoRequestDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ModeloVeiculoController {
    private final MontadoraService montadoraService;
    private ModeloVeiculoService modeloVeiculoService;

    public ModeloVeiculoController(ModeloVeiculoService modeloVeiculoService, MontadoraService montadoraService) {
        this.modeloVeiculoService = modeloVeiculoService;
        this.montadoraService = montadoraService;
    }

    @GetMapping("/modelosVeiculos")
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

    @PostMapping("/modelosVeiculos")
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
