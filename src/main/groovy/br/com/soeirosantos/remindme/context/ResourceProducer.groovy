package br.com.soeirosantos.remindme.context

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

class ResourceProducer {

	@Produces @RequestScoped
	def FacesContext getFacesContext() {
		return FacesContext.currentInstance
	} 
	
}
