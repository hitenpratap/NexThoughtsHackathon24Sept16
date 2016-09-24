package com.issue.tracker.team

import com.issue.tracker.user.Member

class TeamMember {

    Member member
    Team team

    static constraints = {
        member nullable: false
        team nullable: false
    }

}
