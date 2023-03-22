<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者認証</title>
<link rel="stylesheet" href="css/Certification.css">
</head>
<body>
<h1 class="title">管理者認証</h1>
	<div class="form">
		<form action="AdminRegister" method="post">
			<h3>管理者コード  <input type="password" name="AdminCode"></h3>
			<div class="submit">
				<input type="submit" value="認証" class="button">
			</div>
		</form>
	</div>
</body>
</html>