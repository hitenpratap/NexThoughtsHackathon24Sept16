package com.issue.tracker.task

import com.issue.tracker.Enums

class Document {

    String name
    String path
    String contentType
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

}
