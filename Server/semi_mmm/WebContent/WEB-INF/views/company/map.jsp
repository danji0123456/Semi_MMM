<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/css/content.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>함께 갈 수 있는 곳</title>

<script
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=zpg6saeiva&submodules=geocoder"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>



</head>
<body>

	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="container">
			<div class="con mt-3">
				<h3>
					<code>우리가 함께 갈 수 있는 장소</code>
				</h3>
				<div>
					<a class="btn btn-primary" data-toggle="collapse"
						href="#collapseExample1"> 수영장 </a> <a class="btn btn-primary"
						data-toggle="collapse" href="#collapseExample2"> 공원</a> <a
						class="btn btn-primary" data-toggle="collapse"
						href="#collapseExample3"> 카페/식당</a> <a class="btn btn-primary"
						data-toggle="collapse" href="#collapseExample4">쇼핑몰 </a> <a
						class="btn btn-primary" data-toggle="collapse"
						href="#collapseExample5"> 호텔</a>
				</div>
				<div class="collapse" id="collapseExample1">
					<div class="card card-body">
						<button id="test1" onclick="dog1()">개떼놀이터</button>
						<br>
						<button id="test2" onclick="dog2()">스타독스</button>
						<br>
						<button id="test3" onclick="dog3()">딩고카페</button>
						<br>
						<button id="test4" onclick="dog4()">파라다이스독</button>
					</div>
				</div>
				<div class="collapse" id="collapseExample2">
					<div class="card card-body">
						<button id="test5" onclick="dog5()">월드컵공원</button>
						<br>
						<button id="test6" onclick="dog6()">보라매공원</button>
						<br>
						<button id="test7" onclick="dog7()">개판오분전</button>
						<br>
						<button id="test8" onclick="dog8()">수락반려견 놀이터</button>
						<br>
						<button id="test9" onclick="dog9()">노원마들스타디움</button>
					</div>
				</div>
				<div class="collapse" id="collapseExample3">
					<div class="card card-body">
						<button id="test10" onclick="dog10()">상상다방</button>
						<br>
						<button id="test11" onclick="dog11()">얼띵앤키친</button>
						<br>
						<button id="test12" onclick="dog12()">두애견포차</button>
					</div>
				</div>
				<div class="collapse" id="collapseExample4">
					<div class="card card-body">
						<button id="test13" onclick="dog13()">IFC</button>
						<br>
						<button id="test14" onclick="dog14()">스타필드 고양</button>
					</div>
				</div>

				<div class="collapse" id="collapseExample5">
					<div class="card card-body">
						<button id="test15" onclick="dog15()">카푸치노 호텔</button>
						<br>
						<button id="test16" onclick="dog16()">오크우드 프리미어 인천</button>
						<br>
						<button id="test17" onclick="dog17()">비스타 워커힐 호텔</button>
					</div>
				</div>
			</div>
				
				<br>
			<div id="play" style="width: 95%; height: 500px;"></div>
		</div>
	</div>
	<br>

	<script>
		$(function() {
			$("#test1").click(function() {

			});
			$("#test2").click(function() {

			});
			$("#test3").click(function() {

			});
			$("#test4").click(function() {

			});
			$("#test5").click(function() {

			});
			$("#test6").click(function() {

			});
			$("#test7").click(function() {

			});
			$("#test8").click(function() {

			});
			$("#test9").click(function() {

			});
			$("#test10").click(function() {

			});
			$("#test11").click(function() {

			});
			$("#test12").click(function() {

			});
			$("#test13").click(function() {

			});
			$("#test14").click(function() {

			});
			$("#test15").click(function() {

			});
			$("#test16").click(function() {

			});
			$("#test17").click(function() {

			});

		});
		$(document).ready(function() {
			$('#btn1').on('click', function() {
				let collapses = $('div.container').find('.collapse');
				collapses.each(function() {
					$(this).collapse('toggle');
				});
			});
		});

		function dog1() {
			map.panTo(position1);
		}
		function dog2() {
			map.panTo(position2);
		}
		function dog3() {
			map.panTo(position3);
		}
		function dog4() {
			map.panTo(position4);
		}
		function dog5() {
			map.panTo(position5);
		}
		function dog6() {
			map.panTo(position6);
		}
		function dog7() {
			map.panTo(position7);
		}
		function dog8() {
			map.panTo(position8);
		}
		function dog9() {
			map.panTo(position9);
		}
		function dog10() {
			map.panTo(position10);
		}
		function dog11() {
			map.panTo(position11);
		}
		function dog12() {
			map.panTo(position12);
		}
		function dog13() {
			map.panTo(position13);
		}
		function dog14() {
			map.panTo(position14);
		}
		function dog15() {
			map.panTo(position15);
		}
		function dog16() {
			map.panTo(position16);
		}
		function dog17() {
			map.panTo(position17);
		}
	</script>

	
	<script>
		var HOME_PATH = window.HOME_PATH || '.';

		var position1 = new naver.maps.LatLng(37.66624, 127.187882);
		var position2 = new naver.maps.LatLng(37.780495, 126.715696);
		var position3 = new naver.maps.LatLng(37.235487, 127.054918);
		var position4 = new naver.maps.LatLng(36.993873, 127.193349);
		var position5 = new naver.maps.LatLng(37.569254, 126.878524);
		var position6 = new naver.maps.LatLng(37.493434, 126.919701);
		var position7 = new naver.maps.LatLng(37.471343, 126.959988);
		var position8 = new naver.maps.LatLng(37.675327, 127.062623);
		var position9 = new naver.maps.LatLng(37.644240, 127.057615);
		var position10 = new naver.maps.LatLng(37.551834, 126.922513);
		var position11 = new naver.maps.LatLng(37.546633, 126.918542);
		var position12 = new naver.maps.LatLng(37.490743, 127.010398);
		var position13 = new naver.maps.LatLng(37.525183, 126.925306);
		var position14 = new naver.maps.LatLng(37.646892, 126.894814);
		var position15 = new naver.maps.LatLng(37.507005, 127.031507);
		var position16 = new naver.maps.LatLng(37.389396, 126.644216);
		var position17 = new naver.maps.LatLng(37.555978, 127.110869);

		var map = new naver.maps.Map('play', {
			center : position1,
			zoom : 19
		});

		var markerOptions1 = {
			position : position1.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};

		var markerOptions2 = {
			position : position2.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions3 = {
			position : position3.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions4 = {
			position : position4.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions5 = {
			position : position5.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions6 = {
			position : position6.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions7 = {
			position : position7.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions8 = {
			position : position8.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions9 = {
			position : position9.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions10 = {
			position : position10.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions11 = {
			position : position11.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions12 = {
			position : position12.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions13 = {
			position : position13.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions14 = {
			position : position14.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions15 = {
			position : position15.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions16 = {
			position : position16.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};
		var markerOptions17 = {
			position : position17.destinationPoint(90, 15),
			map : map,
			icon : {
				url : '/img/map.png',
				size : new naver.maps.Size(50, 52),
				origin : new naver.maps.Point(0, 0),
				anchor : new naver.maps.Point(25, 26)
			}
		};

		var marker1 = new naver.maps.Marker(markerOptions1);
		var marker2 = new naver.maps.Marker(markerOptions2);
		var marker3 = new naver.maps.Marker(markerOptions3);
		var marker4 = new naver.maps.Marker(markerOptions4);
		var marker5 = new naver.maps.Marker(markerOptions5);
		var marker6 = new naver.maps.Marker(markerOptions6);
		var marker7 = new naver.maps.Marker(markerOptions7);
		var marker8 = new naver.maps.Marker(markerOptions8);
		var marker9 = new naver.maps.Marker(markerOptions9);
		var marker10 = new naver.maps.Marker(markerOptions10);
		var marker11 = new naver.maps.Marker(markerOptions11);
		var marker12 = new naver.maps.Marker(markerOptions12);
		var marker13 = new naver.maps.Marker(markerOptions13);
		var marker14 = new naver.maps.Marker(markerOptions14);
		var marker15 = new naver.maps.Marker(markerOptions15);
		var marker16 = new naver.maps.Marker(markerOptions16);
		var marker17 = new naver.maps.Marker(markerOptions17);

		var contentString1 = [
				'<a href="/map?name=개떼"><div class="iw_inner">',
				'<h3>개떼놀이터</h3>',
				'<p>경기 남양주시 진건읍 사릉로 280번길 7<br/>',
				'<img src="'+ HOME_PATH +'/img/play1.png" width="300" height="80" alt="개떼놀이터" class="thumb" /><br/>',
				'   </p>', '</div>', '</a>' ].join('');

		var contentString2 = [
				'<div class="iw_inner">',
				'<h3>스타독스</h3>',
				'<p>경기 파주시 탄현면 국화향길 10-40<br/>',
				'<img src="'+ HOME_PATH +'/img/play2.png" width="300" height="80" alt="스타독스" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');

		var contentString3 = [
				'<div class="iw_inner">',
				'<h3>딩고카페</h3>',
				'<p>경기 수원시 영통구 태장로 54번길 166<br/>',
				'<img src="'+ HOME_PATH +'/img/play3.png" width="300" height="80" alt="딩고카페" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString4 = [
				'<div class="iw_inner">',
				'<h3>파라다이스독</h3>',
				'<p>경기 안성시 공도읍 대신두길 28 <br/>',
				'<img src="'+ HOME_PATH +'/img/play4.png" width="300" height="80" alt="파라다이스독" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString5 = [
				'<div class="iw_inner">',
				'<h3>월드컵공원</h3>',
				'<p>서울 마포구 하늘공원로 108-1(평화의 주차장 옆)<br/>',
				'<img src="'+ HOME_PATH +'/img/play5.png" width="300" height="80" alt="월드컵공원" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString6 = [
				'<div class="iw_inner">',
				'<h3>보라매공원</h3>',
				'<p>서울 동작구 여의대방로20길 33(향기원 옆)<br/>',
				'<img src="'+ HOME_PATH +'/img/play6.png" width="300" height="80" alt="보라매공원" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString7 = [
				'<div class="iw_inner">',
				'<h3>개판오분전</h3>',
				'<p>서울 관악구 낙성대로 77 낙성대공원 잔디광장 <br/>',
				'<img src="'+ HOME_PATH +'/img/play7.jpg" width="300" height="80" alt="개판오분전" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString8 = [
				'<div class="iw_inner">',
				'<h3>수락 반려견 놀이터</h3>',
				'<p>서울 노원구 상계동 산 62-5(수락산 노원골) <br/>',
				'<img src="'+ HOME_PATH +'/img/play8.jpg" width="300" height="80" alt="수락반려견놀이터" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString9 = [
				'<div class="iw_inner">',
				'<h3>노원 마들스타디움</h3>',
				'<p>서울 노원구 상계동  <br/>',
				'<img src="'+ HOME_PATH +'/img/play9.jpg" width="300" height="80" alt="노원 마들스타디움" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString10 = [
				'<div class="iw_inner">',
				'<h3>상상마당</h3>',
				'<p>서울 마포구 와우산로21길 19-16 NS TOWER 3층 <br/>',
				'<img src="'+ HOME_PATH +'/img/play10.jpg" width="300" height="80" alt="상상마당" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString11 = [
				'<div class="iw_inner">',
				'<h3>얼띵앤키친</h3>',
				'<p>서울 마포구 토정로5길 22<br/>',
				'<img src="'+ HOME_PATH +'/img/play11.jpg" width="300" height="80" alt="얼띵앤키친" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString12 = [
				'<div class="iw_inner">',
				'<h3>두애견포차</h3>',
				'<p>서울 반포대로 26길 21<br/>',
				'<img src="'+ HOME_PATH +'/img/play12.jpg" width="300" height="80" alt="두애견포차" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString13 = [
				'<div class="iw_inner">',
				'<h3>IFC</h3>',
				'<p>서울 영등포구 국제금융로 10<br/>',
				'<img src="'+ HOME_PATH +'/img/play13.jpg" width="300" height="80" alt="IFC" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString14 = [
				'<div class="iw_inner">',
				'<h3>스타필드 고양</h3>',
				'<p>경기도 고양시 덕양구 창릉동 고양대로 1955<br/>',
				'<img src="'+ HOME_PATH +'/img/play14.jpg" width="300" height="80" alt="스타필드 고양" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString15 = [
				'<div class="iw_inner">',
				'<h3>카푸치노 호텔</h3>',
				'<p>서울 강남구 봉은사로 155<br/>',
				'<img src="'+ HOME_PATH +'/img/play15.png" width="300" height="80" alt="카푸치노 호텔" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString16 = [
				'<div class="iw_inner">',
				'<h3>오크우드 프리미어 인천</h3>',
				'<p>인천광역시 연수구 컨벤시아대로 165<br/>',
				'<img src="'+ HOME_PATH +'/img/play16.png" width="300" height="80" alt="오크우드 프리미어 인천" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');
		var contentString17 = [
				'<div class="iw_inner">',
				'<h3>비스타 워커힐 서울</h3>',
				'<p>서울특별시 광진구 광장동 워커힐로 177<br/>',
				'<img src="'+ HOME_PATH +'/img/play17.jpg" width="300" height="80" alt="비스타 워커힐 서울" class="thumb" /><br/>',
				'   </p>', '</div>' ].join('');

		var infowindow1 = new naver.maps.InfoWindow({
			content : contentString1,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker1, "click", function(e) {
			if (infowindow1.getMap()) {
				infowindow1.close();
			} else {
				infowindow1.open(map, marker1);
			}
		});

		var infowindow2 = new naver.maps.InfoWindow({
			content : contentString2,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker2, "click", function(e) {
			if (infowindow2.getMap()) {
				infowindow2.close();
			} else {
				infowindow2.open(map, marker2);
			}
		});

		var infowindow3 = new naver.maps.InfoWindow({
			content : contentString3,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker3, "click", function(e) {
			if (infowindow3.getMap()) {
				infowindow3.close();
			} else {
				infowindow3.open(map, marker3);
			}
		});
		var infowindow4 = new naver.maps.InfoWindow({
			content : contentString4,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker4, "click", function(e) {
			if (infowindow4.getMap()) {
				infowindow4.close();
			} else {
				infowindow4.open(map, marker4);
			}
		});
		var infowindow5 = new naver.maps.InfoWindow({
			content : contentString5,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker5, "click", function(e) {
			if (infowindow5.getMap()) {
				infowindow5.close();
			} else {
				infowindow5.open(map, marker5);
			}
		});
		var infowindow6 = new naver.maps.InfoWindow({
			content : contentString6,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker6, "click", function(e) {
			if (infowindow6.getMap()) {
				infowindow6.close();
			} else {
				infowindow6.open(map, marker6);
			}
		});
		var infowindow7 = new naver.maps.InfoWindow({
			content : contentString7,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker7, "click", function(e) {
			if (infowindow7.getMap()) {
				infowindow7.close();
			} else {
				infowindow7.open(map, marker7);
			}
		});
		var infowindow8 = new naver.maps.InfoWindow({
			content : contentString8,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker8, "click", function(e) {
			if (infowindow8.getMap()) {
				infowindow8.close();
			} else {
				infowindow8.open(map, marker8);
			}
		});
		var infowindow9 = new naver.maps.InfoWindow({
			content : contentString9,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker9, "click", function(e) {
			if (infowindow9.getMap()) {
				infowindow9.close();
			} else {
				infowindow9.open(map, marker9);
			}
		});
		var infowindow10 = new naver.maps.InfoWindow({
			content : 0,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker10, "click", function(e) {
			if (infowindow10.getMap()) {
				infowindow10.close();
			} else {
				infowindow10.open(map, marker10);
			}
		});
		var infowindow11 = new naver.maps.InfoWindow({
			content : contentString11,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker11, "click", function(e) {
			if (infowindow11.getMap()) {
				infowindow11.close();
			} else {
				infowindow11.open(map, marker11);
			}
		});
		var infowindow12 = new naver.maps.InfoWindow({
			content : contentString12,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker12, "click", function(e) {
			if (infowindow12.getMap()) {
				infowindow12.close();
			} else {
				infowindow12.open(map, marker12);
			}
		});
		var infowindow13 = new naver.maps.InfoWindow({
			content : contentString13,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker13, "click", function(e) {
			if (infowindow13.getMap()) {
				infowindow13.close();
			} else {
				infowindow13.open(map, marker13);
			}
		});
		var infowindow14 = new naver.maps.InfoWindow({
			content : contentString14,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker14, "click", function(e) {
			if (infowindow14.getMap()) {
				infowindow14.close();
			} else {
				infowindow14.open(map, marker14);
			}
		});
		var infowindow15 = new naver.maps.InfoWindow({
			content : contentString15,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker15, "click", function(e) {
			if (infowindow15.getMap()) {
				infowindow15.close();
			} else {
				infowindow15.open(map, marker15);
			}
		});
		var infowindow16 = new naver.maps.InfoWindow({
			content : contentString16,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker16, "click", function(e) {
			if (infowindow16.getMap()) {
				infowindow16.close();
			} else {
				infowindow16.open(map, marker16);
			}
		});
		var infowindow17 = new naver.maps.InfoWindow({
			content : contentString17,
			maxWidth : 300,
			backgroundColor : "#eee",
			borderColor : "#2db400",
			borderWidth : 2,
			anchorSize : new naver.maps.Size(30, 30),
			anchorSkew : true,
			anchorColor : "#eee",
			pixelOffset : new naver.maps.Point(20, -20)
		});

		naver.maps.Event.addListener(marker17, "click", function(e) {
			if (infowindow17.getMap()) {
				infowindow17.close();
			} else {
				infowindow17.open(map, marker17);
			}
		});
	</script>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<link rel="stylesheet" href="/css/ey.css">
</body>
</html>