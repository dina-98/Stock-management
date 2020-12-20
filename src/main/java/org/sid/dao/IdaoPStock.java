package org.sid.dao;

import java.util.List;

import org.sid.entities.Produits_Stock;

public interface IdaoPStock {

	public void addProduit(Produits_Stock p);
	public List<Produits_Stock> listProduit();
	public Produits_Stock getProduit(int codeP);
	public void deleteProduit(int codeP);
	public void updateProduit(Produits_Stock p);
}
