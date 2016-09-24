package com.issue.tracker

import com.issue.tracker.authentication.Role
import com.issue.tracker.authentication.UserRole
import com.issue.tracker.user.Member
import grails.transaction.Transactional

@Transactional
class BootstrapService {

    def main() {
        createRoles()
        createMembers()
    }

    public void createRoles() {
        if (Role.count < 1) {
            new Role(authority: 'ROLE_ADMIN').save(flush: true)
            new Role(authority: 'ROLE_MEMBER').save(flush: true)
        }
    }

    def createLabels() {
        println "**************creating Labels**************"
    }

    def createMembers() {
        if (Member.count < 1) {
            new File("${AppUtil.staticResourcesDirPath}/Member_Data.csv").eachCsvLine { tokens ->
                log.info("***************   Creating member with email address  ====>>>>>>  ${tokens[3]}")
                Member member = new Member(tokens)
                AppUtil.save(member)
                UserRole.create(member, Role.findByAuthority("ROLE_MEMBER"))
            }
        }
    }

    def createTeam() {
        List<String> names = [""]
    }
}
