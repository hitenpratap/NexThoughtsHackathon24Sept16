package com.issue.tracker.team

import grails.validation.Validateable

@Validateable
class TeamCO {

    String name

    static constraints = {
        importFrom Team
    }

}
