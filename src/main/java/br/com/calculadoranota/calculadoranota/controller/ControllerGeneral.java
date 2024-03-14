package br.com.calculadoranota.calculadoranota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.calculadoranota.calculadoranota.controller.DTO.RequestCalcularNotas;
import br.com.calculadoranota.calculadoranota.facade.FacadeGeneral;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ControllerGeneral {
    @Autowired
    private FacadeGeneral facadeGeneral;
    
    @GetMapping("/")
    public ModelAndView carregarHomePage() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @PostMapping("/")
    public ModelAndView calcularNotas(RequestCalcularNotas r) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("resultado", facadeGeneral.calculateNota(r.getNota1VA(), r.getNota2VA(), r.getNota3VA()));
        return mv;
    }
    
}
