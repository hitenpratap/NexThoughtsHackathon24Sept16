package com.issue.tracker.Project

import com.issue.tracker.Enums
import com.issue.tracker.team.Team

class ProjectTeam {

    Team team
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static belongsTo = [project: Project]

    static constraints = {
        team nullable: false
    }

}
