package com.issue.tracker.user

import com.issue.tracker.authentication.User
import com.issue.tracker.team.Team

class Member extends User {

    String firstName
    String lastName
    String phoneNumber
    String skypeName

    static hasMany = [teams: Team]

    static constraints = {
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
        phoneNumber blank: false, nullable: false
        skypeName blank: true, nullable: true
    }

}
