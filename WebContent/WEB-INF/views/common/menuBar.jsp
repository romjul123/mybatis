<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<style>
			h1 {
				text-align : center;
			}
			.menu {
				display : table-cell;
				width : 250px;
				height : 50px;
				text-align : center;
				vertical-align : middle;
				font-size : 20px;
				background : yellowgreen;
				color : black;
			}
			.menu:hover { background : white; cursor : pointer; }
			.login-table {
 				float : right; 
				--table-collapse : collapes;
			}
			.login-area {
				height : 80px;
			}
		</style>
	</head>
	<body>
		<h1>Welcome to MybatisWeb</h1>
		<br>
		<div class="login-area">
			<c:if test="${sessionScope.member eq null }">
			<form action="/member/login.do" method="post">
				<table class="login-table">
					<tr>
						<td>아이디 : </td>
						<td><input type="text" name="member-id"></td>
						<td rowspan="2"><button style="height:50px;">로그인</button></td>
					</tr>
					<tr>
						<td>비밀번호 : </td>
						<td><input type="password" name="member-pw"></td>
					</tr>
				</table>
			</form>
			</c:if>
			<c:if test="${sessionScope.member ne null }">
				<table class="login-table">
					<tr>
						<td>
							<b>${sessionScope.member.memberName }</b>님 환영합니다!
						</td>
					</tr>
					<tr>
						<td>
							<a href="/member/logout.do">로그아웃</a>
						</td>
					</tr>
				</table>
			</c:if>
		</div>
		<div>
			<div class="menu" onlick="">Home</div>
			<div class="menu" onlick="">멤버목록</div>
			<div class="menu" onlick="">강좌목록</div>
			<div class="menu" onlick="">게시판</div>
			<div class="menu" onlick="">ETC</div>
		</div>
	</body>
</html>