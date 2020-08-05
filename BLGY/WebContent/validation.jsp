<%@page import="com.sun.org.apache.bcel.internal.generic.DADD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<input type="hidden" value= "${validation.validation}" name="validation" id="validation">
<input type="hidden" value= "${validation.email}" name="email" id="email">
</form>
<%session.invalidate();%>
<script>
var x = document.getElementById('validation').value;	
var email = document.getElementById('email').value;
redirect();
function redirect() {	
	if (x == 1) {
		window.location.href = './importInfo.bill?email='+email;
	}
	else if (x == 0) {
		window.location.href = './invalidRequest.bill';
		alert("존재하지 않는 아이디입니다.");
	}
	else if (x == -1) {
		window.location.href = './invalidRequest.bill';
		alert("일치하지 않는 비밀번호 입니다.");
	}
	else if (x == 2) {
		window.location.href = './adminmain.bill';
	}
	else {
		window.location.href = './invalidRequest.bill';
		alert("에러. 관리자에게 문의해주시기 바랍니다.");
	}
}
</script>
</body>
</html>