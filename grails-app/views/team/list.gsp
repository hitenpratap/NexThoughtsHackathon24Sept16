<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<div class="container">
    <h2>Team List
        <a href="${createLink(controller: 'team', action: 'create')}" class="pull-right btn btn-primary">Create Team</a>
    </h2>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Dated</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${teamList}" var="team" status="i">
            <tr>
                <td>${i + 1}</td>
                <td>${team.dateCreated.format("MMM dd, yyyy")}</td>
                <td>${team.name}</td>
                <td><a href="javascript:void(0)"><i class="fa fa-pencil-square-o"></i> Edit</a>&nbsp;|&nbsp;
                    <a href="javascript:void(0)"><i class="fa fa-trash" aria-hidden="true"></i>
                        Delete</a></td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>