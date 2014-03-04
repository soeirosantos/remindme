package br.com.soeirosantos.remindme.service

import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.inject.Named

import br.com.soeirosantos.remindme.domain.AllTags
import br.com.soeirosantos.remindme.domain.Note
import br.com.soeirosantos.remindme.domain.Tag
import br.com.soeirosantos.remindme.qualifiers.PreSave;

@Named
class TagService {

	@Inject
	AllTags allTags
	
	def associateTags(@Observes @PreSave Note note) {
		def tags = extractTag(note.body)
		tags.each { tag ->
			def t = new Tag(name:tag)
			t = allTags.getOrCreate(t)
			note.tags.add(t)
		}
		return note
	}

	def extractTag(noteBody) {
		return noteBody.split().findAll { it.startsWith("#") }.collect{ it[1..-1] }
	}
		
}
