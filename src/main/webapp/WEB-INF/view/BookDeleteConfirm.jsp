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
	<%
	request.setCharacterEncoding("UTF-8");
	String isbn = request.getParameter("isbn");
	String genre_id = request.getParameter("genre_id");
	int genre_idStr = Integer.parseInt(genre_id);
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String new_old = request.getParameter("new_old");
	boolean new_oldStr = Boolean.parseBoolean(new_old);
	String title_kana = request.getParameter("title_kana");
	String author_kana = request.getParameter("author_kana");
	%>
	<p style="color:red">この内容の図書を削除しますか。</p>
	<p style="color:black">ISBN:<%=isbn %></p>
	<p>ジャンル：<%=genre_id %></p>
	<p>タイトル:<%=title %><p>
	<p>著者名:<%=author %></p>
	<p>出版社:<%=publisher %></p>
	<p>新書or旧書:<%=new_old %></p>
	<p>書名ヨミ:<%=title_kana %></p>
	<p>著名ヨミ:<%=author_kana %></p>
	<a href="DeleteBookExecute">削除</a><br>
	<a href="AdminTOP">戻る</a>
</body>
</html>