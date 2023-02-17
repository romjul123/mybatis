<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멤버 목록</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<style>
			table { --margin : 0 auto;}
		</style>
	</head>
	<body>
		<jsp:include page="../common/menuBar.jsp"></jsp:include>
		<br><br>
		<div>
			<div>
				<table class="table table-hover table-condensed">
					<colgroup>
						<col width="80" align="center">
						<col width="200">
						<col width="200">
						<col width="400">
					</colgroup>
					<thead>
						<tr>
							<th>No</th>
							<th>회원ID</th>
							<th>이름</th>
							<th>주소</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mList }" var="member" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td>${member.memberId }</td>
								<td>${member.memberName }</td>
								<td>${member.memberAddr }</td>
								<td>
									<c:if test="${sessionScope.member.memberId eq member.memberId }">
									<a class="btn btn-xs btn-warning" href="/member/modify.do">UPDATE</a>
									</c:if>
								</td>
								<td>
									<c:if test="${sessionScope.member.memberId eq member.memberId }">
										<a class="btn btn-xs btn-danger" href="/member/delete.do">DELETE</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6" align="center">
							${pageNavi }
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</body>
</html>