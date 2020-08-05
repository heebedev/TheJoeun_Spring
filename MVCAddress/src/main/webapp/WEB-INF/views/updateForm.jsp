<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 등록</title>
</head>
<body>
	<table border="1">
		<form action="update" method="get">
			<input type="hidden" name="seq" value="${detail.seq }">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="150" value="${detail.name }"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="telno" size="150" value="${detail.telno }"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" size="150" value="${detail.address }"></td>
			</tr>
			<tr>
				<td>전자우편</td>
				<td><input type="text" name="email" size="150" value="${detail.email }"></td>
			</tr>
			<tr>
				<td>관계</td>
				<td><input type="text" name="relation" size="150" value="${detail.relation }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</form>
	</table>
	
	<a href="delete?seq=${detail.seq }">삭제</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="list">목록보기</a>

</body>
</html>