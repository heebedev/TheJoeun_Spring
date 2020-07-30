<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATE PAGE</title>
</head>
<body>
	createPage.jsp<br>
	
	<%
		String conPath = request.getContextPath();
	%>
	
	
	<!-- conPath : 다른 jsp를 리턴할때는 상관없는데 자기 자신을 다시 부를때는 conPath를 쓴다.  -->
	<form action="<%=conPath %>/student/create">
		이름 : <input type="text" name="name" value="${student.name}"> <br>
		아이디 : <input type="text" name="id" value="${student.id}"> <br>
		<input type="submit" value="OK">
	</form>
</body>
</html>