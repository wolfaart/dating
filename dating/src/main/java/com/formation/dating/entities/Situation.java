package com.formation.dating.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.formation.dating.enumerations.Orientation;

@Entity
public class Situation {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idSitutation;
	@NotNull
	@NotBlank
	private String statutPro;
	@NotNull
	@NotBlank
	private String statutPerso;
	@NotNull
	@NotBlank
	private Integer nbrEnfant;
	@NotNull
	@NotBlank
	private Orientation orientation;
	@NotNull
	@NotBlank
	private String fumeur;
	@NotNull
	@NotBlank
	private String alcool;
	@OneToMany
	private Collection<Utilisateur> utilisateurs= new ArrayList<>();
	
	public Situation() {
		
	}

	public Integer getIdSitutation() {
		return idSitutation;
	}

	public void setIdSitutation(Integer idSitutation) {
		this.idSitutation = idSitutation;
	}

	public String getStatutPro() {
		return statutPro;
	}

	public void setStatutPro(String statutPro) {
		this.statutPro = statutPro;
	}

	public String getStatutPerso() {
		return statutPerso;
	}

	public void setStatutPerso(String statutPerso) {
		this.statutPerso = statutPerso;
	}

	public Integer getNbrEnfant() {
		return nbrEnfant;
	}

	public void setNbrEnfant(Integer nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public String getFumeur() {
		return fumeur;
	}

	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}

	public String getAlcool() {
		return alcool;
	}

	public void setAlcool(String alcool) {
		this.alcool = alcool;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	
}
