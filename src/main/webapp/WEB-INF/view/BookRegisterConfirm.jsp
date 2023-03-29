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
	<p style="color:red">この内容で登録しますか。</p>
	<%
		Book book = (Book)session.getAttribute("input_data");
	%>
	<p style="color:black">ジャンル：<%=book.getGenre_id() %></p>
	<p>タイトル:<%=book.getTitle() %><p>
	<p>著者名:<%=book.getAuthor() %></p>
	<p>ISBN:<%=book.getIsbn() %></p>
	<p>出版社:<%=book.getPublisher() %></p>
	<p>新書or旧書:<%=book.getNew_old() %></p>
	<p>書名ヨミ:<%=book.getTitle_kana() %></p>
	<p>著名ヨミ:<%=book.getAuthor_kana() %></p>
	<a href="DeleteBookExecute">登録</a><br>
	<a href="AdminTOP">戻る</a>
</body>
</html>