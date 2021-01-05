package com.shub.addressBook

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap


class PersonService {

    def getById(Serializable id) {
        return Person.get(id)
    }

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
