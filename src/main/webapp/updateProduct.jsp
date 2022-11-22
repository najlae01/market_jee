<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateProduct.do" method="post">

		<input type="number" value="${id}" name="id" hidden="true"> <br />
		
		<label>Name :</label> <input type="text" value="${oldName}" name="name"> <br />

		<label>Description :</label> <input type="text" value="${oldDescription}" name="description"> <br />
		<label>Price :</label> <input type="number" value="${oldPrice}" name="price"> <br />
		<label>Quantity :</label> <input type="number" value="${oldQuantity}" name="quantity"> <br />
		<input type="submit" name="save" value="Add"> <br />
	</form>
</body>
</html>