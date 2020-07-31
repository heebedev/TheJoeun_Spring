<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<% request.setCharacterEncoding("utf-8"); %>
<meta charset="UTF-8">
<title>사용자 정보 입력</title>

</head>
<body>

	<form action="inforesult">
	
이름 : <input type="text" name = "name"> <br>
아이디 : <input type="text" name = "id"> <br>
패스워드 : <input type="password" name = "pw"> <br>
취미 : <input type="checkbox" name ="hobby" value="독서">독서
	<input type="checkbox" name ="hobby" value="요리">요리
	<input type="checkbox" name ="hobby" value="조깅">조깅
	<input type="checkbox" name ="hobby" value="수영">수영 <br>
전공 : <input type="radio" name="major" value="국어">국어
	<input type="radio" name="major" value="영어">영어
	<input type="radio" name="major" value="디자인">디자인 <br>
Protocol : <select name="protocol">
			<option value="HTTP">HTTP</option>
			<option value="FTP">FTP</option>
		</select> <br>
	
	<input type="submit" value="전송">
	</form>
	<input type="button" value="취소" href="userinfo">


</body>
</html>