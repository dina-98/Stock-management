package org.sid.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Produits_Approvisionnement {
   
	@Id
	private int codePdt;
	private int qteCommande;
	private Date datePrevueLivraison ;
	
	public int getCodePdt() {
		return codePdt;
	}
	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}
	public int getQteCommande() {
		return qteCommande;
	}
	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}
	public Date getDatePrevueLivraison() {
		return datePrevueLivraison;
	}
	public void setDatePrevueLivraison(Date datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}
	public Produits_Approvisionnement(int codePdt, int qteCommande, Date datePrevueLivraison) {
		super();
		this.codePdt = codePdt;
		this.qteCommande = qteCommande;
		this.datePrevueLivraison = datePrevueLivraison;
	}
	public Produits_Approvisionnement() {
		super();
	}
	
	
	
}
