<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
 <head>
	<meta charset="UTF-8">
	<title>관리자 페이지</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 </head>
    <!--get 방식, /admin :관리자만 접근 가능-->
	<h1>관리자 페이지</h1>
	<p><sec:authentication property="name"/>님의 페이지입니다.</p>
  <body>
 </body>
</html>