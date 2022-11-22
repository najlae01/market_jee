<%@page import="java.util.ArrayList"%>
<%@page import="fstt.org.market.entities.Product"%>
<%@page import="fstt.org.market.entities.Order"%>
<%@page import="java.util.ListIterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
	%>
	<form action="saveOrderline.do" method="post">
		<label>Quantity :</label> <input type="number" name="quantity">
		<br /> <label>Product Name :</label> <select name="product"
			id="product">
			<%
			for (int i = 0; i < products.size(); i++) {
			%>
			<option value="<%=products.get(i).getProductId()%>"><%=products.get(i).getProductName()%></option>
			<%
			}
			%>
		</select> <label>Order Id :</label> <select name="order" id="order">
			<%
			for (int i = 0; i < orders.size(); i++) {
			%>
			<option value="<%=orders.get(i).getOrderId()%>"><%=orders.get(i).getOrderId()%></option>
			<%
			}
			%>
		</select> <input type="submit" name="save" value="Add"> <br />
	</form>
</body>
</html>