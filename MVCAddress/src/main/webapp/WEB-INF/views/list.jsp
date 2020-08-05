<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Address</title>
</head>
<body>

<h2>MVC 주소록</h2>

<form action="listQuery" method="post">
	검색 선택 :
	<select name="query">
		<option value="NAME">이름</option>
		<option value="TELNO">전화번호</option>
		<option value="ADDRESS" selected="selected">주소</option>
		<option value="RELATION">관계</option>
	</select>
		<input type="text" name="content" size="30">
		<input type="submit" value="검색">
</form>
<br><br>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>전자우편</th>
		<th>관계</th>
	</tr>
	
	<c:forEach items="${ list }" var="dto">
	<tr>
		<td><a href="updateform?seq=${dto.seq }">${dto.seq }</a></td>
		<td>${dto.name }</td>
		<td>${dto.telno }</td>
		<td>${dto.address }</td>
		<td>${dto.email }</td>
		<td>${dto.relation }</td>
	</tr>
	</c:forEach>	
</table>

<p><a href="writeForm">주소록 등록</a></p>


</body>
</html>