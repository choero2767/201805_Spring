<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form action="/user/userUpdateForm" method="get" class="form-horizontal"
	role="form">

	<%
		UserVo user = (UserVo) request.getAttribute("userVo");
	%>http://localhost:8081/profile/brown.png

	<!-- 아이디값 보내기** -->
	<input type="hidden" id="userId" name="userId"
		value="${userVo.userId }">

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">



			<c:choose>
				<c:when test="${userVo.profile != null }">
					<img src="${userVo.profile }" />
				</c:when>
				<c:otherwise>
					<!-- 									<img src="./profile/noimage.png" width = "150" height="150"/> -->
					<img src="/fileDownload?userId=${userVo.userId}" />
				</c:otherwise>
			</c:choose>

		</div>
	</div>


	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.userId}</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이름</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.name}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.add1}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.add2}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.zipcd}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">생년월일</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.birth}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">이메일</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.email}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">연락처</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.tel}</label>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">수 정</button>

		</div>
	</div>
</form>

