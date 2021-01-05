package com.shub.addressBook

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

/**
 * PersonService performs the functions and the logic
 * which are in PersonController
 *
 */
class PersonService {

    // gets the id for each person
    def getById(Serializable id) {
        return Person.get(id)
    }

    // generates a list based and sorts the list in descending order
    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Person> personList = Person.createCriteria().list(params) {
            if(params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if(!params.sort) {
                order("id", "desc")
            }
        }
        return [list:personList, count:Person.count()]
    }

    // Validates if the person is saved and saves it to the database
    @Transactional
    def save(GrailsParameterMap params) {
        Person person = new Person(params)
        def response = AppUtil.saveResponse(false, person)
        if(person.validate()) {
            person.save(flush: true)
            if (!person.hasErrors()) {
                response.isSuccess = true
            }
        }
        return response
    }

    // Updates the persons information and saves it to the list and the database
    @Transactional
    def update(Person person, GrailsParameterMap params) {
        person.properties = params
        def response = AppUtil.saveResponse(false, person)
        if(person.validate()) {
            person.save(flush: true)
            if (!person.hasErrors()) {
                response.isSuccess = true
            }
        }
        return response
    }

    // deletes the person from the list and the database
    @Transactional
    def delete(Person person) {
        try {
            person.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
}
