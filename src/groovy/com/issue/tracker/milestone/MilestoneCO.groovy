package com.issue.tracker.milestone

import com.issue.tracker.Project.Project
import grails.validation.Validateable

@Validateable
class MilestoneCO {
    String name
    String description
    String dueDate
    static constraints = {
        importFrom Milestone
    }
}