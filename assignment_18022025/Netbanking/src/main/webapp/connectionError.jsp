<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Error Page</title>
	</head>
	<body>
		<h2>${msg}</h2>
		<hr>
		<% 
			String errCodeStr = (String) request.getAttribute("errCode");
			int errCode = (errCodeStr != null) ? Integer.parseInt(errCodeStr) : -1;
			
			if (errCode == 1) { 
		%>
         	<%@ include file="login.html" %>
	    <% } else if (errCode == 2) { %> 
         	<%@ include file="register.html" %>	      		
	    <% } else { %>
	         <h3>Try Again Later..</h3>
	         <a href="/">Home</a>
	    <% } %>

	</body>
</html>
