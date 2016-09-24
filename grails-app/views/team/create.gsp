<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<div class="col-lg-offset-1">
    <h2>Create New Team</h2>

    <div class="row">
        <div class="col-lg-8">
            <form method="post" action="${createLink(controller: 'team', action: 'save')}">
                <div class="form-group label-floating col-lg-12 ${hasErrors(bean: teamCO, field: "name", 'has-error')}">
                    <label class="control-label">Team Name</label>
                    <input type="text" name="name" class="form-control" value="${teamCO?.name}">
                    <helperTG:renderFieldError bean="${teamCO}" field="name"/>
                </div>

                <div class="form-group col-lg-12">
                    <input type="submit" value="Submit" class="btn btn-primary">
                </div>
            </form>
        </div>

        <div class="col-lg-4">
            <h4>What is a team?</h4>

            <p>Teams foster collaboration by allowing multiple Bitbucket users to share an account plan.</p>
            <ul>
                <li>Create team-owned repositories</li>
                <li>Delegate administration</li>
                <li>Send email invitations</li>
                <li>Manage repository access via groups</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>