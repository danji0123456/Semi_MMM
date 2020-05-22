<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 -->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Adimn - 메인 페이지</title>
<link href="/admin/css/tg_styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
<style>
nav a {
	cursor: pointer;
}

</style>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">

	<a class="navbar-brand" href="/admin" style="height: 100%"><img
		src="/admin/img/logo.png" style="height: 100%">&nbsp;관리자 페이지</a>
	<button class="btn btn-link btn-sm order-1 order-lg-0"
		id="sidebarToggle" href="/admin">
		<i class="fas fa-bars"></i>
	</button>
	<!-- Navbar Search-->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
	</form>
	<!-- Navbar-->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			id="userDropdown" href="#" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"><i
				class="fas fa-user fa-fw"></i></a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="/logout">Logout</a>
			</div></li>
	</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Core</div>
					<a class="nav-link" href="/admin">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> 관리자 메인 페이지
					</a>
					<div class="sb-sidenav-menu-heading">게시글 관리</div>
					<a class="nav-link collapsed" data-toggle="collapse"
						data-target="#collapseLayouts" aria-expanded="false"
						aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> 자랑게시판 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav"> <a class="nav-link"
							href="/adminNoticeList?reqPage=1">게시글 관리</a> <a class="nav-link"
							href="/adminCommentList?reqPage=1">댓글 관리</a> </nav>
					</div>
					<a class="nav-link collapsed" data-toggle="collapse"
						data-target="#collapsePages" aria-expanded="false"
						aria-controls="collapsePages">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> Q&A 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePages"
						aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav accordion"
							id="sidenavAccordionPages"> <a class="nav-link"
							href="/adminQnaList?reqPage=1">질문 관리</a> <a class="nav-link"
							href="/adminAnswerList?reqPage=1">응답 관리</a> </nav>
					</div>
					<a class="nav-link collapsed" data-toggle="collapse"
						data-target="#collapseArticle" aria-expanded="false"
						aria-controls="collapseArticle">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> 중고장터 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseArticle"
						aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav accordion"
							id="sidenavAccordionArticle"> <a class="nav-link"
							href="/adminArticleNoticeList?reqPage=1">게시글 관리</a> <a class="nav-link"
							href="/adminArticleCommentList?reqPage=1">댓글 관리</a> </nav>
					</div>
					<div class="sb-sidenav-menu-heading">회원관리</div>
					<a class="nav-link" href="/adminUserList?reqPage=1">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> 일반 회원
					</a> <a class="nav-link" href="/adminBusinessList?reqPage=1">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> 사업자 회원
					</a>
					<div class="sb-sidenav-menu-heading">사이트관리</div>
					<a class="nav-link" href="/adminFnaList?reqPage=1">
						<div class="sb-nav-link-icon">
							<i class="fas fa-columns"></i>
						</div> F&A 관리
					</a>
				</div>
			</div>
			<div class="sb-sidenav-footer">
				<div class="small">Logged in as:</div>
				Administrator Page
			</div>
			</nav>
		</div>
		<style>
            .notice_box {
                width: 100%;
                margin: auto;
                height: 500px;
            }
            
            .notice_box>h2 {
                margin: 0;
                margin-left: 5%;
                padding-top: 1%;
                font-weight: bolder;
            }
            
            .notice_box>hr {
                width: 95%;
                margin: 0 auto;
                margin-top: 10px;
                margin-bottom: 10px;
            }
            
            .content_box {
                float: left;
                width: 49.8%;
                height: 90%;
                margin: 0 auto;
                box-sizing: padding-box;
            }
            
            .content_box>h5 {
                width: 80%;
                margin: 0 auto;
                margin-top: 1%;
            }
            
            .content_box>h5>a {
                display: block;
                text-decoration: none;
                float: right;
                font-size: 0.8em;
                margin-top: 10px;
                color: black;
            }
            
            .content_box>hr {
                width: 90%;
                text-align: center;
            }
            
            .table_box {
                width: 80%;
                margin: 0 auto;
            }
            
            .table_tr {
                width: 100%;
            }
            
            .table_tr>div {
                height: 50px;
                line-height: 50px;
                float: left;
                overflow: hidden;
                text-overflow: ellipsis;
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
            }
            
            .table_tr>div:first-child, .table_tr>div:last-child {
                width: 20%;
                text-align: center;
            }
            
            .table_tr>div:nth-of-type(2) {
                width: 58%;
                padding-left: 5%;
                padding-right: 5%;
            }
            
            .table_tr:first-child {
                font-weight: bolder;
                text-align: center;
            }
            
            .member_tr a {
                text-decoration: none;                
            }
            
            .member_tr {
                width: 100%;
            }
            
            .member_tr>div {
                height: 50px;
                line-height: 50px;
                float: left;
                overflow: hidden;
                text-overflow: ellipsis;
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                width: 33%;
                text-align: center;
            }
            
            .member_tr:first-child {
                font-weight: bolder;
            }
            
            .member_tr a {
                text-decoration: none;                
            }
		</style>
        <script>
            function articlePopup(articleCommentNo) {
                var status = "left=500px, top=100px, width=600px, height=300px, menubar=no, status=no,scrollbars=yes";
                var title = "adminArticleComment";
                var url = "/adminArticleComment";
                var popup = window.open("", title, status);
                
                $("input[name=articleCommentNo]").val(articleCommentNo);
                $("#page").attr("action", url);
                $("#page").attr("method", "post");
                $("#page").attr("target", title); //새로 열린 popup창과 form 태그를 연결
                $("#page").submit();
            }
            
            function noticePopup(noticeCommentNo) {
                var status = "left=500px, top=100px, width=600px, height=300px, menubar=no, status=no,scrollbars=yes";
                var title = "adminNoticeComment";
                var url = "/adminNoticeComment";
                var popup = window.open("", title, status);
                
                $("input[name=noticeCommentNo]").val(noticeCommentNo);
                $("#page").attr("action", url);
                $("#page").attr("method", "post");
                $("#page").attr("target", title); //새로 열린 popup창과 form 태그를 연결
                $("#page").submit();
            }
            
            function answerPopup(answerNo) {
                var status = "left=500px, top=100px, width=1200px, height=800px, menubar=no, status=no,scrollbars=yes";
                var title = "adminQnaAnswer";
                var url = "/adminQnaAnswer";
                var popup = window.open("", title, status);
                
                $("input[name=answerNo]").val(answerNo);
                $("#page").attr("action", url);
                $("#page").attr("method", "post");
                $("#page").attr("target", title); //새로 열린 popup창과 form 태그를 연결
                $("#page").submit();
            }
            
            function memberPopup(memberId) {
                var status = "left=500px, top=100px, width=1200px, height=800px, menubar=no, status=no,scrollbars=yes";
                var title = "adminMemberInfo";
                var url = "/adminMemberInfo";
                var popup = window.open("", title, status);
                
                $("input[name=memberId]").val(memberId);
                $("#page").attr("action", url);
                $("#page").attr("method", "post");
                $("#page").attr("target", title); //새로 열린 popup창과 form 태그를 연결
                $("#page").submit();
            }
            
            function shopPopup(memberId) {
                var status = "left=500px, top=100px, width=1200px, height=800px, menubar=no, status=no,scrollbars=yes";
                var title = "adminShopInfo";
                var url = "/adminShopInfo";
                var popup = window.open("", title, status);
                
                $("input[name=memberId]").val(memberId);
                $("#page").attr("action", url);
                $("#page").attr("method", "post");
                $("#page").attr("target", title); //새로 열린 popup창과 form 태그를 연결
                $("#page").submit();
            }
            
            $(function() {
                var aTag = $(".table_tr>div:nth-of-type(2)").children();

                for (var i = 0; i < aTag.length; i++) {
                    aTag.eq(i).html(aTag.eq(i).html().replace(/(<([^>]+)>)/ig,""));
                }
            })
        </script>
		<div id="layoutSidenav_content">
			<main>
                <form id="page">
                    <input type="hidden" name="articleCommentNo">
                    <input type="hidden" name="noticeCommentNo">
                    <input type="hidden" name="answerNo">
                    <input type="hidden" name="memberId">
                </form>
				<div class="notice_box">
                    <h2>자랑게시판 관리</h2>
                    <hr>
                    <div class="content_box">
                        <h5>게시글 목록<a href="/adminNoticeList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="table_tr">
                                <div>게시글번호</div>
                                <div>제목</div>
                                <div>작성자</div>
                            </div>
                            <c:forEach items="${info.notice }" var="notice">
                            	<c:if test="${notice.noticeDeleteBool eq 0 }">
                            		<div class="table_tr delete_false">
                                        <div>${notice.noticeNo }</div>
                                        <div><a class="delete_false" href="/adminNoticeRead?noticeNo=${notice.noticeNo }">${notice.noticeTitle }</a></div>
                                        <div>${notice.noticeWriter }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${notice.noticeDeleteBool eq 1 }">
                            		<div class="table_tr delete_true">
                                        <div>${notice.noticeNo }</div>
                                        <div><a class="delete_true" href="/adminNoticeRead?noticeNo=${notice.noticeNo }">${notice.noticeTitle }</a></div>
                                        <div>${notice.noticeWriter }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="content_box">
                        <h5>댓글 목록<a href="/adminCommentList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="table_tr">
                                <div>댓글번호</div>
                                <div>댓글내용</div>
                                <div>작성자</div>
                            </div>
                            <c:forEach items="${info.noticeComment }" var="noticeComment">
                            	<c:if test="${noticeComment.noticeCommentBool eq 0 }">
                            		<div class="table_tr delete_false">
                                        <div>${noticeComment.noticeCommentNo }</div>
                                        <div><a class="delete_false" href="javascript:void(0)" onclick="noticePopup(${noticeComment.noticeCommentNo })">${noticeComment.noticeCommentContent }</a></div>
                                        <div>${noticeComment.noticeCommentWriter }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${noticeComment.noticeCommentBool eq 1 }">
                            		<div class="table_tr delete_true">
                                        <div>${noticeComment.noticeCommentNo }</div>
                                        <div><a class="delete_true" href="javascript:void(0)" onclick="noticePopup(${noticeComment.noticeCommentNo })">${noticeComment.noticeCommentContent }</a></div>
                                        <div>${noticeComment.noticeCommentWriter }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
				</div>
				<div class="notice_box">
                    <h2>Q&A 관리</h2>
                    <hr>
                    <div class="content_box">
                        <h5>질문 목록<a href="/adminQnaList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="table_tr"> 
                                <div>질문번호</div>
                                <div>제목</div>
                                <div>작성자</div>
                            </div>
                            <c:forEach items="${info.qna }" var="qna">
                            	<c:if test="${qna.qnaNoticeDeleteBool eq 0 }">
                            		<div class="table_tr delete_false">
                                        <div>${qna.qnaNoticeNo }</div>
                                        <div><a class="delete_false" href="/adminQnaNoticeRead?qnaNoticeNo=${qna.qnaNoticeNo }">${qna.qnaNoticeTitle }</a></div>
                                        <div>${qna.qnaNoticeWriter }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${qna.qnaNoticeDeleteBool eq 1 }">
                            		<div class="table_tr delete_true">
                                        <div>${qna.qnaNoticeNo }</div>
                                        <div><a class="delete_true" href="/adminQnaNoticeRead?qnaNoticeNo=${qna.qnaNoticeNo }">${qna.qnaNoticeTitle }</a></div>
                                        <div>${qna.qnaNoticeWriter }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="content_box">
                        <h5>응답 목록<a href="/adminAnswerList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="table_tr"> 
                                <div>응답번호</div>
                                <div>응답내용</div>
                                <div>작성자</div>
                            </div>
                            <c:forEach items="${info.qnaAnswer }" var="qnaAnswer">
                            	<c:if test="${qnaAnswer.answerDeleteBool eq 0 }">
                            		<div class="table_tr delete_false">
                                        <div>${qnaAnswer.answerNo }</div>
                                        <div><a class="delete_false" href="javascript:void(0)" onclick="answerPopup(${qnaAnswer.answerNo })">${qnaAnswer.answerContent }</a></div>
                                        <div>${qnaAnswer.answerWriter }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${qnaAnswer.answerDeleteBool eq 1 }">
                            		<div class="table_tr delete_true">
                                        <div>${qnaAnswer.answerNo }</div>
                                        <div><a class="delete_true" href="javascript:void(0)" onclick="answerPopup(${qnaAnswer.answerNo })">${qnaAnswer.answerContent }</a></div>
                                        <div>${qnaAnswer.answerWriter }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
				</div>
				<div class="notice_box">
                    <h2>중고장터 관리</h2>
                    <hr>
                    <div class="content_box">
                        <h5>게시글 목록<a href="/adminArticleNoticeList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="table_tr"> 
                                <div>게시글번호</div>
                                <div>제목</div>
                                <div>작성자</div>
                            </div>
                            <c:forEach items="${info.article }" var="article">
                            	<c:if test="${article.articleNoticeDeleteBool eq 0 }">
                            		<div class="table_tr delete_false">
                                        <div>${article.articleNoticeNo }</div>
                                        <div><a class="delete_false" href="/adminArticleRead?articleNoticeNo=${article.articleNoticeNo }">${article.articleNoticeTitle }</a></div>
                                        <div>${article.articleNoticeWriter }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${article.articleNoticeDeleteBool eq 1 }">
                            		<div class="table_tr delete_true">
                                        <div>${article.articleNoticeNo }</div>
                                        <div><a class="delete_true" href="/adminArticleRead?articleNoticeNo=${article.articleNoticeNo }">${article.articleNoticeTitle }</a></div>
                                        <div>${article.articleNoticeWriter }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="content_box">
                        <h5>댓글 목록<a href="/adminArticleCommentList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="table_tr">
                                <div>댓글번호</div>
                                <div>댓글내용</div>
                                <div>작성자</div>
                            </div>
                            <c:forEach items="${info.articleComment }" var="articleComment">
                            	<c:if test="${articleComment.articleCommentDeleteBool eq 0 }">
                            		<div class="table_tr delete_false">
                                        <div>${articleComment.articleCommentNo }</div>
                                        <div><a class="delete_false" href="javascript:void(0)" onclick="articlePopup(${articleComment.articleCommentNo })">${articleComment.articleCommentContent }</a></div>
                                        <div>${articleComment.articleCommentWriter }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${articleComment.articleCommentDeleteBool eq 1 }">
                            		<div class="table_tr delete_true">
                                        <div>${articleComment.articleCommentNo }</div>
                                        <div><a class="delete_true" href="javascript:void(0)" onclick="articlePopup(${articleComment.articleCommentNo })">${articleComment.articleCommentContent }</a></div>
                                        <div>${articleComment.articleCommentWriter }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
				</div>
				<div class="notice_box">
                    <h2>회원 관리</h2>
                    <hr>
                    <div class="content_box">
                        <h5>일반 회원 목록<a href="/adminUserList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="member_tr">
                                <div>아이디</div>
                                <div>닉네임</div>
                                <div>가입일</div>
                            </div>
                            <c:forEach items="${info.member }" var="member">
                            	<c:if test="${member.memberLevel eq 1 }">
                            		<div class="member_tr delete_false">
                                        <div><a class="delete_false" href="javascript:void(0)" onclick="memberPopup('${member.memberId }')">${member.memberId }</a></div>
                                        <div>${member.memberNickname }</div>
                                        <div>${member.enrollDate }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${member.memberLevel eq 3 }">
                            		<div class="member_tr delete_true">
                                        <div><a class="delete_true" href="javascript:void(0)" onclick="memberPopup('${member.memberId }')">${member.memberId }</a></div>
                                        <div>${member.memberNickname }</div>
                                        <div>${member.enrollDate }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="content_box">
                        <h5>사업자 회원 목록<a href="/adminBusinessList?reqPage=1">more <i class="fas fa-plus" style="font-size: 0.7em;"></i></a></h5>
                        <hr>
                        <div class="table_box">
                            <div class="member_tr">
                                <div>아이디</div>
                                <div>닉네임</div>
                                <div>가입일</div>
                            </div>
                            <c:forEach items="${info.shop }" var="shop">
                            	<c:if test="${shop.memberLevel eq 2 }">
                            		<div class="member_tr delete_false">
                                        <div><a class="delete_false" href="javascript:void(0)" onclick="shopPopup('${shop.memberId }')">${shop.memberId }</a></div>
                                        <div>${shop.memberNickname }</div>
                                        <div>${shop.enrollDate }</div>
                            	   </div>
                            	</c:if>
                            	<c:if test="${shop.memberLevel eq 4 }">
                            		<div class="member_tr delete_true">
                                        <div><a class="delete_true" href="javascript:void(0)" onclick="shopPopup('${shop.memberId }')">${shop.memberId }</a></div>
                                        <div>${shop.memberNickname }</div>
                                        <div>${shop.enrollDate }</div>
                            	   </div>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
			<div class="container-fluid">
				<div class="d-flex align-items-center justify-content-between small">
					<div class="text-muted">Copyright &copy; Your Website 2019</div>
					<div>
						<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
							&amp; Conditions</a>
					</div>
				</div>
			</div>
			</footer>
		</div>
	</div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="/admin/js/tg_scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
</body>
</html>