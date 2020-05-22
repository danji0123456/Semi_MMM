<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시글 보기 - ${article.articleNoticeTitle}</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
<style>
    .container {
        padding-top: 20px;
        padding-bottom: 20px;
    }

    .container>h5, .container>h3, .container>h4 {
        margin-left: 50px;
        margin-bottom: 10px;
        margin-top: 10px;
    }

    .content {
        margin: 0 auto;
        margin-top: 10px;
        margin-bottom: 10px;
        width: 90%;
    }

    .container>h3>button {
        float: right;
        color: #545454;
        border: 1px solid #FFA6C2;
        background-color: white;
        margin-right: 20px;
        font-weight: bold;
        height: 26px;
        line-height: 26px;
        padding: 0;
        width: 50px;
    }

    .container>h3>button:hover {
        background-color: #FFA6C2;
        color: white;
    }

    .comment {
        width: 95%;
        margin: 0 auto;
    }

    .comment>h4>button {
        float: right;
    }

    .container>h5>span {
        float: right;
        margin-right: 50px;
    }

    .commentWrite {
        width: 95%;
        margin-top: 30px;
        margin: 0 auto;
        overflow: hidden;
    }

    .commentWrite>form>* {
        float: left;
    }

    .commentWrite textarea {
        width: 90%;
        resize: none;
    }

    .commentWrite button {
        left: 30px;
        margin-top: 30px;
    }

    .container>h4 {
        overflow: hidden;
    }

    .container>h4>* {
        float: left;
    }

    .container>h4>span {
        display: inline-block;
        line-height: 80px;
    }

    #soldBox {
        display: inline-block;
        width: 80px;
        height: 80px;
        background-position: center;
        background-size: contain;
        background-repeat: no-repeat;
    }

    #soldText {
        font-size: 0.8em;
        font-weight: bold;
    }

    .commentOneBox {
        width: 100%;
        height: auto;
        font-size: 18px;
        padding-top: 10px;
        padding-bottom: 5px;
        border-top: 2px solid rgba(0, 0, 0, 0.2);
    }

    .commentOneBox>div {
        display: inline-block;
        vertical-align: middle;
    }
    
    .commentOneBox>div>span {
        word-break: break-all;
        white-space: pre-line;
    }
    
    .commentOneBox a, .commentOneBox a:hover, .commentOneBox a:focus {
        text-decoration: none;
        color: black;
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
    }
    
    .commentOneBox>div:first-child {
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
    }
    
    .commentOneBox textarea {
        resize: none;
    }
    
    .commentOneBox>div:nth-of-type(3) {
        font-size: 0.7em;
        font-weight: bolder;
    }
</style>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container">
		<h5>중고장터 > ${article.articleNoticeCategory1 } >
			${article.articleNoticeCategory2 }</h5>
		<h3>${article.articleNoticeTitle }
			<c:if
				test="${sessionScope.member.memberId == article.articleNoticeWriter }">
				<button class="btn" id="delete">삭제</button>
				<button class="btn" id="modify">수정</button>
			</c:if>
		</h3>
		<h5>
			작성자 : ${memberNickname }<span>작성일 :
				${article.articleNoticeDate }</span>
		</h5>
		<h4>
			<span>구매여부 : </span>
			<div id="soldBox"></div>
			<span id="soldText"></span>
		</h4>
		<hr>
		<div class="content">${article.articleNoticeContent }</div>
		<hr>
		<c:if test="${not empty sessionScope.member.memberId}">
			<div class="commentWrite">
				<form action="/articleCommentWrite" method="post">
					<input type="hidden" name="articleRef"
						value="${article.articleNoticeNo}"> <input type="hidden"
						name="articleCommentWriter"
						value="${sessionScope.member.memberId}"> <input
						type="hidden" name="articleCommentRef" value="0"> <input
						type="hidden" name="articleCommentLevel" value="1">
					<textarea rows="5" name="articleCommentContent"></textarea>
					<button class="btn btn-primary" style="margin-bottom: 30px; margin-left: 10px;">댓글
						입력</button>
				</form>
			</div>
			<br>
		</c:if>
		<div class="comment">
			<h4>
				댓글: ${fn:length(list)}개
				<button class="btn btn-info" id="list">목록으로</button>
			</h4>
			<br>
			<br>
			<c:forEach items="${list }" var="comment">
                <!-- 레벨 1에서의 댓글 출력 -->
				<c:if test="${comment.comment.articleCommentLevel == 1}">
					<div class="commentOneBox">
						<div style="width: 15%; padding-left: 1%">
							<c:out value="${comment.nickname}" />
						</div>
						<div style="width: 60%;">
							<span><c:out value="${comment.comment.articleCommentContent }" /></span>
				            <textarea style="width:95%; display: none" name="articleCommentContent"><c:out value="${comment.comment.articleCommentContent }" /></textarea>
						</div>
						<div style="width: 10%;">
							<c:if test="${comment.comment.articleCommentDeleteBool == 0 }">
								<c:out value="${comment.comment.articleCommentDate }" />
							</c:if>
						</div>
						<div style="width: 10%;">
							<table style="width: 100%;">
								<tr>
                                    <td style="width: 33%;">
                                        <c:if test="${(not empty sessionScope.member.memberId) and comment.comment.articleCommentDeleteBool == 0}">
                                            <a href="javascript:void(0)" onclick="reComment(this, ${comment.comment.articleCommentLevel}, ${comment.comment.articleCommentNo })">답글</a>
                                        </c:if>
                                    </td>
                                    <td style="width: 33%;">
                                        <c:if test="${comment.comment.articleCommentWriter == sessionScope.member.memberId and comment.comment.articleCommentDeleteBool == 0}">
                                            <a href="javascript:void(0)" onclick="modifyCommentWrite(this)">수정</a>
                                            <input type="hidden" name="articleCommentNo" value="${comment.comment.articleCommentNo}">
                                        </c:if>
                                    </td>
                                    <td style="width: 33%;">
                                        <c:if test="${comment.comment.articleCommentWriter == sessionScope.member.memberId and comment3.comment.articleCommentRef == comment2.comment.articleCommentNo }">
                                            <a href="javascript:void(0)" onclick="deleteComment(this);">삭제</a>
                                        </c:if>
                                    </td>
								</tr>
							</table>
						</div>
					</div>
				</c:if>
				<c:forEach items="${list }" var="comment2">
                    <!-- 레벨 2에서의 댓글 출력. 레벨 1에서의 댓글 1회당 1번씩 루프를 돌린다 -->
					<c:if
						test="${comment2.comment.articleCommentLevel == 2 and comment2.comment.articleCommentRef == comment.comment.articleCommentNo }">
						<div class="commentOneBox">
							<div style="width: 15%; padding-left: 3%">
								<i class="fas fa-level-up-alt fa-rotate-90"></i>
								<c:out value="${comment2.nickname}" />
							</div>
							<div style="width: 60%;">
								<span><c:out value="${comment2.comment.articleCommentContent }" /></span>
								<textarea style="width:95%; display: none" name="articleCommentContent"><c:out value="${comment2.comment.articleCommentContent }" /></textarea>
							</div>
							<div style="width: 10%;">
								<c:if test="${comment2.comment.articleCommentDeleteBool == 0 }">
									<c:out value="${comment2.comment.articleCommentDate }" />
								</c:if>
							</div>
							<div style="width: 10%;">
								<table style="width: 100%;">
									<tr>
                                        <td style="width: 33%;">
                                            <c:if test="${(not empty sessionScope.member.memberId) and comment2.comment.articleCommentDeleteBool == 0}">
                                                <a href="javascript:void(0)" onclick="reComment(this, ${comment2.comment.articleCommentLevel}, ${comment2.comment.articleCommentNo })">답글</a>
                                            </c:if>
                                        </td>
										<td style="width: 33%;">
                                            <c:if test="${comment2.comment.articleCommentWriter == sessionScope.member.memberId and comment2.comment.articleCommentDeleteBool == 0}">
                                                <a href="javascript:void(0)" onclick="modifyCommentWrite(this)">수정</a>
                                                <input type="hidden" name="articleCommentNo" value="${comment2.comment.articleCommentNo}">
                                            </c:if>
                                        </td>
                                        <td style="width: 33%;">
                                            <c:if test="${comment2.comment.articleCommentWriter == sessionScope.member.memberId and comment2.comment.articleCommentDeleteBool == 0}">
                                                <a href="javascript:void(0)" onclick="deleteComment(this);">삭제</a>
                                            </c:if>
                                        </td>
									</tr>
								</table>
							</div>
						</div>
						<c:forEach items="${list }" var="comment3">
                            <!-- 레벨 3에서의 댓글 출력. 레벨 2에서의 댓글 1회당 1번씩 루프를 돌린다 -->
							<c:if
								test="${comment3.comment.articleCommentLevel == 3 and comment3.comment.articleCommentRef == comment2.comment.articleCommentNo }">
								<div class="commentOneBox">
									<div style="width: 15%; padding-left: 5%">
										<i class="fas fa-level-up-alt fa-rotate-90"></i>
										<c:out value="${comment3.nickname}" />
									</div>
									<div style="width: 60%;">
										<span><c:out value="${comment3.comment.articleCommentContent }" /></span>
								        <textarea style="width:95%; display: none" name="articleCommentContent"><c:out value="${comment3.comment.articleCommentContent }" /></textarea>
									</div>
									<div style="width: 10%;">
										<c:if test="${comment3.comment.articleCommentDeleteBool == 0 }">
											<c:out value="${comment3.comment.articleCommentDate }" />
										</c:if>
									</div>
									<div style="width: 10%;">
										<table style="width: 100%;">
											<tr>
												<td style="width: 33%;"></td>
                                                <td style="width: 33%;">
                                                	<c:if test="${comment3.comment.articleCommentWriter == sessionScope.member.memberId and comment3.comment.articleCommentDeleteBool == 0}">
                                                        <a href="javascript:void(0)" onclick="modifyCommentWrite(this);">수정</a>
                                                        <input type="hidden" name="articleCommentNo" value="${comment3.comment.articleCommentNo}">
                                                    </c:if>
                                                </td>
                                                <td style="width: 33%;">
                                                    <c:if test="${comment3.comment.articleCommentWriter == sessionScope.member.memberId and comment3.comment.articleCommentDeleteBool == 0}">
                                                        <a href="javascript:void(0)" onclick="deleteComment(this);">삭제</a>
                                                    </c:if>
                                                </td>
											</tr>
										</table>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</c:forEach>
		</div>
        <form action="/articleCommentModify" method="post" id="modifyCommentBox" style="display: none;"></form>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
    <script>
        $("#modify").click(function() {
            location.href = "/articleModifyFrm?articleNoticeNo=" + ${article.articleNoticeNo};
        });
        
        $("#delete").click(function() {
            if (confirm("게시글을 삭제하시겠습니까?")) {
                location.href = "/articleDelete?articleNoticeNo=" + ${article.articleNoticeNo};
            }
        });
        
        $("#list").click(function() {
            location.href = "/articleList";
        });
        
        if (${article.articleNoticeSoldBool} == 0) {
            $("#soldBox").css("background-image", "url(/img/sold.png)");
            $("#soldText").html("구매가능");
            $("#soldText").css("color", "blue");
        } else {
            $("#soldBox").css("background-image", "url(/img/soldout.png)");
            $("#soldText").html("판매완료");
            $("#soldText").css("color", "red"); 
        }
        
        function modifyCommentWrite(obj) {
            $(obj).html("수정완료");
            $(obj).attr("onclick", "modifyCommentComplet(this)");
            $(obj).parent().next().children().html("수정취소").attr("onclick", "modifyCommentCancel(this)");
            $(obj).parents("table").parent().prev().prev().children().toggle();
            $(obj).parent().prev().children().toggle();
        }
        
        //댓글 수정용 메소드
        //입력받은 데이터를 modifyCommentBox form에 넣은 다음 submit을 보낸다.
        function modifyCommentComplet(obj) {
            var form = $("#modifyCommentBox");
            $(form).append($(obj).next());
            $(form).append($(obj).parents("table").parent().prev().prev().children("textarea"));
            $(form).append($("<input type='hidden' name='articleNoticeNo' value='" + ${article.articleNoticeNo} + "'>"));
            $(form).submit();
        }
        
        function modifyCommentCancel(obj) {
            $(obj).html("삭제");
            $(obj).attr("onclick", "deleteComment(this)");
            $(obj).parent().prev().children().html("수정").attr("onclick", "modifyCommentWrite(this)");
            $(obj).parents("table").parent().prev().prev().children().toggle();
            $(obj).parent().prev().prev().children().toggle();
        }
        
        function deleteComment(obj) {
            if(confirm("해당 댓글을 삭제하시겠습니까?")) {
                location.href = "/articleCommentDelete?articleCommentNo=" + $(obj).parent().prev().children("input").val() + "&articleNoticeNo=" + ${article.articleNoticeNo};
            }
        }
        
        function reComment(obj, level, commentNo) {
        	$(obj).parents("table").toggle();
            var comment = $(obj).parents(".commentOneBox");
            
            var commentBox = $("<div class='commentOneBox'></div>");
            
            var first = $("<div style='width: 15%; padding-left: " + (level * 2 + 1) + "%'></div>");
            first.append("<i class='fas fa-level-up-alt fa-rotate-90'></i>");
            commentBox.append(first);
            
            var seccond = $("<div style='width: 70%;'></div>");
            var form = $("<form action='/articleCommentWrite' method='post'></from>");
            form.append("<input type='hidden' name='articleRef'	value='${article.articleNoticeNo}'>");
            form.append("<input type='hidden' name='articleCommentWriter' value='${sessionScope.member.memberId}'>");
            form.append("<input	type='hidden' name='articleCommentRef' value='" + commentNo + "'>");
            form.append("<input	type='hidden' name='articleCommentLevel' value='" + (level + 1) + "'>");
            form.append("<textarea style='width:95%;' name='articleCommentContent'></textarea>");
            seccond.append(form);
            commentBox.append(seccond);
            
            var third = $("<div style='width: 10%; font-weight: normal; font-size: 1.0em'></div>");
            var table = $("<table style='width: 100%'></table>");
            var tbody = $("<tbody></tbody>");
            var tr = $("<tr></tr>");
            tr.append("<td style='width: 33%'><a href='javascript:void(0)' onclick='reCommentWrite(this)'>입력</a><td>");
            tr.append("<td style='width: 33%'><a href='javascript:void(0)' onclick='reCommentCancel(this)'>취소</a><td>");
            tbody.append(tr);
            table.append(tbody);
            third.append(table);
            commentBox.append(third);
            
            comment.after(commentBox);
        }
        
        function reCommentWrite(obj) {
            $(obj).parents(".commentOneBox").find("form").submit();
        }
        
        function reCommentCancel(obj) {
            var comment = $(obj).parents(".commentOneBox");
            comment.prev().find("table").toggle();
            comment.remove();
        }

    </script>

</html>
