package addressbookapp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(redirect:"/person/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
