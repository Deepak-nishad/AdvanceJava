<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logincheck" method="post">
      Enter uid : <input type="text" name="uid" />
      <br/>
      Enter pwd : <input type="password" name="pwd" />
      <br/>
      <input type="submit" value="LOGIN" />
   </form>
   
     ${cookie.loginerror.value }
    <%--  showing the value of cookie --%>
   
</body>
</html>