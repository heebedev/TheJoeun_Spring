<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<form action="write" method="get">
		<tr>
			<td>작성자</td>
			<td><input type="text" name="mWrite" size="50"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="mContent" size="150"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="입력"> &nbsp;&nbsp;&nbsp;<a href="list">목록보기</a></td>
		</tr>
	</form>
</table>

</body>
</html>