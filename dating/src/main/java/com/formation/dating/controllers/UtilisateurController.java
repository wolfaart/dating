package com.formation.dating.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.formation.dating.entities.Adresse;
import com.formation.dating.entities.Apparence;
import com.formation.dating.entities.CentreInteret;
import com.formation.dating.entities.Login;
import com.formation.dating.entities.Multimedia;
import com.formation.dating.entities.Photo;
import com.formation.dating.entities.Situation;
import com.formation.dating.entities.Utilisateur;
import com.formation.dating.enumerations.Alcool;
import com.formation.dating.enumerations.Fumeur;
import com.formation.dating.enumerations.Orientation;
import com.formation.dating.enumerations.Sexe;
import com.formation.dating.services.AdresseService;
import com.formation.dating.services.ApparenceService;
import com.formation.dating.services.CentreInteretService;
import com.formation.dating.services.MultimediaService;
import com.formation.dating.services.PhotoService;
import com.formation.dating.services.SituationService;
import com.formation.dating.services.UtilisateurService;



@Controller
public class UtilisateurController {

	private final UtilisateurService utilisateurService;
	private final AdresseService adresseService;
	private final ApparenceService apparenceService;
	private final CentreInteretService centreInteretService;
	private final MultimediaService multimediaService;
	private final PhotoService photoService;
	private final SituationService situationService;
	
	@Autowired
	public UtilisateurController(UtilisateurService utilisateurService, AdresseService adresseService,
			ApparenceService apparenceService, CentreInteretService centreInteretService,
			MultimediaService multimediaService, PhotoService photoService, SituationService situationService) {
		super();
		this.utilisateurService = utilisateurService;
		this.adresseService = adresseService;
		this.apparenceService = apparenceService;
		this.centreInteretService = centreInteretService;
		this.multimediaService = multimediaService;
		this.photoService = photoService;
		this.situationService = situationService;
	}
	
	@GetMapping("/register")
	public String getRegister(ModelMap model) {
		model.addAttribute("fragment", "/fragments/utilisateur/register.html");
		model.addAttribute("user", new Utilisateur());
		model.addAttribute("situation", new Situation());
		model.addAttribute("adresse",new Adresse());
		model.addAttribute("centreInteret",new CentreInteret());
		model.addAttribute("multimedia", new Multimedia());
		model.addAttribute("apparence", new Apparence());
		model.addAttribute("orientation",Orientation.values());
		model.addAttribute("sexe",Sexe.values());
		model.addAttribute("fumeur",Fumeur.values());
		model.addAttribute("alcool",Alcool.values());
		return "pages/home";
	}
	


	@PostMapping("/register")
	public String postRegister(ModelMap model,@Valid @ModelAttribute(name="user") Utilisateur utilisateur,BindingResult utilisateurResult,@Valid @ModelAttribute(name="situation") Situation situation,
			BindingResult situationResult,@Valid @ModelAttribute(name="adresse") Adresse adresse,BindingResult adresseResult,
			@Valid @ModelAttribute(name="centreInteret") CentreInteret centreInteret,BindingResult centreInteretResult,
			@Valid @ModelAttribute(name="multimedia") Multimedia multimedia,BindingResult multimediaResult,
			@Valid @ModelAttribute(name="apparence") Apparence apparence,BindingResult apparenceResult,
			@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IllegalStateException, IOException{
		
		if(utilisateurResult.hasErrors() || situationResult.hasErrors() || centreInteretResult.hasErrors() || adresseResult.hasErrors() || multimediaResult.hasErrors()) {
			
			model.addAttribute("fragment", "/fragments/utilisateur/register.html");
			model.addAttribute("orientation",Orientation.values());
			model.addAttribute("sexe",Sexe.values());
			model.addAttribute("fumeur",Fumeur.values());
			model.addAttribute("alcool",Alcool.values());
			return "pages/home";
		}
		
		
		 for (MultipartFile uploadedFile : uploadingFiles) {

	            if (PhotoController.checkIfImage(uploadedFile.getOriginalFilename())) {
	                File file = new File(PhotoController.UPLOAD_FOLDER + uploadedFile.getOriginalFilename());
	                uploadedFile.transferTo(file);
	                Photo photo = new Photo();
	                photo.setUtilisateur(utilisateur);
	                photo.setLien(uploadedFile.getOriginalFilename());
	                photoService.save(photo);
	                
	            }
		 }      
		adresseService.save(adresse);
		apparenceService.save(apparence);
		centreInteretService.save(centreInteret);
		multimediaService.save(multimedia);
		situationService.save(situation);
		utilisateur.setAdresse(adresse);
		utilisateur.setSituation(situation);
		utilisateurService.save(utilisateur);
		model.addAttribute("orientation",Orientation.values());
		model.addAttribute("sexe",Sexe.values());
		model.addAttribute("fumeur",Fumeur.values());
		model.addAttribute("alcool",Alcool.values());
		model.addAttribute("fragment", "/fragments/utilisateur/register.html");
		return "pages/home";	
	}
	
	@GetMapping("/utilisateur/connexion")
	public String getLogin(ModelMap model) {
		model.addAttribute("login", new Login());
		model.addAttribute("fragment","/fragments/utilisateur/connexion.html");
		return "pages/home";
	}
	
	@GetMapping("utilisateur/logout")
	public String logout(ModelMap model, HttpSession httpSession) {
		httpSession.invalidate();
		model.addAttribute("fragment","/fragments/rien");
		return "pages/home";
	}
	
	@PostMapping("/utilisateur/connexion")
	public String postConnexion(@Valid @ModelAttribute(name="login") Login login,BindingResult loginResult,
								ModelMap model,HttpSession httpSession,HttpServletRequest request) {
		
		Utilisateur utilisateur=utilisateurService.login(login.getEmail(),login.getPassword());
		if(loginResult.hasErrors() || utilisateur==null) {
			model.addAttribute("fragment","/fragments/utilisateur/connexion");
			model.addAttribute("login", new Login());
			return "pages/home";
		}
		httpSession.setMaxInactiveInterval(60*60);
		startSession(httpSession);
		httpSession.setAttribute("utilisateur",utilisateur);;
		return "redirect:"+request.getHeader("Referer");
		
	}
	
	public void startSession(HttpSession httpSession) {
		String key="Meetix";
		if(httpSession.getAttribute(key) == null) {
			httpSession.setAttribute(key, new Date());
		}
	}
}
