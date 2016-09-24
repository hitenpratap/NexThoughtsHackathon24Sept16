<%@ page import="com.issue.tracker.Enums" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<h2>${team?.name}</h2>

<div class="row">
    <div class="col-lg-8">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Team Members</h3>
            </div>

            <div class="panel-body" id="teamMemberList">
                <g:render template="/teamMember/list" model="[teamMemberList: teamMemberList]"/>
            </div>
        </div>
    </div>

    <div class="col-lg-4">
        <h4>Add New Member?</h4>

        <form name="addTeamMember" method="post" id="addTeamMember">
            <input type="hidden" name="teamId" value="${team.uniqueId}"/>

            <div class="form-group label-floating col-lg-12 ${hasErrors(bean: teamCO, field: "name", 'has-error')}">
                <label class="control-label">Email Address</label>
                <input type="text" name="emailAddress" class="form-control" value="${teamCO?.name}">
                <helperTG:renderFieldError bean="${teamCO}" field="name"/>
            </div>

            <div class="form-group label-floating col-lg-12 ${hasErrors(bean: teamCO, field: "name", 'has-error')}">
                <label class="control-label">Access Level</label>
                <g:select name="accessLevel" from="${Enums.MemberAccessLevel}" class="form-control"
                          noSelection="['': 'Select access level']" valueMessagePrefix="team.member.access"/>
                <helperTG:renderFieldError bean="${teamCO}" field="name"/>
            </div>

            <div class="form-group col-lg-12">
                <input type="button" id="teamMemberAddBtn" onclick="submitAddMemberForm()" value="Submit"
                       class="btn btn-primary">
            </div>
        </form>
    </div>
</div>
<script>
    function submitAddMemberForm() {
        $("#teamMemberAddBtn").addClass('disabled');
        $("#teamMemberAddBtn").val('Please Wait...');
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'teamMember',action: 'ax_addNewMember')}",
            data: $("#addTeamMember").serialize()
        }).done(function (data) {
            if (data.result == "SUCCESS") {
                loadTeamMemberTable(data.teamId);
                notifySuccess(data.successMsg);
                $("#addTeamMember").find("input").val("");
                $("#addTeamMember").find("select").val("");
            } else {
                notifyError(data.errorMsg);
            }
            $("#teamMemberAddBtn").val('Submit');
            $("#teamMemberAddBtn").removeClass('disabled');
        });
    }

    function loadTeamMemberTable(teamId) {
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'teamMember',action: 'ax_loadTeamMemberList')}",
            data: {teamId: teamId}
        }).done(function (data) {
            if (data.result == "SUCCESS") {
                $("#teamMemberList").html(data.memberTableData);
            } else {
                notifyError(data.errorMsg);
            }
        });
    }

    function removeTeamMember(teamMemberId) {
        if (confirm("Are you sure?")) {
            $.ajax({
                type: "POST",
                url: "${createLink(controller: 'teamMember',action: 'ax_removeTeamMember')}",
                data: {teamMemberId: teamMemberId}
            }).done(function (data) {
                if (data.result == "SUCCESS") {
                    notifySuccess(data.successMsg);
                    loadTeamMemberTable(data.teamId);
                } else {
                    notifyError(data.errorMsg);
                }
            });
        }
    }
</script>
</body>
</html>