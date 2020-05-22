<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원 정보 상세보기</title>
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
	<h2>회원 정보</h2>
	<h4>아이디 : ${data.member.memberId }</h4>
	<h4>닉네임 : ${data.member.memberNickname }</h4>
	<h4>이름 : ${data.member.memberName }</h4>
	<h4>생일 : ${data.member.memberBirth }</h4>
	<h4>전화번호 : ${data.member.phone }</h4>
	<h4>주소 : ${data.member.spaceAddr }</h4>
	<h4>가입일 : ${data.member.enrollDate }</h4>
	<h4><a href="javascirpt:void(0)" onclick="page1();">자랑게시판 글쓰기 목록 보기</a></h4>
	<h4><a href="javascirpt:void(0)" onclick="page2();">자랑게시판 댓글 목록 보기</a></h4>
	<h4><a href="javascirpt:void(0)" onclick="page3();">Q&A게시판 질문 목록 보기</a></h4>
	<h4><a href="javascirpt:void(0)" onclick="page4();">Q&A게시판 응답 목록 보기</a></h4>
	<h4><a href="javascirpt:void(0)" onclick="page5();">중고장터 글쓰기 목록 보기</a></h4>
	<h4><a href="javascirpt:void(0)" onclick="page6();">중고장터 댓글 목록 보기</a></h4>
	<h4>프로필 이미지 : 
		<c:if test="${not empty data.member.profileImg }">
			<img src="/upload/memberImg/${data.member.profileImg }" style="width: 200px;">
		</c:if>
	</h4>
	<br>
	<h2>강아지 정보</h2>
	<c:forEach items="${data.dogs }" var="dog">
		<hr>
		<div class="dogArea">
			<h4>이름 : ${dog.dogName }</h4>
			<h4>품종 : ${dog.variety }</h4>
			<h4>나이 : ${dog.age }</h4>
			<h4>성별 : ${dog.dogGender }</h4>
			<h4>이미지</h4>
			<img src="/upload/dogImg/${dog.dogImg }">
		</div>
	</c:forEach>
	<div style='text-align: center'>
		<c:if test="${data.member.memberLevel eq 1 }">
    		<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
    		background-color: black; color: white; font-size: 15px; border: none' onclick='deleteConfirm();'>정지</button>
    	</c:if>
    	<c:if test="${data.member.memberLevel eq 3 }">
        	<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
        	background-color: black; color: white; font-size: 15px; border: none' onclick='recoveryConfirm();'>복구</button>
        </c:if>
        <button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
        background-color: black; color: white; font-size: 15px; border: none' onclick='self.close();'>취소</button>
	</div>
	<script>
		function page1() {
			opener.parent.location.href = "/adminNoticeList?reqPage=1&type=notice_writer&search=${data.member.memberId}";
		}
		function page2() {
			opener.parent.location.href = "/adminCommentList?reqPage=1&type=notice_comment_writer&search=${data.member.memberId}";
		}
		function page3() {
			opener.parent.location.href = "/adminQnaList?reqPage=1&type=qna_notice_Writer&search=${data.member.memberId}";
		}
		function page4() {
			opener.parent.location.href = "/adminAnswerList?reqPage=1&type=answer_writer&search=${data.member.memberId}";
		}
		function page5() {
			opener.parent.location.href = "/adminArticleNoticeList?reqPage=1&type=article_notice_writer&search=${data.member.memberId}";
		}
		function page6() {
			opener.parent.location.href = "/adminArticleCommentList?reqPage=1&type=article_comment_writer&search=${data.member.memberId}";
		}
		
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