<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
	
	<Table>
		<form action="insert" method="post">
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="20"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="20"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="입력"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="list">목록보기</a></td>
			</tr>
			
		</form>
	</Table>



</body>
</html>