<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%@ include file="../header/header.jsp" %>
<%@ include file="../menu/nav.jsp"%>

<c:set var="root" value="${pageContext.request.contextPath }"></c:set>

<body>

<%--
	<table class = "table table-striped table-bordered">
		  	<tbody align="center">
		  		<tr>
		  			<th></th>
		  			<th>Dong</th>
		  			<th>aptName</th>
		  		</tr>
		  		<tr>
		  			<td><img src="${root}/img/${deal.img}"  class="img-thumbnail" style="width: 200px; height : 200px"></td>
		  			<td>${deal.dong }</td>
		  			<td>${deal.aptName }</td>
		  		</tr>
		  		
		  		<tr>
		  			<th>건설년도</th>
		  			<th>거래가</th>
		  			<th>거래일자</th>
		  		</tr>
		  		<tr>
		  			<td>${deal.buildYear }</td>
		  			<td>${deal.dealAmount }</td>
		  			<td>${deal.dealYear }.${deal.dealMonth }.${deal.dealDay }</td>
		  		</tr>
		  		
		  		<tr>
		  			<th>면적</th>
		  			<th>층</th>
		  			<th>지번</th>
		  		</tr>
		  		<tr>
		  			<td>${deal.area }</td>
		  			<td>${deal.floor }</td>
		  			<td>${deal.jibun }</td>
		  		</tr>
		  	</tbody>
	</table>
 --%>
	<div class="container" style="margin-top: 100px">
		<img src="${root}/resources/img/${deal.img}"  class="img-thumbnail" style="width: 200px; height : 200px; float:left">
		<div style="float:left; margin-left:50px; margin-top:20px" class="col-8">
			<h5 class="text-primary"><b>${deal.dong } ${deal.aptName }</b></h5>
			<table>
				<tbody>
					<tr>
						<th>건설년도</th>
			  			<th>거래일자</th>
			  			<th>거래가</th>
					</tr>
					<tr>
						<td><p>${deal.buildYear }</p></td>
						<td><p>${deal.dealYear }.${deal.dealMonth }.${deal.dealDay }</p></td>
						<td><p>${deal.dealAmount }</p></td>
					</tr>
					
					<tr>
			  			<th>면적</th>
			  			<th>층</th>
			  			<th>지번</th>
			  		</tr>
			  		<tr>
			  			<td>${deal.area }</td>
			  			<td>${deal.floor }</td>
			  			<td>${deal.jibun }</td>
			  		</tr>
				</tbody>
			</table>
		</div>
		
		<div style="clear : both"></div>
		
		
		<div style="margin-top:100px">
		<h2 class="text-info">주변 상권 정보</h2>
	
		<c:choose>
			<c:when test="${shops.size() ==0 }">
				<h3 class="text-info">상권 정보가 없습니다.</h3>
			
			</c:when>
			
			<c:otherwise>
				<c:forEach var="shop" items="${shops}">
				
				<%--
				</br>
				</br>
		  		<table class = "table table-striped table-dark table-bordered">
		  			<tbody align="center">
			  			<tr>
			  				<th>상호명</th>
			  				<th>분류</th>
			  				<th>층 정보</th>
			  			</tr>
			  			
			  			<tr>
			  				<td>${shop.shopName }</td>
			  				<td>${shop.smallCategoryName }</td>
			  				<td>${shop.floorInfo }</td>
			  			</tr>
			  			
			  			<tr>
			  				<th>도로명주소</th>
			  				<th>위도</th>
			  				<th>경도</th>
			  			</tr>
			  			
			  			<tr>
			  				<td>${shop.roadAddress }</td>
			  				<td>${shop.longitude}</td>
			  				<td>${shop.latitude }</td>
			  			</tr>
		  			</tbody>
		  		</table>
		  		 --%>
		  		<div class="border-bottom" style="margin: 30px">
		  			<h4>${shop.shopName }</h4>
		  			<p>${shop.smallCategoryName }</p>
		  			<p>${shop.roadAddress }</p>
		  		</div>
		  		</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	</div>
	
	
	
	
	
</body>
</html>