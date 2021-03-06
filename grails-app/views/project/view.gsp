<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<h2>${project.name}</h2>

<p class="help-block">Last Updated: <helperTG:renderDateFormat date="${project.lastUpdated}"/></p>

<div class="col-lg-12">
    <div class="col-lg-4">
        <a href="${createLink(controller: 'task', action: 'list', params: [projectId: project?.uuid])}"
           class="btn btn-primary btn-block"><i class="fa fa-tasks"></i> Tasks</a>
    </div>

    <div class="col-lg-4">
        <a href="${createLink(controller: 'label',action: 'index',params: [projectId:project.uuid])}" class="btn btn-success btn-block"><i class="fa fa-tags"></i> Labels</a>
    </div>

    <div class="col-lg-4">
        <a href="${createLink(controller: 'milestone', action: 'list', params: [projectId: project.uuid])}"
           class="btn btn-info btn-block"><i class="fa fa-calendar"></i> Milestones</a>
    </div>

    <div class="col-lg-4">
        <a href="${createLink(controller: 'project',action: 'accessManagement',params: [projectId:project.uuid])}" class="btn btn-info btn-block"><i class="fa fa-calendar"></i> Grant Access</a>
    </div>
</div>
</body>
</html>