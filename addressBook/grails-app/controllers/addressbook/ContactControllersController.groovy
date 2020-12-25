package addressbook

import grails.web.servlet.mvc.GrailsParameterMap

class ContactControllersController {

    def index() {
        redirect action: "list"
    }

    def create() { }

    def save(GrailsParameterMap params) {
        Contact contact = new Contact(params)
        contact.save flush: true, failOnError: true
        redirect action: "Show", id: contact.id
    }

    def edit(GrailsParameterMap params) {

    }

    def update(GrailsParameterMap params) {


    }
    def delete() { }
    def list() { }
}
