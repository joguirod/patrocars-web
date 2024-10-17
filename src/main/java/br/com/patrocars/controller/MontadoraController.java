package br.com.patrocars.controller;

import br.com.patrocars.domain.model.modeloVeiculo.ModeloVeiculo;
import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.model.veiculo.Veiculo;
import br.com.patrocars.domain.service.MontadoraService;
import br.com.patrocars.dto.MontadoraRequestDTO;
import br.com.patrocars.dto.VeiculoRequestDTO;
import br.com.patrocars.exception.MontadoraNotFoundException;
import br.com.patrocars.exception.VeiculoNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class MontadoraController {
    private MontadoraService montadoraService;

    public MontadoraController(MontadoraService montadoraService) {
        this.montadoraService = montadoraService;
    }

    @GetMapping("/montadora")
    public ModelAndView montadoras() {
        List<Montadora> montadoras = montadoraService.getAllMontadoras();

        ModelAndView mv = new ModelAndView("montadora/montadoras");
        mv.addObject("montadoras", montadoras);
        return mv;
    }

    @GetMapping("/montadora/adicionar")
    public ModelAndView montadoraAdicionar() {
        ModelAndView mv = new ModelAndView("montadora/adicionar");
        return mv;
    }

    @GetMapping("/montadora/editar/{id}")
    public ModelAndView montadoraEditar(@PathVariable UUID id) throws MontadoraNotFoundException {
        ModelAndView mv = new ModelAndView("montadora/editar");

        Montadora montadora = montadoraService.getMontadoraPorId(id);

        MontadoraRequestDTO montadoraRequestDTO = new MontadoraRequestDTO();
        montadoraRequestDTO.setId(montadora.getId());
        montadoraRequestDTO.setPais(montadora.getPais());
        montadoraRequestDTO.setAnoFundacao(montadora.getAnoFundacao());
        montadoraRequestDTO.setNome(montadora.getNome());

        mv.addObject("montadoraRequestDTO", montadoraRequestDTO);
        return mv;
    }

    @PostMapping("/montadora/editar/{id}")
    public ModelAndView montadoraEditar(@PathVariable UUID id, MontadoraRequestDTO montadoraRequestDTO) throws MontadoraNotFoundException {
        Montadora montadora = montadoraService.getMontadoraPorId(id);
        montadoraRequestDTO.setId(id);
        montadoraService.atualizar(montadoraRequestDTO.toMontadora());

        return new ModelAndView("redirect:/montadora");
    }

    @PostMapping("/montadora")
    public String cadastrar(MontadoraRequestDTO montadoraRequestDTO){
        Montadora montadora = montadoraRequestDTO.toMontadora();
        montadoraService.salvar(montadora);
        return "redirect:/montadoras";
    }

    @ModelAttribute(value="montadoraRequestDTO")
    public MontadoraRequestDTO getVeiculoRequestDTO(){
        return new MontadoraRequestDTO();
    }
}