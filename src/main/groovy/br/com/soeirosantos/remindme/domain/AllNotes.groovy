package br.com.soeirosantos.remindme.domain

import javax.ejb.LocalBean
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
class AllNotes {

	@PersistenceContext
	EntityManager entityManager

	def add(Note note) {
		entityManager.merge(note)
	}

	def all(){
		return entityManager.createNamedQuery(Note.FIND_ALL).getResultList()
	}

	def findAllByTagName(String tagName) {
		return entityManager.createNamedQuery(Note.FIND_ALL_BY_TAG_NAME).setParameter("name", tagName).getResultList()
	}
}
