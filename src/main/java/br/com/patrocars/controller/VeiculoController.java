package br.com.patrocars.controller;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.model.veiculo.Veiculo;
import br.com.patrocars.domain.service.ModeloVeiculoService;
import br.com.patrocars.domain.service.MontadoraService;
import br.com.patrocars.domain.service.VeiculoService;
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
public class VeiculoController {
    private VeiculoService veiculoService;
    private ModeloVeiculoService modeloVeiculoService;

    public VeiculoController(VeiculoService veiculoService, ModeloVeiculoService modeloVeiculoService) {
        this.veiculoService = veiculoService;
        this.modeloVeiculoService = modeloVeiculoService;
    }

    @GetMapping("/veiculos")
    public ModelAndView veiculos() {
        List<Veiculo> veiculos = veiculoService.getAllVeiculos();

        ModelAndView mv = new ModelAndView("veiculo/veiculos");
        mv.addObject("veiculos", veiculos);
        return mv;
    }

    @GetMapping("/veiculos/adicionar")
    public ModelAndView veiculoAdicionar() {
        ModelAndView mv = new ModelAndView("veiculo/adicionar");
        mv.addObject("modelosVeiculos", modeloVeiculoService.getAllModelosVeiculos());
        return mv;
    }

    @PostMapping("/veiculos")
    public ModelAndView cadastrar(@Valid VeiculoRequestDTO veiculoRequestDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("veiculo/adicionar");
        } else {
            Veiculo veiculo = veiculoRequestDTO.toVeiculo();
            veiculoService.salvar(veiculo);
            return new ModelAndView("redirect:/veiculos");
        }
    }

    @ModelAttribute(value="veiculoRequestDTO")
    public VeiculoRequestDTO getVeiculoRequestDTO(){
        return new VeiculoRequestDTO();
    }
}
