<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
<%
request.setCharacterEncoding("UTF-8");
String email="";
String nickname="";
String password="";
email=request.getParameter("email");
nickname=request.getParameter("nickname");
password=request.getParameter("pw");
%>
function addresspop(){
	var addressPop = window.open("./jusoPopup.jsp","addressPop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo,entX,entY){
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.addrDetail.value = addrDetail;
		document.form.entX.value = entX;
		document.form.entY.value = entY;	
}
function populatedropdown(dayfield, monthfield, yearfield){
	var today=new Date()
	var dayfield=document.getElementById(dayfield)
	var monthfield=document.getElementById(monthfield)
	var yearfield=document.getElementById(yearfield)
	    for (var i=0; i<31; i++)
	        dayfield.options[i]=new Option(i+1, i+1)
	    for (var m=0; m<12; m++)
	        monthfield.options[m]=new Option(m+1, m+1)
	var thisyear=today.getFullYear()
	    for (var y=0; y<100; y++){
	        yearfield.options[y]=new Option(thisyear, thisyear)
	        thisyear-=1
    }
    yearfield.options[0]=new Option(today.getFullYear(), today.getFullYear(), true, true)
}
$(document).ready(function(){
	  $("#pwbtn").click(function(){
	    $("p").toggle();
	  });
	});

</script>
	<style type="text/css">
			body{			
			max-width:350px;
			margin: 0 auto;
		}
			input[type="text"] {
			width: 300px;
			padding: 10px 20px; 
			margin:5px 0;			
			border: solid 2px black;
			border-radius: 8px; 
		}
			input[type="submit"] {
			width: 300px;
			padding: 10px 20px; 
			margin:5px 0;			
			border: solid 2px black;
			border-radius: 8px; 
		}
			input[type="button"] {
			width: 300px;
			padding: 10px 20px; 
			margin:5px 0;			
			border: solid 2px black;
			border-radius: 8px; 
		}
			input[type="password"] {
			width: 300px;
			padding: 10px 20px; 
			margin:5px 0;			
			border: solid 2px black;
			border-radius: 8px; 
		}
	</style>
	
<title>개인정보 수정</title>
</head>
<body>
<center>
<h1>개인정보 수정</h1>
</center>
	<div id="list"></div>
	<div id="callBackDiv">
<form action="./updateuserdata.bill" name="form" id="form" method="post">
		<table>
			<tr><td><center><input type="button" value="비밀번호수정" id="pwbtn"></center>
			<p style="display:none;"><input type="password" name=pw value="${userdata.pw}"></p></td></tr>
			<tr><td><input type ='text' name='nickname' placeholder = '닉네임' value="${userdata.nickname}"/></td></tr>
			<tr><td><input type ='text' name='telno' placeholder = '전화번호' value="${userdata.telno}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/></td></tr>
			<tr><td><input type="text" id="roadAddrPart1" placeholder= '주소' value="${userdata.address}"name="address" onClick="addresspop();" readonly/></td></tr>
			<tr><td><input type="text" id="addrDetail"  placeholder='상세주소' value="${userdata.addressdt}"name="addressdt" /></td></tr>
			<tr><td><input type="hidden" id="entX"  placeholder='위도'name="entX" value="${userdata.xaxis}"/></td></tr>
			<tr><td><input type="hidden" id="entY" placeholder='경도' name="entY" value="${userdata.yaxis}"/></td></tr>
			<tr><td><input type="hidden" id="email" placeholder='경도' name="email" value="${userdata.email}"/></td></tr>
		</table>
			<center>
			<input type="submit" value="수정하기">
			</center>
</form>
	</div>

</body>
</html>