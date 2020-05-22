<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    	.mypage-menu>li {
    	display:inline-block;
    	width: 200px;
    	height: 50px;
    	line-height: 50px;
    	cursor: pointer;
    	border-bottom-left-radius: 10px;
    	border-bottom-right-radius:  10px;
    	border-top-left-radius: 10px;
    	border-top-right-radius: 10px;
    	}
    	.mypage-menu>li:hover {
    	background-color: #E4E8EB ;
    	}
    	.mypage-menu>li>a {
    		text-decoration: none;
    	}
    </style>
    <div style="width:100%; height:50px;">
<ul style="list-style:none; margin:0 auto; text-align:center;" class="mypage-menu">
	<li><a href="/mypageMain?memberId=${member.memberId }">개인정보</a></li>
	<li><a href="/myDog?memberId=${member.memberId }">내 강아지 등록</a></li>
	<li><a href="/showMyList?memberId=${member.memberId }&reqPage=1">내 글보기</a></li>
	<li><a href="/myCart?memberId=${member.memberId }">장바구니</a></li>
</ul>
</div>