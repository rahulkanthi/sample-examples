<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: cyan">

<form action="AddGenie" style="margin-left: 50px;margin-top: 50px;">

<label style="font-size: 25px">Genie Id: </label><input type="text" required name="id" style="margin-left: 100px;font-size: 25px"><br><br>
<label style="font-size: 25px">Genie Name: </label><input type="text" required name="name" style="margin-left: 62px;font-size: 25px"><br><br>
<label style="font-size: 25px">Genie Category: </label><input type="text" required name="category" style="margin-left: 32px;font-size: 25px"><br><br>
<label style="font-size: 25px">Genie Severity: </label><input type="text" required name="severity" style="margin-left: 40px;font-size: 25px"><br><br>
<label style="font-size: 25px">Genie Description: </label><input type="text" required name="description" style="margin-left: 8px;font-size: 25px"><br><br>
<br>
<input type="submit" value="Submit" style="margin-left: 100px;font-size: 25px"> 

</form>

<br><br>

<%
if(request.getAttribute("ans")!=null)
{
	String ans=(String)request.getAttribute("ans");

}


%>

<label style="margin-left: 80px;font-size: 25px"> ${ans}</label>

</body>
</html>