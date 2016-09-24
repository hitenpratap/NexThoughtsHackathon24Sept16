package com.issue.tracker.project

import com.issue.tracker.AppUtil
import com.issue.tracker.Project.Project
import com.issue.tracker.user.Member
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_MEMBER"])
class ProjectController {

    def springSecurityService

    def index = {
        Member member = springSecurityService.currentUser as Member
        List<Project> projectList = Project.createCriteria().list {
            eq('owner', member)
            order('dateCreated', ORDER_ASCENDING)
        }
        render view: 'index', model: [projectList: projectList]
    }

    def create = {}

    def save = {
        Member member = springSecurityService.currentUser as Member
        Project project = new Project(name: params.name, owner: member)
        AppUtil.save(project)
        redirect action: 'index'
    }

    def view = {
        Project project = Project.findByUuid(params.projectId)
        if (project) {
            render(view: '/project/view', model: [project: project])
        } else {
            flash.error = "Something went wrong. Please try again."
            redirect(action: 'index')
        }
    }

    def delete = {}
}
