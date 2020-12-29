package com.shub

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

/**
 * PersonController is responsible for creating, saving, editing, show and
 * deleting a person information.
 */
class PersonController {

    PersonService personService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /**
     * index action states the counter for the list
     *
     * @param max States the max number for the list
     */
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personService.list(params), model:[personCount: personService.count()]
    }

    /**
     * Show action show the list by the id
     *
     * @param id is where the persons information is stored on the list
     */
    def show(Long id) {
        respond personService.get(id)
    }

    /**
     * create action creates a new person when the user clicks on New Person
     *
     */
    def create() {
        respond new Person(params)
    }

    /**
     * save action saves the persons information to the database
     *
     * @param person gets the persons information that needs to be saved into
     * the database
     */
    def save(Person person) {
        if (person == null) {
            notFound()
            return
        }

        try {
            personService.save(person)
        } catch (ValidationException e) {
            respond person.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect person
            }
            '*' { respond person, [status: CREATED] }
        }
    }

    /**
     * edit action edits the persons information if the user needs to change
     * anything
     *
     * @param id edits the information based on the id
     */
    def edit(Long id) {
        respond personService.get(id)
    }

    /**
     * update action updates the information that is on the list and which
     * is saved on the database
     *
     * @param person gets the person that needs to be updated
     */
    def update(Person person) {
        if (person == null) {
            notFound()
            return
        }

        try {
            personService.save(person)
        } catch (ValidationException e) {
            respond person.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect person
            }
            '*'{ respond person, [status: OK] }
        }
    }

    /**
     * delete action deletes the persons information and removes it from the
     * list and the databse based on the id
     *
     * @param id gets the id that needs to be removed
     */
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'Person'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
}
