<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Review" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レビューを投稿</title>
</head>
<body>
    <h1>レビューを投稿</h1>
    <form action="ReviewServlet" method="post">
        <%-- セッションから ISBN と email を取得する --%>
        <input type="hidden" id="isbn" name="isbn" value="${sessionScope.isbn}">
        <input type="hidden" id="email" name="email" value="${sessionScope.email}">
        
        <label for="comment">コメント:</label>
        <textarea id="comment" name="comment" rows="4" cols="50" required></textarea><br>
        <label for="point">評価:</label>
        <input type="number" id="point" name="point" min="1" max="5" required><br>
        <input type="submit" value="投稿">
    </form>
</body>
</html>