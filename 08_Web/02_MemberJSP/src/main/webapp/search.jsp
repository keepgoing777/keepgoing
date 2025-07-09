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
<%
        //String searchId = (String) request.getAttribute("searchId");
        Member member = (Member) request.getAttribute("member");
        String id = request.getParameter("id"); 
    %>
    
  <%--<p>검색한 아이디: <%= searchId %></p> --%>
    
    <% if (member != null) { %>
        <h1>회원 정보</h1>
            <ul>
                <li>아이디 : <%= member.getId() %></li>
                <li>이름 : <%= member.getName() %></li>
                <li>나이 : <%= member.getAge() %></li> 
        </ul>
    <% } else { %>
        <p style="color: red;">해당 <%=id %>의 회원이 존재하지 않습니다.</p>
    <% } %>
    
    <br>
    <a href="view.jsp">돌아가기</a>
</body>
</html>