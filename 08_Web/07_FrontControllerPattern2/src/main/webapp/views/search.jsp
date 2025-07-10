<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>회원검색</h2>
   <form action="/front" method="get">
    <input type="hidden" name="command" value="search"> <%--추가--%>
    검색할 회원 아이디 : <input type = "text" name = "id">
    <input type="submit" value="검색">
    </form>
</body>
</html>