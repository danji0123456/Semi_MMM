<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/css/content.css">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />



<title>(주)ㅁㅁㅁ회사소개:)</title>
<style>
.title {
	text-align: center;
	padding: 20px;
}

.centered{
	text-align: center;
	padding : 70px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="container">
			<div id="home">
            
       
        <div class="section primary-section" id="service">
            <div class="container">
               
                <div class="title">
                    <h1>(주)ㅁㅁㅁ 회사는 이렇습니다.</h1>
                    
                    <p>강아지를 부를 때 멍멍이라고 많이 부릅니다. 어떻게 하면 사람들 기억에 남을까 고민하다가 초성만 가져와서 상호를 만들었습니다. </p>
                   
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                
                            </div>
                            <h3>강아지용 디저트</h3>
                            <p>우리 강아지용 케익, 쿠키 등 엄선한 재료들로 신뢰도 높은 디저트 가게에서 구매 가능하게 하였습니다.</p>
                            <img class="img-circle" src="img/desert.png" alt="service 2" />
                        </div>
                    </div>
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                               
                            </div>
                            <h3>중고거래 게시판</h3>
                            <p>강아지들이 더 이상 좋아하지 않는 장난감! 여기서 거래를 해보세요</p>
                             <img class="img-circle" src="img/deal2.png" alt="service 2" />
                        </div>
                    </div>
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                
                            </div>
                            <h3>즐거운 커뮤니티</h3>
                            <p>강아지 키우시는 분들과 즐거운 커뮤니티! 여기서  속닥속닥  얘기하고 가세요:)</p>
                            <img class="img-circle" src="img/personalimg.png" alt="service 3">
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
       
       
     
      
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>