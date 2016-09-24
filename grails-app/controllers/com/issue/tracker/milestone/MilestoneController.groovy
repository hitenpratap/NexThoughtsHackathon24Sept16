package com.issue.tracker.milestone

import com.issue.tracker.AppUtil
import com.issue.tracker.Project.Project
import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

@Secured(['ROLE_MEMBER'])
class MilestoneController {

    def list = {
        Project project = Project.findByUuid(params.projectId)
        List<Milestone> milestoneList = Milestone.findAllByProject(project)
        [milestoneList: milestoneList, project: project]
    }

    def create = {
        Project project = Project.findByUuid(params.projectId)
        [project: project]
    }

    def save = { MilestoneCO milestoneCO ->
        Project project = Project.findByUuid(params.projectId)
        if (milestoneCO.validate()) {
            if (Milestone.countByNameAndProject(milestoneCO.name, project) >= 1) {
                flash.error = "Milestone already exists with name(${milestoneCO.name})."
                redirect(action: 'create', params: [projectId: project.uuid])
            } else {
                Milestone milestone = new Milestone(milestoneCO, project)
                if (milestoneCO.dueDate) {
                    milestone.dueDate = AppUtil.customDateFormat("MM/dd/yyyy", milestoneCO.dueDate)
                }
                AppUtil.save(milestone)
                flash.success = "Milestone created successfully."
                redirect(action: 'create', params: [projectId: project.uuid])
            }
        } else {
            flash.error = milestoneCO.errors
            render(view: '/milestone/create', model: [milestoneCO: milestoneCO, projectId: project.uuid])
        }
    }
}
