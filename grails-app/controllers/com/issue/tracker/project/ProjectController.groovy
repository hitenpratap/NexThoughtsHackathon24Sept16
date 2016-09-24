package com.issue.tracker.project

import com.issue.tracker.AppUtil
import com.issue.tracker.Project.Project
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_MEMBER"])
class ProjectController {

    def index = {
        List<Project> projectList = Project.list()
        render view: 'index', model: [projectList: projectList]
    }

    def create = {
        render view: 'create'
    }

    def save = {
        Project project = new Project(name: params.name)
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
