<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>회원 가입</title>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1jvn44xnbf&submodules=geocoder"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <style>
        #joinForm {
            width: 1000px;
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 50px;
            padding-right: 20px;
        }

        ul.join_box {
            border: 1px solid #ddd;
            background-color: #fff;
        }

        .checkBox,
        .checkBox>ul {
            position: relative;
        }

        .checkBox>ul>li {
            float: left;
        }

        .checkBox>ul>li:first-child {
            width: 85%;
            padding: 15px;
            font-weight: 600;
            color: #888;
        }

        .checkBox textarea {
            width: 96%;
            height: 90px;
            margin: 0 2%;
            background-color: #f7f7f7;
            color: #888;
            border: none;
        }

        .footBtwrap {
            margin-top: 15px;
        }

        .footBtwrap>li {
            float: left;
            width: 50%;
            height: 60px;
        }

        .form-control {
            margin: 5px;
        }

    </style>
    <script>
        var pwchk = "";
        var joinOk = 0;
        $(function() {
            $(".form-control").blur(function() {
                if ($(this).val() == "") {
                    $(this).css("border", "3px solid red");
                } else {
                    var value = $(this).val();
                    getVal(value, $(this));
                }
            });
        });

        function getVal(val, what) {
            var regExp = "";
            if (what.attr("id") == "id") {
                regExp = /^[a-zA-Z0-9]{4,12}$/;
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    $.ajax({
                        url: "/checkId",
                        type: "get",
                        data: {
                            val: val
                        },
                        success: function(data) {
                            console.log(data);
                            if (data == true) {
                                what.css("border", "3px solid red");
                                $("#checkId").prop("type", "text");
                                $("#checkId").val("아이디가 중복입니다");
                            } else {
                                what.css("border", "3px solid #76D5FF");
                                $("#checkId").prop("type", "hidden");
                                joinOk++;
                            }
                        }
                    });
                }
            }
            if (what.attr("id") == "pw") {
                regExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                } else {
                    pwchk = val;
                    what.css("border", "3px solid #76D5FF");
                }
            }
            if (what.attr("id") == "pwchk") {
                if (val != pwchk) {
                    what.css("border", "3px solid red");
                    $("#checkPw").prop("type", "text");
                    $("#checkPw").val("비밀번호가 일치하지 않습니다");
                } else {
                    what.css("border", "3px solid #76D5FF");
                    $("#checkPw").prop("type", "hidden");
                    joinOk++;

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
                    joinOk++;
                }
            }
            if (what.attr("id") == "nick") {
                regExp = /^[가-힣0-9a-zA-Z]{2,10}$/;
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    $.ajax({
                        url: "/checkNick",
                        type: "get",
                        data: {
                            val: val
                        },
                        success: function(data) {
                            console.log(data);
                            if (data == true) {
                                what.css("border", "3px solid red");
                                $("#checkNick").prop("type", "text");
                                $("#checkNick").val("샵 네임이 중복입니다");
                            } else {
                                what.css("border", "3px solid #76D5FF");
                                $("#checkNick").prop("type", "hidden");
                                joinOk++;
                            }
                        }
                    });
                }
            }
            if (what.attr("id") == "birth") {
                regExp = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                    what.focus();
                    $("#checkBirth").prop("type", "text");
                    $("#checkBirth").val("날짜 정보가 잘못된 형식입니다");
                } else {
                    pwchk = val;
                    what.css("border", "3px solid #76D5FF");
                    $("#checkBirth").prop("type", "hidden");
                    joinOk++;
                }
            }
            if (what.attr("id") == "ph2") {
                regExp = /\d{3,4}/;
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    pwchk = val;
                    what.css("border", "3px solid #76D5FF");
                    joinOk++;
                }
            }
            if (what.attr("id") == "ph3") {
                regExp = /[0-9]{4}/;
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    pwchk = val;
                    what.css("border", "3px solid #76D5FF");
                    joinOk++;
                }
            }
            if (what.attr("id") == "detailAddr") {
                if (what.val() == "") {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    what.css("border", "3px solid #76D5FF");
                    joinOk++;
                }
            }
            if (what.attr("id") == "shopId") {
                regExp = /^[0-9]{3}-[0-9]{2}-[0-9]{5}$/
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    pwchk = val;
                    what.css("border", "3px solid #76D5FF");
                    joinOk++;
                }
            }
            if (what.attr("id") == "shopBank") {
                if (what.val() == "") {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    what.css("border", "3px solid #76D5FF");
                    joinOk++;
                }
            }
            if (what.attr("id") == "shopBankAccount") {
                regExp = /^[0-9]{10,}$/
                if (!regExp.test(val)) {
                    what.css("border", "3px solid red");
                    what.focus();
                } else {
                    pwchk = val;
                    what.css("border", "3px solid #76D5FF");
                    joinOk++;
                }
            }
        }

        function sub() {
            $("#checksub").val("");
            if (joinOk < 11) {
                $("#checksub").val("입력 정보가 잘못되었습니다!");
                $("#checksub").prop("type", "text");
                return false;
            }
            return true;
        }

        function addrSearch() {
            new daum.Postcode({
                oncomplete: function(data) {
                    $("#postCode").val(data.zoneCode);
                    $("#roadAddr").val(data.roadAddress);
                    $("#jibunAddr").val(data.jibunAddress);
                }
            }).open();
        }

    </script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <div class="container">
        <form action="/comJoinMember" id="joinForm" method="post">
            <legend>사업자 회원가입</legend>
            <input type="text" id="id" name="id" class="form-control input-lg" placeholder="아이디 (사업자 번호를 입력해주세요)" required />
            <input type="hidden" id="checkId" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly>
            <br>
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <input type="password" id="pw" name="password" class="form-control input-lg" placeholder="패스워드(특수문자+문자+숫자 포함 형태의 8~15자리)" required />
                </div>
                <div class="col-xs-6 col-md-6">
                    <input type="password" id="pwchk" name="confirm_password" class="form-control input-lg" placeholder="패스워드 재입력" required />
                </div>
            </div>
            <input type="hidden" id="checkPw" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly>
            <br>
            <input type="text" name="name" id="name" class="form-control input-lg" placeholder="사업자 이름 (최소 2글자 이상 6글자 이하)" required />
            <br>
            <input type="text" name="nickname" id="nick" class="form-control input-lg" placeholder="샵 네임 (2~10 문자)" required />
            <input type="hidden" id="checkNick" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly>
            <br>
            <input type="text" name="birth" id="birth" class="form-control input-lg" placeholder="창업날짜 (ex : 20151010)" required />
            <input type="hidden" id="checkBirth" style="border:0px; color:red;font-size:11px;margin-left:20px;" size="30" readonly>
            <br>
            <div class="row">
                <div class="col-xs-4 col-md-4">
                    <select name="phone1" class="form-control input-lg">
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="019">019</option>
                    </select>
                </div>
                <div class="col-xs-4 col-md-4">
                    <input type="text" id="ph2" name="phone2" class="form-control input-lg" placeholder="전화번호" required />
                </div>
                <div class="col-xs-4 col-md-4">
                    <input type="text" id="ph3" name="phone3" class="form-control input-lg" placeholder="전화번호" required />
                </div>
            </div>
            <br>
            <input type="text" id="postCode" style="width: 200px; display: inline-block;" class="form-control input" placeholder="우편번호" readonly>
            <button type="button" id="addrSerachBtn" onclick="addrSearch();" class="btn btn-primary">주소검색</button>
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <input id="roadAddr" name="roadAddr" style="display: inline-block;" type="text" class="form-control input-lg" placeholder="도로명주소" readonly>
                </div>
                <div class="col-xs-6 col-md-6">
                    <input id="jibunAddr" name="jibunAddr" style="display: inline-block;" type="text" class="form-control input-lg" placeholder="지번주소" readonly>
                </div>
            </div>
            <div>
                <input id="detailAddr" name="detailAddr" style="display: inline-block;" type="text" class="form-control input-lg" placeholder="사업장 주소">
            </div>
            <input type="hidden" id="checksub" style="border:0px; color:red;font-size:15px;margin-left:20px;" size="30" readonly>
            <br>
            <input type="text" id="shopId" name="shopId" class="form-control input-lg" placeholder="사업자 번호 ex)123-12-12345" required>
            <br>
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <input type="text" id="shopBank" name="shopBank" class="form-control input-lg" placeholder="거래 은행을 입력하세요" required>
                </div>
                <div class="col-xs-6 col-md-6">
                    <input type="text" id="shopBankAccount" name="shopBankAccount" class="form-control input-lg" placeholder="계좌번호를 입력하세요('-'제외)" required>
                </div>
            </div>
            <br><br>
            <div style="width:100%; text-align:center;">
                <button class="btn btn-lg btn-secondary btn-lg signup-btn" type="button" style="width:300px;" onclick="location.href='/'">나가기</button>
                <button class="btn btn-lg btn-primary btn-lg signup-btn" type="submit" style="width:300px;" onclick="return sub();">회원가입</button>
            </div>
        </form>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>

</html>
