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
		<p style="color:red">登録に失敗しました。</p>
		<h2>図書登録</h2>
		<form action="RegisterBookConfirm" method="post">
			ジャンル：<input type="text" name="genre_id" value="<%=request.getParameter("genre_id") %>"><br>
			タイトル：<input type="text" name="title" value="<%=request.getParameter("title") %>"><br>
			著者名：<input type="text" name="author" value="<%=request.getParameter("author") %>"><br>
			ISBN：<input type="text" name="isbn" value="<%=request.getParameter("isbn") %>"><br>
			出版社：<input type="text" name="publisher" value="<%=request.getParameter("publisher") %>"><br>
			<input type="radio" name="new_old" value="0<%=request.getParameter("new_old")%>">新書
			<input type="radio" name="new_old" value="1<%=request.getParameter("new_old")%>">旧書<br>
			書名ヨミ：<input type="text" name="title_kana" value="<%=request.getParameter("title_kana") %>"><br>
		　　著名ヨミ：<input type="text" name="author_kana" value="<%=request.getParameter("author_kana") %>"><br>
			
			<input type="submit" value="登録">
			<a href="AdminTOP">戻る</a>
		</form>
	<%	
		} else {
	%>
		<form action="RegisterBookConfirm" method="post">
			ジャンル：<input type="text" name="genre_id"><br>
			タイトル：<input type="text" name="title"><br>
			著者名：<input type="text" name="author"><br>
			ISBN：<input type="text" name="isbn"><br>
			出版社：<input type="text" name="publisher"><br>
			<input type="radio" name="new_old">新書
			<input type="radio" name="new_old">旧書<br>
			書名ヨミ：<input type="text" name="title_kana"><br>
		　　著名ヨミ：<input type="text" name="author_kana"><br>
		
			<input type="submit" value="登録">
			<a href="AdminTOP">戻る</a>
	</form>
	<% } %>
</body>
</html>