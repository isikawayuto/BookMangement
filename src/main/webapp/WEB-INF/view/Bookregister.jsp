<%@page import="dto.Genre"%>
<%@page import="dao.AdminDAO"%>
<%@page import="dto.Book"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            line-height: 1.6;
            margin: 0;
        }

        h1 {
            text-align: center;
            padding: 20px;
            background-color: #333;
            color: #fff;
        }

        form {
            width: 50%;
            margin: 30px auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        label {
            display: block;
            margin: 10px 0;
        }

        input[type="text"],
        input[type="number"],
        input[type="file"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        input[type="checkbox"] {
            margin-top: 10px;
        }

        input[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #666;
        }
    </style>
</head>
<body>
    <h1>図書登録</h1>
    <%
        List<Genre> genres = new ArrayList<>();
        try {
            genres = AdminDAO.getGenres();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
    <form action="BookRegistrationServlet" method="POST" enctype="multipart/form-data">
        <label for="isbn">ISBN</label>
        <input type="text" name="isbn" id="isbn" required><br>
        
        <label for="id">ID</label>
        <input type="number" name="id" id="id" required>
        
        <label for="genre_id">ジャンルID</label>
        <select name="genre_id" id="genre_id" required>
            <% for (Genre genre : genres) { %>
                <option value="<%= genre.getId() %>"><%= genre.getName() %></option>
            <% } %>
        </select><br>
        
        <label for="title">タイトル</label>
        <input type="text" name="title" id="title" required><br>
        
        <label for="author">著者</label>
        <input type="text" name="author" id="author" required><br>
        
        <label for="publisher">出版社</label>
        <input type="text" name="publisher" id="publisher" required><br>
        
        <label for="new_old">新書or旧書(旧書の場合はチェックをお願いします。)</label>
        <input type="checkbox" name="new_old" id="new_old"><br>
        
        <label for="title_kana">タイトル（カナ）</label>
        <input type="text" name="title_kana" id="title_kana"><br>
        
        <label for="author_kana">著者（カナ）</label>
        <input type="text" name="author_kana" id="author_kana"><br>
        
        <label for="image">画像</label>
        <input type="file" name="image" id="image"><br>
        
        <input type="submit" value="登録">
    </form>
</body>
</html>