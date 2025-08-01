<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
 <head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 </head>
    <h1>회원가입</h1>
    <form action="/register" method="post">
      아이디 : <input type="text" name="id"> <br>
	  비밀번호 : <input type="text" name="pwd"> <br>
	  이름 : <input type="text" name="name"> <br>
	<button type="submit">회원가입</button>
  </form>
  <body>
 </body>
</html>