<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userdata" class="com.blgy.dto.UserDto" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.location.href = 'Mainpage.bill?userseq='+ <jsp:getProperty property="userseq" name="userdata"/>;
</script>
</head>
<body>
</body>
</html>