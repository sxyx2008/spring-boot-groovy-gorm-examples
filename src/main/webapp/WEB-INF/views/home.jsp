<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/22 0022
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach items="${studentList}" var="student">
    <c:out value="${student.id}"/>
    <c:out value="${student.name}"/>
    <c:out value="${student.age}"/>
    <hr/>
</c:forEach>
</body>
</html>
