package com.issue.tracker.project

import com.issue.tracker.AppUtil
import com.issue.tracker.Enums
import com.issue.tracker.Project.Project
import com.issue.tracker.Project.ProjectMember
import com.issue.tracker.user.Member
import grails.plugin.springsecurity.annotation.Secured
import com.issue.tracker.user.Member

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

    def accessManagement() {
        println "------------------------------------->>>>${params.projectId}"

        Project project = Project.findByUuid(params.projectId as String)
        println "------------------------------------->>>>${project}"

        List<ProjectMember> projectMemberList = ProjectMember.findAllByProject(project)
        render view: 'projectAccessManagement', model: [project: project, projectMemberList: projectMemberList]
    }

    def grantAccess() {

        Member member = Member.findByUsername(params.username)
        Project project = Project.findByUuid(params.projectId )

        if (member && project) {
            String access = params.grantAccess
            Enums.MemberAccessLevel accessLevel = access && StringUtils.isNotBlank(access)?Enums.MemberAccessLevel.valueOf(access):Enums.MemberAccessLevel.WRITE
            ProjectMember projectMember = new ProjectMember(member: member, accessLevel: accessLevel,project: project)
            AppUtil.save(projectMember)
            flash.message = "Access Granted successfully !"
        } else {
            flash.message = "OOps Something went wrong !"
        }
        redirect action: 'accessManagement',params: [projectId:project.uuid]
    }
}
