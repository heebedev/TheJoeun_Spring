<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
function goPopup(){
	var pop = window.open("./jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
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
	</style>
	
<title>회원가입</title>
</head>
<body>
<h1 style= "text-align: center;"><a class="home" href="Mainpage.bill"><img src="logo.png" alt="logo" height="130" width="240"></a></h1>
<h1 align= "center">개인정보 입력</h1>
<form action="createAcc.bill" name="form" id="form" method="post">
	<div id="list"></div>
	<div id="callBackDiv">
		<table>
			<tr><td><input type ='text' name='email' placeholder = '이메일' id='email' value="<%=email%>" readonly/></td></tr>
			<tr><td><input type ='text' name='name' placeholder = '이름' id='name'></td></tr>
			<tr><td><input type ='text' name='nickname' placeholder = '닉네임'value="<%=nickname%>"></td></tr>
			<tr><td>
			<div>
			<b style="color: gray;"> &nbsp &nbsp 생년월일 &nbsp &nbsp </b>
			<select name='year' id="daydropdown" style="width: 100px;height: 30px; border: solid 2px black; border-radius: 8px;"></select>
			<select name='month'id="monthdropdown"style="width: 70px;height: 30px; border: solid 2px black; border-radius: 8px;"></select>
			<select name='day' id="yeardropdown"style="width: 70px;height: 30px; border: solid 2px black; border-radius: 8px;"></select>
			<script type="text/javascript">
			window.onload=function(){populatedropdown("yeardropdown", "monthdropdown", "daydropdown")}
			</script>
			</div>
			</td></tr>
			<tr><td><input type ='text' name='telno' placeholder = '전화번호' onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/></td></tr>
			<tr><td><input type="text" id="roadAddrPart1" placeholder= '주소' name="address" onClick="goPopup();" readonly/></td></tr>
			<tr><td><input type="text" id="addrDetail"  placeholder='상세주소' name="addressdt" /></td></tr>
			<tr><td><input type="hidden" id="entX"  placeholder='위도'name="entX" /></td></tr>
			<tr><td><input type="hidden" id="entY" placeholder='경도' name="entY" /></td></tr>
			<tr><td><input type='hidden' name='pw1' placeholder = '비밀번호' value="<%=password%>"></td></tr>
		</table>
			<center>
			<input type="submit" value="가입하기">
			</center>
			
	</div>

</form>

</body>
</html>