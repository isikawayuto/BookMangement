<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="dto.BookDTO" %>
  <%@ page import="dto.Users" %>
  <%@ page import="dto.Lending" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却確認画面</title>
<link rel="stylesheet" href="css/ReturnConfirmation.css">
</head>
<body>
<%
BookDTO book = (BookDTO)session.getAttribute("input_data");
Users users = (Users)session.getAttribute("users");
Lending len = (Lending)session.getAttribute("len");
%>
<h1>返却確認画面</h1>
<h3>利用者：<%=users.getName() %></h3>
<table border="1">
<tr>
<td rowspan="7">本の画像</td>
<td>タイトル</td>
<td><%=book.getTitle() %></td>
</tr>
<tr>
<td>識別番号</td>
<td><%=book.getBook_id()%></td>
</tr>
<tr>
<td>著者</td>
<td><%=book.getPublisher()%></td>
</tr>
<tr>
<td>出版社</td>
<td><%=book.getAuthor() %></td>
</tr>
<tr>
<td>ジャンル</td>
<td><%=book.getGenre_id() %></td>
</tr>
<tr>
<td>ISBN</td>
<td><%=book.getIsbn() %></td>
</tr>
<tr>
<td>新旧</td>
<td><%=book.getNew_old() %></td>
</tr>
</table>
<p>貸出日：<%=len.getLending_date() %> 返却期限：<%=len.getDeadline() %></p> 

<button type="button" onclick="location.href='./'">戻る</button>
<label class="open" for="popup" >返却</label>
<input type="checkbox" id="popup">
<div class="gray">
<div class="window">

<label class="close" for="popup">×</label>
<h4 class="title">本当に返却しますか？</h4>
<button type="button" onclick="location.href='ReturnConfirmation'">戻る</button>
<button type="button" onclick="location.href='Returncompleted'">はい</button>
</div>
</div>


</body>
</html>