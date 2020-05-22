<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가게 정보 상세보기</title>
</head>
<style>
	body {
		width: 99%;
		padding-left: 5%;
		padding-right: 5%;
		padding-top: 20px;
		padding-bottom: 20px;
        box-sizing: border-box;
	}
	
	img {
		width: 100%;
	}
	
	.dogArea {
		width: 90%;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	
	a {
		text-decoration: none;
		color: blue;
	}
</style>
<body>
	<h2>가게 정보</h2>
	<h4>아이디 : ${data.member.memberId }</h4>
	<h4>가게이름 : ${data.member.memberNickname }</h4>
	<h4>이름 : ${data.member.memberName }</h4>
	<h4>전화번호 : ${data.member.phone }</h4>
	<h4>주소 : ${data.member.spaceAddr }</h4>
	<h4>가입일 : ${data.member.enrollDate }</h4>
	<h4>사업자 번호 : ${data.shop.shopId }</h4>
	<h4>사업자 은행 : ${data.shop.shopBank }</h4>
	<h4>사업자 계좌 : ${data.shop.shopBankAccount }</h4>
	<h4>프로필 이미지 : 
		<c:if test="${not empty data.member.profileImg }">
			<img src="/upload/memberImg/${data.member.profileImg }" style="width: 200px;">
		</c:if>
	</h4>
	<hr>
	<c:forEach items="${data.products }" var="product">
		<h4>제품명 : ${product.product.productTitle }</h4>
		<h4>옵션 종류</h4>
		<c:forEach items="${product.options }" var="option">
			<h5>- 옵션명 : ${option.optionTitle } / 가격 : ${option.optionPrice }원</h5>
		</c:forEach>
	</c:forEach>
	<div style='text-align: center'>
		<c:if test="${data.member.memberLevel eq 2 }">
	    	<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
	    	background-color: black; color: white; font-size: 15px; border: none' onclick='deleteConfirm();'>정지</button>
	    </c:if>
	    <c:if test="${data.member.memberLevel eq 4 }">
	       	<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
	       	background-color: black; color: white; font-size: 15px; border: none' onclick='recoveryConfirm();'>복구</button>
	    </c:if>
	    <button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
	    background-color: black; color: white; font-size: 15px; border: none' onclick='self.close();'>취소</button>
	</div>
	<script>
		
		function deleteConfirm() {
			if (confirm("계정을 정지시키겠습니까?")) {
				location.href = "/adminMemberDelete?memberId=${data.member.memberId }&memberLevel=${data.member.memberLevel}";
			}
		}
		
		function recoveryConfirm() {
			if (confirm("계정을 복구하시겠습니까?")) {
				location.href = "/adminMemberRecovery?memberId=${data.member.memberId }&memberLevel=${data.member.memberLevel}";
			}
		}
	</script>
</body>
</html>