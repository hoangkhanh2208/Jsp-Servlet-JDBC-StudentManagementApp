<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Home Page</h3>
	Here is a demo of Simple Student Management Web Application using jsp, servlet and; Jdbc.<br><br>
	<b>It includes the following functions:</b>
      <ul>
         <li>Login</li>
         <li>Storing user information in cookies</li>
         <li>Student List</li>
         <li>Create Student</li>
         <li>Edit Student</li>
         <li>Delete Student</li>
      </ul>
 
     <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>