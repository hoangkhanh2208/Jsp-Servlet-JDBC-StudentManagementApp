<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Edit Student</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Edit Student</h3>

	<p style="color: red;">${errorString}</p>

	<c:if test="${not empty student }">
		<form method="POST"
			action="${pageContext.request.contextPath}/editStudent">
			<input type="hidden" name="id" value="${student.id}" />
			<table border="0">
				<tr>
					<td>Id</td>
					<td style="color: red;">${student.id}</td>
				</tr>
				<tr>
					<td>Full Name</td>
					 <td><input type="text" name="fullName" value="${student.fullName}" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" value="${student.age}" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" value="${student.address}" /></td>
				</tr>
				<tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/studentList">Cancel</a>
                  </td>
               </tr>
			</table>
		</form>
	</c:if>

	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>