<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">


<script src="${cp }/js/bootstrap.js"></script>
<link href="${cp }/css/bootstrap.css" rel="stylesheet">
<link href="${cp }/css/blog.css?v=2" rel="stylesheet">


<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="/js/summernote-ko-KR.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<link href="${cp }/css/dashboard.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script>
	$(document).ready(function() {
		$('#summernote').summernote({
  		  height: 300,                 // 에디터 높이
  		  minHeight: null,             // 최소 높이
  		  maxHeight: null,             // 최대 높이
  		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
  		  lang: "ko-KR",					// 한글 설정
//   		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
            
  		});
// 		$('#regBtn').on('click',function(){
// 			$('#frm').submit();
// 		})
  		
	});

</script>
</head>
<style>
td {
	width: 100px;
}
</style>


<body>

	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/cBoard/cboardList.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<br>
				<br>
				<br>
				<div class="form-group">
					<label id="userid" for="userid" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목" value="${boardVO.boardTitle}"/>	
					</div>
				</div>
				<br>
				<br>
				<br>
				<div class="form-group">
					<label id="userid" for="userid" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-10">
					 <textarea id="summernote" name="boardContent"  placeholder="내용" value="${boardVO.boardContent}"></textarea>
					</div>
				</div>
				<br>
				<br>
				<br>
				<div class="form-group">
					<label id="userid" for="userid" class="col-sm-2 control-label">첨부파일</label>
							<div>
								<c:forEach items="${filesList }" var = "fileList">
									<input type="text" class="form-control" id="fileNm" name="fileNm" placeholder="첨부파일" value="${fileList.realFileNm }"/><br>
								</c:forEach>	
							</div>
							<input type="file" name="fileName" />
				</div>

				<br><br><br>
				<div class="form-group">
					<input type="submit" value="수정하기">
				</div>
				<br><br><br>
			</div>
		</div>
	</div>
</body>
</html>
