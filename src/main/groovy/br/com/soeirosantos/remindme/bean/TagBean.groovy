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
import br.com.soeirosantos.remindme.domain.AllTags;
import br.com.soeirosantos.remindme.domain.Note
import br.com.soeirosantos.remindme.service.TagService;

@Named
@ViewScoped
class TagBean {

	@Inject
	AllTags allTags
	
	@Inject
	AllNotes allNotes
	
	@Inject
	@ViewScoped
	NoteBean noteBean
	
	def getTags() {
		def model = new DefaultTagCloudModel();
		allTags.all().each {
			model.addTag(new DefaultTagCloudItem(it.name, it.notes.size()))
		}
		return model
	}
	
	public void onSelect(SelectEvent event) {
		TagCloudItem item = (TagCloudItem) event.getObject()
		noteBean.notes = allNotes.findAllByTagName(item.label)
	}
	
}
