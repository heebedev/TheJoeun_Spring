<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC 게시판</title>
</head>
<body>
	<table width = "500" cellpadding = "0" cellspacing = "0" border = "1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items = "${list}" var = "dto">
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td><a href = "detail?bId=${dto.bId}">${dto.bTitle}</a></td>
				<td>${dto.bDate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href = "write_view">글작성</a></td>
		</tr>
	</table>

</body>
</html>