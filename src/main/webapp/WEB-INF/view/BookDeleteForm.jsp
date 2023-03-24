<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
		String error = request.getParameter("error");
		if(error != null){
			
	%>
		<p style="color:red">削除に失敗しました。</p>
		<h2>図書削除</h2>
		<form action="DeleteBookConfirm" method="post">
			ISBN：<input type="text" name="isbn" value="<%=request.getParameter("isbn") %>"><br>
			本ID：<input type="text" name="book_id" value="<%=request.getParameter("book_id") %>"><br>
		<input type="submit" value="確認">
	</form>
		<a href="AdminTOP">戻る</a>
	<%	
		} else {
	%>
	<h2>図書削除</h2>
	<form action="DeleteBookConfirm" method="post">
		ISBN：<input type="text" name="isbn"><br>
		本ID：<input type="text" name="book_id"><br>
		<input type="submit" value="確認">
	</form>
	<a href="AdminTOP">戻る</a>
	<% } %>
</body>
</html>