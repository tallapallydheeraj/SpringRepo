<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

</head>
<body>
	<h1>Billing - ${cust.customerEmailId }!!!</h1>
	<p>Billing details...</p>
	<div class='container'>
	<table class='table'>
		<tr>
			<th>Invoice No:</th>
			<th>Date</th>
			<th>Item</th>
			<th>Quantity</th>
			<th>Invoice Amount:</th>
		</tr>
		<c:forEach items="${invoices }" var="inv">
			<tr>
				<td>${inv.invno }</td>
				<td>${inv.date }</td>
				<td>${inv.product.pname }</td>
				<td>${inv.qty }</td>
				<td>${inv.invoiceamount }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div>
		<a href='logout'>Logout</a>
	</div>

</body>
</html>
