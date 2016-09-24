package com.issue.tracker.Project

import com.issue.tracker.Enums
import com.issue.tracker.label.Label

class Project {

    String name
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static hasMany = [labels: Label]

    static constraints = {
        name nullable: false, blank: false
        uuid nullable: false, blank: false
    }
}
