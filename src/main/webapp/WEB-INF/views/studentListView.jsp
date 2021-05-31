<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Student List</title>
	<style type="text/css">
		img{
			height: 18px;
			width:18px;
		}
		
	</style>
	
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Student List</h3>
	<p style="color: red;">${errorString}</p>

	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Address</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>

		<c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.fullName}</td>
				<td>${student.age}</td>
				<td>${student.address}</td>
				<td><a href="editStudent?id=${student.id}">Edit</a></td>
				<td><a href="deleteStudent?id=${student.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="insertStudent" >Add Student</a>
	
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>