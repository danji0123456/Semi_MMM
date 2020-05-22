<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>중고장터 - 수정하기</title>
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

        .switch {
          position: relative;
          display: inline-block;
          width: 60px;
          height: 34px;
        }

        .switch input { 
          opacity: 0;
          width: 0;
          height: 0;
        }

        .slider {
          position: absolute;
          cursor: pointer;
          top: 0;
          left: 0;
          right: 0;
          bottom: 0;
          background-color: #ccc;
          -webkit-transition: .4s;
          transition: .4s;
        }

        .slider:before {
          position: absolute;
          content: "";
          height: 26px;
          width: 26px;
          left: 4px;
          bottom: 4px;
          background-color: white;
          -webkit-transition: .4s;
          transition: .4s;
        }

        input:checked + .slider {
          background-color: #2196F3;
        }

        input:focus + .slider {
          box-shadow: 0 0 1px #2196F3;
        }

        input:checked + .slider:before {
          -webkit-transform: translateX(26px);
          -ms-transform: translateX(26px);
          transform: translateX(26px);
        }

        /* Rounded sliders */
        .slider.round {
          border-radius: 34px;
        }

        .slider.round:before {
          border-radius: 50%;
        }
        
        #slide-btn>* {
            float: left;
            line-height: 50px;
            height: 34px;
            line-height: 34px;
            margin-top: 10px;
            margin-bottom: 10px;
            margin-left: 5px;
            margin-right: 5px;
        }
        #slide-btn>span {
        }
    </style>
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <div class="container">
        <h1 style="padding: 10px;">중고장터 수정하기</h1>
        <hr>
        <form action="/articleModify" method="post" id="frm">
            <input type="hidden" name="articleNoticeNo" value="${article.articleNoticeNo}">
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
                    <th><input type="hidden" value="${sessionScope.member.memberId}" name="articleNoticeWriter">
                    </th>
                    <th></th>
                </tr>
                <tr>
                    <th>판매여부 : </th>
                    <th style="line-height: 50px" id="slide-btn">
                        <span>판매완료</span>
                        <label class="switch">
                            <input type="checkbox" name="articleNoticeSoldBool" id="articleNoticeSoldBool" value="">
                            <span class="slider round"></span>
                        </label>
                        <span>판매중</span>
                    </th>
                </tr>
                <tr>
                    <td colspan="5">
                        <jsp:include page="/WEB-INF/views/common/smartEditorFormArticle.jsp" />
                    </td>
                </tr>
            </table>

            <div class="btnArea">
                <input type="button" class="btn btn-primary" id="save" value="수정">
                <input type="button" class="btn btn-primary" id="cancel" value="취소">
                <input type="hidden" id="now" value="modify">
            </div>
        </form>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script>
        $(function() {
            var option1 = $("select[name=articleNoticeCategory1]>option");
            for (var i = 0; i < option1.length; i++) {
                if ($(option1[i]).val() == "${article.articleNoticeCategory1 }") {
                    $(option1[i]).prop("selected", true);
                }
            }
            var option2 = $("select[name=articleNoticeCategory2]>option");
            for (var i = 0; i < option2.length; i++) {
                if ($(option2[i]).val() == "${article.articleNoticeCategory2 }") {
                    $(option2[i]).prop("selected", true);
                }
            }
            
            if (${article.articleNoticeSoldBool} == 0) {
                $("#articleNoticeSoldBool").prop("checked", true);
                $("#articleNoticeSoldBool").val("0");
            } else {
                $("#articleNoticeSoldBool").prop("checked", false);
                $("#articleNoticeSoldBool").val("1");
            }
            
            $("#articleNoticeSoldBool").change(function() {
                if ($(this).prop("checked")) {
                    $("#articleNoticeSoldBool").val("0");
                } else {
                    $("#articleNoticeSoldBool").val("1");
                }
            });
        });

    </script>
</body>

</html>
