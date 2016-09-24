package com.issue.tracker.task

import grails.validation.Validateable

@Validateable
class TaskCO {

    String title
    String description
    String assignee
    String projectId

    static constraints = {
        importFrom Task
        assignee blank: true, nullable: true
        projectId blank: false, nullable: false
    }

}
