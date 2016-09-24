<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="front"/>
</head>

<body>
<div class="col-lg-offset-3">
    <h2>Login to get started</h2>

    <form name="loginForm" action="${createLink(uri: '/j_spring_security_check')}"
          method="post">
        <div class="col-lg-8">
            <div class="form-group label-floating">
                <label class="control-label">Email Address</label>
                <input type="email" name="j_username" class="form-control">
            </div>
        </div>

        <div class="col-lg-8">
            <div class="form-group label-floating">
                <label class="control-label">Password</label>
                <input type="password" name="j_password" class="form-control">
            </div>
        </div>

        <div class="col-lg-8">
            <input class="btn btn-primary" value="Submit" type="submit">
        </div>
    </form>
</div>
</body>
</html>