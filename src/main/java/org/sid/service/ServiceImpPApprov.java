package org.sid.service;

import java.util.List;

import org.sid.dao.IdaoPApprov;
import org.sid.entities.Produits_Approvisionnement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ServiceImpPApprov implements IservicePApprov {

	private IdaoPApprov dao;
	
	public void setDao(IdaoPApprov dao) {
		this.dao = dao;
	}

	@Override
	public void addProduit(Produits_Approvisionnement p) {
		dao.addProduit(p);
		
	}

	@Override
	public List<Produits_Approvisionnement> listProduit() {
		return dao.listProduit();
	}

	@Override
	public Produits_Approvisionnement getProduit(int codeP) {
		return dao.getProduit(codeP);
	}

	@Override
	public void deleteProduit(int codeP) {
		dao.deleteProduit(codeP);
		
	}

	@Override
	public void updateProduit(Produits_Approvisionnement p) {
		dao.updateProduit(p);
		
	}

}
