<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script><link href="bootstrap.css" rel="stylesheet">Bootstrap core CSS -->
<%@ include file="/layout/commonLib.jsp"%>

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

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판 등록</h2>
						<div class="table-responsive">
							<form id="frm" action="${cp }/CBoardInsert" method="POST">
								<table class="table table-striped">
									<tr>
										<input type="hidden" id="userId" name="userId"value=${S_USERS.userId }>
										<td>게시판이름</td>
										<td><input type="text" id="cboardCategory"
											name="cboardCategory"></td>
										<td><select name="cboardUseCheck">
												<option value="0">사용</option>
												<option value="1">미사용</option>
										</select></td>
										<td><input name="Btn" type="submit" value="생성"></td>
									</tr>
									<br>
								</table>
							</form>
						</div>

						<h2 class="sub-header">게시판 목록 조회</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<c:forEach items="${cBoardList }" var="cBoardList">
									<form id="frm" action="${cp }/CBoardUpdate" method="POST">
									<tr>
										<input type="hidden" id="userId" name="userId" value=${S_USERS.userId }/>
										<td>게시판이름</td>
										<td><input type="text" id="cboardCategory"
											name="cboardCategory" value="${cBoardList.cboardCategory }"></td>
										<td><select name="cboardUseCheck">
												<c:if test="${cBoardList.cboardUseCheck == '0' }">
													<option value="0">사용</option>
													<option value="1">미사용</option>
												</c:if>
												<c:if test="${cBoardList.cboardUseCheck == '1' }">
													<option value="1">미사용</option>
													<option value="0">사용</option>
												</c:if>
										</select></td>
										<td><input name="Btn" type="submit" value="수정"></td>
									</tr>
									</form>
								</c:forEach>
							</table>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
