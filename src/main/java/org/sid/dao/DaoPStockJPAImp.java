package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Produits_Stock;

public class DaoPStockJPAImp implements IdaoPStock{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addProduit(Produits_Stock p) {
		// TODO Auto-generated method stub
		em.persist(p);
	}

	@Override
	public List<Produits_Stock> listProduit() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Produits_Stock p");
		return req.getResultList();
	}

	@Override
	public Produits_Stock getProduit(int codeP) {
		return em.find(Produits_Stock.class, codeP);
	}

	@Override
	public void deleteProduit(int codeP) {
		Produits_Stock p = getProduit(codeP);
		em.remove(p);
		
	}

	@Override
	public void updateProduit(Produits_Stock p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

}
