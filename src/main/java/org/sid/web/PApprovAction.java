package org.sid.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.sid.entities.Produits_Approvisionnement;
import org.sid.entities.Produits_Stock;
import org.sid.service.IservicePApprov;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class PApprovAction extends ActionSupport {

	//instantion de Produits_Approvisionnement
	public Produits_Approvisionnement produitApprov = new Produits_Approvisionnement();
	//liste des produits de approvisionnement
	public List<Produits_Approvisionnement> listPApprov;
	//false pour ajouter un produit et true pour modifier
	public boolean editMode=false;
	//message d'erreur
	public String codeErr = "";
	//code de produit
	public int codeP;
	@Autowired
	private IservicePApprov service;
	Logger logger =Logger.getLogger(this.getClass());
	
	//remplir la liste des approvisionnement
	public String indexA() {
		listPApprov = service.listProduit();
		  return SUCCESS;
	  }
	
	//cette methode va modifier ou ajouter un produit approvisionnement 
	public String saveA() {
		try {
			if(editMode == false) {
				//ajouter un produit
				  service.addProduit(produitApprov);
				  produitApprov = new Produits_Approvisionnement();
					codeErr = "";
			}
				  else {
					//modifier un produit
					  System.out.println("id ====== "+produitApprov.getCodePdt());
					  service.updateProduit(produitApprov);
					  produitApprov = new Produits_Approvisionnement();
					  editMode=false;
					  codeErr = "";

				  }
		} catch (Exception e) {
			//erreur: si le code de produit est déja existe
			codeErr = "Ce code est déja existe";
			System.err.println("erroooooor");
		}

		//remplir la liste des approvisionnement
		listPApprov = service.listProduit();
		  return SUCCESS;
	  }
	
	//suppression d'un produit
	public String deleteA() {
		  service.deleteProduit(codeP);
		  listPApprov = service.listProduit();
		  return SUCCESS;
	  }
	
	//initialiser les inputs avec les valeurs de produit selectioné
	public String editA() {
		  editMode= true;
		  produitApprov = service.getProduit(codeP);
		  System.out.println("id ====== "+produitApprov.getCodePdt());
		  listPApprov = service.listProduit();
		  return SUCCESS;
	  }
}
