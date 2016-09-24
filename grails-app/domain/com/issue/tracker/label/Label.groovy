package com.issue.tracker.label

import com.issue.tracker.Enums
import com.issue.tracker.LabelColor
import com.issue.tracker.Project.Project

class Label {

    String name
    String uuid = UUID.randomUUID().toString()
    LabelColor color = LabelColor.GREEN
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static belongsTo = [project:Project]

    static constraints = {
        name nullable: false, blank: false
        uuid nullable: false, blank: false
    }
}
