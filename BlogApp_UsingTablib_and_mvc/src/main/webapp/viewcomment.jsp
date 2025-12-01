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
<h1>hello from view comment</h1>

<c:forEach var="topic" items="${tlist }">
      <span> ${topic.text} </span>
     	<br/>
     </c:forEach>
</body>
</html>