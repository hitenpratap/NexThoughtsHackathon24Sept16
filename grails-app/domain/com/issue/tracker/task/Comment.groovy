package com.issue.tracker.task

import com.issue.tracker.Enums
import com.issue.tracker.Project.ProjectMember

class Comment {

    String commentText
    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT
    ProjectMember member
    Document document

    static belongsTo = [task: Task]

    static mapping = {
        commentText type: 'text'
    }

    static constraints = {
        commentText blank: false, nullable: false
        member nullable: false
        document nullable: true
    }

}
