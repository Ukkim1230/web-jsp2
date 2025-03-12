<%@page import="com.web.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 리스트</title>
</head>
<body>
<a href="/views/user/user-insert">유저추가</a>
${empty users}
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.uiNum}</td>
				<td><a href="/user/user-view?uiNum=${user.uiNum}">${user.uiName}</a></td>
				<td>${user.uiAge}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>