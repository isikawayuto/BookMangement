<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理者TOPメニュー</title>
    <link rel="stylesheet" href="css/AdminTOP.css">
    <link rel="stylesheet" href="css/review.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
         body {
            font-family: 'Roboto', sans-serif;
            font-size: 16px;
            line-height: 1.5;
            color: #333;
            background-color: #f7f9fa;
        }

        h1 {
            font-size: 32px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }

        .logout-btn {
            position: absolute;
            top: 20px;
            right: 20px;
        }

        .menu {
            display: flex;
            justify-content: center;
            list-style: none;
            padding: 0;
            margin-bottom: 20px;
        }

        .menu li {
            margin-right: 20px;
        }

        .menu a {
            font-size: 20px;
            font-weight: bold;
            color: #0072C6;
            text-decoration: none;
        }

        .menu a:hover {
            color: #0056a3;
        }

        .search-container {
            display: flex;
            justify-content: space-between;
            max-width: 900px;
            margin: 0 auto 20px;
            padding: 20px;
            background-color: #f0f0f0;
            border-radius: 8px;
        }

        .search-box {
            width: 70%;
        }

        .search-box__title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            display: block;
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            border: 1px solid #ccc;
            background-color: #fff;
            box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.2);
        }

        .btn {
            font-size: 16px;
            padding: 10px 20px;
            border-radius: 4px;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }

        .btn-primary {
            background-color: #1abc9c;
            color: #fff;
        }

        .btn-primary:hover {
            background-color: #148f77;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

    </style>
</head>
<body>
    <h1>
    </style>
</head>
<body>
    <h1>図書管理システム</h1>
    <div class="logout-btn">
        <button type="button" onclick="location.href='AdminLogout'">ログアウト</button>
    </div>
    <ul class="menu">
        <li><a href="BookRegistrationServlet">図書登録</a></li>
        <li><a href="tourism.html">図書削除</a></li>
        <li><a href="history.html">図書編集</a></li>
        <li><a href="tradition.html">図書検索</a></li>
    </ul>
    <div class="search-container">
        <div class="search-box">
            <form method="post" action="UserSearch">
                <h2 class="search-box__title">ユーザー検索</h2>
                <div class="form-group">
                    <label for="search_user_name" class="form-label">ユーザー名</label>
                    <input type="text" id="search_user_name" name="search_user_name" class="form-input">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">検索</button>
                </div>
            </form>
        </div>
        <div class="button-container">
            <button type="button" class="btn btn-primary" onclick="location.href='AllBooksServlet'">一覧表示</button>
            <button type="button" class="btn btn-primary">貸出</button>
        </div>
    </div>
    <h2>承認待ちレビュー
  <div>
        <c:forEach items="${unapprovedReviews}" var="review">
            <div class="review-card my-3">
                <h3>${review.email}</h3>
                <p>ISBN: ${review.isbn}</p>
                <p>${review.comment}</p>
                <div class="rating">
                    <div class="stars">
                        <c:forEach begin="1" end="5" var="i">
                            <input type="radio" name="star" value="${i}" id="star${i}" ${i == review.point ? 'checked' : ''} disabled>
                            <label for="star${i}"></label>
                        </c:forEach>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" onclick="location.href='AdminReviewApproval?id=${review.id}'">承認</button>
                <button type="button" class="btn btn-danger" onclick="location.href='AdminReviewReject?id=${review.id}'">却下</button>
            </div>
        </c:forEach>
    </div>
</body>
</html>