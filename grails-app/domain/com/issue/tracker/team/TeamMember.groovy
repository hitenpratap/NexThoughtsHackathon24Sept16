package com.issue.tracker.team

import com.issue.tracker.Enums
import com.issue.tracker.user.Member

class TeamMember {

    Member member
    Team team
    Enums.MemberAccessLevel accessLevel

    static constraints = {
        member nullable: false
        team nullable: false
        accessLevel nullable: false
    }

    TeamMember() {}

    TeamMember(Team team, Enums.MemberAccessLevel accessLevel, Member member) {
        this.member = member
        this.team = team
        this.accessLevel = accessLevel
    }

}
