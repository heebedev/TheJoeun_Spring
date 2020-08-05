<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <jsp:useBean id="userdata" class="com.blgy.dto.UserDto" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<input type="text" value= "<%=request.getAttribute("prdseq") %>" name="prdseq" id="prdseq">
<input type="text" value= "<jsp:getProperty property="userseq" name="userdata"/>" name="myseq" id="myseq">
</form>
<script>

window.location.href = './productDetail.bill?prdseq='+document.getElementById('prdseq').value+'&userseq='+document.getElementById('myseq').value;
	
</script>
</body>
</html>