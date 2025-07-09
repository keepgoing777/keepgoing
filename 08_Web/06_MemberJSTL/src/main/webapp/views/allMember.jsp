<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
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
<h1>전체 리스트</h1>
  <table border = "1">
        <th>인덱스</th>
        <th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>나이</th>
<%-- 삭제한 부분
    <%List<Member> list = (List<Member>) request.getAttribute("list");%> 
	<% for (Member member : list) {%>
	<tr>
	  <td><%=member.getId() %></td>
	  <td><%=member.getPwd() %></td>
	  <td><%=member.getName() %></td>
	  <td><%=member.getAge() %></td>
	</tr>
      <% }%>
 --%>
 
  <c:forEach items="${list}" var ="member" varStatus="status">
   <tr>
    <%--index:0부터 / count:1부터 시작--%>
    <td>${status.index}</td>
    <td>${status.count}</td>
    <td>${member.id}</td>
    <td>${member.pwd}</td>
    <td>${member.name}</td>
    <td>${member.age}</td>
   </tr>
  </c:forEach> 
</table>
   <a href="/">메인 페이지로 이동</a>
</body>
</html>