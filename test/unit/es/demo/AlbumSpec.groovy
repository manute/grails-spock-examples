package es.demo

import grails.plugin.spock.*

class AlbumSpec extends UnitSpec {

  	def "albums can be saved and retrieved"() {
		setup: mockDomain(Album)
	    when: 
	  		   def album=new Album(author:"Spock",title:"Spock-Examples").save()
	    then:  !album.hasErrors()
		and:   Album.findByAuthor("Spock")
	 }
}
