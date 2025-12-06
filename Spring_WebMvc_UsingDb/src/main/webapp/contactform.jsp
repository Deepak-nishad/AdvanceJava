<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Contact form</h1>
<f:form action="insertContact" modelAttribute="ct">
       Enter uid : <f:input path="uid"/>
        <br/>
        Enter password : <f:input path="password"/>
        <br/>
        Enter fname : <f:input path="fname"/>
        <br/>
        Enter lname : <f:input path="lname"/>
        <br/>
        Enter email  : <f:input path="email"/>
        <br/>
        Enter contact no  : <f:input path="contactno"/>
            
        <br/>
        <input type="submit" value="Create Contact" />

</f:form>
</body>
</html>