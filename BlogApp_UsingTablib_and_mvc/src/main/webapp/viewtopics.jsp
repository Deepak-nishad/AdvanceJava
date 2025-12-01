<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<c:forEach var="topic" items="${tlist }">
     	<a href="getcomments?topicid=${topic.topicid }" title="${topic.tdesc }"> ${topic.tname } </a> <span> ${topic.tdesc} </span>
     	<br/>
     </c:forEach>



</body>
</html>