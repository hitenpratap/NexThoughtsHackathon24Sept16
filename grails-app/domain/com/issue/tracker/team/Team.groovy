package com.issue.tracker.team

import com.issue.tracker.Enums
import com.issue.tracker.user.Member

class Team {

    String name
    Date dateCreated
    Date lastUpdated
    String uniqueId = UUID.randomUUID().toString()
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static belongsTo = [owner: Member]

    static constraints = {
        name blank: false, nullable: false
    }

    Team() {}

    Team(TeamCO teamCO, Member member) {
        this.name = teamCO.name
        this.owner = member
    }

    String getMemberName() {}

}
