package com.issue.tracker.team

import com.issue.tracker.Enums
import com.issue.tracker.user.Member

class TeamMember {

    Member member
    Team team
    Enums.MemberAccessLevel accessLevel
    Date dateCreated
    Date lastUpdated
    String uniqueId = UUID.randomUUID().toString()
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static constraints = {
        member nullable: false
        team nullable: false
        accessLevel nullable: false
    }

    static transients = ['memberName']

    TeamMember() {}

    TeamMember(Team team, Enums.MemberAccessLevel accessLevel, Member member) {
        this.member = member
        this.team = team
        this.accessLevel = accessLevel
    }

    String getMemberName() {
        member.fullName
    }

}
