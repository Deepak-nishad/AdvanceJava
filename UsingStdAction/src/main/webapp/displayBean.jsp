<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="userinfo" class="models.User" scope="request"/>

FirstName: <jsp:getProperty property="fname" name="userinfo"/>
lasttName: <jsp:getProperty property="lname" name="userinfo"/>

</body>
</html>