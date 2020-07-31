<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<% request.setCharacterEncoding("utf-8"); %>
<meta charset="UTF-8">
<title>결과</title>

</head>
<body>

이름 : ${result.name } <br>
아이디 : ${result.id } <br>
패스워드 : ${result.pw } <br>
취미 : [
 <c:forEach items="${result.hobby }" var="item">
 	${item} 
 </c:forEach>] <br>
전공 : ${result.major } <br>
Protocol : ${result.protocol } <br>

</body>
</html>