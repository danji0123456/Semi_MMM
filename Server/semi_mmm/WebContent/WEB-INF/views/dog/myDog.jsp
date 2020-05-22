<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 댕댕이</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="container">
<div id="mypageArea" style="margin: 0 auto; width:1100px;border: 1px solid  #E4E8EB;">
<jsp:include page="/WEB-INF/views/member/mypageMenu.jsp" />
<style>
.mypage-menu>li:nth-child(2) {background-color: #B6EAFA;}
.table a {display:block; cursor:pointer;}
</style>
<script>
function popupOpen(dogId) {
		var popUrl = "/showDog?dogId="+dogId;
		var popOption = "width=1100, height=550, resizable=no, scrollbars=yes, status=no;"; 
		window.open(popUrl,"",popOption);
	}
</script>

<h2>내 강아지 리스트</h2>
	<table class="table table-striped">
		<tr>
			<td style="text-align:center;">강아지 이름</td>
			<td style="text-align:center;">강아지 사진</td>
		</tr>
		<c:forEach items="${dog }" var="d">
		
		<c:if test="${empty d}">
		<td colspan="2" style="text-align:center;">강이지 정보가 없습니다</td>
		</c:if>
		<c:if test="${not empty d}">
			<tr>
				<td style="text-align:center; line-height:200px; font-size:25px; font-weight:bold;"><a onclick="popupOpen('${d.dogId}');">${d.dogName }</a></td>
				<td style="text-align:center;"><img src="/upload/dogImg/${d.dogImg}" style="width:300px; height:200px;"></td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
	<div>
	<button style="float:right; margin: 20px;" class="btn btn-primary" onclick="location.href='/insertMyDog'">등록하기</button>
	</div>
</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>