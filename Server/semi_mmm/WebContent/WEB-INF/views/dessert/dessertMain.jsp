<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/content.css">
<title>dessertMain</title>
<style>
	.container{
		margin: 0 auto;
        overflow: hidden;
        background-color: gray;
	}
	.sell-list{
		float:left;
		width: 250px;
		height: 300px;
		margin-left: 50px;
		margin-right: 50px;
		margin-top: 70px;
		margin-bottom: 30px;
        list-style: none;
	}
	.sell-list>a{
		text-decoration: none;
		
	}
	.sell-list1{
		width: 100%;
		height: 80%;
		background-color: black;
	}
	.sell-list2{
		width: 100%;
		height: 20%;
		background-color: yellow;
	}
    .sell-list2>div:first-child{
        width:100%;
        height: 50%;
        background-color: blue;
    }
    .sell-list2>div:last-child{
        width:100%;
        height: 50%;
        background-color: aquamarine;
    }
</style>
</head>
<body>
	
	
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container">
		<form action="/dessertMain" method="get">
			<ul>
				<li class="sell-list"><a href="#">
					<div class="sell-list1"></div>
					<div class="sell-list2">
                        <div>상품판매페이지제목(사업자닉네임)</div>
                        <div>사업자이름</div>
                    </div></a>
				</li>
				<li class="sell-list"><a href="#">
					<div class="sell-list1"></div>
					<div class="sell-list2">
                        <div>상품판매페이지제목(사업자닉네임)</div>
                        <div>사업자이름</div>
                    </div></a>
				</li>
				<li class="sell-list"><a href="#">
					<div class="sell-list1"></div>
					<div class="sell-list2">
                        <div>상품판매페이지제목(사업자닉네임)</div>
                        <div>사업자이름</div>
                    </div></a>
				</li>
			</ul>
		</form>
	</div>
   <jsp:include page="/WEB-INF/views/common/footer.jsp" /> 
</body>
</html>