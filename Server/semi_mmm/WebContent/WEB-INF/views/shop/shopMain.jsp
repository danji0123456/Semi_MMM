<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
       ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 
<title>shopMain</title>
<style>
	.sell-list{
		float:left;
		width: 250px;
		height: 100px;
		margin-left: 50px;
		margin-right: 250px;
		margin-top: 70px;
		margin-bottom: 90px;
        list-style: none;
        box-shadow: 7px 7px 20px grey;
	}
    .sell-list>a{
        color: black;
    }
	.sell-list>a:hover{
		text-decoration: none;
        color: darkgray;
		
	}
	.sell-list1{
		width: 100%;
		height: 70%;
		font-size: 25px;
		text-align: center;
        text-decoration: none;
        line-height: 70px;
        border: 5px solid #B6EAFA;
	}
	.sell-list2{
		width: 100%;
		height: 30%;
		background-color: #B6EAFA;
		text-align: right;
        line-height: 35px;
        padding-right: 10px;
        font-weight: 600;
	}
</style>
</head>
<body>
	
	<div id="wrapper">
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container">
		<form action="/sellProductFrm2" method="get">
			<%for(Member m : list) {%>
	         <ul>
	         	<li class="sell-list"> 
	         		<a onclick="location.href='/sellProductFrm2?memberId=<%=m.getMemberId() %>'">
	         			<input type="hidden" name="memberId">
	         			<input type="hidden" name="memberNickname">
	         			<div class="sell-list1" name="memberNickname"><%=m.getMemberNickname() %></div>
                        <div class="sell-list2" ><%=m.getMemberName() %></div>
	         		</a>
	         	</li>
	         </ul>
	         <%} %>
		</form>
         <!--<c:if test="${not empty sessionScope.member }"><!-- 글쓰기는 로그인 한 사람만 할수있게 -->
            <!--<button class="btn btn-outline-info" id="write-btn">글쓰기</button>-->
         <!--</c:if>-->
	         
      </div>
      </div>
      <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>



</html>