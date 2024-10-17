package br.com.patrocars.controller;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.model.veiculo.Veiculo;
import br.com.patrocars.domain.service.ModeloVeiculoService;
import br.com.patrocars.domain.service.MontadoraService;
import br.com.patrocars.domain.service.VeiculoService;
import br.com.patrocars.dto.MontadoraRequestDTO;
import br.com.patrocars.dto.VeiculoRequestDTO;
import br.com.patrocars.exception.VeiculoNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class VeiculoController {
    private VeiculoService veiculoService;
    private ModeloVeiculoService modeloVeiculoService;

    public VeiculoController(VeiculoService veiculoService, ModeloVeiculoService modeloVeiculoService) {
        this.veiculoService = veiculoService;
        this.modeloVeiculoService = modeloVeiculoService;
    }

    @GetMapping("/veiculo")
    public ModelAndView veiculos() {
        List<Veiculo> veiculos = veiculoService.getAllVeiculos();

        ModelAndView mv = new ModelAndView("veiculo/veiculos");
        mv.addObject("veiculos", veiculos);
        return mv;
    }

    @GetMapping("/veiculo/adicionar")
    public ModelAndView veiculoAdicionar() {
        ModelAndView mv = new ModelAndView("veiculo/adicionar");
        mv.addObject("modelosVeiculos", modeloVeiculoService.getAllModelosVeiculos());
        return mv;
    }

    @PostMapping("/veiculo")
    public ModelAndView cadastrar(@Valid VeiculoRequestDTO veiculoRequestDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("veiculo/adicionar");
        } else {
            Veiculo veiculo = veiculoRequestDTO.toVeiculo();
            veiculoService.salvar(veiculo);
            return new ModelAndView("redirect:/veiculo");
        }
    }

    @GetMapping("/veiculo/editar/{id}")
    public ModelAndView veiculoEditar(@PathVariable UUID id) throws VeiculoNotFoundException {
        ModelAndView mv = new ModelAndView("veiculo/editar");

        Veiculo veiculo = veiculoService.getVeiculoPorId(id);

        VeiculoRequestDTO veiculoRequestDTO = new VeiculoRequestDTO();
        veiculoRequestDTO.setId(veiculo.getId());
        veiculoRequestDTO.setModeloVeiculo(veiculo.getModelo());
        veiculoRequestDTO.setPlaca(veiculo.getPlaca());
        veiculoRequestDTO.setAnoFabricacao(veiculo.getAnoFabricacao());
        veiculoRequestDTO.setAnoModelo(veiculo.getAnoModelo());
        veiculoRequestDTO.setCor(veiculo.getCor());

        mv.addObject("veiculoRequestDTO", veiculoRequestDTO);
        return mv;
    }

    @PostMapping("/veiculo/editar/{id}")
    public ModelAndView veiculoEditar(@PathVariable UUID id, VeiculoRequestDTO veiculoRequestDTO) throws VeiculoNotFoundException {
        ModeloVeiculo modeloVeiculo = veiculoService.getVeiculoPorId(id).getModelo();
        veiculoRequestDTO.setId(id);
        veiculoRequestDTO.setModeloVeiculo(modeloVeiculo);
        veiculoService.atualizar(veiculoRequestDTO.toVeiculo());

        return new ModelAndView("redirect:/veiculo");
    }

    @ModelAttribute(value="veiculoRequestDTO")
    public VeiculoRequestDTO getVeiculoRequestDTO(){
        return new VeiculoRequestDTO();
    }
}
