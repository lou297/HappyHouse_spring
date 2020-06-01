<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%@ include file="../header/header.jsp"%>
<%@ include file="../menu/nav.jsp"%>

<c:set var="root" value="${pageContext.request.contextPath }" />
<script type="text/javascript">
	function pageMove(pg) { 
		document.getElementById("pg").value=pg;
		var group = document.getElementsByName("group");
		for(var i=0;i<group.length;i++){
			if(group[i].checked==true){
				var g = group[i].value;
				location.href="${root}/house/main?group="+g+"&pg="+pg;
			}
		}
	}
	function pageMove_search(pg) { 
		document.getElementById("pg").value=pg;
		var group = document.getElementsByName("group");
		var g;
		var c;
		
		for(var i=0;i<group.length;i++){
			if(group[i].checked==true){
				g = group[i].value;
			}
		}
		var category = document.getElementById("category");
		var c = category.options[category.selectedIndex].value;
		
		document.getElementById("loginform").action = "${root}/house/search?category="+c+"&group="+g+"&pg="+pg;
		document.getElementById("loginform").submit();
	}
	
	$(document).ready(function(){

		$.get("${root}/select/sido"
			,function(data, status){
				$.each(data, function(index, vo) {
					$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
				});//each
			}//function
			, "json"
		);//get
	});//ready
	$(document).ready(function(){
		$("#sido").change(function() {
			$.get("${root}/select/gugun"
					,{sido:$("#sido").val()}
					,function(data, status){
						$("#gugun").empty();
						$("#gugun").append('<option value="0">구군</option>');
						$.each(data, function(index, vo) {
							$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
						});//each
					}//function
					, "json"
			);//get
		});//change
		$("#gugun").change(function() {
			$.get("${root}/select/dong"
					,{gugun:$("#gugun").val()}
					,function(data, status){
						$("#dong").empty();
						$("#dong").append('<option value="0">동</option>');
						$.each(data, function(index, vo) {
							$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
						});//each
					}//function
					, "json"
			);//get
		});//change
		$("#dong").change(function() {
			$.get("${root}/select/apt"
					,{dong:$("#dong").val()}
					,function(data, status){
						$("#searchResult").empty();
						$.each(data, function(index, vo) {
							let str = "<div class='justify-content-center border-bottom' align='left' style='margin-top:20px'>"
							+ "<a href='${root}/house.do?act=house_info&no=" + vo.no +"'  style='font-size:20px'><b>"+vo.aptName+"</b></a>"
							+ "<p>거래금액 : "+vo.dealAmount+"만원</p>"
							+ "<p>면적 : "+vo.area+"</p>"
							+ "<p>"+vo.dealYear+"."+vo.dealMonth+"."+vo.dealDay+"</p>"
							+ "</div>";
							
							//<div class="justify-content-center border-bottom" align="left" style="margin-top:20px">
							//<a href="${root}/house.do?act=house_info&no=${deal.no}"  style="font-size:20px"><b>${deal.aptName }</b></a>
							//<p>거래금액 : ${deal.dealAmount }만원</p>
							//<p>면적 : ${deal.area }</p>
							//<p>${deal.dealYear }.${deal.dealMonth }.${deal.dealDay }</p>
							//</div>
							$("#searchResult").append(str);
						});//each
					}//function
					, "json"
			);//get
		});//change
	});//ready

</script>


<body>
	<div class="container" align="center">

		<div class="col-lg-8" style="margin-top : 100px">
			<h2>거래 목록</h2>
			
			<div style="margin-top: 50px">
				<select id="sido">
					<option value="0">시</option>
				</select>
				<select id="gugun">
					<option value="0">구군</option>
				</select>
				<select id="dong">
					<option value="0">동</option>
				</select>
			</div>
			

			<div style="margin-bottom: 50px">
				<form id="loginform" method="get" action="">
					<input type="hidden" name="pg" id="pg" value=""> <input
						type="radio" id="all" value="all" name="group"
						onclick="location.href='javascript:pageMove(1);'"
						<c:if test="${group eq 'all'}">checked="checked"</c:if>> <label
						for="all">전체</label> <input type="radio" id="apt" value="apt"
						name="group"
						onclick="location.href='javascript:pageMove(1);'"
						<c:if test="${group eq 'apt'}">checked="checked"</c:if>> <label
						for="apt">아파트</label> <input type="radio" id="house" value="house"
						name="group"
						onclick="location.href='javascript:pageMove(1);'"
						<c:if test="${group eq 'house'}">checked="checked"</c:if>>
					<label for="house">주택</label> <select name="category" id="category">
						<option value="apt"
							<c:if test="${apt ne null}">selected="selected"</c:if>>건물
							이름으로 검색</option>
						<option value="dong"
							<c:if test="${dong ne null}">selected="selected"</c:if>>동
							이름으로 검색</option>
					</select>
					<div class="form-group input-group" align="left">
						<input type="text" class="form-control" id="search" name="search"
							placeholder="" value="${search}">
						<div class="input-group-append">
							<button type="button" class="btn btn-dark text-white" onclick="javascript:pageMove_search(1);">검색</button>
						</div>
					</div>
				</form>

			</div>


			<div id="searchResult">
				<c:forEach var="deal" items="${dealList}">
				
					<div class="justify-content-center border-bottom" align="left" style="margin-top:20px">
						<a href="${root}/house/detail?no=${deal.no}"  style="font-size:20px"><b>${deal.aptName }</b></a>
						<p>거래금액 : ${deal.dealAmount }만원</p>
						<p>면적 : ${deal.area }</p>
						<p>${deal.dealYear }.${deal.dealMonth }.${deal.dealDay }</p>
					</div>
	
	
				</c:forEach>
			 </div>


			${navigation.navigator}


		</div>
	</div>
</body>
</html>