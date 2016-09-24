package com.issue.tracker.admin

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_MEMBER'])
class AdminController {

    def index = {}

}
