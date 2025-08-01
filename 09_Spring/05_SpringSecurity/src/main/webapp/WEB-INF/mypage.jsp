<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
 <head>
	<meta charset="UTF-8">
	<title>Mypage</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 </head>
    <!--get 방식, /mypage : 인증된(로그인된) 사람만 접근 가능-->
	<h1>마이페이지</h1>
	<p><sec:authentication property="principal.id"/>님의 아이디</p>
	<p><sec:authentication property="principal.name"/>님의 페이지입니다.</p>
  <body>
 </body>
</html>