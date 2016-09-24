package com.issue.tracker.team

import com.issue.tracker.AppUtil
import com.issue.tracker.Enums
import com.issue.tracker.user.Member
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_MEMBER'])
class TeamController {

    def springSecurityService

    def list = {
        Member member = springSecurityService.currentUser as Member
        List<Team> teamList = Team.createCriteria().list {
            eq('owner', member)
        }
        [teamList: teamList]
    }

    def create = {}

    def save = { TeamCO teamCO ->
        if (teamCO.validate()) {
            Member member = springSecurityService.currentUser as Member
            if (Team.countByNameAndOwner(teamCO.name, member) >= 1) {
                flash.error = "Another team already preset with name(${teamCO.name})."
                redirect(action: 'create')
            } else {
                Team team = new Team(teamCO, member)
                AppUtil.save(team)
                TeamMember teamMember = new TeamMember(team, Enums.MemberAccessLevel.ADMIN, member)
                AppUtil.save(teamMember)
                flash.success = "Team created successfully."
                redirect(action: 'list')
            }
        } else {
            render(view: '/team/create', model: [teamCO: teamCO])
        }
    }

}
