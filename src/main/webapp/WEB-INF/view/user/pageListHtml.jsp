<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- userList --%>
<%-- <c:forEach items="${userList}" var="user">
	<tr onClick="alertId('${user.userId}')">
		<td>${user.rnum }</td>
		<td>${user.userId }</td>
		<td>${user.name }</td>
		<td><fmt:formatDate value="${user.birth}" pattern="yyyy-MM-dd" /></td>
	</tr>
</c:forEach> --%>

<li><a href="javascript:getUserList(1);" aria-label="Previous">
		<span aria-hidden="true">&laquo;</span>
</a></li>


<c:forEach begin="1" end="${pageCnt}" var="i">
	<li><a href="javascript:getUserList(${i});">${i}</a></li>
</c:forEach>

<li><a href="javascript:getUserList(${pageCnt});"
	aria-label="Next"> <span aria-hidden="true">&raquo;</span>
</a></li>
