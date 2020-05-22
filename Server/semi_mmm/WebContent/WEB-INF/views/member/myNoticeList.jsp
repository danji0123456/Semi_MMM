<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내가 쓴 글</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="container">
<div id="mypageArea" style="margin: 0 auto; width:1100px;border: 1px solid  #E4E8EB;">
<jsp:include page="/WEB-INF/views/member/mypageMenu.jsp" />
<style>.mypage-menu>li:nth-child(3) {background-color: #B6EAFA;}
.table{width:1000px;margin: 0auto;text-align: center;}
#pageNavi{text-align: center;width: 1000px;margin: 0 auto;}
#pageNavi>*{magin: 10px;	}
.selectPage{font-size: 18px;color: blue;}</style>

<c:forEach items="${list }" var="n">
		<c:choose>
        <c:when test="${n.noticeImgs eq n.noticeImgs }">
					<div style="width: 33%; height: 400px; display: inline-block; margin-bottom: 2%; padding: 20px;">
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
			<div id="pageNavi" style=" margin-top: 3%;">${pageNavi }</div>
			</div>
			</div>
   <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>