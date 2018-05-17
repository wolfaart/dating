package com.formation.dating.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.formation.dating.enumerations.Alcool;
import com.formation.dating.enumerations.Fumeur;
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
	private Integer nbrEnfant;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Orientation orientation;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Fumeur fumeur;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Alcool alcool;
	@OneToMany(cascade= CascadeType.ALL)
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




	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Fumeur getFumeur() {
		return fumeur;
	}

	public void setFumeur(Fumeur fumeur) {
		this.fumeur = fumeur;
	}

	public Alcool getAlcool() {
		return alcool;
	}

	public void setAlcool(Alcool alcool) {
		this.alcool = alcool;
	}


	
}
