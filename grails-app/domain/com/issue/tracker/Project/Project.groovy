package com.issue.tracker.Project

import com.issue.tracker.Enums
import com.issue.tracker.label.Label
import com.issue.tracker.milestone.Milestone
import com.issue.tracker.task.Task

class Project {

    String name
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static hasMany = [labels: Label, tasks: Task, milestones: Milestone, contributers: ProjectMember, teams: ProjectTeam]

    static constraints = {
        name nullable: false, blank: false
        uuid nullable: false, blank: false
    }

    static transients = ['taskCount', 'memberCount', 'teamCount']

    Integer getTaskCount() {
        tasks && !tasks.empty ? tasks.size() : 0
    }

    Integer getMemberCount() {
        Integer count = 0
        if (contributers && !contributers.empty) {
            count = contributers.count { contributor ->
                contributor.team == null
            }
        }
        count
    }

    Integer getTeamCount() {
        teams && !teams.empty ? teams.size() : 0
    }
}
