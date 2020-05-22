<%@page import="dog.model.vo.*"%>
<%@page import="notice.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<title>이미지 게시판</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>

<style>
		.table{
			width:1000px;
			margin: 0auto;
			text-align: center;
		}
		#pageNavi{
			text-align: center;
			width: 1000px;
			margin: 0 auto;
		}
		
		#pageNavi>*{
			magin: 10px;
			
		}
		
		.selectPage{
			font-size: 18px;
			color: blue;
		}

	</style>


</head>
<body>

 <jsp:include page="/WEB-INF/views/common/header.jsp" />

<div class="container">
		<h1>커뮤니티 </h1>
		<c:if test="${not empty sessionScope.member.memberId }">
		  		<div style="text-align: right;">
		  			<button id="logining" class="btn btn-lg btn-primary btn-block" style=" width:100px; height: 40px; line-height: 100%; display: inline-block; font-size: 20px; margin-bottom: 1%;" type="submit" onclick="location.href='/noticeDog?memberId=${sessionScope.member.memberId }'">글쓰기</button>
		  			<input type="hidden" name="memberId" value="${sessionScope.member.memberId }">
		  		</div>
		  	</c:if>
		  	
		  	<c:if test="${not empty sessionScope.shop.memberId }">
		  		<div style="text-align: right;">
		  			<button id="logining" class="btn btn-lg btn-primary btn-block" style=" width:100px; height: 40px; line-height: 100%; display: inline-block; font-size: 20px; margin-bottom: 1%;" type="submit" onclick="location.href='/noticeDog?memberId=${sessionScope.shop.memberId }'">글쓰기</button>
		  			<input type="hidden" name="memberId" value="${sessionScope.shop.memberId }">
		  		</div>

		  	</c:if>
		  	

	
	
				<c:forEach items="${list }" var="n">
						<c:choose>
        <c:when test="${n.noticeImgs eq n.noticeImgs }">
					<div style="width: 33%; height: 400px; display: inline-block; margin-bottom: 2%;">
					<a href="/noticeView?noticeNo=${n.noticeNo }&memberId=${n.noticeWriter }">
					
					<img src="${n.noticeImgs}" class="rounded" alt="Cinque Terre" style="width: 100%; height: 100%;">
					</a>
					<div style="border: 1px solid black;">
					<div style=" margin: 0 auto; text-align: center; overflow:hidden; width:350px; text-overflow: ellipsis; white-space:nowrap;  font-weight: bold;">${n.noticeTitle }</div>
					<div><div style="float: left; margin-left: 1%; display: inline-block; color: gray;">${n.noticeWriter }</div><div style="text-align: right; margin-right: 1%;">${n.noticeDate }</div></div>
					</div>
				</div>
				</c:when>
			</c:choose>
			</c:forEach>
			

		
		<div id="pageNavi" style=" margin-top: 3%;">${pageNavi }</div>
		

	
		<table style="margin: 0 auto; margin-bottom: 2%; margin-top: 2%">
		<tr>
		  <td style="width: 20%; text-align: center;">
		  	<select>
		  	<option>제목</option>
		  	<option>내용</option>
		  	<option>작성자</option>
		  	</select>
		  </td>
		
		  <td style="width: 60%;"><input type="text" style="width: 100%;"></td>
		  
		   <td style="width: 20%;">
		   <form action="/noticeWriteFrm" method="post">
		  	<button id="logining" class="btn btn-lg btn-primary btn-block" style=" width:100px; height: 30px; line-height: 40%; display: inline-block; margin-left: 10%; font-size: 20px;" type="submit">검색</button>
		  </form>
		  </td>
		  
		</tr>
		</table>
	</div>
		
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
	
</body>

	<script>
		$("#write-btn").click(function(){
			location.href="/photoWriteFrm";
		});
		
		function fn_more(start){
			var param = {start:start};
			$.ajax({
				url : "/photoMore",
				data : param,
				type : "post",
				dataType : "json",
				
				success : function(data){
					var html = "";
					for(var i=0; i<data.length;i++){
						html += "<div class='border border-dark' style='width350px; margin:0 auto; margin-bottom:10px;'>";
						html += "<img src='/upload/photo/"+data[i].photoFilepath+"' width='100%'>";
						html += "<p class='caption'>"+data[i].photoContent+"</p></div>";
					}
					$("#photo-wrapper").append(html);
					$("#more-btn").val(Number(start)+5);
					$("#more-btn").attr("currentCount",Number($('#more-btn').attr("currentCount"))+data.length);
					var totalCount = $("#more-btn").attr("totalCount");
					var currentCount =  $("#more-btn").attr("currentCount");
					if(totalCount == currentCount){
						$("#more-btn").attr("disabled",true);
						$("#more-btn").css("cursor","not-allowed");
					}
				},
				
				error : function(){
					console.log("실패");
				}
			});
		}

	</script>
</html>