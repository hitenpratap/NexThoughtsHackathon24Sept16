package com.issue.tracker.label

import com.issue.tracker.AppUtil
import com.issue.tracker.Project.Project
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN", "ROLE_MEMBER"])
class LabelController {

    def index() {
        Project project = Project.get(1)
        List<Label> labelList = Label.list([order: 'desc'])
        render(view: 'index', model: [labelList: labelList, project: project])
    }

    def create() {
        render(view: 'create')
    }

    def edit() {
        render(view: 'edit')

    }

    def save() {
        Project project = Project.get(1)
        Label label = new Label(name: params.name, project: project)
        AppUtil.save(label)
        redirect(view: 'index')
    }

    def updateLabel() {
        Label label = Label.findByUuid(params.uuid as String)
        label.name = params.name
        AppUtil.save(label)
        redirect(view: 'index')
    }

    def deleteLabel() {

    }
}
