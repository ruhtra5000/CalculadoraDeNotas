package br.com.calculadoranota.calculadoranota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.calculadoranota.calculadoranota.controller.DTO.RequestCalcularNotas;
import br.com.calculadoranota.calculadoranota.facade.FacadeGeneral;

@Controller
public class ControllerGeneral implements ErrorController {
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
        try {
            mv.addObject("resultado", facadeGeneral.calculateNota(r.getNota1VA(), 
            r.getNota2VA(), r.getNota3VA(), r.getModo()));
        }
        catch (Exception err) {
            mv.setViewName("erro");
            mv.addObject("erro", err.getMessage());
        }
        return mv;
    }
    
    @GetMapping("/ajuda")
    public ModelAndView carregarPaginaAjuda() {
        ModelAndView mv = new ModelAndView("ajuda");
        return mv;
    }
    
    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView mv = new ModelAndView("erro");
        mv.addObject("erro", "Página não encontrada ou problemas internos no site!");
        return mv;
    }
}
