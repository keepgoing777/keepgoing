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
 <%-- 입력한 숫자가 1이면 1값이 들어왔네요 --%>
  <c:if test="${param.number == '1'}">
    <h2>1값이 들어왔네요</h2>  
  </c:if>
 <%-- 1이 아닌 숫자들은 1값이 아니네요.. --%>
  <c:if test="${param.number != '1'}">
      <h2>1값이 아니네요..</h2>  
  </c:if>
</body>
</html>