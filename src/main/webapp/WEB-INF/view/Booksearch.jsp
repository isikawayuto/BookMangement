<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書検索</title>
<link rel="stylesheet" href="css/Booksearch.css">
</head>
<body>
<h1>図書検索</h1>
<div>
			<form class="from-prace" action="AdminTOP" method="post">
				<table>
					<tr class="form-interval">
						<td id="ISBN">ISBN</td><td><input type="text" id=input-size size="50" name="ISBN"></td>
					</tr>
					<tr class="form-interval">
						<td id="title">タイトル</td><td><input type="text" id=input-size size="50" name="タイトル"></td>
					</tr>
					<tr class="form-interval">
						<td id="title">著者</td><td><input type="text" id=input-size size="50" name="著者"></td>
					</tr>
					<tr class="form-interval">
						<td id="title">出版社</td><td><input type="text" id=input-size size="50" name="出版社"></td>
					</tr>
					<tr class="form-interval">
					<td id="title">ジャンル
					<select name="ジャンル">
  					<option value="1">指定なし</option>
 					<option value="2">アドベンチャー</option>
  					<option value="3"></option>
  					<option value="4"></option>
  					<option value="5"></option>
  					<option value="6"></option>
					</select>
					<td id="title">新書</td><td><input type="radio" id=input-size size="50" name="新書"></td>
					<td id="title">旧書</td><td><input type="radio" id=input-size size="50" name="旧書"></td>
					
					</tr>
						
				</table>
				<input id="button" type="submit" value="検索">
			</form>
		</div>
</body>
</html>