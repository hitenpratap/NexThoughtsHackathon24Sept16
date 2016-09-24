package com.issue.tracker.team

import com.issue.tracker.user.Member
import org.apache.commons.lang.RandomStringUtils

class Team {

    String name
    Date dateCreated
    Date lastUpdated
    String uniqueId = UUID.randomUUID().toString()

    static belongsTo = [owner: Member]

    static constraints = {
        name blank: false, nullable: false
    }

    Team() {}

    Team(def tokens) {
        this.name = tokens[0]
        Long memberId = Long.parseLong(RandomStringUtils.randomNumeric(1))
        this.owner = Member.get(memberId == 0 ? 1 : memberId)
    }

}
