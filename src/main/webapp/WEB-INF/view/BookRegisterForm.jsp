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
			ISBN：<input type="text" name="isbn" value="<%=request.getParameter("isbn") %>"><br>
			<p>ジャンル：
			<select name="genre_id">
			<option value="0">指定なし</option>
			<option value="1">アドベンチャー</option>
			<option value="2">ミステリー</option>
			<option value="3">ファンタジー</option>
			</select></p>
			タイトル：<input type="text" name="title" value="<%=request.getParameter("title") %>"><br>
			著者名：<input type="text" name="author" value="<%=request.getParameter("author") %>"><br>
			出版社：<input type="text" name="publisher" value="<%=request.getParameter("publisher") %>"><br>
			<input type="radio" name="new_old" value="true<%=request.getParameter("new_old")%>">新書
			<input type="radio" name="new_old" value="false<%=request.getParameter("new_old")%>">旧書<br>
			書名ヨミ：<input type="text" name="title_kana" value="<%=request.getParameter("title_kana") %>"><br>
			著名ヨミ：<input type="text" name="author_kana" value="<%=request.getParameter("author_kana") %>"><br>
			<input type="submit" value="登録"><br>
			<a href="AdminTOP">戻る</a>
		</form>
	<%	
		} else {
	%>
		<form action="RegisterBookConfirm" method="post">
		<h2>図書登録</h2>
			ISBN：<input type="text" name="isbn"><br>
			<p>ジャンル：
			<select name="genre_id">
			<option value="0">指定なし</option>
			<option value="1">アドベンチャー</option>
			<option value="2">ミステリー</option>
			<option value="3">ファンタジー</option>
			</select></p>
			タイトル：<input type="text" name="title"><br>
			著者名：<input type="text" name="author"><br>
			出版社：<input type="text" name="publisher"><br>
			<input type="radio" name="new_old" value="true">新書
			<input type="radio" name="new_old" value="false">旧書<br>
			書名ヨミ：<input type="text" name="title_kana"><br>
			著名ヨミ：<input type="text" name="author_kana"><br>
			<input type="submit" value="登録"><br>
			<a href="AdminTOP">戻る</a>	
	</form>
	<% } %>
</body>
</html>