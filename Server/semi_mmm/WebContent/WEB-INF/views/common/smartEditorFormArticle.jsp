<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="article.model.vo.ArticleNotice" %>
<%
	String ctx = request.getContextPath(); //콘텍스트명 얻어오기.
%>

<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->
<script type="text/javascript" src="/sm/js/HuskyEZCreator.js" charset="utf-8"></script>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<style>
    .contentBox {
        text-align: center;
        margin: 0 auto;
        width: 1110px;
    }

    .context {
        text-align: center;
        margin: 0 auto;
        width: 1110px;
    }

    #ir1 {
        padding-left: 10%;
    }

    #title {
        font-size: 22px;
    }

    .btnst {
        color: black;
        background-color: #B6EAFA;
        width: 100px;
        height: 50px;
        border: 0px solid white;
        border-radius: 10px;
        margin-top: 10px;
        margin-left: 10px;
    }

    .bigTitle {}

</style>



<div class="contentBox">
    <div class="context">

        <table width="100%">
            <tr>
                <td><input type="text" id="title" name="title" style="width: 1100px; height: 30px;" placeholder="제목을 입력하세요." required /></td>
            </tr>

            <tr>
                <td><textarea rows="10" cols="30" id="ir1" name="content" style="width: 1100px; height: 400px;" placeholder="내용을 입력하세요." required>
                <c:if test="${not empty article }">
                	${article.articleNoticeContent }
                </c:if>
                </textarea>
                </td>
            </tr>
        </table>
        <c:if test="${not empty article }">
            <div id="htmlArea" style="display: none;">
        	   ${article.articleNoticeContent }
            </div>
        </c:if>
    </div>
</div>


<script type="text/javascript">
    $(function() {

        var imgArr = new Array();
        var oEditors = [];
        //에러 방지를 위한 articleNoticeNo 초기화
        var articleNoticeNo = "";

        // 추가 글꼴 목록
        //var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

        nhn.husky.EZCreator.createInIFrame({
            oAppRef: oEditors,
            elPlaceHolder: "ir1",
            sSkinURI: "sm/SmartEditor2Skin.html",
            htParams: {
                bUseToolbar: true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
                bUseVerticalResizer: true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
                bUseModeChanger: true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
                //bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
                //aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
                fOnBeforeUnload: function() {
                    //alert("완료!");
                }
            }, //boolean
            fOnAppLoad: function() {
                //예제 코드
                //oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
            },
            fCreator: "createSEditor2"

        });
        
        if ($("#now").val() == "modify") {
//            oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
            
            //이미지 수정인 경우 기존의 이미지의 src를 저장한다.
//            var context = $("textarea[name=content]").val();
            
            var img = $("#htmlArea").find("img");
            $("#htmlArea").html("");
            
            for (var i = 0; i < img.length; i++) {
                //순회를 하면서 arr에 img태그의 src값을 저장한다.
                imgArr.push($(img).eq(i).attr("src"));
            }
        }

        //저장버튼 클릭시 form 전송
        $("#save").click(function() {
            oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
            
            if ($("#now").val() == "modify") {
                var context = $("textarea[name=content]").val();

                //context 내에서 img 태그만 추출
                var img = $(context).find("img");

                //img 태그에서 src를 저장해 보낼 변수
                var arr = new Array();
                for (var i = 0; i < img.length; i++) {
                    //순회를 하면서 arr에 img태그의 src값을 저장한다.
                    arr.push($(img).eq(i).attr("src"));
                }
                
                for (var i = 0; i < arr.length; i++) {
                    var index = imgArr.indexOf(arr[i]);
                    if (index != -1) {
                        imgArr.splice(index, 1);
                    }
                }
                
                if (imgArr.length != 0) {
                    $.ajax({
                        url: "/articleDeleteFile",
                        data: {
                            arr: imgArr
                        },
                        type: "post"
                    });
                }
            }
            
            $("#frm").submit();
        });

        //취소버튼 클릭시 저장한 이미지들 삭제
        $("#cancel").click(function() {

            if ($("#now").val() == "write") {
                oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

                //html 코드로 변환된 context의 val를 가져옴.
                var context = $("textarea[name=content]").val();

                //context 내에서 img 태그만 추출
                var img = $(context).find("img");

                //img 태그에서 src를 저장해 보낼 변수
                var arr = new Array();
                for (var i = 0; i < img.length; i++) {
                    //순회를 하면서 arr에 img태그의 src값을 저장한다.
                    arr.push($(img).eq(i).attr("src"));
                }
                //            var length = arr.length;

                //ajax
                $.ajax({
                    url: "/articleDeleteFile",
                    data: {
                        arr: arr
                    },
                    type: "post"
                });
                location.href = "/articleList";
            } else {
                
                oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

                //html 코드로 변환된 context의 val를 가져옴.
                var context = $("textarea[name=content]").val();

                //context 내에서 img 태그만 추출
                var img = $(context).find("img");

                //img 태그에서 src를 저장해 보낼 변수
                var arr = new Array();
                for (var i = 0; i < img.length; i++) {
                    //순회를 하면서 arr에 img태그의 src값을 저장한다.
                    arr.push($(img).eq(i).attr("src"));
                }
                
                for (var i = 0; i < imgArr.length; i++) {
                    var index = arr.indexOf(imgArr[i]);
                    if (index != -1) {
                        arr.splice(index, 1);
                    }
                }
                
                $.ajax({
                    url: "/articleDeleteFile",
                    data: {
                        arr: arr
                    },
                    type: "post"
                });
                
                location.href = "/articleRead?articleNoticeNo=" + articleNoticeNo;
            }
        });

    });

</script>
<c:if test="${not empty article }">
    <script>
        $(function() {
            $("#title").val("${article.articleNoticeTitle}");
        });
        articleNoticeNo = "${article.articleNoticeNo}";
    </script>
</c:if>
