<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userinfo"  class="models.User" scope="request"/>


<jsp:setProperty property="uid" name="userinfo" param="uid"/>
<jsp:setProperty property="fname" name="userinfo" param="fname"/>
<jsp:setProperty property="lname" name="userinfo" param="lname"/>
<jsp:setProperty property="email" name="userinfo" param="email"/>
<jsp:setProperty property="contactno" name="userinfo" param="contact"/>
<jsp:setProperty property="adress" name="userinfo" param="adress"/>


<jsp:forward page="/displayBean.jsp"></jsp:forward>


</body>
</html>