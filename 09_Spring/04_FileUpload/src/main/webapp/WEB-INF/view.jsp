<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
<!--list에서 view 연결, a 링크를 통해 딱 해당 정보만 나올 수 있도록!
<div class="container">
	<h1>${board.title}</h1>
	<p>${board.content}</p>
	<img src="http://192.168.0.35:8081/${board.url}"/>
</div>
-->
  <div class="container">
	  <h1>게시물 정보</h1>
	  <form action="/update" method="post" enctype="multipart/form-data">
        <input type="hidden" name="no" value="${board.no}" />
		<input type="hidden" name="url" value="${board.url}" />
		<div class="form-group">
		   <label>Title</label>
		   <input class="form-control" name="title" value="${board.title}" />
	    </div>
		<div class="form-group">
		   <label>Content</label>
		   <textarea class="form-control" name="content" />${board.content}
		   </textarea>
		</div>
		<img src="http://192.168.0.35:8081/${board.url}" /> 
	
<!--수정 시 file이 있다면 기존 파일을 삭제하고 새로 추가된 파일로 업로드, DB 수정
(파일 삭제 : File 객체의 delete() 메서드 사용)
-->	
		
		<div class="form-group">
			   <label>Update File</label>
			   <input class="form-control" name="file" type="file" accept="image/*" />
		</div>
		<button type="submit" class="btn btn-outline-warning">수정</button>
		<a class="btn btn-outline-danger" herf="/delete?no=${board.no}">삭제</a>
	  </form>
  </div>
</body>
<html>