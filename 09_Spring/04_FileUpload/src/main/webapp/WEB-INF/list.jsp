<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>List Page</h1>
		<table class="table">
			<thead>
				<th>번호</th>
				<th>제목</th>
				<th>작성시간</th>
			</thead>
		    <tbody>
			</tbody>
		</table>
				
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  글 추가
		</button>

		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
			  <form action="/write" method="post" enctype="multpart/form-data">
		      <div class="modal-body">
					<div class="mb-3">
					<label class="form-label">Title</label>
					<input type="text" class="form-control" name="title">
					</div>
					<div class="mb-3">
					<label class="form-label">Content</label>
					<textarea class="form-control" rows="3" name="content"></textarea>
					
					<div class="mb-3">
					<label class="form-label">Add File</label>
					<input class="form-control" name="file" type="file" id="formFile" accept="image/*">
					</div>		
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <button type="button" class="btn btn-warning">등록</button>
		      </div>
			  </form>
		    </div>
		  </div>
		</div>
	</div>

</body>
<html>