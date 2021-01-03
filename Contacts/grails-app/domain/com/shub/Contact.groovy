package com.shub

class Contact {

    String firstName
    String lastName
    String address
    String city
    String postalCode

    static constraints = {
      firstName nullable:false, unique: false, blank: false
      lastName nullable:false, unique: false, blank: false
      address nullable:false, unique: false, blank: false
      city nullable:false, unique: false, blank: false
      postalCode  nullable:false, unique: false, blank: false
    }

    String toString() {
      firstName
    }
}
