<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<%@ include file="WEB-INF/views/header/header.jsp"%>
<%@ include file="WEB-INF/views/menu/nav.jsp"%>
<style>
div.top {
	width: 100%;
	height: 10%;
	background-image: URL(${root}/img/house.jpg);
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
}

ul {
	list-style: none;
}

img.ssafy {
	width: 100%;
	height: 100%;
	max-width: 250px;
	max-height: 250px;
}

img.mainMap {
	width: auto;
	height: auto;
	max-width: 100%;
	max-height: 300px;
}
</style>

<body>
	<div align="center">

		<c:set var="root" value="${pageContext.request.contextPath }" />

		<div>
			<div class="top">
				<h1>HAPPY HOUSE</h1>
				<hr width="50%" size="3">
				<p>행복한 우리집</p>
			</div>
			<div>
				<img src="${root}/img/multimap.jpg" class="mainMap">
			</div>
		</div>
		<div class="container" style="padding-top: 5%;">
			<div class="row">
				<div class="col-md-4">
					<a href="https://www.ssafy.com/ksp/jsp/swp/swpMain.jsp"><img
						alt="이미지를 불러올 수 없습니다." class="ssafy" src="${root}/img/ssafy4.jpg "></a>
				</div>
				<div class="col-md-4">
					<h6>지혜롭게 내집 마련하기</h6>
					<hr>
					<ul style="padding: 0">
						<li>가용자금 확인 및 대출 계획</li>
						<li>집 종류 및 지역 선택</li>
						<li>정보 수집 & 시세파악</li>
						<li>부동산 방문 & 집구경</li>
						<li>계약 및 잔금 치르기</li>
					</ul>
				</div>
				<div class="col-md-4">
					<h6>오늘의 뉴스</h6>
					<hr>
					<ul style="padding: 0">
						<li><a class="nav-link"
							href="https://news.naver.com/main/read.nhn?oid=421&aid=0004634015">
								GTX-A 개통 속도 붙나?</a></li>
						<li><a class="nav-link"
							href="https://realestate.daum.net/news/detail/main/20200512165115075">
								8000세대로 주택수요 해결될까?</a></li>
						<li><a class="nav-link"
							href="http://www.hani.co.kr/arti/economy/property/944405.html">
								법인 내세운 꼼수 투기 폭증</a></li>
						<li><a class="nav-link"
							href="https://www.mk.co.kr/news/realestate/view/2020/05/484844/">
								'서울 아파트 35층 규제'</a></li>
					</ul>
				</div>
			</div>
		</div>

		<footer>
			<div>
				<h6>Find Us</h6>
				<hr width="30%">
				<ul style="padding: 0">
					<li>만든이 : 김민건, 이정훈</li>
					<li>HappyHouse_Front_End project</li>
					<li>Completion date : 2020-05-12</li>
				</ul>
			</div>
		</footer>

	</div>
</body>
</html>
