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
	int oldClientId = Integer.parseInt(request.getAttribute("oldClientId").toString());
	String oldClientName = request.getAttribute("oldClientName").toString();
	ArrayList<Client> list = (ArrayList<Client>) request.getAttribute("list");
	%>
	<form action="updateOrder.do" method="post">
		<input type="number" value="${id}" name="id" hidden="true"> <br />



		<label>Client Name :</label> <select name="client" id="client">
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<%
			if (list.get(i).getClientId() == oldClientId) {
			%>
			<option selected value="<%=oldClientId%>"><%=oldClientName%></option>
			<%
			continue;
			}
			%>
			<option value="<%=list.get(i).getClientId()%>"><%=list.get(i).getClientName()%></option>
			<%
			}
			%>
		</select>
		 <%-- <label>Date :</label> <input type="date" value="${oldDate}"
			name="date"> <br /> --%>
		 <input type="submit" name="save"
			value="Add"> <br />
	</form>
</body>
</html>