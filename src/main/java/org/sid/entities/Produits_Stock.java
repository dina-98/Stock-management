package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produits_Stock implements Serializable {
	@Id
	private int codePdt;
	private int qtePdt;
	private String nomPdt;
	private String descPdt;
	private int prixPdt;
	
	
	public int getCodePdt() {
		return codePdt;
	}
	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}
	public int getQtePdt() {
		return qtePdt;
	}
	public void setQtePdt(int qtePdt) {
		this.qtePdt = qtePdt;
	}
	public String getNomPdt() {
		return nomPdt;
	}
	public void setNomPdt(String nomPdt) {
		this.nomPdt = nomPdt;
	}
	public String getDescPdt() {
		return descPdt;
	}
	public void setDescPdt(String descPdt) {
		this.descPdt = descPdt;
	}
	public int getPrixPdt() {
		return prixPdt;
	}
	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}
	public Produits_Stock(int codePdt, int qtePdt, String nomPdt, String descPdt, int prixPdt) {
		super();
		this.codePdt = codePdt;
		this.qtePdt = qtePdt;
		this.nomPdt = nomPdt;
		this.descPdt = descPdt;
		this.prixPdt = prixPdt;
	}
	public Produits_Stock() {
		super();
	}
	
}
