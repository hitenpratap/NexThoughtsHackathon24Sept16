<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<div class="col-lg-offset-1">
    <h2>Create New Task</h2>

    <div class="row">
        <div class="col-lg-8">
            <form method="post" action="${createLink(controller: 'task', action: 'save')}">
                <input type="hidden" name="projectId" value="${project?.uuid}">

                <div class="form-group label-floating col-lg-12 ${hasErrors(bean: taskCO, field: "title", 'has-error')}">
                    <label class="control-label">Title</label>
                    <input type="text" name="title" class="form-control" value="${taskCO?.title}">
                    <helperTG:renderFieldError bean="${taskCO}" field="title"/>
                </div>

                <div class="form-group label-floating col-lg-12 ${hasErrors(bean: taskCO, field: "description", 'has-error')}">
                    <label class="control-label">Description</label>
                    <textarea name="description" rows="6" class="form-control">${taskCO?.description}</textarea>
                    <helperTG:renderFieldError bean="${taskCO}" field="description"/>
                </div>

                <div class="form-group label-floating col-lg-6 ${hasErrors(bean: taskCO, field: "assignee", 'has-error')}">
                    <label class="control-label">Assignee</label>
                    <g:select name="assignee" from="${memberList}" optionKey="uuid" optionValue="memberName"
                              class="form-control" noSelection="['': 'Select a member']" value="${taskCO?.assignee}"/>
                    <helperTG:renderFieldError bean="${taskCO}" field="assignee"/>
                </div>

                <div class="form-group label-floating col-lg-6">
                    <label class="control-label">Attachment</label>
                    <input type="file" name="attachment" class="form-control"/>
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