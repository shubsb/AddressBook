package com.shub

class Person {
  String fName
  String lName
  String address
  String city
  String postalCode


  static constraints = {
      fName nullable:false, unique: true, blank: false
      lName nullable:false, unique: true, blank: false
      address nullable:false, unique: true, blank: false
      city nullable:false, unique: true, blank: false
      postalCode  nullable:false, unique: true, blank: false
  }

  String toString() {
      fName
  }
}
