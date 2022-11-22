<%@page import="java.util.ArrayList"%>
<%@page import="fstt.org.market.entities.Client"%>
<%@page import="java.util.ListIterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Management</title>
</head>
<body>
	<%
	ArrayList<Client> list = (ArrayList<Client>) request.getAttribute("list");
	%>

	<table>
		<thead>
			<tr>
				<th>Id</th>

				<th>Name</th>

				<th>Address</th>

				<th>Phone</th>

				<th>City</th>

				<th>Delete</th>

				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>

				<td><%=list.get(i).getClientId()%></td>
				<td><%=list.get(i).getClientName()%></td>
				<td><%=list.get(i).getClientAddress()%></td>
				<td><%=list.get(i).getClientPhone()%></td>
				<td><%=list.get(i).getClientCity()%></td>
				<td><a href="deleteClient.do?id=<%=list.get(i).getClientId()%>">
						delete </a></td>
				<td><a href="updateClient.do?id=<%=list.get(i).getClientId()%>">
						update </a></td>

			</tr>

			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>