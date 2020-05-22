<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
		<section class="container">
			<h1>글작성</h1>
			<form id="frm" action="/insertNotice" method="post">
				<table class="table table-bordered">
					
					<tr>
						<td colspan="2">
							<div style="width: 15%; float: left; text-align: center; line-height: 40px;"> 
							작성자 : ${sessionScope.member.memberNickname }
								   ${sessionScope.shop.memberNickname }
								  
								  
							</div>
							
							
							 <c:if test="${not empty sessionScope.member.memberId }">
							<input type="hidden" name="imgeNoticeWriter" value="${sessionScope.member.memberId }">
							</c:if>
							 <c:if test="${not empty sessionScope.shop.memberId }">
							<input type="hidden" name="imgeNoticeWriter" value="${sessionScope.shop.memberId }">
							</c:if>
							
							
							<!--  <input type="hidden" name="imgeNoticeWriter" value="${sessionScope.shop.memberId }"> -->
							<input type="text" class="form-control" name="imgeNoticeTitle" style="width: 85%;" placeholder="제목을 입력해주세요.">
							<input type="hidden" name="imgeNoticeNo" value="${noticeNo }">
							<input type="hidden" name="dogName" value="${dog.dogName }">
						</td>
					</tr>
					
					<tr>
						<td>
							<jsp:include page="/WEB-INF/views/common/smartEditorForm.jsp" />
						</td>
					</tr>
					
					<tr style="text-align: center;">
						<th colspan="2">
							<input type="button" class="btn btn-outline-primary" id="save" value="작성">
							<button type="button" class="btn btn-outline-primary"  onclick="location.href='/noticeList?reqPage=1'">취소</button>
						</th>
					</tr>
				</table>
				</form>
		</section>

</body>
</html>