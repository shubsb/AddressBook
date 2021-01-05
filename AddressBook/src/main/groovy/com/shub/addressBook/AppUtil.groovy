package com.shub.addressBook

import org.grails.web.util.WebUtils

// AppUtil class is used for save response, app sessions and info messages
class AppUtil {

    // saveResponse checks if it's a successful or not
    static saveResponse(Boolean isSuccess, def model) {
        return [isSuccess: isSuccess, model: model]
    }

    static getAppSession() {
        return WebUtils.retrieveGrailsWebRequest().session
    }

    // Used for display messages
    static infoMessage(String message, boolean status = true) {
        return [info: message, success: status]
    }
}
