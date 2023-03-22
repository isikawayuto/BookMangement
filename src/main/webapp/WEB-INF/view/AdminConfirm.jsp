<%@page import="dto.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<link rel="stylesheet" href="css/AdminConfirm.css">
</head>
<body>
	<%
		Account ac = (Account)session.getAttribute("Admin");
		String Code = (String)session.getAttribute("Code"); 
	%>
	<h1 class="title">登録確認画面</h1>
	<table>
		<tr class="item-contair">
			<td class="item-name">名前：</td><td class="item"><%=ac.getName() %></td>
		</tr>
		<tr class="item-contair">
			<td class="item-name">メール：</td><td class="item"><%=ac.getMail() %></td>
		</tr>
		<tr class="item-contair">
			<td class="item-name">パスワード：</td><td class="item">********</td>
		<tr>
	</table>
	<div class="button-contair">
		<form action="AdminRegister" method="post">
			<input type="hidden" name="AdminCode" value="12345">
			<input type="submit" value="戻る"  class="button">
		</form>
		<button type="button" onclick="location.href='AdminExecute'" class="button">OK</button>
	</div>
</body>
</html>