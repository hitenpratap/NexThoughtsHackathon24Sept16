package com.issue.tracker.label

import com.issue.tracker.LabelColor

class Label {

    String name
    String uuid = UUID.randomUUID().toString()
    LabelColor color = LabelColor.GREEN
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name nullable: false, blank: false
        uuid nullable: false, blank: false
    }
}
