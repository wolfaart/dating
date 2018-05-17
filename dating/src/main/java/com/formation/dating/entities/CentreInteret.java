package com.formation.dating.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CentreInteret {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idCI;
	
	private String sport;
	
	private String loisir;
	@ManyToMany(cascade= CascadeType.ALL)
	private Collection<Multimedia> multimedias=new ArrayList<>();
	@ManyToMany(cascade= CascadeType.ALL)
	private Collection<Utilisateur> utilisateurs= new ArrayList<>();
	
	public CentreInteret() {
		
	}

	public Integer getIdCI() {
		return idCI;
	}

	public void setIdCI(Integer idCI) {
		this.idCI = idCI;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getLoisir() {
		return loisir;
	}

	public void setLoisir(String loisir) {
		this.loisir = loisir;
	}
	
	
}
