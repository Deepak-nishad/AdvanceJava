<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>All contact information</h1>
	<table border="1">
		<c:forEach var="ct" items="${contactlist}">
			<tr>
				<td>${ct.cid }</td>
				<td>${ct.uid }</td>
				<td>${ct.password }</td>
				<td>${ct.fname }</td>
				<td>${ct.lname }</td>
				<td>${ct.email }</td>
				<td>${ct.contactno }</td>
			</tr>

		</c:forEach>
		

	</table>

<a href="getContact">Insert Contact</a>
</body>
</html>