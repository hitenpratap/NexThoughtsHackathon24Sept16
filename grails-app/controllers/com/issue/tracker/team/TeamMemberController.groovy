package com.issue.tracker.team

import com.issue.tracker.AppUtil
import com.issue.tracker.Enums
import com.issue.tracker.user.Member
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_MEMBER'])
class TeamMemberController {

    def ax_addNewMember = { TeamMemberCO teamMemberCO ->
        def result = [:]
        if (teamMemberCO.validate()) {
            Team team = Team.findByUniqueId(params.teamId)
            if (team) {
                Member member = Member.findByUsername(teamMemberCO.emailAddress)
                if (member) {
                    TeamMember teamMember = new TeamMember(team, Enums.MemberAccessLevel.valueOf(teamMemberCO.accessLevel), member)
                    AppUtil.save(teamMember)
                    result.result = "SUCCESS"
                    result.teamId = "${team.uniqueId}"
                    result.successMsg = "Member has been added to team successfully."
                } else {
                    result.errorMsg = "Member with given email address not found."
                }
            } else {
                result.errorMsg = "Something went wrong. Please try again."
            }
        } else {
            result.errorMsg = "Something went wrong. Please try again."
        }
        render result as JSON
    }

    def ax_loadTeamMemberList = {
        def result = [:]
        Team team = Team.findByUniqueId(params.teamId)
        if (team) {
            List<TeamMember> teamMemberList = TeamMember.createCriteria().list {
                eq('team', team)
            }
            result.result = "SUCCESS"
            result.memberTableData = g.render(template: '/teamMember/list', model: [teamMemberList: teamMemberList])
        } else {
            result.errorMsg = "Something went wrong. Please try again."
        }
        render result as JSON
    }

}
