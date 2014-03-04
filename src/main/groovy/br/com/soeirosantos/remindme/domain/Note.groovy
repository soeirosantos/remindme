package br.com.soeirosantos.remindme.domain

import javax.persistence.Column;
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery

import br.com.soeirosantos.remindme.service.ColorService;

@Entity
@NamedQueries([ 
				@NamedQuery(name=Note.FIND_ALL, query="SELECT n FROM Note n"),
				@NamedQuery(name=Note.FIND_ALL_BY_TAG_NAME, query="SELECT distinct n FROM Note n join n.tags t where t.name = :name "),
				 
			  ])
class Note {

	final static String FIND_ALL = "Note.findAll"
	final static String FIND_ALL_BY_TAG_NAME = "Note.findAllByTagName"
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id
	String title
	@Column(length=500)
	String body
	String color
	Date remind
	Integer priority
	Date created = new Date()
	
	@ManyToMany
	Set<Tag> tags = new HashSet<>()
	
	def getBodyColor() {
		def bodyColor = "blackTextNote"
		if (this.color) {
			def rgb = ColorService.fromHexaToRgb(this.color)
			if ( rgb.find{ it < 120 } ) {
				bodyColor = "whiteTextNote"
			} 
		}
		return bodyColor
	}
	
	@Override
	def String toString() {
		if (body) {
			return body.length() > 50 ? body[0..50].split()[0..-2].join(" ")+"..." : body
		} else {
			return GString.EMPTY
		}
	}
	
}
