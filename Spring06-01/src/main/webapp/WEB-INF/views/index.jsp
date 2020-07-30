<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>

Get<br>
	<form action ="student" method="get">
		student id : <input type="text" name="id"><br>
		<input type = "submit" value="확인">
	
	</form>
<hr>
Post<br>
	<form action ="student" method="post">
		student id : <input type="text" name="id"><br>
		<input type = "submit" value="확인">
	
	</form>

</body>
</html>