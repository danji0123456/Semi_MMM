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
<title>Adimn - F&A 관리 페이지</title>
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
            table {
                width: 90%;
                margin: 0 auto;
                margin-top: 20px;
            }
            
            table>tbody, table tr {
                width: 100%;
            }
            
            table tr {
                border-top: 1px solid rgba(0, 0, 0, 0.2);
                padding-top: 10px;
                padding-bottom: 10px;
                height: 50px;
            }
            
            tbody>tr:first-child {
                text-align: center;
                font-weight: bold;
            }
            
            tr>td:first-child, tr>td:nth-of-type(2) {
                width: 5%;
                text-align: center;
                font-weight: bold;
            }
            
            tr>td:nth-of-type(3), tr>td:last-child {
                width: 45%;
                padding-left: 5px;
            	padding-right: 5px;
            }
            
            .btnArea {
            	text-align: center;
            	margin: 30px;
            }
            
        </style>
		<div id="layoutSidenav_content">
			<main>
				<h1 style="margin: 20px;">F&A 관리</h1>
                <table>
                    <tr>
                        <td></td>
                        <td>번호</td>
                        <td>질문</td>
                        <td>응답</td>
                    </tr>
                    <c:forEach items="${list }" var="data">
	                    <tr>
	                        <td>
	                            <input type="radio" name="radio">
	                            <input type="hidden" value="${data.fna.qnaNo }">
	                        </td>
	                        <td>${data.rnum }</td>
	                        <td>${data.fna.question }</td>
	                        <td>${data.fna.answer }</td>
	                    </tr>
                    </c:forEach>
                </table>
                <div class="btnArea">
                    <button id="insertBtn" class="btn btn-primary">추가</button>
                    <button id="modifyBtn" class="btn btn-primary">수정</button>
                    <button id="deleteBtn" class="btn btn-primary">삭제</button>
                </div>
                <form action="/adminFnaPopup" id="fna" method="post">
                	<input type="hidden" name="type" id="type">
                	<input type="hidden" id="qnaNo" name="qnaNo" >
                </form>
                <script>
                	$("#insertBtn").click(function() {
            			var status = "left=500px, top=100px, width=600px, height=400px, menubar=no, status=no,scrollbars=yes";
            			var title = "adminFnaPopup";
            			var popup = window.open("", title, status);
            			
                		$("#type").val("insert");
            			$("#fna").attr("target", title);
                		$("#fna").submit();
                	});
                	$("#modifyBtn").click(function() {
                		var radio = $("input[type=radio]");
                		var i;
                		
                		for (i = 0; i < radio.length; i++) {
                			if (radio.eq(i).prop("checked") == true) {
                				break;
                			}
                		}
                		
                		if (i == radio.length) {
                			alert("수정할 항목을 선택하세요.");
                			return;
                		} else {
                			var status = "left=500px, top=100px, width=600px, height=400px, menubar=no, status=no,scrollbars=yes";
                			var title = "adminFnaPopup";
                			var popup = window.open("", title, status);

                			$("#type").val("modify");
                			$("#qnaNo").val(radio.eq(i).next().val());
                			$("#fna").attr("target", title);
                			$("#fna").submit();
                		}
                		
                	});
                	$("#deleteBtn").click(function() {
                		var radio = $("input[type=radio]");
                		var i;
                		
                		for (i = 0; i < radio.length; i++) {
                			if (radio.eq(i).prop("checked") == true) {
                				break;
                			}
                		}
                		
                		if (i == radio.length) {
                			alert("삭제할 항목을 선택하세요.");
                			return;
                		} else {
                            if (confirm("해당 F&A를 삭제하시겠습니까?")) {
                                location.href = "/adminFnaDelete?qnaNo=" + radio.eq(i).next().val();
                            }
                		}
                	});
                </script>
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