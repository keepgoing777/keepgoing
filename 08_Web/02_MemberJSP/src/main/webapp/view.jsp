<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  
    <%--SearchServlet 생성, search.jsp에서 결과확인 --%>
    <h2>회원조회</h2>
    <form action="search">
    검색할 회원 아이디 : <input type = "text" name = "id">
    <input type = "submit" value="조회">
    </form>
	<h1>전체 리스트</h1>
	<%
	List<Member> list = (List<Member>) request.getAttribute("list");
	%>
	<table border = "1">
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>나이</th>
	<% for (Member member : list) {%>
	<tr>
	  <td><%=member.getId() %></td>
	  <td><%=member.getPwd() %></td>
	  <td><%=member.getName() %></td>
	  <td><%=member.getAge() %></td>
	</tr>
 <% }%>
</table>
</body>
</html>