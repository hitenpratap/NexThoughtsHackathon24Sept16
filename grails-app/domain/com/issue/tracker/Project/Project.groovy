package com.issue.tracker.Project

import com.issue.tracker.label.Label
import com.issue.tracker.team.Team

class Project {

    String name
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated

    static hasMany = [labels: Label]

    static constraints = {
        name nullable: false, blank: false
        uuid nullable: false, blank: false
    }
}
