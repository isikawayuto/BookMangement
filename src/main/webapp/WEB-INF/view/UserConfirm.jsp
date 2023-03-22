<%@page import="dto.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<link rel="stylesheet" href="css/UserConfirm.css">
</head>
<body>
	<%
		Account ac = (Account)session.getAttribute("User");
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
		<button type="button" onclick="location.href='UserRegister'" class="button">戻る</button>
		<button type="button" onclick="location.href='UserExecute'" class="button">OK</button>
	</div>
</body>
</html>