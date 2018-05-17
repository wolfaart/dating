package com.formation.dating.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idAdresse;
	@NotNull
	@Column(length=5)
	private Integer codePostal;
	@NotNull
	@Column(length=4)
	private Integer numero;
	@NotNull
	@NotBlank
	private String typeRue;
	@NotNull
	@NotBlank
	private String nomRue;

	@Column(length=100)
	private String complement;

	private String prefixe;
	@OneToMany(mappedBy="adresse",cascade= CascadeType.ALL)
	private Collection<Utilisateur> utilisateurs= new ArrayList<>();
	
	public Adresse() {
		
	}

	public Integer getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTypeRue() {
		return typeRue;
	}

	public void setTypeRue(String typeRue) {
		this.typeRue = typeRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPrefixe() {
		return prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	
}
