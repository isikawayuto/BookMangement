<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="color:red">この内容の図書を削除しますか。</p>
	<%
		Book book = (Book)session.getAttribute("input_data");
	%>
	<p style="color:black">ジャンル：<%=book.getGenre_id() %></p><br>
	<p>タイトル:<%=book.getTitle() %><p><br>
	<p>著者名:<%=book.getAuthor() %></p><br>
	<p>ISBN:<%=book.getIsbn() %></p><br>
	<p>出版社:<%=book.getPublisher() %></p><br>
	<p>新書or旧書:<%=book.getNew_old() %></p><br>
	<p>書名ヨミ:<%=book.getTitle_kana() %></p><br>
	<p>著名ヨミ:<%=book.getAuthor_kana() %></p><br>
	<a href="DeleteBookExecute">削除</a>
	<a href="AdminTOP">戻る</a>
</body>
</html>