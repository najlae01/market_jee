<%@page import="java.util.ArrayList"%>
<%@page import="fstt.org.market.entities.Order"%>
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
	ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list");
	%>

	<table>
		<thead>
			<tr>
				<th>Id</th>

				<th>Date</th>

				<th>Client</th>

				<th>OrderLines</th>

				<th>Delete</th>

				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>

				<td><%=list.get(i).getOrderId()%></td>
				<td><%=list.get(i).getOrderDate()%></td>
				<td><%=list.get(i).getClient().getClientName()%></td>
				<%
				ArrayList<Orderline> ordelines = list.get(i).getOrderlines();
				%>
				<td>
				<%
			for (int j = 0; j < ordelines.size(); j++) {
			%>
				<%=ordelines.get(j).getOrderlineId()%>
			<%
			}
			%>
				</td>
				<td><a href="deleteOrder.do?id=<%=list.get(i).getOrderId()%>">
						delete </a></td>
				<td><a href="updateOrder.do?id=<%=list.get(i).getOrderId()%>">
						update </a></td>

			</tr>

			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>