<%@page import="dao.GenieDao,model.Genie,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: cyan">


	<%
		List<Genie> genies = (List<Genie>) request.getAttribute("genies");

		/* for (int i = 0; i < genie.size(); i++) {
			out.println("Id: " + genie.get(i).getId() + "<br>");
			out.println("Name: " + genie.get(i).getName() + "<br>");
			out.println("Category: " + genie.get(i).getCategory() + "<br>");
			out.println("Severity: " + genie.get(i).getSeverity() + "<br>");
			out.println("Description: " + genie.get(i).getDescription() + "<br>");
			out.println("-------------" + "<br>");
		
		} */
		
// 		out.print(genies);
		
	%>



	
	<table border="" height="300px" width="90%" style="text-align: center;">
		<tr >
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Severity</th>
			<th>Description</th>
			<!-- <th>Edit</th>
			<th>Delete</th> -->
		</tr>

		<c:forEach items="${genies}" var="u">

			<tr>
				<td>${u.getId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getCategory()}</td>
				<td>${u.getSeverity()}</td>
				<td>${u.getDescription()}</td>

 				<%-- <td><a href="UpdateGenieById.jsp?id=${u.getId()}">Edit</a></td>
 				<td><a href="DeleteGenieById.jsp?id=${u.getId()}">Delete</a></td>  --%>
			</tr>

		</c:forEach>
	</table>

</body>
</html>