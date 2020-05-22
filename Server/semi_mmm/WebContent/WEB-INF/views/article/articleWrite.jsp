<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/content.css">
<title>중고장터 - 글쓰기</title>
<style>

.container>* {
	margin-left: 10%;
	margin-right: 10%;
	width: 80%;
}

.container>hr {
	margin-top: 20px;
	margin-bottom: 20px;
}

.btnArea {
	margin: 0 auto;
	text-align: center;
	margin-top: 10px;
	margin-bottom: 10px;
}

.btnArea>button {
	width: 100px;
	margin: 10px;
}

.categoryBox {
	text-align: left;
	margin: 10px;
}

select {
	width: 150px;
}

option {
	font-weight: bolder;
}

table {
	margin: 0 auto;
	text-align: center;
}

tr>* {
	width: 20%;
}

input[type="button"] {
	width: 100px;
	margin: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container">
		<h1 style="padding: 10px;">중고장터 글쓰기</h1>
		<hr>
		<form action="/articleWrite" method="post" id="frm">
			<table>
				<tr>
					<th>카테고리 선택 :</th>
					<th><select name="articleNoticeCategory1" style="margin-top: 10px;	margin-bottom: 20px;" size="4" required>
							<option value="대형견">대형견</option>
							<option value="중형견">중형견</option>
							<option value="소형견">소형견</option>
					</select></th>
					<th><select name="articleNoticeCategory2" style="margin-top: 10px;	margin-bottom: 20px;" size="4" required>
							<option value="식품">식품</option>
							<option value="장난감">장난감</option>
							<option value="의상">의상</option>
							<option value="가구">가구</option>
					</select></th>
					<th><input type="hidden"
						value="${sessionScope.member.memberId}" name="articleNoticeWriter">
					</th>
					<th></th>
				</tr>
				<tr>
					<td colspan="5"><jsp:include
							page="/WEB-INF/views/common/smartEditorFormArticle.jsp" /></td>
				</tr>
			</table>

			<div class="btnArea">
				<input type="button" class="btn btn-primary" id="save" value="글쓰기">
				<input type="button" class="btn btn-primary" id="cancel" value="취소">
                <input type="hidden" id="now" value="write">
			</div>
		</form>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>