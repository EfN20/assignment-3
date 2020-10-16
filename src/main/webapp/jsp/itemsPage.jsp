<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Berikkali
  Date: 16.10.2020
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
    User signedUser;
%>
<html>
<head>
    <title>Items page</title>
</head>
<body>
    <h1><c:out value="${signedUser.username}" /></h1>
</body>
</html>
