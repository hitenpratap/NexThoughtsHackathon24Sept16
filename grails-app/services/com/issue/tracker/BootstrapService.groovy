package com.issue.tracker

import com.issue.tracker.Project.Project
import com.issue.tracker.authentication.Role
import com.issue.tracker.authentication.UserRole
import com.issue.tracker.label.Label
import com.issue.tracker.team.Team
import com.issue.tracker.user.Admin
import com.issue.tracker.user.Member
import grails.transaction.Transactional

@Transactional
class BootstrapService {

    def main() {
        createRoles()
        createMembers()
        createAdmin()
        createTeam()
        createProjects()
    }

    public void createRoles() {
        if (Role.count < 1) {
            new Role(authority: 'ROLE_ADMIN').save(flush: true)
            new Role(authority: 'ROLE_MEMBER').save(flush: true)
        }
    }

    def createLabels(Project project) {
        if(Label.count<1){
            List<String> labels = ['Bug', 'Testing', 'Development', 'Tested', 'Minor', 'Major']
            labels.each { label ->
                println "**************creating Labels******${label}********"
                AppUtil.save(new Label(name: label, project: project))
            }
        }
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

    def createProjects() {
        if(Project.count<1){
            List<String> projects = ['P2PLending', 'Fin360', 'PayTM', 'Amazon', 'DigitalIndia', 'SherKhan', 'Flipkart']
            projects.each { name ->
                println "************** creating projects ******${name}********"
                Project project = new Project(name: name)
                AppUtil.save(project)
                createLabels(project)
            }
        }
    }

    def createAdmin() {
        (0..4).each { num ->
            if (Admin.count < 1) {
                Admin admin = new Admin(num)
                AppUtil.save(admin)
                UserRole.create(admin, Role.findByAuthority("ROLE_ADMIN"))
            }
        }
    }

    def createTeam() {
        if (Team.count < 1) {
            new File("${AppUtil.staticResourcesDirPath}/Team_Data.csv").eachCsvLine { tokens ->
                log.info("***************   Creating Team with name  ====>>>>>>  ${tokens[0]}")
                Team team = new Team(tokens)
                AppUtil.save(team)
            }
        }
    }
}
