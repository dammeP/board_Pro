<%@page import="kr.or.ddit.board.vo.BoardVO"%>
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

</script>
<style>
#boardTitle{ font-size: 2.0em;}
.left-box{ color: #8B4513;}
#boardContent{ font-size: 1.2em;}
#hrLine{border: 3px solid #3C3C8C;}
#textS{width:700px; height:100px;  }
#reNm{width : 50px; height:50px; font-weight:bold;}
#reCo{width : 500px; height:100px; }
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
				<br>
				<br>
				<br>
				<div class="form-group">
					<div class="col-sm-10">
						<label id="boardTitle" data-userid="${boardVO.boardTitle}"class="control=label">${boardVO.boardTitle}</label>
					</div>
				</div>
				<br>
				<div class="form-group">
					<div class="left-box">
						<label id="userId" class="control=label">작성자 : </label>
						<label id="userId" class="control=label">${boardVO.userId}</label>
						<label id="userId" class="control=label">작성일자 : </label>
						<label id="boardDate" class="control=label">${boardVO.boardDate}</label>
					</div>
				</div>
				<br>
				<br>
				<div class="form-group">
					<div class="col-sm-10">
						<label id="boardContent"class="control=label">${boardVO.boardContent}</label>
					</div>
				</div>
				<br>
				<br>
				<br>
				<div class="form-group">
					<label id="userid" for="userid" >첨부파일</label>
					<div>
						<form action="${cp }/profileDownload?fileNo=${fileList.fileNo}" method="GET" enctype="multipart/form-data">
								<c:forEach items="${filesList }" var="fileList">
								<img src="${cp}/profileImg?fileNo=${fileList.fileNo}"/><br>
									<input type="hidden" name="fileNo" value="${fileList.fileNo}">
									<div>
									<button id="profileDownBtn"  type="submit" class="btn btn-default"  >다운로드 : ${fileList.realFileNm }</button>
									</div>
								</c:forEach>	
						</form>
					</div>
				</div>
				<div>
					<div class="col-sm-offset-6 col-sm-10">
					<form action="${cp }/BoardUpdate?boardNo=${boardVO.boardNo}" method="GET" enctype="multipart/form-data">
						<input type="hidden" name="boardNo" value="${boardVO.boardNo}">
						<button name="upBtn" type="submit" class="btn btn-default">수정
						</button>
					</form>
						<form action="${cp }/BoardDelete" method="POST">
							<% String boardNo = request.getParameter("boardNo"); 
							%>							
							<input type="hidden" name="cboardNo" value="${boardVO.CBoardNo}" >
							<input type="hidden" name="boardNo" value="${boardVO.boardNo}" >
							<button name="delBtn" type="submit" class="btn btn-default">
								삭제
							</button>
						</form>
						<form action="${cp }/BoardInsertPa?boardNo=${boardVO.boardNo}" method="GET" >
							<input type="hidden" name="cboardNoPa" value="${boardVO.CBoardNo}" >
							<input type="hidden" name="boardNoPa" value="${boardVO.boardNo}" >
							<input type="hidden" name="userIdPa" value="${boardVO.userId}" >
							<button name="ureBtnpBtn" type="submit" class="btn btn-default">
								답글
							</button>
						</form>
					</div>
				</div>

				<br><br><br>




				<div class="form-group">
					<div id="replyS" class="col-sm-10">
					<label>댓글 조회</label>
					<form action="${cp }/ReplyDelete" method="POST">
						<table>
							<c:forEach items="${replyList}" var="replyList">
								<c:if test="${replyList.replyDelCheck != '1'}" >
								<tr>
									<td id="ReNm">${replyList.userId }</td>
								</tr>
								<tr>
									<td id="ReCo">${replyList.replyContent }</td>
									<input type="hidden" name="boardNo" value="${boardVO.boardNo}" >
									<input type="hidden" name="replyNo" value="${replyList.replyNo }">
									<td><button>삭제</button></td>
								</tr>
								</c:if>
							</c:forEach>
					</form>
							
						</table>
						<form action="${cp }/BoardRegist" method="POST">
							<textarea id="textS" name="replyC"></textarea>
							<input type="hidden" name="boardNo" value="${boardVO.boardNo}">
							<input type="hidden" name="userId" value="${boardVO.userId }">
							<button name="addBtnR" type="submit">등록</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
