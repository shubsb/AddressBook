package addressbook

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class UserService {

    def save(GrailsParameterMap params) {
        Contact contact = new Contact(params)
    }
}
