package com.formation.dating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.formation.dating.entities.Situation;
import com.formation.dating.entities.Utilisateur;
import com.formation.dating.enumerations.Orientation;

@Controller
public class UtilisateurController {

	public UtilisateurController() {
		
	}
	
	@GetMapping("/register")
	public String getRegister(ModelMap model) {
		model.addAttribute("fragment", "/fragments/utilisateur/register.html");
		model.addAttribute("user", new Utilisateur());
		model.addAttribute("situation", new Situation());
		model.addAttribute("orientation",Orientation.values());
		return "pages/home";
	}
}
