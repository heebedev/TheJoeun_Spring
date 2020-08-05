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
<input type="hidden" value= "${pw.validation}" name="validation" id="validation">
<input type="hidden" value= "${pw.email}" name="email" id="email">
</form>
<%session.invalidate();%>
<script>
var x = document.getElementById('validation').value;	
var email = document.getElementById('email').value;
redirect();
function redirect() {	
	if (x == 1) {
		window.location.href = './resetPw.jsp?email='+email;
	}
	else if (x == 0) {
		window.location.href = './FindPw.bill';
		alert("존재하지 않는 정보조합입니다.");
	}
	else {
		window.location.href = './FindPw.bill';
		alert("에러. 관리자에게 문의해주시기 바랍니다.");
	}
}
</script>
</body>
</html>