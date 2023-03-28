<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
<% List<BankAccount>list=(List<BankAccount>)request.getAttribute("list");%>

<table border="1">
<tr>
<th>Account Number</th>
<th>Account Type</th>
<th>Customer Name</th>
<th>Customer Id</th>
<th>Status</th>
<th>Change Status</th>
</tr>
<%for(BankAccount account:list){%>
	<tr>
	<th><%=account.getAcno() %></th>
	<th><%=account.getType() %></th>
	<th><%=account.getCustomer().getName() %></th>
	<th><%=account.getCustomer().getCust_id() %></th>
	<th><%=account.isStatus() %></th>
	<th> <a href="changestatus?acno=<%=account.getAcno()%>"><button>change</button></a></th>
	</tr>
	<% }%>


</table>
<br><br>
<a href="home.html"><button>Logout</button></a>




</body>
</html>