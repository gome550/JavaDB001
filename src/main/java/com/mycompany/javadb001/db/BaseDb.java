package com.mycompany.javadb001.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 * データベース操作ベースクラス
 */
public class BaseDb<T> {

	protected Class<T> entityClass;

	@PersistenceContext(unitName="com.mycompany_JavaDB001_war_1.0-SNAPSHOTPU")
	protected EntityManager em;

	public BaseDb(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void create(T entity) {
		em.persist(entity);
	}

	public void edit(T entity) {
		em.merge(entity);
	}

	public void remove(T entity) {
		em.remove(em.merge(entity));
	}

	public T find(Object id) {
		return em.find(entityClass, id);
	}

	public void commit() {
		em.flush();
	}

	public List<T> findAll() {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

}
