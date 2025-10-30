package com.fede587.ospedale.web.controller;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.service.DottoreService;
import com.fede587.ospedale.core.service.RepartoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class DottoreController {

    private final DottoreService dottoreService;
    private final RepartoService repartoService;

    public DottoreController(DottoreService dottoreService, RepartoService repartoService) {
        this.dottoreService = dottoreService;
        this.repartoService = repartoService;
    }

    @GetMapping("/dottori/nuovo")
    public String nuovo(Model model) {
        model.addAttribute("dottore", new Dottore());
        model.addAttribute("reparti", repartoService.findAll());
        return "/dottoriForm";
    }

    @PostMapping("/dottoriForm")
    public String crea(@ModelAttribute Dottore dottore,
                       @RequestParam(name = "repartoId", required = false) Long repartoId,
                       Model model,
                       RedirectAttributes ra) {

        if (repartoId == null) {
            model.addAttribute("error", "Seleziona un reparto");
            model.addAttribute("reparti", repartoService.findAll());
            return "/dottoriForm";
        }

        Optional<Reparto> repartoOpt = repartoService.findById(repartoId);
        if (repartoOpt.isEmpty()) {
            model.addAttribute("error", "Reparto non valido");
            model.addAttribute("reparti", repartoService.findAll());
            return "/dottoriForm";
        }

        dottore.setReparto(repartoOpt.get());
        dottoreService.save(dottore);
        ra.addFlashAttribute("success", "Dottore creato con successo");
        return "redirect:/dottoriForm";
    }
}
