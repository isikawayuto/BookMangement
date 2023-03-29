<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.BookDTO" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出画面</title>
<link rel="stylesheet" href="css/RentalScrean.css">
</head>
<body>
<h1>貸出画面</h1>
<table border="1">
<tr>
<th>タイトル</th>
<th>著者</th>
<th>出版社</th>
<th>ジャンル</th>
<th>新旧</th>
<th>ISBN</th>
<th>識別番号</th>
<th>　　　</th>
</tr>
<% 
	List<BookDTO> select = (ArrayList<BookDTO>)session.getAttribute("select");
	String genre = (String)session.getAttribute("genre_name");
	for(BookDTO b : select){
		String judge_name="";
		if(b.getNew_old()== false){
			judge_name = "旧書";
		}else{
			judge_name ="新書";
		}
%>
<tr>
	<td><%=b.getTitle() %></td>
	<td><%=b.getAuthor() %></td>
	<td><%=b.getPublisher()%></td>
	<td><%=genre %></td>
	<td><%=judge_name %></td>
	<td><%=b.getIsbn() %></td>
	<td><%=b.getBook_id() %></td>
	<td>
		<form action="RentalConfirmation" method="get">
			<input type="hidden" name="isbn" value="<%=b.getIsbn()%>">
			<input type="hidden" name="book_id" value="<%=b.getBook_id()%>">
			<button type="submit">選択</button>
		</form>
	</td>
<tr>
<%	} %>
</table>
</body>
</html>