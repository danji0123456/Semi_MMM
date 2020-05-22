<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<title>댓글 상세보기</title>
</head>
<body>
	<h3>작성자 : ${comment.noticeCommentWriter} </h3>
    <h5>작성일 : ${comment.noticeCommentDate} </h5>
    <h4><a style='text-decoration: none' href='javascript:void(0)' onclick="page()">작성 게시글로 이동</a></h4>
    <hr>
    <div>
    	${comment.contentBr }
    </div>
    <hr>
	<div style='text-align: center'>
		<c:if test="${comment.noticeCommentBool eq 0 }">
    		<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
    		background-color: black; color: white; font-size: 15px; border: none' onclick='deleteConfirm();'>삭제</button>
    	</c:if>
    	<c:if test="${comment.noticeCommentBool eq 1 }">
        	<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
        	background-color: black; color: white; font-size: 15px; border: none' onclick='recoveryConfirm();'>복구</button>
        </c:if>
        <button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
        background-color: black; color: white; font-size: 15px; border: none' onclick='self.close();'>취소</button>
	</div>
	<script>
		function page() {
			opener.parent.location.href = "/adminNoticeRead?noticeNo=${comment.noticeCommentRef}";
		}
		
		function deleteConfirm() {
			if (confirm("댓글 삭제하시겠습니까?")) {
				location.href = "/adminNoticeCommentDelete?noticeCommentNo=${comment.noticeCommentNo}";
			}
		}
		
		function recoveryConfirm() {
			if (confirm("댓글을 복구하시겠습니까?")) {
				location.href = "/adminNoticeCommentRecovery?noticeCommentNo=${comment.noticeCommentNo}";
			}
		}
	</script>
</body>
</html>