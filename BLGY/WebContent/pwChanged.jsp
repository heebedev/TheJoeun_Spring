<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script type="text/javascript">
alert( '<%=request.getParameter("email")%>님의 비밀번호가 변경되었습니다.');
self.close();
</script>
</body>
</html>