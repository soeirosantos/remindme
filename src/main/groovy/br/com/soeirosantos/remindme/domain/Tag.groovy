package br.com.soeirosantos.remindme.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery

@Entity
@NamedQueries([
	@NamedQuery(name=Tag.FIND_ALL, query="SELECT distinct t FROM Tag t join fetch t.notes"),
	@NamedQuery(name=Tag.FIND_BY_NAME, query="select t from Tag t where t.name = :name"),
  ])
class Tag {

	static final FIND_ALL = "Tag.findAll"
	static final FIND_BY_NAME = "Tag.findByName"
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id
	
	@Column(unique=true)
	String name
	
	@ManyToMany(mappedBy="tags")
	Set<Note> notes = new HashSet<>()
	
}
