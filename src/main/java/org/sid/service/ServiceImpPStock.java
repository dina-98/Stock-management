package org.sid.service;

import java.util.List;

import org.sid.dao.IdaoPStock;
import org.sid.entities.Produits_Stock;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ServiceImpPStock implements IsevicePStock {

	private IdaoPStock dao;
	
	public void setDao(IdaoPStock dao) {
		this.dao = dao;
	}

	@Override
	public void addProduit(Produits_Stock p) {
		// TODO Auto-generated method stub
		dao.addProduit(p);
		
	}

	@Override
	public List<Produits_Stock> listProduit() {
		// TODO Auto-generated method stub
		return dao.listProduit();
	}

	@Override
	public Produits_Stock getProduit(int codeP) {
		// TODO Auto-generated method stub
		return dao.getProduit(codeP);
	}

	@Override
	public void deleteProduit(int codeP) {
		// TODO Auto-generated method stub
		dao.deleteProduit(codeP);
		
	}

	@Override
	public void updateProduit(Produits_Stock p) {
		// TODO Auto-generated method stub
		dao.updateProduit(p);
		
	}
	

}
