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
<%@ include file="/layout/commonLib.jsp" %>

<style>
	td{width : 100px;}
</style>

</head>

<body>

<%@ include file="/layout/header.jsp" %>

<div class="container-fluid">
	<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/cBoard/cboardList.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
				<form id="frm" action="${cp }/CBoardCreate" method="POST">
					<table class="table table-striped">
						<tr>
							<input type="hidden" id="userId" name="userId" value=${param.userId }>						
							<td>게시판이름</td>
							<td><input id="textid"
							 type="text" id="cboardCategory" name="cboardCategory"></td>
							<td>
							<select id="cboardUseCheck">
								<option value="0">사용</option>
								<option value="1">미사용</option>
							</td>
							<td><button type="regBtn">생성</button></td>
						</tr>
					</table>
				</form>
					<table>
						<tr>
							<td>게시판이름</td>
							<td><input type="text" ></td>
							<td>
							<select id="useSel">
								<option value="">사용</option>
								<option value="">미사용</option>
							</td>
							<td><button type="submit">생성</button></td>
						</tr>
		
					</table>
	
				</div>		
		</div>
	 </div>
</div>
</body>
</html>
