package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class FruitService {

	@Inject
	EntityManager entityManager;
	
	@Transactional
	public void createFruit(Fruit fruit) {
		entityManager.persist(fruit);
	}
	
	@Transactional
	public void deleteFruit(Fruit fruit) {
		entityManager.detach(fruit);
	}
}
