<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="classes.C_Products"%>
<%@page import="logicLayer.Products"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>procura</title>
</head>
<body>

	<%
	ArrayList<Products> lProducts = (ArrayList<Products>) request.getAttribute("lProducts");
	for (Products p : lProducts) {
	%>


	<figure>
		<!-- <img src="${pageContext.request.contextPath}/img/product1.jpg">-->



		<form method="post" action="AddProduct">
			<img src=<%=p.getProductImg()%>>
			<%=p.getPrice_vl()%>
			<button name="add" type="submit" value=<%= p.getProduct_id()%>>add
				kart</button>
		</form>
		<h1><%=p.getProduct_ds()%></h1>
	</figure>







	<%
	}
	%>

</body>
</html>