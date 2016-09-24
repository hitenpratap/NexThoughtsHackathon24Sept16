package com.issue.tracker.milestone

import com.issue.tracker.AppUtil
import com.issue.tracker.Project.Project
import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

@Secured(['ROLE_MEMBER'])
class MilestoneController {

    def list = {
        Project project = Project.list().first()
        List<Milestone> milestoneList = Milestone.findAllByProject(project)
        [milestoneList: milestoneList]
    }

    def create = {}

    def save = { MilestoneCO milestoneCO ->
        if (milestoneCO.validate()) {
            Project project = Project.list().first()
            if (Milestone.countByNameAndProject(milestoneCO.name, project) >= 1) {
                flash.error = "Milestone already exists with name(${milestoneCO.name})."
                redirect(action: 'create')
            } else {
                Milestone milestone = new Milestone(milestoneCO, project)
                if (milestoneCO.dueDate) {
                    milestone.dueDate = AppUtil.customDateFormat("MM/dd/yyyy", milestoneCO.dueDate)
                }
                AppUtil.save(milestone)
                flash.success = "Milestone created successfully."
                redirect(action: 'create')
            }
        } else {
            flash.error = milestoneCO.errors
            render(view: '/milestone/create', model: [milestoneCO: milestoneCO])
        }
    }
}
