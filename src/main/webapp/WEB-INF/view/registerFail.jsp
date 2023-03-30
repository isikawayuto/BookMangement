<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>登録失敗</title>
</head>
<body>
    <h1>登録失敗</h1>
    <p>書籍の登録に失敗しました。もう一度お試しください。</p>
    <form action="registerBookServlet" method="post">
        <input type="hidden" name="isbn" value="${param.isbn}">
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" name="genre_id" value="${param.genre_id}">
        <input type="hidden" name="title" value="${param.title}">
        <input type="hidden" name="author" value="${param.author}">
        <input type="hidden" name="publisher" value="${param.publisher}">
        <input type="hidden" name="new_old" value="${param.new_old}">
        <input type="hidden" name="title_kana" value="${param.title_kana}">
        <input type="hidden" name="author_kana" value="${param.author_kana}">
        <input type="submit" value="再試行">
    </form>
    <a href="adminPage.jsp">管理者ページに戻る</a>
</body>
</html>
