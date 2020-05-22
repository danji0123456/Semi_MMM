<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="container">
   <div style="padding: 50px; border: .5px solid #E4E8EB; text-align:center;" >
   		<h2>회원 가입 완료!</h2>
   		<hr stlye="border: .5px solid #E4E8EB;">
   		<br>
   		<h4>회원 가입을 축하드립니다!</h4>
   		<h4>MMM에서 다양한 서비스를 누려보세요!</h4>
   		<br><br>
   		<span>
   		<button class="btn btn-lg btn-secondary btn-lg signup-btn" style="display:inline-block;" onclick="location.href='/'">홈으로</button>
   		<button class="btn btn-lg btn-primary btn-lg signup-btn" style="display:inline-block;" onclick="location.href='/loginFrm'">로그인</button>
   		</span>
   		<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
   </div>
   
   </div>
   <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>