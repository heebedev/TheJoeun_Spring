<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<table>
		<form action="update" method="post">
		
			<tr>
				<td>아이디</td>
				<td><input type="text" name="bId" size="30" value="${bId}" readonly="readonly">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="30" value="${bName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" value="${bTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows="10" >${bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list">목록보기</a>
			</tr>
			
		</form>
	</table>
</body>
</html>