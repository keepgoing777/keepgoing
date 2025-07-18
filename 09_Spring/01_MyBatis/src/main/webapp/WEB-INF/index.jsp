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
	<h1>회원관리</h1>
	<c:choose>
		<c:when test = "${not empty member}">
			<h1>${member.name}님 로그인 하셨습니다. </h1>
	<!-- 로그인한 사람의 정보 수정-->			
	<form action = "/update" method = "post">
	  비밀번호 : <input type = "password" name = "pwd" value ="${member.pwd}"><br> 
	  이름 : <input type = "text" name = "name" value = "${member.name}"><br>
	  나이 : <input type = "text" name = "age" value = "${member.age}"><br>
	 <input type = "submit" value = "회원수정">
    </form>
	
	<h2>비밀번호만 변경</h2>
	<form action = "/update" method = "post">
	  비밀번호 : <input type = "password" name = "pwd"><br> 
	 <input type = "submit" value="비밀번호 수정">
	</form>
	<!-- primarykey가 id-->
	<a herf ="/delete">회원탈퇴</a>	
    </c:when>
	<c:otherwise>
     	<a href = "/register">회원가입</a>
 w   	<a href = "/login">로그인</a>
	</c:otherwise>
	</c:choose>	
	
	<!--회원검색-->
	<form action = "/search">
		<select name = "select">
			<option value = "all">이름 또는 아이디</option>
			<option value = "id">아이디</option>
			<option value = "name">이름</option>
		</select>
		<input type = "text" name = "keyword" value = "${param.keyword}">
		<input type = "submit" value = "검색">
	</form>
	<form action = "/delete" method = "post">
		
	<!-- 회원목록-->
	 <table border = "1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>삭제</th>
		</tr>
       <c:forEach items = "${list}" var = "item">
		<tr>
			<td>${item.id}</td>
			<td>${item.pwd}</td>
			<td>${item.name}</td>
			<td>${item.age}</td>	
			<td><input type = "checkbox" name= "idList" value = "${item.id}"> </td>
		</tr>	
	   </c:forEach>
	  </table>
	  <input type = "submit" value = "삭제">
	</form>
</body>
</html>