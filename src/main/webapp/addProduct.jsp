<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveProduct.do" method="post">

		<label>Name :</label> <input type="text" name="name"> <br />

		<label>Description :</label> <input type="text" name="description"> <br />
		<label>Price :</label> <input type="number" name="price"> <br />
		<label>Quantity In Stock :</label> <input type="number" name="quantity"> <br />
		<input type="submit" name="save" value="Add"> <br />
	</form>
</body>
</html>