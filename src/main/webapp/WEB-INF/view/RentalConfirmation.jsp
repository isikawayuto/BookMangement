<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出確認画面</title>
<link rel="stylesheet" href="css/RentalConfirmation.css">
</head>
<body>
<h1>貸出確認画面</h1>
<h3>利用者：</h3>
<%
BookDTO book = (BookDTO)session.getAttribute("input_data");
%>
<table border="1">
<tr>
<td rowspan="7">本の画像</td>
<td>タイトル</td>
<td></td>
</tr>
<tr>
<td>識別番号</td>
<td></td>
</tr>
<tr>
<td>著者</td>
<td></td>
</tr>
<tr>
<td>出版社</td>
<td></td>
</tr>
<tr>
<td>ジャンル</td>
<td></td>
</tr>
<tr>
<td>ISBN</td>
<td></td>
</tr>
<tr>
<td>新旧</td>
<td></td>
</tr>
</table>
<p>貸出日： 返却期限：</p> 

<button type="button" onclick="location.href='./'">戻る</button>
<label class="open" for="popup" >貸出</label>

<input type="checkbox" id="popup">
<div class="gray">
<div class="window">

<label class="close" for="popup">×</label>
<h4 class="title">本当に貸出しますか？</h4>
<button type="button" onclick="location.href='RentalConfirmation'">戻る</button>
<button type="button" onclick="location.href='Loancompleted'">はい</button>
</div>
</div>


</body>
</html>