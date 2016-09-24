package com.issue.tracker.member

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_MEMBER'])
class DashboardController {

    def index = {

    }


}
