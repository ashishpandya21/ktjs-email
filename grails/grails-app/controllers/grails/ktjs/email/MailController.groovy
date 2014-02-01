package grails.ktjs.email

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

class MailController {

	def index() {
        def json = new JSONObject()
		 json.putAt("id", "Inbox")
		 json.put("mails", Mail.getAll())
		render json as JSON
	}

	def mailDetails() {
		render Mail.get(params.id) as JSON
	}
}
