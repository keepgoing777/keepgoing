<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>1. 기존방식</h2>
 <% 
    String id = request.getParameter("id");
    String[] hobbyList = request.getParameterValues("hobby");
 %>
  <ul>
    <li>아이디 : <%=id%></li>
    <% for(String hobby : hobbyList) {%>
    <li>취미 : <%=hobby %></li>
    <%}%>
  </ul>
 <h2>2. EL</h2>
  <ul>
    <li>아이디 : ${param.id}</li>
    <li>취미 : ${paramValues.hobby[0]}</li>
  </ul>
</body>
</html>