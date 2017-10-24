<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employees page</h2>
	<table>
	<thead>
	  <tr>
	  <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th> 
    <th>Age</th>
    <th>Length of service</th>
  </tr>
	</thead>
		<tbody>
			<c:forEach items="${employees}" var="employee">
			    <tr>
			        <td><c:out value="${employee.id}"/></td>
			        <td><c:out value="${employee.employeeFirstName}"/></td>
			        <td><c:out value="${employee.employeeLastName}"/></td>  
			        <td><c:out value="${employee.age}"/></td> 
			        <td><c:out value="${employee.lengthOfService}"/></td>     
			    </tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>