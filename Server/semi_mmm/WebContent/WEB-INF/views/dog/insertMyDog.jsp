<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<script>
var joinIdOk = false;
var joinNameOk = false;
var joinAgeOk = false;
$(function() {
	$("#dogId").blur(function() {
		if ($("#dogId").val() == "") {
			$("#dogId").css("border", "3px solid red");
		} else {
			 var value = $(this).val();
             getVal(value, $(this));
		}
	});
	$("#dogName").blur(function() {
		if ($("#dogName").val() == "") {
			$("#dogName").css("border", "3px solid red");
		} else {
			$("#dogName").css("border", "3px solid #76D5FF");
			 var value = $(this).val();
             getVal(value, $(this));
		}
	});
	$("#dogAge").blur(function() {
		if ($("#dogAge").val() == "") {
			$("#dogAge").css("border", "3px solid red");
		} else {
			$("#dogAge").css("border", "3px solid #76D5FF");
			 var value = $(this).val();
             getVal(value, $(this));
		}
	});
	 
});
function getVal(val, what) {
    var regExp = "";
    if (what.attr("id") == "dogId") {
        regExp = /^[a-zA-Z0-9]{4,15}$/;
        if (!regExp.test(val)) {
       	what.css("border", "3px solid red");
       	what.focus();
        } else {
			$.ajax({
				url : "/checkDogId",
				type : "get",
				data : {
					val : val
				},
				success : function(data) {
					console.log(data);
					if (data == true) {
						what.css("border", "3px solid red");
						$("#checkId").prop("type","text");
						$("#checkId").val("등록번호가 중복입니다");
					} else {
						what.css("border", "3px solid #76D5FF");
						$("#checkId").prop("type","hidden");
						joinIdOk = true;
					}
				}
			});
		}
	}
    if (what.attr("id") == "dogName") {
    	regExp = /^[가-힣]{1,10}$/;
    	if (!regExp.test(val)) {
    		what.css("border", "3px solid red");
    		what.focus();
    	} else {
    		pwchk = val;
    		what.css("border", "3px solid #76D5FF");
    		joinNameOk = true;
    	}
    }
    if (what.attr("id") == "dogAge") {
		regExp = /^[1-9]{1}$|^[1-3]{1}[0-8]{1}$/;
		if (!regExp.test(val)) {
			what.css("border", "3px solid red");
			what.focus();
		} else {
			pwchk = val;
			what.css("border", "3px solid #76D5FF");
			joinAgeOk = true;
		}
	}
}


function sub() {
	if (joinIdOk == false || joinNameOk == false || joinAgeOk == false) {
		alert("필수 입력 정보를 입력해주세요");
		return false;	
	} else {
		return true;	
	}
	return false;
	
}

</script>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="container">
<div id="mypageArea" style="margin: 0 auto; width:1100px;border: 1px solid  #E4E8EB;">
<jsp:include page="/WEB-INF/views/member/mypageMenu.jsp" />
<style>
.mypage-menu>li:nth-child(2) {background-color: #B6EAFA;}
#joinForm{width: 1000px;margin: 0 auto;padding-top: 50px; padding-bottom: 50px;padding-right:20px;}
#left>div>label {width:20%;}
.input-lg {width:80%; border: 1px solid black;}
</style>
<form action="/addDog" id="updateForm" method="post" enctype="multipart/form-data">
<input type="hidden" value="${member.memberId }" name="memberId" id="memberId">
  <legend>강이지 등록</legend>
<div style="display:flex">
<div id="left" style="width:70%;border:1px solid black; padding: 20px;">
<div><label for="dogid">* 강아지 등록번호</label><input type="text" id="dogId" name="dogId" class="input-lg" placeholder="실제 등록번호 4~15 문자입력"/></div>
 <input type="hidden" id="checkId" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly><br>
<div><label for="dogName">* 강아지 이름</label><input type="text" id="dogName" name="dogName" class="input-lg" placeholder="이름은 1~10자 사이"/></div><br>
<div style="display:flex; line-height:100px;"><label for="variety">&nbsp;&nbsp;강아지 품종</label>
<select name="dogCate" size="4">
							<option value="대형견">대형견</option>
							<option value="중형견">중형견</option>
							<option value="소형견">소형견</option>
</select>
<input type="text" id="variety" name="variety" class="input-lg" style="margin-left:20px; width:70%; margin-top:28px;"/></div><br>
<div><label for="dogAge">* 강아지 나이</label><input type="text" id="dogAge" name="dogAge" placeholder="1~38세까지" class="input-lg"/></div><br>
<div><label for="dogGenderM">&nbsp;&nbsp;강아지 성별</label><input type="radio" id="dogGenderM" name="dogGender" value="m" />&nbsp;M&nbsp;&nbsp;
<input type="radio" id="dogGenderW" name="dogGender" value="w"/>&nbsp;W</div><br>
  </div>
  <div id="right" style="width:30%; text-align:center; border:1px solid black; border-left: 0px;"><p style="margin:10px; font-weight:bold;">* 댕댕이 사진</p>
  <div style="border-bottom: 1px solid black;border-top: 1px solid black">
  	<div style="width:100%;  padding:30px; margin:0 auto;">
  	  	<img src="/upload/dogImg/noDogImg.png"  style="width:100%; height:90%;">
  	</div><input type="file" value="사진 선택" name="dogImg" style="border:0px; margin: 10px;">
  </div>
  </div>
  </div>

<button type="submit" style="float:right; margin: 20px;" class="btn btn-primary" onclick="return sub();">등록하기</button>
  </form>
</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>