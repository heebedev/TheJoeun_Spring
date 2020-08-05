<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content Detail</title>
</head>
<body>
	<table width = "500" cellpadding = "0" cellspacing = "0" border = "1">
		
		<c:forEach items = "${detail}" var = "dto">
			<tr>
				<td>아이디 : </td>
				<td>${dto.bId}</td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td>${dto.bName}</td>
			</tr>
			<tr>
				<td>제목 : </td>
				<td>${dto.bTitle}</a></td>
			</tr>	
			<tr>	
				<td>내용 : </td>
				<td>${dto.bContent}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="update_view?bId=${dto.bId}&bName=${dto.bName}&bTitle=${dto.bTitle}&bContent=${dto.bContent}">수정</a>&nbsp;&nbsp;&nbsp;<a href="delete?bId=${dto.bId}">삭제</a></td>
			</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>