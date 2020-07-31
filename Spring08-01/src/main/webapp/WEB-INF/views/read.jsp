<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기</title>
</head>
<body>

	<Table>
		<form action="update" method="post">
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="20" value="${dto.bName }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="20" value="${dto.bTitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows="10">${dto.bContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"> 
				<input type="hidden" name="bId" value="${dto.bId }">
				<input type="submit" value="수정"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
				<input type="button" value="삭제" onClick="location.href='delete?bId=${dto.bId }'"><br>
				<input type="button" value="뒤로가기" onClick="location.href='list'">
				</td>
			</tr>
			
		</form>
	</Table>
	<br>
	
	



</body>
</html>