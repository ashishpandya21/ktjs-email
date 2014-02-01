package grails.ktjs.email

class Mail {
	String sendingFrom
	String sendingTo
	String sentDate
	String subject
	String folder
	String messageContent
	
    static constraints = {
		messageContent type: 'text'
    }
}
