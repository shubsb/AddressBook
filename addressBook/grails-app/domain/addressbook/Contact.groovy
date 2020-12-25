package addressbook

class Contact {

    String fName
    String lName
    String address
    String city
    String postalCode

    Set<ContactDetails> contactDetails

    static constraints = {
        fName nullable:false, unique: true, blank: false
        lName nullable:false, unique: true, blank: false
        address nullable:false, unique: true, blank: false
        city nullable:false, unique: true, blank: false
        postalCode  nullable:false, unique: true, blank: false
    }

    static hasMany = [contactDetails: ContactDetails]

    static mapping = {
        version(false)
        contactDetails cascade: 'all-delete-orphan'
    }
}
