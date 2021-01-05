<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select name="sigungu" id="sigungu">
	<c:forEach var="sigungu" items="${sigungu}" varStatus="status">
	  <option value="${sigungu.sigunguCode}">${sigungu.sigunguNm}</option>
	</c:forEach>
</select>
