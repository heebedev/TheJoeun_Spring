<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>내용</th>
		<th>삭제</th>
	</tr>
	
	<c:forEach items="${ list }" var="dto">
	<tr>
		<td>${dto.mId }</td>
		<td>${dto.mWriter }</td>
		<td>${dto.mContent }</td>
		<td><a href="delete?mId=${dto.mId }">X</a></td>
	</tr>
	</c:forEach>	
</table>

<p><a href="writeForm">글작성</a></p>

</body>
</html>