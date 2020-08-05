<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>빌릴꼬냥</title>
	<style type="text/css">
		body{			
			max-width:1000px;
			margin: 0 auto;
		}
		ul {
			background-color: white;
			list-style-type: none;
			margin: 0;
			padding: 0;
			overflow: hidden;
		}
		li { float: left; }
		li a {
			display: block;
			background-color: white;
			color: #000000;
			padding: 8px;
			text-decoration: none;
			text-align: center;
			font-weight: bold;
		}
		li a:hover:not(.current) {
			background-color: gray;
			color: blue;
			text-decoration:underline;
		}
		li a.home{
			background-color: black;
			color: white;
		}
		input[type="text"] {
			width: 20%;
			padding: 10px 20px; 
			margin:5px 0;			
			border: solid 2px black;
			border-radius: 8px; 
		}
	div.post {position:realative; width: 80%; height:1200px; top:50px; margin:auto;}
	div.banner {position: relative; width: 100%; height: 210px;  margin:0 auto; padding:0; overflow: hidden;}
	div.banner ul {position: absolute; margin: 0px; padding:0; list-style: none; }
	div.banner ul li {float: left; width: 1000px; height: 210px; margin:0; padding:0;}
	
		textarea{
			width:100%;
			padding 10px 20px;
			margin: 5px 0;
			border: solid 2px black;
			border-radius: 8px;
			height: 500px;
		}
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="./jquery-ui-1.12.1/jquery-ui.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="./jquery-ui-1.12.1/jquery-ui.min.js"></script>
	<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>

<script type="text/JavaScript">
	$(document).ready(function() {
		var $banner = $(".banner").find("ul");

		var $bannerWidth = $banner.children().outerWidth();
		var $bannerHeight = $banner.children().outerHeight();
		var $length = $banner.children().length;
		var rollingId;

		rollingId = setInterval(function() { rollingStart(); }, 5000);
    
		function rollingStart() {
			$banner.css("width", $bannerWidth * $length + "px");
			$banner.css("height", $bannerHeight + "px");
			$banner.animate({left: - $bannerWidth + "px"}, 1500, function() {
				$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
				$(this).find("li:first").remove();
				$(this).css("left", 0);
			});
		}
	}); 
</script>
<script type="text/javascript">

function goPopup(){
	var pop = window.open("./jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
</script>
</head>

<body>
	<ul>
			<li><a class="home" href="mainpage2.bill">홈</a></li>
		<ul style="float:right; list-style-type:none;">
			<li><a href="mypage.bill">마이페이지</a></li>
			<li><a href="logOut.bill">로그아웃</a></li>
			<li><a href="newPost.bill">게시글 작성하기</a></li>
		</ul>
	</ul>
		<div class="banner">
			<ul>
				<li><img src="https://media.bunjang.co.kr/images/nocrop/471722706.jpg" width="100%" height="210px"></li>
				<li><img src="https://media.bunjang.co.kr/images/nocrop/465890574.jpg" width="100%" height="210px"></li>
				<li><img src="https://media.bunjang.co.kr/images/nocrop/415809298.jpg" width="100%" height="210px"></li>
				<li><img src="https://media.bunjang.co.kr/images/nocrop/472834031.jpg" width="100%" height="210px"></li>
			</ul>
		</div>
	
	<div class="post">
	<form action="post.bill" form="form"> 
	<input type='text' name='title' style='width:500px;'>
	<center>
	<textarea name="info"></textarea>
	</center>
		
	</form>
	<form onsubmit>
	</form>
	</div>	
</body>
</html>