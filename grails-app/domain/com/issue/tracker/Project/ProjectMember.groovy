package com.issue.tracker.Project

import com.issue.tracker.Enums
import com.issue.tracker.user.Member

class ProjectMember {

    Member member
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT

    static belongsTo = [project: Project]

    static constraints = {
        member nullable: false
    }

}
