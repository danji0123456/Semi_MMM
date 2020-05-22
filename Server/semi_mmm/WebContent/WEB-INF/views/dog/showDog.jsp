<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${oneDog.dogName }</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css?after">
<link rel="stylesheet" href="/css/content.css?after">
</head>
<script>
var joinNameOk = true;
var joinAgeOk = true;
$(function() {
	$("#dogName").change(function() {
		if ($("#dogName").val() == "") {
			$("#dogName").css("border", "3px solid red");
			joinNameOk = false;
		} else {
			$("#dogName").css("border", "3px solid #76D5FF");
			 var value = $(this).val();
             getVal(value, $(this));
		}
	});
	$("#dogAge").change(function() {
		if ($("#dogAge").val() == "") {
			$("#dogAge").css("border", "3px solid red");
			joinAgeOk = false;
		} else {
			$("#dogAge").css("border", "3px solid #76D5FF");
			 var value = $(this).val();
             getVal(value, $(this));
		}
	});
	 
});
function getVal(val, what) {
    var regExp = "";
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
	if (joinNameOk == false || joinAgeOk == false) {
		alert("필수 입력 정보를 입력해주세요");
		return false;	
	} else {
		return true;	
	}
	return false;
}
function deleteDog(dogId) {
	var result = confirm("정말 삭제하실 건가요?");
	if(result) {
		window.location.href="/deleteDog?dogId="+dogId;
	} 
}
</script>
<body>
<div id="mypageArea" style="margin: 0 auto; width:1100px;border: 1px solid  #E4E8EB;">
<style>
#joinForm{width: 1000px;margin: 0 auto;padding-top: 50px; padding-bottom: 50px;padding-right:20px;}
#left>div>label {width:20%;}
.input-lg {width:80%; border: 1px solid black;}
</style>
<form action="/updateDog" id="updateForm" method="post" enctype="multipart/form-data">
<input type="hidden" value="${member.memberId }" name="memberId" id="memberId">
  <legend>내 강아지 정보</legend>
<div style="display:flex">
<div id="left" style="width:70%;border:1px solid black; padding: 20px;">
<div><label for="dogid">* 강이지 등록번호</label><input type="text" value="${oneDog.dogId }" id="dogId" name="dogId" class="input-lg" readonly/></div>
 <input type="hidden" id="checkId" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly><br>
<div><label for="dogName">* 강아지 이름</label><input type="text" id="dogName" name="dogName" class="input-lg" value="${oneDog.dogName }"/></div><br>
<div style="display:flex; line-height:100px;"><label for="variety">&nbsp;&nbsp;강아지 품종</label>
<select name="dogCate" size="4">
<c:if test="${empty var[0] }"><option value="대형견">대형견</option><option value="중형견">중형견</option><option value="소형견">소형견</option></c:if>
<c:if test="${not empty var[0] }">
<c:if test="${var[0] eq '대형견'}">
<option value="대형견" selected>대형견</option><option value="중형견">중형견</option><option value="소형견">소형견</option></c:if>
<c:if test="${var[0] eq '중형견'}">
<option value="대형견" >대형견</option><option value="중형견" selected>중형견</option><option value="소형견">소형견</option></c:if>
<c:if test="${var[0] eq '소형견'}">
<option value="대형견" >대형견</option><option value="중형견">중형견</option><option value="소형견" selected>소형견</option></c:if></c:if>						
</select>
<input type="text" id="variety" name="variety" class="input-lg" style="margin-left:20px; width:70%; margin-top:28px;" value="${var[1] }"/></div><br>
<div><label for="dogAge">* 강아지 나이</label><input type="text" id="dogAge" name="dogAge" value="${oneDog.age }" class="input-lg"/></div><br>
<div><label for="dogGenderM">&nbsp;&nbsp;강아지 성별</label>
<c:if test="${oneDog.dogGender eq 'null' }">
<input type="radio" id="dogGenderM" name="dogGender" value="m" />&nbsp;M&nbsp;&nbsp;
<input type="radio" id="dogGenderW" name="dogGender" value="w"/>&nbsp;W
</c:if>
<c:if test="${oneDog.dogGender eq 'm' }">
<input type="radio" id="dogGenderM" name="dogGender" value="m" checked/>&nbsp;M&nbsp;&nbsp;
<input type="radio" id="dogGenderW" name="dogGender" value="w"/>&nbsp;W
</c:if>
<c:if test="${oneDog.dogGender eq 'w' }">
<input type="radio" id="dogGenderM" name="dogGender" value="m" />&nbsp;M&nbsp;&nbsp;
<input type="radio" id="dogGenderW" name="dogGender" value="w" checked/>&nbsp;W
</c:if></div><br>
  </div>
  <div id="right" style="width:30%; text-align:center; border:1px solid black; border-left: 0px;"><p style="margin:10px; font-weight:bold;">* 댕댕이 사진</p>
  <div style="border-bottom: 1px solid black;border-top: 1px solid black">
  	<div style="width:100%;  padding:30px; margin:0 auto;">
  	  	<img src="/upload/dogImg/${oneDog.dogImg }"  style="width:100%; height:90%;">
  	  	<input type="hidden" value="${oneDog.dogImg }" name="dogOriginImg">
  	</div><input type="file" value="사진 선택" name="dogImg" style="border:0px; margin: 10px;">
  </div>
  </div>
  </div>

<button type="submit" style="float:right; margin: 20px;" class="btn btn-primary" onclick="return sub();">수정하기</button>
<button type="button" style="float:right; margin: 20px;" class="btn btn-sumarry" onclick="deleteDog('${oneDog.dogId }');">삭제하기</button>
  </form>
  </div>
</body>
</html>