<%@ page import="com.issue.tracker.Enums" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="front"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Access Management</title>
</head>

<body>
<div class="container-fluid" style="height: 1000px;background-color: white ">
    <div class="row" style="height: 130px;">
        <h1 style="background-color: yellow;color: #7b1fa2;text-align: center">My Project</h1>
    </div>

    <div class="row" style="height: 100px;">
        <h1 style="background-color: floralwhite;color: #ec407a;text-align: center">Add Contributors</h1>
    </div>

    <div class="row ">
        <g:form  name="accessProjectForm" controller="project" action="grantAccess">
         <input type="hidden" name="projectId" value="${project.uuid}"/>
            <div class="col-lg-4">
                <div class="form-group">
                    <input type="text"  class="form-control" name="username" placeholder="username . . ."/>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="form-group label-floating">
                    <g:select id="acessControl" class="form-control" name='accessControl'
                              noSelection="${['null': 'Select One...']}"
                              from='${com.issue.tracker.Enums.MemberAccessLevel.values()}'></g:select>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="form-group label-floating has-success">

                </div>
            </div>
            <div class="col-lg-4">
            </div>
            <div class="col-lg-4">
            </div>
            <br><br>
            <div class="col-lg-4">
                <div class="form-group label-floating">
                    <g:submitButton class="form-control" name="Grant Access"/>

                </div>
            </div>


        </g:form>
    </div>
    <br><br>

    <div class="row-fluid">
        <div class="col-lg-3">
        </div>
          <div class="col-lg-6">
              <div class="panel panel-primary">
                  <div class="panel-heading">
                      <h3 class="panel-title">Members in Project</h3>
                  </div>

                  <div class="panel-body">
                      <table class="table">
                          <thead>
                          <tr>
                              <th>#</th>
                              <th>Name</th>
                              <th>Access</th>
                          </tr>
                          </thead>
                          <tbody>
                          <g:each in="${projectMemberList}" var="member" status="i">

                              <tr>
                                  <td>${i + 1}</td>
                                  <td>${member?.member?.fullName}</td>
                                  <td>${member?.accessLevel}</td>
                              </tr>
                          </g:each>
                          </tbody>
                      </table>
                  </div>

              </div>
        <div class="col-lg-3">
        </div>
    </div>

</div>
</body>
</html>