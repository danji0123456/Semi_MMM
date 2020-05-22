<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<title>회원가입</title>
</head>
<style>
table>tbody>tr>td{padding: 10px;}
#joinForm{width: 1000px;margin: 0 auto;padding-top: 50px; padding-bottom: 50px;padding-right:20px;}
td>img{
width:150px; height:150px; box-shadow: 1px 1px #E4E8EB; padding:10px;cursor: pointer;
}
td>img:hover{
box-shadow: 1px 1px .5px .5px gray;
}
</style>
<script>
$(function(){
	$("#personal").click(function(){
		location.href="/joinFrm";
	});
	$("#company").click(function(){
		location.href="/comJoinFrm";
	});
});
</script>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<style>
	p {margin:0 auto;}
	</style>
<div class="container">
  <div style="padding: 30px; border:.5px solid #E4E8EB; text-align:center;" >
	<h3>회원가입</h3>
	<hr style="border: .5px solid #E4E8EB;"><br>
	<table style="margin:0 auto;">
		<tr style="padding: 40px;">
		<td colspan="2"><p style="font-size: 30px; display:block; padding-left:130px;" >안녕하세요</p></td><td colspan="2"><p style="font-size: 30px; color:#76D5FF; padding-right:150px;">MMM 입니다!</p></td>
		<tr>
		<tr><td colspan="4"><p style="font-size: 15px;  text-align:center;">저희 MMM은 개인회원과 사업자으로 구분되어지며,</p></td></tr>
		<tr><td colspan="4"><p style="font-size: 15px; text-align:center;">회원가입시 다양한 서비스를 누릴 수 있습니다</p></td></tr>
		<tr>
		<td colspan="4"><p style="font-size: 15px; text-align:center; color:#76D5FF;">(* 개인회원과 사업자는 서로 전환되지 않습니다!)</p></td>
		</tr>
		<tr>
		<td style="padding:40px;">
		<img src="/img/personalimg.png" id="personal">
		</td>
		<td style="padding-right:40px;">
		개인회원입니다
		</td>
		<td style="padding:40px;">
		<img src="/img/companyimg.png" id="company">
		</td>
		<td style="padding-right:40px;">
		기업회원
		</td>
		</tr>
	</table>
   </div>
</div>
   <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>