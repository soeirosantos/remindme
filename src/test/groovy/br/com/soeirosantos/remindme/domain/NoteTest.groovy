package br.com.soeirosantos.remindme.domain

import org.junit.Assert
import org.junit.Test

import br.com.soeirosantos.remindme.service.ColorService;
import br.com.soeirosantos.remindme.service.TagService

class NoteTest {

	@Test
	def void testToStringEmptyBody() {
		Note n = new Note()
		Assert.assertEquals(GString.EMPTY.toString(), n.toString())
	}	

	@Test
	def void testToStringNotEmptyBody() {
		Note n = new Note()
		def body = "Test short string"
		n.body = body
		Assert.assertEquals(body, n.toString())
	}

	@Test
	def void testToStringNotEmptyAndLongBody() {
		Note n = new Note()
		def body = "Test if a very long string is correctly concatenated as it should be"
		n.body = body
		def partialBody = "Test if a very long string is correctly..."
		Assert.assertEquals(partialBody, n.toString())
	}
	
	@Test
	def void testBodyColor() {
		Note n = new Note()
		n.color = "b5949b"
		Assert.assertEquals("blackTextNote", n.getBodyColor())
	}
	
	@Test
	def void testExtractTag(){
		def noteBody = "test if is extracting tags #SQN #java"
		TagService tagService = new TagService()
		def tags = tagService.extractTag(noteBody)
		Assert.assertEquals(["SQN", "java"], tags)
	}
}
