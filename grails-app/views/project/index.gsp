<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="front"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Project Management</title>
</head>

<body>
<h2>Project List
    <a href="${createLink(controller: 'project', action: 'create')}"
       class="pull-right btn btn-primary">Create Project</a>
</h2>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Projects</h3>
    </div>

    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Dated</th>
                <th>Name</th>
                <th>Issue(s)</th>
                <th>Member(s)</th>
                <th>Team(s)</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${projectList}" var="project" status="i">

                <tr>
                    <td>${i + 1}</td>
                    <td>${project.dateCreated.format("MMM dd, yyyy")}</td>
                    <td>${project.name}</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td><a href="${createLink(controller: 'project', action: 'view', params: [projectId: project.uuid])}"><i
                            class="fa fa-eye"></i> View</a>&nbsp;|&nbsp;<a
                            href="${createLink(controller: 'project', action: 'edit')}"><i
                                class="fa fa-pencil-square-o"></i> Edit</a>&nbsp;|&nbsp;
                        <a href="${createLink(controller: 'project', action: 'delete')}"><i
                                class="fa fa-trash"></i> Delete</a>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>