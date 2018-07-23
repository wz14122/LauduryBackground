package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<T> implements BatchDao<T> {

	@PersistenceContext
	protected EntityManager em;
	
	public void batchUpdate(List<T> list) {
		for(int i = 0; i<list.size();i++) {
			em.merge(list.get(i));
			if(i % 10 == 0) {
				em.flush();
				em.clear();
			}
		}
	}
	
	public void batchInsert(List<T> list) {
		for(int i = 0; i<list.size();i++) {
			em.persist(list.get(i));
			if(i % 10 == 0) {
				em.flush();
				em.clear();
			}
		}
	}
	
}
