<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userdata" class="com.blgy.dto.UserDto" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:setProperty property="userseq" name="userdata" value="${userData.userseq}"/>
<jsp:setProperty property="nickname" name="userdata" value="${userData.nickname}"/>
<jsp:setProperty property="xaxis" name="userdata" value="${userData.xaxis}"/>
<jsp:setProperty property="yaxis" name="userdata" value="${userData.yaxis}"/>
<script>
window.location.href = 'Mainpage.bill?userseq='+${userData.userseq};
</script>
</head>
<body>
</body>
</html>