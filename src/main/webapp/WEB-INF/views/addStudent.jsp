<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Add Student</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
	<h3>Add Student</h3>
	
	<p style="color: red;">${errorString}</p>
	
	<form method="POST" action="${pageContext.request.contextPath}/insertStudent">
		<table border="0">
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
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="studentList">Cancel</a>
               </td>
            </tr>
		</table>
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>