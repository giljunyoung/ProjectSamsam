<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<c:forEach var="animal" items="${animalList}" varStatus="status">
	<div class="pet-box">
		<div class="pet-img">
		  <img src="${animal.filename }" alt="img" />
		</div>
		<div class="pet-content">
			<span>${animal.kindCd }</span>
			<span>${animal.sexCd }</span>
			<span>${animal.happenDt }</span>
			<span>${animal.orgNm }</span>
			<span>${animal.happenPlace }</span>
		</div>
	</div>
</c:forEach>