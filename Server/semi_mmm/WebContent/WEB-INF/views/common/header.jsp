<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css?after">
<link rel="stylesheet" href="/css/content.css?after">
<link rel="stylesheet" href="/css/menu.css?after">
<link rel="stylesheet" href="/css/ham-menu1.css?after">
<script type="text/javascript" src="/js/header.js?after"></script>
<style>
.logoutImg {
width: 0px;
height: 0px;
}
@media screen and (max-width: 1200px) {
  #header .logout, .userName{
    display: none;
  }
}
@media screen and (max-width: 1200px) {
 .logoutImg {
   width: 20px;
   height: 20px;
  }
}
.profile {
    width: 50px;
    height: 50px;
    object-fit: cover;
    border-radius: 70%;
}
</style>
    <div id="header" style="height:100px;">
        <div id="navbar">
            <div id="navbar_menu">
                <div id="wrapper_menu">
                    <div id="line-wrapper" href="javascript:void(0)" class="closebtn" onclick="openNav()">
                        <!-- 추가된 부분 -->
                        <div id="line-top" class="line init top-reverse" style="background-color:#545454;"></div>
                        <div id="line-mid" class="line init mid-reverse" style="background-color:#545454;"></div>
                        <div id="line-bot" class="line init bot-reverse" style="background-color:#545454;"></div>
                    </div>
                    <div id="mySidepanel" class="sidepanel">
                        <a href="/info" class="openbtn">회사소개</a>
                        <a href="/articleList" class="openbtn">중고장터</a>
                        <a href="/shopMain" class="openbtn">디저트</a>
                        <a href="/noticeList?reqPage=1" class="openbtn">커뮤니티</a>
                        <a href="/map" class="openbtn">함께 할 수 있는 곳</a>
                        <a href="/fna" class="openbtn">F & A</a>
                    </div>

                </div>
            </div>
            <div id="navbar_logo">
            </div>
            <div id="navbar_login">
            <c:if test="${not empty sessionScope.member.memberId }">
                <span style="font-size:20px;" >
                <img class="profile" src="/upload/memberImg/${sessionScope.member.profileImg }">&nbsp;&nbsp;&nbsp;
                <a href="/myPage?memberId=${sessionScope.member.memberId }" style="text-decoration:none; color:#545454;" class="userName">
                [ ${sessionScope.member.memberNickname } ]&nbsp; 님</a> </span>
                <span style="font-size:20px;" >
                <a onclick="location.href='/logout'" style="cursor: pointer;" class="logout">로그아웃</a>
                <a onclick="location.href='/logout'" style="cursor: pointer;"><img src="/img/logout.png"class="logoutImg"></a></span>
                </c:if>
               <c:if test="${not empty sessionScope.shop.memberId }">
                <span style="font-size:20px;">
                <img class="profile" src="/upload/memberImg/${sessionScope.shop.profileImg }">&nbsp;&nbsp;&nbsp;
                 <a href="/shopPage?memberId=${sessionScope.shop.memberId }"  style="text-decoration:none; color:#545454; " class="userName">[ ${sessionScope.shop.memberNickname } ]&nbsp; 님</a></span>
                <span style="font-size:20px;" >
                <a onclick="location.href='/logout'" style="cursor: pointer;" class="logout">로그아웃</a>
                <a onclick="location.href='/logout'" style="cursor: pointer;"><img src="/img/logout.png"class="logoutImg"></a></span>  
                </c:if>  
                <c:if test="${empty sessionScope.member.memberId && empty sessionScope.shop.memberId }">
                 <span style="font-size:20px;"><a href="/loginFrm" style="text-decoration:none; color:#545454;">로그인</a></span>
                <span style="font-size:20px;"><a href="/joinSelect" style="text-decoration:none; color:#545454;">회원가입</a></span>
                </c:if>
            </div>
        </div>
    </div>

