package br.com.soeirosantos.remindme.bean

import javax.faces.application.FacesMessage
import javax.faces.context.FacesContext
import javax.faces.view.ViewScoped
import javax.inject.Inject
import javax.inject.Named

import org.primefaces.event.SelectEvent
import org.primefaces.model.tagcloud.DefaultTagCloudItem
import org.primefaces.model.tagcloud.DefaultTagCloudModel
import org.primefaces.model.tagcloud.TagCloudItem

import br.com.soeirosantos.remindme.domain.AllNotes
import br.com.soeirosantos.remindme.domain.Note
import br.com.soeirosantos.remindme.qualifiers.PostSave;
import br.com.soeirosantos.remindme.qualifiers.PreSave;
import br.com.soeirosantos.remindme.service.TagService;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;

@Named
@ViewScoped
class NoteBean {

	Note note = new Note()
	
	List<Note> notes;
	
	@Inject
	AllNotes allNotes
	
	@Inject
	TagService tagService
	
	@Inject
	FacesContext context
	
	@Inject
	@PreSave
	Event<Note> preSave

	@Inject
	@PostSave
	Event<Note> postSave
	
	def save() {
		preSave.fire(note)
		allNotes.add(note)
		postSave.fire(note)
		addSuccessMessage()
	}
	
	def getNotes() {
		if (!notes) {
			notes = allNotes.all()
		}
		return notes
	}
	
	def release(@Observes @PostSave Note note) {
		this.note = new Note()
		notes = allNotes.all()
	}
	
	def addSuccessMessage() {
		context.addMessage(null, new FacesMessage("Reminder note saved"))
	}
}
