<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select name="kind" id="kind">
	<c:forEach var="kind" items="${animalkind}" varStatus="status">
	  <option value="${kind.kindCd}">${kind.kindNm}</option>
	</c:forEach>
</select>
