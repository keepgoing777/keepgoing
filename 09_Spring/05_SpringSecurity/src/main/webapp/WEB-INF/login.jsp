<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
 <head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 </head>
 <body>
<!--session Security 방법 name="username" 및 "password"-->
<!--token Security 방법-->
    <h1>로그인</h1>
	<form action="/login" method="post" id="frm">
	아이디 : <input type="text" name="id"> <br>
	비밀번호 : <input type="text" name="pwd"> <br>
	 <button type="submit" id="login">로그인</button>
	</form>
	
	<script>
		$("#login").click((e) => {
			e.preventDefault(); //기존 이벤트 제거(로그인 제출)
			$.ajax({
				url:'/login',
				type:'post',
				data:$('#frm').serialize(),
				success: function(data) {
					alert(data);
				//localStorage에 token 키 값으로 저장
				//index.jsp로 이동
			    localStorage.setItem("token", data);
				location.href = "/";
				}
			});			
		});
	</script>
 </body>
</html>