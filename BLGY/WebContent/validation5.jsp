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
<input type="hidden" value= "${validation.email}" name="userseq" id="userseq">
</form>
<script>
var x = document.getElementById('validation').value;	
var userseq = document.getElementById('userseq').value;
redirect();
function redirect() {	
	if (x == 1) {
		window.location.href = './privateinfo.bill?userseq='+userseq;
	}
	else if (x == -1) {
		window.location.href = './close.jsp';
		alert("일치하지 않는 비밀번호 입니다.");
	}
	else {
		window.location.href = './close.jsp';
		alert("에러. 관리자에게 문의해주시기 바랍니다.");
	}
}
</script>
</body>
</html>