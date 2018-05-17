package com.formation.dating.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Apparence {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idApparence;
	@NotNull
	private Integer taille;
	@NotNull
	@NotBlank
	private String couleurYeux;
	@NotNull
	@NotBlank
	private String origine;
	@NotNull
	@NotBlank
	private String couleurCheveux;
	@NotNull
	@NotBlank
	private String typeCheveux;
	@NotNull
	private Float masse;
	@OneToMany(cascade= CascadeType.ALL)
	private Collection<Utilisateur> utilisateurs=new ArrayList<>();
	
	public Apparence() {
		
	}

	public Integer getIdApparence() {
		return idApparence;
	}

	public void setIdApparence(Integer idApparence) {
		this.idApparence = idApparence;
	}

	public Integer getTaille() {
		return taille;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}

	public String getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(String couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getCouleurCheveux() {
		return couleurCheveux;
	}

	public void setCouleurCheveux(String couleurCheveux) {
		this.couleurCheveux = couleurCheveux;
	}

	public String getTypeCheveux() {
		return typeCheveux;
	}

	public void setTypeCheveux(String typeCheveux) {
		this.typeCheveux = typeCheveux;
	}

	public Float getMasse() {
		return masse;
	}

	public void setMasse(Float masse) {
		this.masse = masse;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	
}
