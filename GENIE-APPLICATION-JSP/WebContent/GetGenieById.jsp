<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.GenieDao,model.Genie,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: cyan">

<form action="GetGenieById" >

<label style="font-size: 25px;margin-top: 50px" >Enter the ID: </label><input type="text" required name="id" style="font-size: 25px;margin-top: 50px"><br>
<br><br>
<input type="submit" value="submit" style="font-size: 25px"><br><br>

</form>


<%
Genie genie = (Genie) request.getAttribute("genies");

%>



<table border=""  width="90%" style="text-align: center;">
		<tr >
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Severity</th>
			<th>Description</th>
			
			
		</tr>
 
			
			<tr>
				<td>${genie.getId()}</td>
				<td>${genie.getName()}</td>
				<td>${genie.getCategory()}</td>
				<td>${genie.getSeverity()}</td>
				<td>${genie.getDescription()}</td>

 				
			</tr>
	 

	</table>



</body>


</html>