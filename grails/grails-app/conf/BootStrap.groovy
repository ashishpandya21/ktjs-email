import grails.converters.JSON;
import grails.ktjs.email.Mail

class BootStrap {

    def init = { servletContext ->
		JSON.registerObjectMarshaller(Mail) {
			def returnArray = [:]
			returnArray['id'] = it.id
			returnArray['sendingFrom'] = it.sendingFrom
			returnArray['sendingTo'] = it.sendingTo
			returnArray['sentDate'] = it.sentDate
			returnArray['subject'] = it.subject
			returnArray['folder'] = it.subject
			returnArray['messageContent'] = it.messageContent
			return returnArray
	}
		new Mail(sendingFrom:"Abbot <oliver@smoke-stage.xyz>", sendingTo:"steve@example.com", sentDate:"May 25, 2011", subject:"Booking confirmation #389629244", folder:"Inbox",
			messageContent:"Hi!im doing good").save()
		new Mail(sendingFrom:"Addison Begoat <upton.oprdrusson@pear-income.xyz>", sendingTo:"steve@example.com", sentDate:"May 7, 2011", subject:"FW: Associate advice", folder:"Inbox",
			messageContent:"Hi!im doing good").save()
		new Mail(sendingFrom:"Allistair <leroy72@plane-railway.xyz>", sendingTo:"steve@example.com", sentDate:"May 19, 2011", subject:"RE: Phone call tomorrow 5 o'clock", folder:"Inbox",
			messageContent:"Hi!im doing good").save()

    }
    def destroy = {
    }
}
