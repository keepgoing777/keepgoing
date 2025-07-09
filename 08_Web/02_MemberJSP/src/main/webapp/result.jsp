<!-- HMTL 주석 : 소스코드에 보여짐 --> 
<%-- JSP 주석 : 소스코드에 안보여짐--%>
<%--
 JSP Element
 1. 지시어 %@ % : 컨테이너에게 알려줄 내용 지정
 2. 스틀릿틀릿 % % : 자바코드는 이 안에서 지정
 3. 출력문 %= % : 출력하는 내용 지정
 
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%--check값도 바인딩해서 여기서 조건을 걸수 있다는 점! --%>
 <% 
   boolean check = (boolean) request.getAttribute("check");
   String name = request.getParameter("name");
 %>
 <%--String name = (String) request.getAttribute("name"); --%>
 <%--check가 true인 경우 --%>
 <% if(check){%>
	 <h1><%=name%>님, 회원가입이 완료되었습니다!!</h1>
  <% } else {%>
     <h1>회원가입 실패 ㅠㅠ </h1>
  <% } %>
</body>
</html>