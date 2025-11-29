<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1> Welcome ${ currentuser.fname } ${currentuser.lname } </h1>
   
     <p>  Email id : ${currentuser.email }  </p>
     <p>  Contact no : ${ requestScope.currentuser.contactno  }</p>
     
       <p>  City : ${currentuser.adress.city } </p>

</body>
</html>