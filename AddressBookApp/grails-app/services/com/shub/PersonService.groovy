package com.shub

import grails.gorm.services.Service

/**
 * PersonService perfroms the functions that were created in PersonController
 *
 */

@Service(Person)
interface PersonService {

    // gets the id for each person
    Person get(Serializable id)

    // generates a list
    List<Person> list(Map args)

    // counte the amout of people in the list
    Long count()

    // used to delete id and information related to the id
    void delete(Serializable id)

    // saves information to the list and to the database
    Person save(Person person)

}
