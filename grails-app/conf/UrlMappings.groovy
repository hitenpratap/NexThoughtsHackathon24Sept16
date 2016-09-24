class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "public", action: "index", method: "GET")

//        "/"(view: "/index")
        "500"(view: '/error')
    }
}
