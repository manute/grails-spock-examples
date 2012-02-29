package es.demo

import grails.plugin.spock.*

class AlbumControllerSpec extends ControllerSpec {

	def "render hello world on index"(){
		when: controller.index()
	    then: 
	        mockResponse.contentAsString.contains("hello")

	}
}