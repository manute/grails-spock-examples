package es.demo

import grails.plugin.spock.*

class AlbumSpec extends UnitSpec {

	def setup(){
		mockDomain(Album)
		def album1=new Album(author:"Beatles",title:"Odyssey").save()	
		def album2=new Album(author:"Beatles",title:"Yellow Submarine").save()	
		def album3=new Album(author:"U2",title:"With or Without you").save()
	}
	
  	def "albums can be saved and retrieved"() {
		//setup: mockDomain(Album)
	    when:  def album=new Album(author:"DobleV",title:"Ciudad").save()
	    then:  !album.hasErrors()
		and:   Album.findByAuthor("DobleV")
	 }
	def "albums can be upated and retrieved"() {
		setup: //mockDomain(Album)
			   def album=new Album(author:"Iron Maiden",title:"Fear of the Dark").save()	
	    when: 
	  		   album.title="The Seven Siths"
			   album.save()
	    then:  !album.hasErrors()
		and:   Album.findByAuthor("Iron Maiden").title=="The Seven Siths"
	 }
	
	def "albums can be retrieved using  their id"(){
		/*setup: mockDomain(Album)
			   def album1=new Album(author:"Beatles",title:"Odyssey").save()	
			   def album2=new Album(author:"Beatles",title:"Yellow Submarine").save()	
			   def album3=new Album(author:"U2",title:"With or Without you").save()		
		*/
		when:  
			   def	album = Album.findByTitle(title)
			  
		then:  
			   album.author == author	
			   album.title == title
		where:
		id  | 	author  	| title
		1  	|  "Beatles"	| "Odyssey"
		2  	|  "Beatles"	| "Yellow Submarine"
		3  	|  "U2"			| "With or Without you"
					
	}
	

}
