package com.issue.tracker.authentication

import grails.plugin.springsecurity.annotation.Secured

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class AuthenticationController {

    def springSecurityService

    def login = {
        render(view: '/login/auth')
    }

    def resolveTargetUrl = {
        log.info("**************************************")
        def roles = (springSecurityService.currentUser)?.authorities
        Role memberRole = Role.findByAuthority("ROLE_MEMBER")
        Role adminRole = Role.findByAuthority("ROLE_ADMIN")
        if (memberRole in roles)
            redirect(controller: 'dashboard', action: 'index')
        else if (adminRole in roles)
            redirect(controller: 'admin', action: 'index')
        else
            redirect(controller: 'public', action: 'index')
    }

}
