<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<style>
		div {
			width: 80%;
			margin: 0 auto;
		}
		
		textarea {
			width: 100%;
			margin-top: 20px;
			margin-bottom: 20px;
			resize: none;
		}
		
		.btnArea {
			width: 100%;
			text-align: center;
		}
	</style>
	<div>
		<form method="post">
			<textarea rows="5" name="question" id="question" placeholder="질문을 입력하세요."></textarea>
			<textarea rows="5" name="answer" id="answer" placeholder="응답을 입력하세요."></textarea>
			<div class="btnArea">
	        	<button type="submit" style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
	        	background-color: black; color: white; font-size: 15px; border: none' id="button"></button>
				<button style='width: 70px; height: 30px; margin-right: 10px; margin-left: 10px; 
	        	background-color: black; color: white; font-size: 15px; border: none' onclick='self.close();'>취소</button>
        	</div>
		</form>
		
		<script>
			$(function() {
				if("${type }" == "insert") {
					$("#button").html("입력");
					$("form").attr("action", "/adminFnaInsert");
				} else {
					$("#button").html("수정");
					$("form").append($("<input type='hidden' name='qnaNo' value='${fna.qnaNo}'>"));
					$("#question").val("${fna.question}");
					$("#answer").val("${fna.answer}");
					$("form").attr("action", "/adminFnaModify");
				}
			})
		</script>
	</div>
</body>
</html>