package com.issue.tracker

class HelperTagLib {

    static namespace = "helperTG"

    def renderFieldError = { attrs ->
        def bean = attrs?.bean
        def field = attrs?.field
        out << render(template: '/common/renderFieldError', model: [bean: bean, field: field])
    }

}
