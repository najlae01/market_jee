<%@page import="java.util.ArrayList"%>
<%@page import="fstt.org.market.entities.Client"%>
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
	ArrayList<Client> list = (ArrayList<Client>) request.getAttribute("list");
	%>
	<form action="saveOrder.do" method="post">

		<label>Client Name :</label> <select name="client" id="client">
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<option value="<%=list.get(i).getClientId()%>"><%=list.get(i).getClientName()%></option>
			<%
			}
			%>
		</select> <input type="submit" name="save" value="Add"> <br />
	</form>
</body>
</html>