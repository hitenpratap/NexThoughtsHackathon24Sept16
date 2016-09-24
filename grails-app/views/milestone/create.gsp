<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front">
</head>

<body>
<div class="container">

    <div class="col-lg-offset-1">
        <h2>Create New Milestone</h2>

        <div class="row">
            <div class="col-lg-12">
                <form method="post" action="${createLink(controller: 'milestone', action: 'save')}">
                    <div class="col-lg-8">
                        <div class="form-group label-floating col-lg-12 ${hasErrors(bean: milestoneCO, field: "name", 'has-error')}">
                            <label class="control-label">Title</label>
                            <input type="text" name="name" class="form-control" value="${milestoneCO?.name}">
                            <helperTG:renderFieldError bean="${milestoneCO}" field="name"/>
                        </div>

                        <div class="form-group label-floating col-lg-12 ${hasErrors(bean: milestoneCO, field: "description", 'has-error')}">
                            <label class="control-label">Description</label>
                            <input type="text" name="description" class="form-control"
                                   value="${milestoneCO?.description}">
                            <helperTG:renderFieldError bean="${milestoneCO}" field="description"/>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <h4>Due Date (Optional)</h4>
                        <input class="datepicker form-control" name="dueDate" id="dueDate"
                               type="text"
                               placeholder="Select Date"/>
                    </div>

                    <div class="form-group col-lg-12">
                        <input type="submit" value="Submit" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>