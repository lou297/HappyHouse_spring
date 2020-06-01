<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<%@ include file="../header/header.jsp"%>

<body>
	<c:set var="root" value="${pageContext.request.contextPath }" />

	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="#">HAPPY HOUSE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample04" aria-controls="navbarsExample04"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample04">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${root}/index.jsp">메인 페이지 <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/house.do?act=main&group=all&pg=1">아파트 거래 정보<span
						class="sr-only">(current)</span></a></li>

				<li class="nav-item"><a class="nav-link"
					href="${root}/tradehub.do?act=category">업종 별 상권 보기</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/tradehub.do?act=dong">동 별 상권 보기</a></li>
			</ul>

			<form class="form-inline my-2 my-md-0">
				<ul class="navbar-nav mr-auto justify-content-end">
					<c:choose>
						<c:when test="${userinfo eq null }">
							<li class="nav-item"><a class="nav-link"
								href="${root}/user.do?act=login">로그인</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${root}/user.do?act=regist">회원 가입</a></li>
						</c:when>

						<c:otherwise>

							<li class="nav-item"><a class="nav-link"
								href="${root}/user.do?act=find_user_info">회원 정보 조회</a></li>

							<li class="nav-item"><a class="nav-link"
								href="${root}/user.do?act=modify_user_info">회원 정보 수정</a></li>

							<li class="nav-item"><a class="nav-link"
								href="${root}/user.do?act=remove_user_info">회원 정보 삭제</a></li>

							<li class="nav-item"><a class="nav-link"
								href="${root}/user.do?act=logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</form>

		</div>
	</nav>
</body>
</html>