package com.formation.dating.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.formation.dating.enumerations.Sexe;

@Entity
public class Utilisateur {

	@Id
	@NotBlank
	@NotNull
	@Email
	private String email;
	@NotNull
	@NotBlank
	@Column(length=150)
	private String nom;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDeNaissance;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	@NotNull
	@NotBlank
	private String motDePasse;
	@NotNull
	@NotBlank
	private String description;
	@NotNull
	@NotBlank
	@Column(length=100)
	private String pseudo;
	@NotBlank
	@NotNull
	@Column(length=10)
	private String numeroTel;

	private Integer type;
	@ManyToOne(cascade= CascadeType.ALL)
	private Adresse adresse;
	@ManyToOne(cascade= CascadeType.ALL)
	private Situation situation;
	@OneToMany(mappedBy="utilisateur",cascade= CascadeType.ALL)
	private Collection<Photo> photos=new ArrayList<>();
	@ManyToMany(mappedBy="utilisateurs",cascade= CascadeType.ALL)
	private Collection<CentreInteret> centreInterets= new ArrayList<>();
	
	
	
	
	public Utilisateur() {
		
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}



	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse =get_SHA_512_SecurePassword(motDePasse);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public static String get_SHA_512_SecurePassword(String passwordToHash) {
		String generatedPassword = null;
		String salt = "olprog";
		try {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(salt.getBytes(StandardCharsets.UTF_8));
		byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
		sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
		}
		return generatedPassword;
		}



	public Sexe getSexe() {
		return sexe;
	}



	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public Situation getSituation() {
		return situation;
	}



	public void setSituation(Situation situation) {
		this.situation = situation;
	}



	public Collection<Photo> getPhotos() {
		return photos;
	}



	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}



	public Collection<CentreInteret> getCentreInterets() {
		return centreInterets;
	}



	public void setCentreInterets(Collection<CentreInteret> centreInterets) {
		this.centreInterets = centreInterets;
	}
	
	
	
}
