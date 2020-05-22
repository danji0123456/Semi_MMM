<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지 게시판</title>

<style>
		.table{
			width:1000px;
			margin: 0auto;
			text-align: center;
		}
		#pageNavi{
			text-align: center;
			width: 1000px;
			margin: 0 auto;
		}
		
		#pageNavi>*{
			magin: 10px;
			
		}
		
		.selectPage{
			font-size: 18px;
			color: blue;
		}
		
		
	</style>


</head>
<body>

 <jsp:include page="/WEB-INF/views/common/header.jsp" />

<section class="container">
		<h1>사진 게시판</h1>

		
		<table class="table table-striped">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>

			<c:forEach items="${list }" var="n">
				<tr>
					<td>${n.noticeNo }</td>
					<td>${n.noticeTitle }</td>
					<td>${n.noticeWriter }</td>
					<td>${n.noticeDate }</td>
				</tr>
			</c:forEach>
		</table>
		

		<div id="pageNavi">${pageNavi }</div>
	</section>
		
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
	
</body>
</html>