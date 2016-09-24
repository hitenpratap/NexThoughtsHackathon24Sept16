package com.issue.tracker.milestone

import com.issue.tracker.Enums
import com.issue.tracker.Project.Project

class Milestone {
    String name
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static belongsTo = [project: Project]
    static constraints = {
        name nullable: false, blank: false
        uuid nullable: false, blank: false
    }

    Milestone() {}

    Milestone(MilestoneCO milestoneCO, Project project) {
        this.name = milestoneCO.name
        this.project = project
    }
}
