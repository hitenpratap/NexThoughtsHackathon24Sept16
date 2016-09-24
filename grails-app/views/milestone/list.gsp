<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<h2>Milestone List
    <a href="${createLink(controller: 'milestone', action: 'create')}"
       class="pull-right btn btn-primary">Create Milestone</a>
</h2>
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Dated</th>
        <th>Due Date</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${milestoneList}" var="milestone" status="i">
        <tr>
            <td>${i + 1}</td>
            <td>${milestone.dateCreated.format("MMM dd, yyyy")}</td>
            <td>
                ${(milestone?.dueDate) ? milestone?.dueDate?.format("MMM dd, yyyy") : "--"}
            </td>
            <td>${milestone.name}</td>
            <td><a href="javascript:void(0)"><i class="fa fa-pencil-square-o"></i> Edit</a>&nbsp;|&nbsp;
                <a href="javascript:void(0)"><i class="fa fa-trash" aria-hidden="true"></i>
                    Delete</a></td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>