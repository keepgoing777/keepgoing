<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   JSTL (JSP Standard Tag Library)
   1. 라이브러리 추가 (jakarta 2개 파일 WEB-INF>lib폴더에 추가)
   2. taglib 속성 지정
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- c:set 변수 지정 -->
  <c:set var="num1" value="5" scope="request" />
  <c:set var="num2" value="9" />
  <c:set var="multiple" value="${num1 * num2}" />
  <h4>${num1} x ${num2} = ${num1 * num2}</h4>  

</body>
</html>