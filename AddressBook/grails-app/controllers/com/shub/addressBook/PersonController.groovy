package com.shub.addressBook

/**
 * PersonController is responsible for creating, saving, editing and
 * deleting a person information.
 */
class PersonController {

    PersonService personService

    /**
     * index action states the counter for the list
     *
     */
    def index() {
        def response = personService.list(params)
        [personList: response.list, total:response.count]
    }

    /**
     * details shows the information for the person
     *
     * @id shows information based on the id
     */
    def details(Integer id) {
        def response = personService.getById(id)
        if(!response) {
            redirect(controller: "person", action:"index")
        } else  {
            [person: response]
        }
     }

    /**
     * create action creates a new person when the user clicks on create
     *
     */
    def create() {
        [person: flash.redirectParams]
    }

    /**
     * save action saves the persons information to the database
     *
     */
    def save() {
        def response = personService.save(params)
        if(!response.isSuccess) {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "person", action: "create")
        } else  {
            flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "person", action: "index")
        }
    }

    /**
     * edit action edits the persons information if the user needs to change
     * anything
     *
     * @param id edits the information based on the id
     */
    def edit(Integer id) {
        if(flash.redirectParams) {
            [person: flash.redirectParams]
        } else  {
            def response = personService.getById(id)
            if(!response) {
                redirect(controller: "person", action: "index")
            } else {
                [person: response]
            }
        }
    }

    /**
     * update action updates the information that is on the list and which
     * is saved on the database
     *
     */
    def update() {
        def response = personService.getById(params.id)
        if(!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "person", action:"index")
        } else {
            response = personService.update(response, params)
            if(!response.isSuccess) {
                flash.redirectParams = response.model
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "person", action: "edit")
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "person", action: "index")
            }
        }
    }


    /**
     * delete action deletes the persons information and removes it from the
     * list and the database based on the id
     *
     * @id id gets the id that needs to be removed
     */
    def delete(Integer id) {
        def response = personService.getById(id)
        if(!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "person", action: "index")
        } else {
            response = personService.delete(response)
            if(!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"), false)
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(cotroller: "person", action: "index")
        }
    }
}
