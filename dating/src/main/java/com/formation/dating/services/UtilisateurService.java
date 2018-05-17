package com.formation.dating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Utilisateur;
import com.formation.dating.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository=utilisateurRepository;
	}
	
	public Iterable<Utilisateur> getAll(){
		return utilisateurRepository.findAll();
	}
	
	public Utilisateur save(Utilisateur u) {
		return utilisateurRepository.save(u);
	}
	
	public Utilisateur login(String email, String password) {
		return utilisateurRepository.findUtilisateurByEmailAndMotDePasse(email, password);
	}
}
