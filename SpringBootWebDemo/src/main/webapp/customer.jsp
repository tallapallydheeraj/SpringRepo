<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	padding:20px;
	width:70%;
	margin:auto;
	background-color: aqua;
	color:black;
}

</style>
</head>
<body>
	<h1>Customer Dashboard </h1>
	<%
	System.out.println(request.getAttribute("customer"));
	
	%>
	<div>
		<p>name : ${cust.customerName }</p>
		<p>Address : ${cust.customerAddress }</p>
		<p>Annual Income : ${cust.annualIncome }</p>
		
	</div>	
	
	<div><a href='invoice'>Invoices</a></div>
	<div><a href='logout'>Logout</a></div>
	
</body>
</html>	