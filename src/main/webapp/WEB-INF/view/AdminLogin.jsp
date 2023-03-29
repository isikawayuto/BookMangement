    <%@page import="dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="css/AdminLogin.css">
</head>
<body>
<h1 class="title">管理者ログイン</h1>
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<div class="error-message">
			<h3 style="color:red"><strong>ログイン失敗</strong></h3>
		</div>
		<form class="from-prace" action="AdminTOP" method="post">
			<table>
				<tr>
					<td id="name">メールアドレス：</td><td><input type="text" id=input-size size="50" name="mail"></td>
				</tr>
				<tr>
					<td id="name">パスワード：</td><td><input type="password" id=input-size size="50" name="pw"></td>
				</tr>
			</table>
			<input id="button" type="submit" value="ログイン">
		</form>
		<div class="Register-message">
			<h2><a href="Certification">※登録はこちら</a></h2>
		</div>
	<%
		} else {
	%>
		<div>
			<form class="from-prace" action="AdminTOP" method="post">
				<table>
					<tr class="form-interval">
						<td id="name">メールアドレス：</td><td><input type="text" id=input-size size="50" name="mail"></td>
					</tr>
					<tr class="form-interval">
						<td id="name">パスワード：</td><td><input type="password" id=input-size size="50" name="pw"></td>
					</tr>
				</table>
				<input id="button" type="submit" value="ログイン">
			</form>
		</div>
		<div class="Register-message">
			<h2><a href="Certification">※登録はこちら</a></h2>
		</div>
	<%
		}
	%>
</body>
</html>