<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/BookDeleteForm.css">
</head>
<body>
<% 
		String error = request.getParameter("error");
		if(error != null){
			
	%>
	<div class="error-message">
		<p style="color:red">削除に失敗しました。</p>
	</div>
		<h2 class="title">図書削除</h2>
		<form  class="from-prace" action="DeleteBookConfirm" method="post">
		<table>
			<tr>
				<td id="name">本ID：</td><td><input type="text" id=input-size size="70" name="book_id" value="<%=request.getParameter("book_id") %>"></td>
			</tr>
			<tr>
				<td id="name">ISBN：</td><td><input type="text" id=input-size size="70" name="isbn" value="<%=request.getParameter("isbn") %>"></td>
			</tr>
		</table>
			<input id="button" type="submit" value="確認">
	</form>
		<a href="AdminTOP">戻る</a>
	<%	
		} else {
	%>
		<h2 class="title">図書削除</h2>
	<div>
		<form class="from-prace" action="DeleteBookConfirm" method="post">
		<table>
			<tr class="form-interval">
			 	<td id="name">本ID：</td><td><input type="text" id=input-size size="70" name="book_id"></td>
			</tr>
			<tr class="form-interval">
				<td id="name">ISBN：</td><td><input type="text" id=input-size size="70" name="isbn"></td>
			</tr>
		</table>	
		<input id="button" type="submit" value="確認">
	</form>
	</div>
	<a href="AdminTOP">戻る</a>
	<% } %>
</body>
</html>