<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<h2>Task List
    <a href="${createLink(controller: 'task', action: 'create', params: [projectId: project?.uuid])}"
       class="pull-right btn btn-primary">Create New Task</a>
</h2>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Projects</h3>
    </div>

    <div class="panel-body">
        <g:if test="${taskList && !taskList.empty}">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Dated</th>
                    <th>Title</th>
                    <th>Assignee</th>
                    <th>Label</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${taskList}" var="task" status="i">
                    <tr>
                        <td>${i + 1}</td>
                        <td>${task.dateCreated.format("MMM dd, yyyy")}</td>
                        <td>${task.title}</td>
                        <td>${task.assigneeName}</td>
                        <td>${task.label ?: 'NA'}</td>
                        <td><a href="${createLink(controller: 'task', action: 'view', params: [taskId: task?.uuid])}"><i
                                class="fa fa-eye"></i> View
                        </a>&nbsp;|&nbsp;
                            <a href="javascript:void(0)"><i class="fa fa-pencil-square-o"></i> Edit</a>&nbsp;|&nbsp;
                            <a href="javascript:void(0)"><i class="fa fa-trash" aria-hidden="true"></i>
                                Delete</a></td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            <div class="alert alert-danger text-center">
                No tasks are created yet. Please create one to get started.
            </div>
        </g:else>
    </div>
</div>
</body>
</html>