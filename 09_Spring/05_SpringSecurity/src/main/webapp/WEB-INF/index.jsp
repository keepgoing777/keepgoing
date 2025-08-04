<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
 <head>
	<meta charset="UTF-8">
	<title>INDEX</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 </head>
  <body>
<!--localhost 들어가면 /login 화면이 바로 뜸 : pom.xml에 SpringSecurity 넣었을떄부터-->
    <div id="annoymous">
    <sec:authorize access="isAnonymous()">
	   <a href="/login">로그인</a><br>
       <a href="/register">회원가입</a><br>
	</sec:authorize>
	</div>
	
	<div id="authenticated">
	<sec:authorize access="isAuthenticated()">
	  <a href="/logout">로그아웃</a><br>
	  <a href="/mypage">마이페이지</a>
	</sec:authorize>
	</div>
	
	<sec:authorize access="hasRole('ADMIN')">
	  <a href="/admin">관리자페이지</a>
	</sec:authorize>

	<!--다음 수업에 진행 style none적용할것-->
 </body>
</html>