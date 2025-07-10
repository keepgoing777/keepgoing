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
    <h2>로그인</h2>
    <form action="/login.do" method="post">
    아이디 : <input type = "text" name = "id">
    비밀번호 : <input type = "text" name = "pwd">
    <input type = "submit" value="로그인">
    </form>
</body>
</html>