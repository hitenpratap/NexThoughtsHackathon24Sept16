<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="front"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Label Management</title>
</head>

<body>
<div class="col-lg-8">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Team Members</h3>
        </div>

        <div class="panel-body" id="teamMemberList">
            <table class="table" style="height: 200px;overflow-y: auto;display: inline-block;">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Project</th>
                    <th>Label</th>
                    <th>Color</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${labelList}" var="label" status="${i}">

                    <tr>
                        <td>${i + 1}</td>
                        <td>${project.name}</td>
                        <td>${label.name}</td>
                        <td>${label.color}</td>
                        <td>
                            <button type="button" title="Edit" class="btn btn-success btn-simple btn-xs">
                                <i class="fa fa-edit"></i>
                                <a href="${createLink(controller: 'label', action: 'edit')}">Edit</a>
                            </button>
                            <button type="button" title="Remove" class="btn btn-danger btn-simple btn-xs">
                                <i class="fa fa-times"></i>
                                <a href="${createLink(controller: 'label', action: 'deleteLabel')}">Delete</a>
                            </button>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="col-lg-4">
    <div class="col-lg-7" style="margin-top: 150px;">

        <button type="button" title="" class="btn btn-success btn-simple btn-xs">
            <a href="${createLink(controller: 'label', action: 'create')}"><h3 style="color: red">Add Label</h3></a>

        </button>
        </div>
    </div>

</div>


</div>
</body>
</html>