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
  		
            
  		});

  		$('#upBtn').on('click',function(){
			alert('수정되었습니다');

    	})

    	$('button[id^=delFBtn]').on('click',function(){
			var fileNo = $(this).attr('value');
// 			alert(fileNo);
			$(this).remove();

			fileNoDynamic = "<div><input type='hidden' value='"+fileNo+"' name='fileNoUp'></div>"
			$('#DelFileListId').append(fileNoDynamic);
			
			
        })
  		
	})

</script>
</head>
<style>
/* #fileA{width: 500px;} */
</style>


<body>

	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/cBoard/cboardList.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form" action="${cp}/BoardUpdate?boardNo=${boardVO.boardNo}" method="POST" enctype="multipart/form-data">
					<br>
					<br>
					<br>
					<div class="form-group">
						<label id="userid" for="userid" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
<!-- 							<label  class="form-control" >제목</label>	 -->
							<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목" value="${boardVO.boardTitle}"/>	
						
						</div>
					</div>
					<br>
					<br>
					<br>
					<div class="form-group">
						<label id="userid" for="userid" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
						 <textarea id="summernote" name="boardContent" placeholder="내용" value="${boardVO.boardContent}">${boardVO.boardContent}</textarea>
						</div>
					</div>
					<br>
					<br>
					<br>
					<div class="form-group">
						<label id="files" for="files" >첨부파일<br>
										<c:forEach items="${filesList }" var="filesList" varStatus="status">
											<button id="delFBtn${status.count}" type="button" name="fileNo"  value="${filesList.fileNo}">${filesList.realFileNm } X</button>
<%-- 											<button id="delFBtn${status.count}" type="button" name="fileNm"  value="${filesList.fileNm}">${filesList.realFileNm } X</button> --%>
											<br>
										</c:forEach>	
										<div id="DelFileListId">
										</div>
						</label>
							
								<c:forEach var="i" begin="1" end="${5-filesList.size() }">
							
									<div class="form-group">
										<label for="userid" class="col-sm-2 control-label">첨부파일</label>
										<div class="col-sm-10">
											  <input type="file" name="fileName${i }"/>
										</div>
									</div>
								</c:forEach>
							
					</div>
	
					<br><br><br>
					<div>
<!-- 						<input id="upBtn"type="submit" value="수정하기"> -->
						<button id="upBtn"type="submit" >수정하기</button>
					</div>
					<br><br><br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
