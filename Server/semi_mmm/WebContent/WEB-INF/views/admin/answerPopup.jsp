<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		img {
			width: 100%;
		}
	</style>
</head>
<body>
	<h3>작성자 : ${answer.answerWriter} </h3>
    <h5>작성일 : ${answer.answerDate} </h5>
    <h4><a style='text-decoration: none' href='javascript:void(0)' onclick="page()">작성 게시글로 이동</a></h4>
    <hr>
    <div>
    	${answer.answerContent }
    </div>
    <hr>
	<div style='text-align: center'>
		<c:if test="${answer.answerDeleteBool eq 0 }">
    		<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
    		background-color: black; color: white; font-size: 15px; border: none' onclick='deleteConfirm();'>삭제</button>
    	</c:if>
    	<c:if test="${answer.answerDeleteBool eq 1 }">
        	<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
        	background-color: black; color: white; font-size: 15px; border: none' onclick='recoveryConfirm();'>복구</button>
        </c:if>
        <button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
        background-color: black; color: white; font-size: 15px; border: none' onclick='self.close();'>취소</button>
	</div>
	<script>
		function page() {
			opener.parent.location.href = "/adminQnaNoticeRead?qnaNoticeNo=${answer.qnaNoticeNo}";
		}
		
		function deleteConfirm() {
			if (confirm("응답을 삭제하시겠습니까?")) {
				location.href = "/adminQnaAnswerDelete?articleCommentNo=${answer.answerNo}";
			}
		}
		
		function recoveryConfirm() {
			if (confirm("응답을 복구하시겠습니까?")) {
				location.href = "/adminQnaAnswerRecovery?articleCommentNo=${answer.answerNo}";
			}
		}
	</script>
</body>
</html>