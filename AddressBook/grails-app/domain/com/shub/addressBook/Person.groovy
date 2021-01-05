package com.shub.addressBook

class Person {

    String firstName
    String lastName
    String address
    String city
    String postalCode
    String personType = GlobalConfig.USER_TYPE.REGULAR_PERSON

    static constraints = {
        firstName(blank: false, nullable: false)
        lastName(blank: false, nullable: false)
        address(blank: false, nullable: false)
        city(blank: false, nullable: false)
        postalCode(blank: false, nullable: false)
    }
}
