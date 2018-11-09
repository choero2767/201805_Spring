<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">
	.userClick{
		cursor : pointer;
	}
</style>

<script type="text/javascript">
	/*$(document).ready(function addRowHandlers(){
		var table = document.getElementById("tableId");
		var rows = table.getElementsByTagName("tr");
		for(i = 0; i < rows.length; i++){
			var currentRow = table.row[i];
			var createClickHandler = function(row){
				return function(){
					var cell = row.getElementsByTagName("td")[1];
					var id = cell.innerHTML;
					alert("사용자 아이디 : " + id);
				};
			};
			currentRow.onClick = createClickHandler(currentRow);
		}
	});
	*/
	function alertId(userId){
		alert("사용자 아이디 : " + userId);
		location.href = "/user/userDetail?userId=" + userId; 
	}
	
	// 교수님 방식
	$(document).ready(function(){
		console.log("document.ready");
		
		// tr에 select (class="userClick")
		$(".userClick").click(function(){
			console.log("userClick");
		});
		
		var ev = "click";
		$("#userList").on("click", ".userClick", function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerHTML;
			
			$("#userId").val(userId);
			$("frm").submit();
		});
		
 		getUserList(1);
		getUserListHtml(1);				// userList html로 리턴해주는 함수
// 		getUserPagenationHtml(1);
	});
	
	
	
function getUserPaginationHtml(page){
	var pageSize = 10;
	
	$.ajax({
		type : "GET",
		url : "/user/userPaginationAjaxHtml",
		data : "page="+page+"&pageSize="+pageSize,
		success : function(dt){
			$(".pagination").html(dt);
		}
	});
}

function getUserListHtml(page){
	var pageSize = 10;
	
	$.ajax({
		type : "GET",
		url : "/user/userPageListAjaxHtml",
		data : "page="+page+"&pageSize="+pageSize,
		success : function(dt){
			$(".pagination").html(dt);
		}
	});
}


// page인자를 받아서
// 해당 페이지에 속하는 사용자 리스트 정보를 가져온다.
function getUserList(page){
	var pageSize = 10;
	console.log("page : " + page);
	
	// ajax call 
	// 사용자 리스트 데이터만 가져오기
	// html(as-is) --> json(to-be) 데이터를 받는 형태로 변경
	
	$.ajax({
		type : "GET",
		url : "/user/userPageListAjax",
		data : "page="+page+"&pageSize="+pageSize,
		success : function(data){
			// data(사용자 json 데이터)를 바탕으로
			// 사용자 리스트를 갱신
			// 1. 기존 리스트를 삭제
			// 2. data를 이용하여 table 태그(tr)를 작성
			// 3. 기존 리스트 위치에다가 붙여넣기
			
			console.log(data);
			var html = "";
			$.each(data.userList, function(idx, user){
				console.log(user);
				html += "<tr class='userClick'>";
				html += "	<td>"+ user.rnum + "</td>";
				html += "	<td>"+ user.userId + "</td>";
				html += "	<td>"+ user.name + "</td>";
				html += "	<td>"+ user.formattedBirth + "</td>";
				html += "</tr>";
			});
			
			$("#userList").html("");
			$("#userList").html(html);
			
			// data.userList
			
// 			<tr onClick = "alertId('${vo.userId}')">
// 			<td>${vo.rnum }</td>
// 			<td>${vo.userId }</td>
// 			<td>${vo.name }</td>
// 			<td><fmt:formatDate value="${vo.birth}" pattern="yyyy-MM-dd"/></td>
// 		</tr>
		}
			
	});
	
}
</script>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id = "tableId">
				<thead>			
					<tr>
						<th>번호</th>
						<th>사용자 아이디</th>
						<th>사용자 이름</th>
						<th>사용자 별명</th>
					</tr>
				</thead>
				
				<tbody id="userList">
				<!-- pageList loop 이용하여 출력 -->
				
					<c:forEach items="${userList}" var="vo">
						<tr onClick = "alertId('${vo.userId}')">
							<td>${vo.rnum }</td>
							<td>${vo.userId }</td>
							<td>${vo.name }</td>
							<td><fmt:formatDate value="${vo.birth}" pattern="yyyy-MM-dd"/></td>
						</tr>
					</c:forEach>
					
				</tbody>	
			</table>
		</div>
		
		<!-- userForm -->
		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>
		
<!-- 		 <li> -->
<!--       			<a href="/user/userPageList?page=1&pageSize=10" aria-label="Previous"> -->
<!--        			 <span aria-hidden="true">&laquo;</span> -->
<!--       			</a> -->
<!--     		</li> -->

<%-- 			<c:forEach begin="0" end="${pageCnt-1 }" var="i"> --%>
<%-- 					<li><a href="/user/userPageList?page=${i+1 }&pageSize=10">${i+1 }</a></li> --%>
<%-- 			</c:forEach> --%>


		<div class="text-center">
			<ul class="pagination">
			 <li>
      			<a href="javascript:getUserList(1);" aria-label="Previous">
       			 <span aria-hidden="true">&laquo;</span>
      			</a>
    		</li>
			
			
			<c:forEach begin="0" end="${pageCnt}" var="i">
					<li><a href="javascript:getUserList(${p });">${i+1 }</a></li>
			</c:forEach>
			
			 <li>
      		<a href="javascript:getUserList(${pageCnt });" aria-label="Next">
        		<span aria-hidden="true">&raquo;</span>
     		 </a>
    		</li>
			</ul>
		</div>
	</div>
</div>