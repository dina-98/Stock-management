package org.sid.service;

import java.util.List;

import org.sid.entities.Produits_Approvisionnement;


public interface IservicePApprov {

	public void addProduit(Produits_Approvisionnement p);
	public List<Produits_Approvisionnement> listProduit();
	public Produits_Approvisionnement getProduit(int codeP);
	public void deleteProduit(int codeP);
	public void updateProduit(Produits_Approvisionnement p);
}
