<%@page import="dog.model.vo.Dog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>

<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->
<script type="text/javascript" src="/sm/js/HuskyEZCreator.js" charset="utf-8"></script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
<style>

		.contentBox{
			text-align: center;
            margin: 0 auto;
		}
        .context{
            text-align: center;
            margin: 0 auto;

        }
        #ir1{
        	padding-left: 10%;
        }
        #title{
        	font-size: 22px;
        }
        .btnst{
            color: black;
            background-color: #B6EAFA;
            width: 100px;
            height: 50px;
            border: 0px solid white;
            border-radius: 10px;
            margin-top: 10px;
            margin-left: 10px; 
        }



    </style>
    


<div class="contentBox">


<div class="context">
   


<table width="100%">
  
        <tr>
            <td>
              
              <textarea rows="10" cols="30" id="ir1" name="content" style="width:100%; height:600px;">
               
              		${n.noticeContent }
      
              </textarea>

            </td>
        </tr>
</table>
</div>
</div>


<script type="text/javascript">
$(function(){
		
var oEditors = [];

// 추가 글꼴 목록
//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "ir1",
	sSkinURI: "sm/SmartEditor2Skin2.html",	
	htParams : {
		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		//bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
		//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
		fOnBeforeUnload : function(){
			//alert("완료!");
		}
	}, //boolean
	fOnAppLoad : function(){
		//예제 코드
		//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
	},
	fCreator: "createSEditor2"
		
});



//저장버튼 클릭시 form 전송
$("#save").click(function(){
    oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
    $("#frm").submit();
	});    
});

</script>
