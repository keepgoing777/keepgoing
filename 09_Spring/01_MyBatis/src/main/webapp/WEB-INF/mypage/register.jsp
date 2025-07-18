<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action = "/register" method = "post">
	  아이디 : <input type = "text" name = "id"><br>
	  비밀번호 : <input type = "password" name = "pwd"><br>
	  이름 : <input type = "text" name = "name"><br>
	  나이 : 	<input type = "text" name = "age"><br>
	  <input type = "submit" value ="회원가입">
	</form>
</body>
</html>