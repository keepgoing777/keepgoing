<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
 <head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 </head>
  <form action="/login" method="post">
	아이디 : <input type="text" name="username"> <br>
	비밀번호 : <input type="text" name="password"> <br>
   <button type="submit">로그인</button>
  <body>
 </body>
</html>