<%@page import="java.util.ArrayList"%>
<%@page import="fstt.org.market.entities.Orderline"%>
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
	ArrayList<Orderline> list = (ArrayList<Orderline>) request.getAttribute("list");
	%>

	<table>
		<thead>
			<tr>
				<th>Id</th>

				<th>Quantity</th>

				<th>Product Name</th>

				<th>Order Id</th>

				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>

				<td><%=list.get(i).getOrderlineId()%></td>
				<td><%=list.get(i).getOrderlineQuantity()%></td>
				<td><%=list.get(i).getOrderlineProduct().getProductName()%></td>
				<td><%=list.get(i).getOrderlineOrder().getOrderId()%></td>
				<td><a href="deleteOrderline.do?id=<%=list.get(i).getOrderlineId()%>">
						delete </a></td>
				<td><a href="updateOrderline.do?id=<%=list.get(i).getOrderlineId()%>">
						update </a></td>

			</tr>

			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>