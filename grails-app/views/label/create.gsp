<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="front"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Label Management</title>
</head>

<body>
<g:form controller="label" action="save">
    <input type="text" name="name" placeholder="name of label">

    <g:submitButton name="Submit"/>
</g:form>
</body>
</html>