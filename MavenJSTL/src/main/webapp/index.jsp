<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<body>

<h2><%= "Hello World!" %></h2>
<c:set var="msg" value="Welcome to Maven" />
  
   <h1>${msg }</h1>
</body>
</html>
