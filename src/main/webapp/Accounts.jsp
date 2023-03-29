<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<BankAccount> list=(List<BankAccount>)request.getAttribute("list"); 
if(list.isEmpty())
{
%>
<h1>No Active Accounts Found</h1>
<%}else{ %>
<h1>Select Bank Account</h1>
<%for(BankAccount account:list){ %>
<a href="setaccount?acno=<%=account.getAcno()%>"><button><%=account.getAcno()%></button></a><br><br>
<% }%>
<%} %>
<br>

<a href="CustomerHome.html"><button>Back</button></a>
</body>
</html>