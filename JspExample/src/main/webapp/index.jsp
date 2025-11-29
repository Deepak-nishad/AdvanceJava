    <%@page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String hours = sdf.format(Calendar.getInstance().getTime());
        int hh = Integer.parseInt(hours);
        if(hh > 6 && hh < 12){  %>
        	   <h1> Good Morning </h1>
        <%}
        else if(hh >= 12 && hh <= 17){ %>
          <h1> Good Afternoon </h1>
        <%}
        else if(hh > 17 && hh <= 20){ %>
          	<h1> Good Evening </h1>
        <%}
        else{ %>
        	 <h1> Good Night </h1>
       <%  }
    
    
    %>


</body>
</html>