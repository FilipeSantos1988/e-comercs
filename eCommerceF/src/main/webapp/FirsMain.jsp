<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<figure>
			<!-- <img src="${pageContext.request.contextPath}/img/product1.jpg">-->

			<h1>Onde gasta, e ainda sai com um sorriso</h1>
			<form method="post" action="OptionMain">
				<button name="button" type="submit" value="1">all products</button>
				<button name="button" type="submit" value="2">category</button>
				<button name="button" type="submit" value="3">show kart</button>
				<button name="button" type="submit" value="4">buy service</button>
				<button name="button" type="submit" value="4">Contacts</button>
			</form>
		</figure>
	</div>

	<form>


		<img src="img/product1.jpeg">

	</form>


	<img src="img/product1.jpeg">
	<form action="SearchProducts" method="post">
		Tipo artigos: Nome: <input type="text" id="nameProduct"name="nameProduct" /> 
		<input type="submit" value="procurar" />
	</form>

</body>
</html>