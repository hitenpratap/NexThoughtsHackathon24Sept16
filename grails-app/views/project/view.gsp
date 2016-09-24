<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<h2>${project.name}</h2>

<p class="help-block">Last Updated: <helperTG:renderDateFormat date="${project.lastUpdated}"/></p>

<div class="row">
    <div class="col-lg-4">
        <a href="javascript:void(0)" class="btn btn-primary btn-block"><i class="fa fa-tasks"></i> Tasks</a>
    </div>

    <div class="col-lg-4">
        <a href="javascript:void(0)" class="btn btn-success btn-block"><i class="fa fa-tags"></i> Labels</a>
    </div>

    <div class="col-lg-4">
        <a href="javascript:void(0)" class="btn btn-info btn-block"><i class="fa fa-calendar"></i> Milestones</a>
    </div>
</div>
</body>
</html>