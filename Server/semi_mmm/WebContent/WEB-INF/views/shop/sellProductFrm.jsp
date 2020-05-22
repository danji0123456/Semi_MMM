<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import = "shop.model.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    select{
        width: 170px;
    }
    label{
        width: 120px;
        text-align: right;
    }
    #shopTitle{
    	color: white;
    	width: 150px;
    	height: 60px;
        line-height: 60px;
    	font-size: 30px;
        background-color: lightblue;
        text-align: center;
        border-radius: 5px;
        margin-top: 20px;
        
    }
    #divLoc{
        width: 400px;
        height: 500px;
        margin: 0 auto;
        margin-top: 20px;
    }
    #divLocTitle{
        font-size: 50px;
        font-weight: 900;
        margin-bottom: 30px;
    }
    #divLoc1{
        background-color: #E4E8EB;
    }
    #divLoc2{
        background-color: red;
        margin-top: 10px;
        margin-right: 500px;
        height: 50px;
    }
    #totalPrice{
    	text-align: right;
    	font-size: 25px;
    	height: 50px;
    	font-weight: 900;
        border: 0px;
    }
    #cartBtn{
        margin-top: 10px;
        margin-left: 260px;
    }
</style>
</head>

<body>
	  	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	  	<section class="container">
		<div id="shopTitle">${bnMemberId }</div>
            <div id="divLoc">
                <div id="divLocTitle">재료 선택</div>
                <form id="toCart" name="toCart" action="/toCart" method="post">
                    <c:if test="${not empty sessionScope.member }">
                        <div id="divLoc1">
                            <c:forEach items="${sl }" var="list1" varStatus="status">
                                <label>${list1.productTitle }</label>
                                <select name="st" onchange=selectOpt(this.value) style="margin:20px; border:2px solid black;">
                                    <option value=","></option>
                                    <c:forEach items="${list1.subList }" var="list2">
                                        <option value="${list2.optionPrice},${list2.optionTitle },${list2.bnMemberId},${list1.productTitle}" }>${list2.optionTitle } (+${list2.optionPrice }원)</option>

                                    </c:forEach>
                                </select><br>
                            </c:forEach>
                        </div>
                    <div id="divLoc2">
                        <input type="hidden" name="orderMemberId" value="${sessionScope.member.memberId }">
                        <input type="text" name="totalPrice" id="totalPrice" value="" readonly>
                        <input type="hidden" name="bnMemberId" value="">
                        <input type="hidden" name="selectOpt" value="">
                    </div>
                    </c:if>
                    <button type="submit" id="cartBtn" class="btn btn-primary">장바구니에 담기</button>
                </form>
            </div>
	  </section>
	  	
	  <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script>
	    $(function(){
	    	$("select[name=st]").change(function(){
		    	var etcs = "";
		    	var etcs2 = "";
		    	var etcs3 = "";
		    	var s = "";
		    	var pt = "";
		    	$("select[name=st] option:selected").each(function(index){
		    		s = $(this).attr("value");
		    		s = s.split(",");
		    		if(s[3]==null){
		    			etcs = Number(etcs) + Number(s[0]);
			    		etcs2 = etcs2 + s[1] + "   ";
			    		etcs3 = s[2];
		    		}else{
			    		etcs = Number(etcs) + Number(s[0]);
			    		etcs2 = etcs2 + s[3] + ":" + s[1] + "   ";
			    		etcs3 = s[2];
		    		}
		    		
		    	});
		    	$("input[name=totalPrice]").attr("value",etcs);
		    	$("input[name=selectOpt]").attr("value",etcs2);
		    	$("input[name=bnMemberId]").attr("value",etcs3);
	    		
	    	});
	    });
    </script>
</body>
</html>