package com.formation.dating.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	@NotBlank
	@Column(length=6)
	private String sexe;
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
	@NotNull
	private Integer type;
	@ManyToOne
	private Adresse adresse;
	@ManyToOne
	private Situation situation;
	@OneToMany
	private Collection<Photo> photos=new ArrayList<>();
	@ManyToMany
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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
	
	
	
}
