package com.shub.addressBook

class PersonController {

    PersonService personService

    def index() {
        def response = personService.list(params)
        [personList: response.list, total:response.count]
    }

    def details(Integer id) {
        def response = personService.getById(id)
        if(!response) {
            redirect(controller: "person", action:"index")
        } else  {
            [person: response]
        }
     }

    def create() {
        [person: flash.redirectParams]
    }

    def save() {
        def response = personService.save(params)
        if(!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "person", action: "create")
        } else  {
            redirect(controller: "person", action: "index")
        }
    }

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

    def update() {
        def response = personService.getById(params.id)
        if(!response) {
            redirect(controller: "person", action:"index")
        } else {
            response = personService.update(response, params)
            if(!response.isSuccess) {
                flash.redirectParams = response.model
                redirect(controller: "person", action: "edit")
            } else {
                redirect(controller: "person", action: "index")
            }
        }
    }


    def delete(Integer id) {
        def response = personService.getById(id)
        if(!response) {
            redirect(controller: "person", action: "index")
        } else {
            response = personService.delete(response)
            redirect(cotroller: "person", action: "index")
        }
    }
}
