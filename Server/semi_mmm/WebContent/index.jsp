<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>

</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MMM</title>
</head>

<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container">
		<div id="carousel-area">
			<div id="demo" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>
				<!-- The slideshow -->	
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/img/doghos.png" alt="병원이래">
					</div>
					<div class="carousel-item">
						<img src="/img/dogpark.png" alt="공원이래">
					</div>
					<div class="carousel-item">
						<img src="/img/parkwan.png" alt="박완규잉">
					</div>
				</div>
				<!-- Left and right controls -->
				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a> <a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</div>
		<div id="content" style="display: flex; margin: 0 auto; width:1300px;">
		<div id="community">
				<c:forEach items="${list }" var="n">
						<c:choose>
        <c:when test="${n.noticeImgs eq n.noticeImgs }">
					<div style="width: 33%; height: 400px; display: inline-block; margin-bottom: 2%;">
					<a href="/noticeView?noticeNo=${n.noticeNo }"><img src="${n.noticeImgs}" class="rounded" alt="Cinque Terre" style="width: 100%; height: 100%;">
					</a>
					<div style="border: 1px solid black;">
					<div style=" margin: 0 auto; text-align: center; overflow:hidden; width:350px; text-overflow: ellipsis; white-space:nowrap;  font-weight: bold;">${n.noticeTitle }</div>
					<div><div style="float: left; margin-left: 1%; display: inline-block; color: gray;">${n.noticeWriter }</div><div style="text-align: right; margin-right: 1%;">${n.noticeDate }</div></div>
					</div>
				</div>
				</c:when>
			</c:choose>
			</c:forEach>
			</div>
		<div id="market">
		<p>이곳을 번개장터 미리보기<p>
		</div>
	<div id="dessert-show">
	<p>이곳을 디저트 샵<p></div>
	</div>
	</div>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>

</html>
