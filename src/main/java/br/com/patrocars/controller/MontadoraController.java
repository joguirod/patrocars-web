package br.com.patrocars.controller;

import br.com.patrocars.domain.model.montadora.Montadora;
import br.com.patrocars.domain.service.MontadoraService;
import br.com.patrocars.dto.MontadoraRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MontadoraController {
    private MontadoraService montadoraService;

    public MontadoraController(MontadoraService montadoraService) {
        this.montadoraService = montadoraService;
    }

    @GetMapping("/montadoras")
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

    @PostMapping("/montadoras")
    public String cadastrar(MontadoraRequestDTO montadoraRequestDTO){
        Montadora montadora = montadoraRequestDTO.toMontadora();
        montadoraService.salvar(montadora);
        return "redirect:/montadoras";
    }
}