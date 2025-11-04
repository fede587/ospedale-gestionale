package com.fede587.ospedale.web.controller;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fede587.ospedale.web.service.ClienteService;

@Controller @Validated
public class AuthController {

  private record RegForm(@NotBlank String username, @NotBlank String password, boolean admin) {}
  private final ClienteService clienti;
  public AuthController(ClienteService clienti){ this.clienti = clienti; }

  @GetMapping("/login")
  public String login(){ return "login"; }

  @GetMapping("/registrazione")
  public String registerForm(Model model){
    model.addAttribute("user", new RegForm("", "", false));
    return "7registrazione";
  }

  @PostMapping("/registrazione")
  public String register(@ModelAttribute("user") RegForm rf){
    clienti.registra(rf.username(), rf.password(), rf.admin());
    return "redirect:/login?registered";
  }
}
