package ospedale_web.ospedale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.service.DottoreService;
import ospedale.ospedale_core.service.RepartoService;

import java.util.Optional;

@Controller
public class DottoreController {

    private final DottoreService DottoreService;
    private final RepartoService repartoService;

    public DottoreController(DottoreService DottoreService, RepartoService repartoService) {
        this.DottoreService = DottoreService;
        this.repartoService = repartoService;
    }

    @GetMapping("/dottori/nuovo")
    public String nuovo(Model model) {
        model.addAttribute("Dottore", new Dottore());
        model.addAttribute("reparti", repartoService.findAll());
        return "dottori/dottoriForm";
    }

    @PostMapping("/dottori")
    public String crea(@ModelAttribute Dottore Dottore,
                       @RequestParam(name = "repartoId", required = false) Long repartoId,
                       Model model,
                       RedirectAttributes redirect) {

        if (repartoId == null) {
            model.addAttribute("error", "Seleziona un reparto");
            model.addAttribute("reparti", repartoService.findAll());
            return "dottori/dottoriForm";
        }

        Optional<Reparto> repartoOpt = repartoService.findById(repartoId);
        if (repartoOpt.isEmpty()) {
            model.addAttribute("error", "Reparto non valido");
            model.addAttribute("reparti", repartoService.findAll());
            return "dottori/dottoriForm";
        }

        Dottore.setReparto(repartoOpt.get());
        DottoreService.save(Dottore);
        redirect.addFlashAttribute("success", "Dottore creato con successo");
        return "redirect:/dottori/dottoriForm";
    }
}
