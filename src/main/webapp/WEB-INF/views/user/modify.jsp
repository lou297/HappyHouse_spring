<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<%@ include file="../menu/nav.jsp"%>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript">
function modifyMember() {
	 if (document.getElementById("id").value == "") {
			alert("아이디를 입력해주세요");
			return;
		}else if (document.getElementById("password").value == "") {
			alert("비밀번호를 입력해주세요");
			return;
		} else if (document.getElementById("name").value == "") {
			alert("이름을 입력해주세요");
			return;
		} else if (document.getElementById("address").value == "") {
			alert("주소를 입력해주세요");
			return;
		} else if(document.getElementById("phone").value == ""){
			alert("전화번호를 입력해주세요");
			return;
		} else {
		document.getElementById("modifyForm").action = "${root}/user/modify";
		document.getElementById("modifyForm").submit();
	}
}
</script>
</head>
<body>
	<div class="container" align="center">
		<h2>회원 정보 확인</h2>
		<div>
			<c:if test="${userinfo != null}">
				<form id="modifyForm" method="post" action="">
					<input type="hidden" name="act" value="modifyCheck">

					<div class="form-group">
						<label for="id">아이디 :</label> 
						<input type="text" class="form-control" id="id" name="id" value="${userinfo.id}" readonly>
					</div>
					<div class="form-group">
						<label for="password">비밀번호 :</label> 
						<input type="password" class="form-control" id="password" name="password" value="${userinfo.password}">
					</div>
					<div class="form-group">
						<label for="name">이름 :</label> 
						<input type="text" class="form-control" id="name" name="name" value="${userinfo.name}">
					</div>
					<div class="form-group">
						<label for="address">주소 :</label> 
						<input type="text" class="form-control" id="address" name="address" value="${userinfo.address}">
					</div>
					<div class="form-group">
						<label for="phone">전화번호 :</label> 
						<input type="text" class="form-control" id="phone" name="phone" value="${userinfo.phone}">
					</div>

					<button class="btn btn-primary" onclick="javascript:modifyMember();">등록</button>
				</form>
			</c:if>
			<c:if test="${userinfo == null}">
				<p>회원 정보 로드 실패</p>
			</c:if>
		</div>
	</div>
</body>
</html>