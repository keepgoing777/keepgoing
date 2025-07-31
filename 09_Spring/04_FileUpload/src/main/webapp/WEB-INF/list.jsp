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
	<div class="container">
		<h1>List Page</h1>
		<form action="/list">
			<input type="text" name="keyword" value="${param.keyword}">
			<input type="submit" value="검색">
		</form>
		<table class="table">
			<thead>
			  <tr>
				<th>번호</th>	
				<th>제목</th>
				<th>작성시간</th>
			  </tr>
			</thead>
		    <tbody>
				<!--리스트 list 가지고 오기 : 반복분-->
				<c:forEach items="${list}" var="board">
					<tr>
				     	<td>${board.no}</td>
						<td>
					    <a href="/view?no=${board.no}">${board.title}</a></td>
						<td><fmt:formatDate value="${board.formatDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>					
				</c:forEach>
			</tbody>
		</table>
				
		<nav>
		   <ul class="pagination">
			 <li class="page-item ${paging.prev ? '' : 'disabled'}"><a class="page-link" href="/list?page=${paging.startPage - 1}&keyword=${param.keyword}">Previous</a></li>
				<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
		     <li class="page-item"><a class="page-link ${paging.page == page ? 'active' : ''}" href="/list?page=${page}&keyword=${param.keyword}">${page}</a></li>
			   	</c:forEach>								
			 <li class="page-item ${paging.next ? '' : 'disabled'}"><a class="page-link" href="/list?page=${paging.endPage + 1}&keyword=${param.keyword}">Next</a></li>
		   </ul>
	    </nav>
					
		<button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#writeModal">글 추가</button>

				<!-- Modal -->
				<div class="modal fade" id="writeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 등록</h1>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
					 
					   <form action="/write" method="post" enctype="multipart/form-data">
					  <div class="modal-body">
						<div class="mb-3">
						<label class="form-label">Title</label>
						<input type="text" class="form-control" name="title">
						</div>
						<div class="mb-3">
						<label class="form-label">Content</label>
						<textarea class="form-control" rows="3" name="content"></textarea>
						</div>
						<div class="mb-3">
						<label class="form-label">Add File</label>
						<input class="form-control" name="file" type="file" accept="image/*">
						</div>
					  </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
				        <button type="submit" class="btn btn-warning">등록</button>
				      </div>
					  </form>
				    </div>
				  </div>
				</div>
			</div>
			
		</body>
		</html>