<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="front"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Project Management</title>
</head>

<body>
<g:form controller="project" action="save">
    <input type="text" name="name" placeholder="name of project">
    <g:submitButton name="Submit"/>
</g:form>
</body>
</html>