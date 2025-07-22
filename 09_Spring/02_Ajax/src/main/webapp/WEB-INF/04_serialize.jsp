<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<title>Ajax</title>
	 <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form id="frm">
		아이디 : <input type="text" name="id" id="id"><br>
		비밀번호 : <input type="password" name="pwd" id="pwd"><br>
		나이 : <input type="text" name="age"><br>
		이름 : <input type="text" name="name" id="name"><br>
		<input type="submit" value="회원가입" id="btn">
	</form>
  <div id="result"></div>
  <script>
	$("#btn").click(()=>{
		$.ajax({
			type : "post",
			url : "/signup",
			data : $("#frm").serialize(),
			success:function(response){
				console.log(response.name);
				$("#result").text(response.name + "님이 회원가입 하셨습니다!")
			},
		});
	});
  </script>
</body>
</html>