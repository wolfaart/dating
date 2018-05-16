package com.formation.dating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idPhoto;
	@NotNull
	@NotBlank
	private String lien;
	@NotNull
	@NotBlank
	private Integer note;
	@ManyToOne
	private Utilisateur utilisateur;
	
	public Photo() {
		
	}

	public Integer getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
}
