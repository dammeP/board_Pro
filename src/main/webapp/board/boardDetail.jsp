<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@ include file="/layout/commonLib.jsp"%>

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script><link href="bootstrap.css" rel="stylesheet">Bootstrap core CSS -->

<script>
// 	$(function(){
// 		$('#boardListID tr').on('click',function(){
// 			var boardNo = $(this).data('boardNo');

// 			document.location="BoardDetail?boardNo=" + boardNo;
// 		})
// 	})



</script>
<style>
td {
	width: 100px;
}
</style>

</head>

<body>

	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/cBoard/cboardList.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<br><br><br>
				<div class="form-group">
					<label id="userid" for="userid" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label id="boardTitle" data-userid="${boardVO.boardTitle}" class="control=label">${boardVO.boardTitle}</label>
						</div>
				</div>
				<br><br><br>
				<div class="form-group">
					<label id="userid" for="userid" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label id="boardContent"  class="control=label">${boardVO.boardContent}</label>
						</div>
				</div>
				<br><br><br>
				<div class="form-group">
					<label id="userid" for="userid" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<label id="file" class="control=label">첨부파일 공간</label>
						</div>
				</div>
				<br><br><br>
				<div class="form-group">
					<label id="userid" for="userid" class="col-sm-2 control-label">댓글</label>
						<div class="col-sm-10">
							<label id="reply"  class="control=label">댓글 공간</label>
						</div>
				</div>
				<br><br><br>
			</div>
		</div>
	</div>
</body>
</html>
