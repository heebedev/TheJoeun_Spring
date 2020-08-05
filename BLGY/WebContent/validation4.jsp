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
<input type="hidden" value= "${dup.validation}" name="validation" id="validation">
<input type="hidden" value= "${dup.email}" name="email" id="email">
</form>
<%session.invalidate();%>
<script>
var x = document.getElementById('validation').value;	
var email = document.getElementById('email').value;
redirect();
function redirect() {	
	if (x == 1) {
		alert("사용할 수 없는 아이디입니다.");
		window.opener.document.info.dup.value = "true";
		self.close();
	}
	else if (x == 0) {
		alert("사용가능한 아이디입니다.");
		window.opener.document.info.dup.value = "false";
		window.opener.document.info.email.readOnly = true;
		self.close();
	}
	else {
		alert("에러. 관리자에게 문의해주시기 바랍니다.");
		self.close();
	}
}
</script>
</body>
</html>