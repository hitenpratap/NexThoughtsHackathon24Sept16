package com.issue.tracker.task

import com.issue.tracker.Enums
import com.issue.tracker.Project.Project
import com.issue.tracker.Project.ProjectMember
import com.issue.tracker.label.Label
import com.issue.tracker.milestone.Milestone

class Task {

    String uuid = UUID.randomUUID().toString()
    Date dateCreated
    Date lastUpdated
    Enums.ObjectStatus objectStatus = Enums.ObjectStatus.RECENT
    String title
    String description
    ProjectMember assignee
    Document document
    Label label
    Milestone milestone
    Enums.TaskStatus status = Enums.TaskStatus.OPEN

    static belongsTo = [project: Project]

    static hasMany = [comments: Comment]

    static mapping = {
        description type: 'text'
    }

    static constraints = {
        title blank: false, nullable: false
        description blank: true, nullable: true
        assignee nullable: true
        document nullable: true
        label nullable: true
        milestone nullable: true
    }

    static transients = ['assigneeName']

    Task() {}

    Task(TaskCO taskCO) {
        this.title = taskCO.title
        this.description = taskCO.description
        this.assignee = taskCO.assignee ? ProjectMember.findByUuid(taskCO.assignee) : null
        this.project = Project.findByUuid(taskCO.projectId)
    }

    String getAssigneeName() {
        assignee ? assignee.memberName : null
    }

}
