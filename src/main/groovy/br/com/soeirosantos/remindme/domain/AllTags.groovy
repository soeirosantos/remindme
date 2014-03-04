package br.com.soeirosantos.remindme.domain

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
class AllTags {

	@PersistenceContext
	EntityManager entityManager

	def getOrCreate(Tag tag) {

		try {

			return entityManager
			.createNamedQuery(Tag.FIND_BY_NAME)
			.setParameter("name", tag.name)
			.getSingleResult()
		} catch (NoResultException e) {

			entityManager.persist(tag)
			entityManager.flush()
			return tag
		}
	}

	def all() {
		return entityManager.createNamedQuery(Tag.FIND_ALL).getResultList()
	}
}
