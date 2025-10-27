package com.fede587.ospedale.web.controller;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.service.RepartoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class RepartoController {

    private final RepartoService repartoService;

    public RepartoController(RepartoService repartoService) {
        this.repartoService = repartoService;
    }

    @GetMapping("/reparti")
    public String lista(Model model) {
        model.addAttribute("reparti", repartoService.findAll());
        return "reparti/lista";
    }

    @GetMapping("/reparti/nuovo")
    public String nuovo(Model model) {
        model.addAttribute("reparto", new Reparto());
        return "reparti/form";
    }

    @PostMapping("/reparti")
    public String crea(@ModelAttribute Reparto reparto, BindingResult result, Model model, RedirectAttributes ra) {
        if (reparto.getNome() == null || reparto.getNome().isBlank()) {
            result.rejectValue("nome", "NotBlank", "Il nome è obbligatorio");
            model.addAttribute("reparto", reparto);
            return "reparti/form";
        }
        repartoService.save(reparto);
        ra.addFlashAttribute("success", "Reparto creato con successo");
        return "redirect:/reparti";
    }

    @GetMapping("/reparti/{id}/modifica")
    public String modifica(@PathVariable Long id, Model model, RedirectAttributes ra) {
        Optional<Reparto> opt = repartoService.findById(id);
        if (opt.isEmpty()) {
            ra.addFlashAttribute("error", "Reparto non trovato");
            return "redirect:/reparti";
        }
        model.addAttribute("reparto", opt.get());
        return "reparti/form";
    }

    @PostMapping("/reparti/{id}/elimina")
    public String elimina(@PathVariable Long id, RedirectAttributes ra) {
        if (repartoService.findById(id).isPresent()) {
            repartoService.deleteById(id);
            ra.addFlashAttribute("success", "Reparto eliminato");
        } else {
            ra.addFlashAttribute("error", "Reparto non trovato");
        }
        return "redirect:/reparti";
    }
    
}

