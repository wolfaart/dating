package com.formation.dating.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Multimedia {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idMultimedia;
	@NotBlank
	@NotNull
	private String typeMultimedia;
	@NotBlank
	@NotNull
	private String genre;
	@NotBlank
	@NotNull
	private String titre;
	@NotBlank
	@NotNull
	private String artiste;
	@ManyToMany
	private Collection<CentreInteret> centreInterets= new ArrayList<>();
	
	public Multimedia() {
		
	}

	public Integer getIdMultimedia() {
		return idMultimedia;
	}

	public void setIdMultimedia(Integer idMultimedia) {
		this.idMultimedia = idMultimedia;
	}

	public String getTypeMultimedia() {
		return typeMultimedia;
	}

	public void setTypeMultimedia(String typeMultimedia) {
		this.typeMultimedia = typeMultimedia;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public Collection<CentreInteret> getCentreInterets() {
		return centreInterets;
	}

	public void setCentreInterets(Collection<CentreInteret> centreInterets) {
		this.centreInterets = centreInterets;
	}
	
	
}
