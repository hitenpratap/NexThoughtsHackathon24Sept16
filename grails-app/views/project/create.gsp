<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="front"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Project Management</title>
</head>

<body>
<div class="col-md-offset-1">
    <h2>Create New Project</h2>

    <div class="row">
        <div class="col-lg-8">
            <form name="createProjectForm" action="${createLink(controller: 'project', action: 'save')}">
                <div class="form-group label-floating col-lg-12">
                    <label class="control-label">Title</label>
                    <input type="text" name="name" class="form-control" value="${taskCO?.title}" required>
                    <helperTG:renderFieldError bean="${taskCO}" field="title"/>
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