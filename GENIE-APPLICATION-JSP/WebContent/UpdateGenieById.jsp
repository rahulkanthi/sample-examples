<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: cyan">


<form action="UpdateGenieById" style="margin-left: 30px;margin-top: 20px" >

<label style="font-size: 25px">Enter the ID: </label><input type="text" required name="id" style="font-size: 25px;margin-left: 130px"><br><br>
<label style="font-size: 25px">Enter Updated Severity: </label><input type="text" required name="severity" style="font-size: 25px;margin-left: 18px"><br><br>
<input type="submit" value="submit" style="font-size: 25px"><br><br>

</form>

<%

if(request.getAttribute("msg")!=null){
	
	String s=(String)request.getAttribute("msg");
	out.print(s);

}

%>


</body>
</html>