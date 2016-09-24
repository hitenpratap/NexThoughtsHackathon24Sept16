package com.issue.tracker.task

import com.issue.tracker.AppUtil
import com.issue.tracker.Enums
import com.issue.tracker.Project.Project
import com.issue.tracker.Project.ProjectMember
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_MEMBER"])
class TaskController {

    def list = {
        Project project = Project.findByUuid(params.projectId)
        if (project) {
            List<Task> taskList = Task.createCriteria().list {
                eq('project', project)
                eq('status', Enums.TaskStatus.OPEN)
            }
            render(view: '/tasks/list', model: [taskList: taskList, project: project])
        } else {
            flash.error = "Something went wrong. Please try again."
            redirect(controller: 'project', action: 'index')
        }
    }

    def create = {
        Project project = Project.findByUuid(params.projectId)
        if (project) {
            List<ProjectMember> memberList = ProjectMember.createCriteria().list {
                eq('project', project)
            }
            render(view: '/tasks/create', model: [memberList: memberList, project: project])
        } else {
            flash.error = "Something went wrong. Please try again."
            redirect(controller: 'task', action: 'list')
        }
    }

    def save = { TaskCO taskCO ->
        if (taskCO.validate()) {
            Task task = new Task(taskCO)
            AppUtil.save(task)
            flash.success = "Task created successfully."
            redirect(action: 'list', params: [projectId: taskCO.projectId])
        } else {
            render(view: '/tasks/create', model: [taskCO: taskCO])
        }
    }

    def view = {}

    def edit = {}

    def delete = {}

}
