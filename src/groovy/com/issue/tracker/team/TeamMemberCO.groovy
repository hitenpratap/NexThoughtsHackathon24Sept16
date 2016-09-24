package com.issue.tracker.team

import grails.validation.Validateable

@Validateable
class TeamMemberCO {

    String emailAddress
    String accessLevel

    static constraints = {
        emailAddress blank: false, nullable: false
        accessLevel blank: false, nullable: false
    }

}
