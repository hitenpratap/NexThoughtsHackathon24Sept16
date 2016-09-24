package com.issue.tracker

import grails.plugin.springsecurity.annotation.Secured

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class PublicController {

    def index() {}
}
