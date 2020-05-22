<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/css/login-box.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<title>로그인</title>
</head>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
	<jsp:include page="/WEB-INF/views/common/header.jsp" />	 
	<div class="card align-middle" style="width:50rem; border-radius:20px;">
		<div class="card-title" style="margin-top:20px;">
			<h2 class="card-title text-center" style="color:#113366;">로그인</h2>
		</div>
		<div class="card-body">
        <h5 class="form-signin-heading" id="show-result">로그인 정보를 입력하세요</h5>
        <label for="inputEmail" class="sr-only">Your ID</label>
        <input type="text" name="memberId" id="uid" class="form-control" placeholder="Your ID" required autofocus><BR>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="memberPw" id="upw" class="form-control" placeholder="Password" required><br>
        <button id="logining" class="btn btn-lg btn-primary btn-block" type="submit">로 그 인</button>
		</div>
	</div>
	<div class="modal">
	</div>
	<br><br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
	<script>
		$("#logining").click(function() {
			var level = $('input[name="userlevel"]:checked').val();
			var memberId = $("#uid").val();
			var memberPw = $("#upw").val();
			var user = {
					level : level,
					memberId : memberId,
					memberPw : memberPw
			}
			$("#show-result").html("");
			$.ajax({
				url : "/login",
				data : user,
				type : "post",
				success : function(data) {
					if(data == 1) {
						$("#show-result").html("&nbsp;로그인 정보가 맞지않습니다!");
						$("#show-result").css("color","red");
						$("#show-result").css("font-weight","bold");
					} else if(data == 2) {
						$("#show-result").html("&nbsp;정지된 계정입니다!");
						$("#show-result").css("color","red");
						$("#show-result").css("font-weight","bold");
					} else if(data == 0) {
						window.location.href = "/admin";
					}
					else if (data == 3 ){
						window.location.href = "/";
					}
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "error:" + error);
				}
			});
		});
		$("#upw").keydown(function(key) {

			if (key.keyCode == 13) {
				$("#logining").click();
			}
			});



	</script>
</body>


</html>

