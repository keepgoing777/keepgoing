<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/register" method="post"> <br>
    아이디 : <input type = "text" name = "id"/><br>
    비밀번호 : <input type = "text" name = "pwd"/><br>
    이름 : <input type = "text" name = "name"/><br>
    나이 : <input type = "number" name = "age"/><br>
    <input type = "submit" value="회원가입"/><br>
    </form>
</body>
</html>