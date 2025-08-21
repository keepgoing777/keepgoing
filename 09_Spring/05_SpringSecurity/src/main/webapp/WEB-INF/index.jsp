<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
 <head>
	<meta charset="UTF-8">
	<title>INDEX</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 </head>
  <body>
<!--localhost 들어가면 /login 화면이 바로 뜸 : pom.xml에 SpringSecurity 넣었을떄부터-->

<!--서버 부분-->
    <sec:authorize access="isAnonymous()"></sec:authorize>
	<sec:authorize access="isAuthenticated()"></sec:authorize>
	<sec:authorize access="hasRole('ADMIN')"></sec:authorize>
	
	<div id="anonymous">	
	   <a href="/login">로그인</a><br>
       <a href="/register">회원가입</a><br>
	</div>
	<div id="authenticated">	
	  <a href="/logout" id="logout">로그아웃</a><br>
	  <a href="/mypage" id="mypage">마이페이지</a>
	</div>
	
	<a href="/admin" id="admin">관리자페이지</a><br>

<!--클라이언트 부분-->
	<script>
	   const token = localStorage.getItem("token");
	   
	   if(token!=null) {
		$('#anonymous').hide();
		$('#authenticated').show();
		$('#admin').hide();
		$.ajax({
			url: '/check',
			type: 'get',
			data: { token : token },
			success: function(data) {
				if(data.role === 'ROLE_ADMIN') {
					$('#admin').show();
				}
			}
		});
	   } else {
		$('#anonymous').show();
		$('#authenticated').hide();
		$('#admin').hide();
	   }
	   
	   $('#logout').click((e) => {
		e.preventDefault();
		localStorage.removeItem("token");
		location.reload(); //jsp 단점. 바로바로 적용안되서 추가
	   });
	   
	   $('#mypage').click((e) => {
		e.preventDefault();
		$.ajax({
			url: '/mypage',
			type: 'get',
			beforeSend: function(xhr) {
				xhr.setRequestHeader('Authorization', 'Bearer ' + token);
			},
			success: function(data){
				$('body').html(data);
			}
		  });
	   });
	   
	   $('#admin').click((e) => {
	    e.preventDefault();
	    $.ajax({
	       url: '/admin',
	       type: 'get',
	       beforeSend: function(xhr) {
	   	      xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	   	   },
	   	   success: function(data){
	   		 $('body').html(data);
	   	   }
	     });
	  });	   
	</script>
	
 </body>
</html>