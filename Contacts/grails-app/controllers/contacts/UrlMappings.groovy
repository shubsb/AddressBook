package contacts

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(redirect:"/contact/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
