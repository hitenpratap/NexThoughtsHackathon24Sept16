package com.issue.tracker.milestone

import com.issue.tracker.AppUtil
import com.issue.tracker.Project.Project

class Milestone {
    String name
    String description
    String uuid = UUID.randomUUID().toString()
    Date dueDate
    Date dateCreated
    Date lastUpdated

    static belongsTo = [project: Project]
    static constraints = {
        name nullable: false, blank: false
        description nullable: true, blank: true
        uuid nullable: false, blank: false
        dueDate nullable: true, blank: true
    }

    Milestone() {}

    Milestone(MilestoneCO milestoneCO, Project project) {
        this.name = milestoneCO.name
        this?.description = milestoneCO?.description
        this?.dueDate = (milestoneCO?.dueDate) ? AppUtil.customDateFormat("MM/dd/yyyy", milestoneCO?.dueDate) : null
        this.project = project
    }
}
