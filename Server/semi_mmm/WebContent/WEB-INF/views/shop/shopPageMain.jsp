<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${m.memberNickname } 님의 마이페이지</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="container">
<div id="mypageArea" style="margin: 0 auto; width:1100px;border: 1px solid  #E4E8EB;">
<jsp:include page="/WEB-INF/views/shop/shopPageMenu.jsp" />
 <style>.mypage-menu>li:first-child {background-color: #B6EAFA;}
#joinForm{width: 1000px;margin: 0 auto;padding-top: 50px; padding-bottom: 50px;padding-right:20px;}
.input-lg {width:80%; border: 1px solid black;}
#left>div>label {width:15%;}
 </style>
 <script>
 function addrSearch() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#postCode").val(data.zoneCode);
				$("#roadAddr").val(data.roadAddress);
				$("#jibunAddr").val(data.jibunAddress);
			}
		}).open();
	}
 	var nickChk = "${m.memberNickname }";
	var pwchk = "";
	var pwChkOk = true;
	var pwOk = true;
	var nickNameOk = true;
	var nextOk = true;
	$(function() {
		$(".input-lg").change(function() {
			if ($(this).val() == "") {
				$(this).css("border", "3px solid red");
				nextOk = false;
			} else {
                var value = $(this).val();
                nextOk = true;
                getVal(value, $(this));
			}
		});
	});
	 function getVal(val, what) {
         var regExp = "";
		if (what.attr("id") == "pw") {
			regExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			if (!regExp.test(val)) {
				what.css("border", "3px solid red");
				pwOk = false;
			} else {
				pwchk = val;
				what.css("border", "3px solid #76D5FF");
				pwOk = false;
			}
		}
		if (what.attr("id") == "pwchk") {
			if (val != pwchk) {
				what.css("border", "3px solid red");
				$("#checkPw").prop("type","text");
				$("#checkPw").val("비밀번호가 일치하지 않습니다");
				pwChkOk = false;
			} else {
				what.css("border", "3px solid #76D5FF");
				$("#checkPw").prop("type","hidden");
				pwChkOk = true;
				pwOk = true;
			}
		}
		if (what.attr("id") == "name") {
			regExp = /^[가-힣]{2,6}$/;
			if (!regExp.test(val)) {
				what.css("border", "3px solid red");
				what.focus();
			} else {
				pwchk = val;
				what.css("border", "3px solid #76D5FF");
			}
		}
		if (what.attr("id") == "nick") {
			if (nickChk == val) {
				what.css("border", "3px solid #76D5FF");
				$("#checkNick").prop("type","hidden");
				nickNameOk = true;
			} else {
			regExp = /^[가-힣0-9a-zA-Z]{2,10}$/;
			if (!regExp.test(val)) {
				what.css("border", "3px solid red");
				what.focus();
				nickNameOk = false;
			} else {
				$.ajax({
					url : "/checkNick",
					type : "get",
					data : {
						val : val
					},
					success : function(data) {
						console.log(data);
						if (data == true) {
							what.css("border", "3px solid red");
							$("#checkNick").prop("type","text");
							$("#checkNick").val("닉네임이 중복입니다");
						} else {
							what.css("border", "3px solid #76D5FF");
							$("#checkNick").prop("type","hidden");
							nickNameOk = true;
						}
					}
				});
			}
			}
	if (what.attr("id") == "ph2") {
			regExp = /^\d{3,4}$/;
			if (!regExp.test(val)) {
				what.css("border", "3px solid red");
				what.focus();
			} else {
				pwchk = val;
				what.css("border", "3px solid #76D5FF");
			}
		}
		if (what.attr("id") == "ph3") {
			regExp = /^[0-9]{4}$/;
			if (!regExp.test(val)) {
				what.css("border", "3px solid red");
				what.focus();
			} else {
				pwchk = val;
				what.css("border", "3px solid #76D5FF");
			}
		}
		if (what.attr("id") == "detailAddr") {
			if (what.val() == "") {
				what.css("border", "3px solid red");
				what.focus();
			} else {
				what.css("border", "3px solid #76D5FF");
			}
		}
	}
	 }
	 
	 function sub() {
		 if(nextOk == true && pwOk ==true && pwChkOk == true && nickNameOk == true) {
			 return true;
		 }
		 if(pwOk == false) {
			 alert("비밀번호 확인을 해주세요");
		 } else {
	 	 alert("정보가 제대로 수정되지 않았습니다");
		 return false;
		 }
		 return false;
	 }
 </script>
 <form action="/updateMember" id="updateForm" method="post" enctype="multipart/form-data">
  <legend>개인정보</legend>
  <div style="display:flex">
  <div id="left" style="width:70%;border:1px solid black; padding: 20px;">
  <div><label for="id">아이디  &nbsp;</label><input type="text" id="id" name="id"  class="input-lg" value="${m.memberId }" readonly/></div><br>
  <div><label for="pw">비밀번호  &nbsp;</label><input type="password" id="pw" name="pw"  class="input-lg" value="${m.memberPw }"/></div><br>
  <div><label for="pwchk">비번 확인  &nbsp;</label><input type="password" id="pwchk" name="pwchk"  class="input-lg" />
   <input type="hidden" id="checkPw" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly></div><br>
    <div><label for="name">이름  &nbsp;</label><input type="text" name="name" id="name" class="input-lg" value="${m.memberName }"/></div><br>
  <div><label for="nick">샵이름  &nbsp;</label><input type="text" name="nickname" id="nick" class="input-lg" value="${m.memberNickname }"/>
  <input type="hidden" id="checkNick" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly></div><br>
     <div><label for="birth">창업날짜  &nbsp;</label> <input type="text" name="birth" id="birth" class="input-lg" value="${m.memberBirth }" readonly/>
     <input type="hidden" id="checkBirth" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly></div><br>
 <div id="phone_area" style="float:right; width:100%;">
  <label for="ph2" style="width:15%;">연락처  &nbsp;</label>
     <select name="phone1" class="input-lg" style="width:20%;">
     <c:if test="${ph1 eq 010}">
       <option value="010" selected>010</option><option value="011">011</option><option value="016">016</option><option value="017">017</option><option value="019">019</option>
       </c:if>
        <c:if test="${ph1 eq 011}">
       <option value="010" >010</option><option value="011" selected>011</option><option value="016">016</option><option value="017">017</option><option value="019">019</option>
       </c:if>
        <c:if test="${ph1 eq 016}">
       <option value="010" >010</option><option value="011">011</option><option value="016" selected>016</option><option value="017">017</option><option value="019">019</option>
       </c:if>
        <c:if test="${ph1 eq 017}">
       <option value="010" >010</option><option value="011">011</option><option value="016">016</option><option value="017" selected>017</option><option value="019">019</option>
       </c:if>
        <c:if test="${ph1 eq 019}">
       <option value="010" >010</option><option value="011">011</option><option value="016">016</option><option value="017">017</option><option value="019" selected>019</option>
       </c:if>
       
     </select>
     <input type="text" id="ph2" name="phone2" class="input-lg" style="width:30%;" value="${ph2}"/>
     <input type="text" id="ph3" name="phone3" class="input-lg" style="width:30%;" value="${ph3 }"/>
    </div>
    <br><br><br><br>
		<div><label for="detailAddr" style="width:15%;">주소  &nbsp;</label>
		<input id="roadAddr" name="roadAddr" style="display: inline-block; width:36%;" type="text" class="input-lg" value="${addr[0] }"> 
		<input id="jibunAddr" name="jibunAddr" style="display: inline-block; width:36%;" type="text" class="input-lg" value="${addr[1] }">
		<button type="button" id="addrSerachBtn" onclick="addrSearch();" class="btn btn-primary">주소검색</button></div><br>
		<input id="detailAddr" name="detailAddr" style="display: inline-block; width:100%;" type="text" class="input-lg" value="${addr[2] }">
  </div>
  <div id="right" style="width:30%; text-align:center; border:1px solid black; border-left: 0px;"><p style="margin:10px; font-weight:bold;">프로필 사진</p>
  <div style="border-top: 1px solid black;border-bottom: 1px solid black">
  	<div style="width:100%;  padding:30px; margin:0 auto;">
  	<img src="/upload/memberImg/${m.profileImg }"  style="width:100%; height:90%;">
  	<input type="hidden" value="${m.profileImg }" name="memberOriginImg">
  	</div><input type="file" value="사진 선택" name="file" style="border:0px; margin: 10px;">
  </div>
  </div>
  </div>
  <br>
  <br><br>
		  <div style="width:100%; text-align:center; padding:20px;">
		  <input type="hidden" value="${m.memberLevel }" name="memberLevel">
  <button class="btn btn-lg btn-secondary btn signup-btn" type="button" style="width:300px;" onclick="location.href='/'">나가기</button>
  <button class="btn btn-lg btn-primary btn signup-btn" type="submit" style="width:300px;" onclick="return sub();">내 정보 수정</button>
</div>
  </form>
</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>