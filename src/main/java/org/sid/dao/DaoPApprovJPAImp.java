package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Produits_Approvisionnement;

public class DaoPApprovJPAImp implements IdaoPApprov {

	@PersistenceContext
	private EntityManager em;
	@Override
	public void addProduit(Produits_Approvisionnement p) {
		em.persist(p);
	}

	@Override
	public List<Produits_Approvisionnement> listProduit() {
		Query req = em.createQuery("select p from Produits_Approvisionnement p");
		return req.getResultList();
	}

	@Override
	public Produits_Approvisionnement getProduit(int codeP) {
		return em.find(Produits_Approvisionnement.class, codeP);
	}

	@Override
	public void deleteProduit(int codeP) {
		Produits_Approvisionnement p = getProduit(codeP);
		em.remove(p);
		
	}

	@Override
	public void updateProduit(Produits_Approvisionnement p) {
		em.merge(p);
		
	}

}
