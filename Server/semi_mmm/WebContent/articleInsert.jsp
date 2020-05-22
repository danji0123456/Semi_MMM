<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
%>
<%    
    //제대로 utf-8환경이 아니라 한글 깨짐 그래서 임의로 추가                                                   
    request.setCharacterEncoding("utf-8");
    
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    //콘솔 출력
    System.out.println("제목:"+title);
    System.out.println("내용:"+content);    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>

	<style type="text/css">
		.con{
			width: 100%;
			margin: 0 auto;
		}
	
		.content{
			width: 80%;
			text-align: center;
			border: 1px solid black; 
			margin: 0 auto;
		}
		
		.title{
			width: 80%;
			text-align: center;
			border: 1px solid black; 
			margin: 0 auto;
		}
		
	</style>

</head>
<body>

	<div class="con">
		<div class="title"><%=title %></div>
		
		<div class="content"><%=content %></div>
	
	</div>

</body>
</html>