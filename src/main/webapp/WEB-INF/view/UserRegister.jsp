<%@page import="dto.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link rel="stylesheet" href="css/UserRegister.css">
</head>
<body>
	<div class="title-container">
		<button type="button" onclick="location.href='UserLogin'" class="title-button">戻る</button>
		<h1 class="title">登録画面</h1>
	</div>
	<%
		request.setCharacterEncoding("UTF-8");
		String Code = (String)session.getAttribute("Code");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			Users ac = (Users)session.getAttribute("User");
	%>
		<p style="color:red" class="error-message">登録に失敗しました。</p>
		<form action="UserConfirm" method="post">
			<table class="table">
				<tr class="form-interval">
					<td class="form-name"><h3>メール：</h3></td><td><input type="email" name="mail" class="form" value="<%=ac.getMail()%>"></td>
				</tr>
				<tr class="form-interval">
					<td class="form-name"><h3>名前：</h3></td><td><input type="text" name="name" class="form" value="<%=ac.getName()%>"></td>
				</tr>
				<tr class="form-interval">
					<td class="form-name"><h3>パスワード：</h3></td><td><input type="password" name="pw" class="form"></td>
				</tr>
			</table>
				<div class="form-button">
					<input type="submit" value="確認" class="button">
				</div>
		</form>
	<%
		} else {
	%>
		<form action="UserConfirm" method="post">
			<table class="table">
				<tr class="form-interval">
					<td class="form-name"><h3>メール：</h3></td><td><input type="email" name="mail" class="form"></td>
				</tr>
				<tr class="form-interval">
					<td class="form-name"><h3>名前：</h3></td><td><input type="text" name="name" class="form"></td>
				</tr>
				<tr class="form-interval">
					<td class="form-name"><h3>パスワード：</h3></td><td><input type="password" name="pw" class="form"></td>
				</tr>
			</table>
				<div class="form-button">
					<input type="submit" value="確認" class="button">
				</div>
		</form>
	<%
		}
	%>
</body>
</html>