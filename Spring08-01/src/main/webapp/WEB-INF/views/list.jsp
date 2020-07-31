<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC 게시판</title>
</head>
<body>

	<table width = "500" style="cellpadding:0 ; cellspacing:0" border = "1">
	
	
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td><a href="read?bId=${dto.bId}">${dto.bTitle }</a></td>
				<td>${dto.bDate }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="write">글작성</a></td>
		</tr>
	
	</table>

</body>
</html>