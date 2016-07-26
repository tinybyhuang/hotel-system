<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>

<!-- 验证码图片刷新 -->
<script type="text/javascript">
	var flag = 0;
	var ss = "&nbsp;&nbsp;&nbsp;&nbsp;";

	//创建异步对象
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();//大多数浏览器
		} catch (e) {
			try {
				return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
			} catch (e) {
				try {
					return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
				} catch (e) {
					alert("当前使用的浏览器不支持该功能");
					throw e;
				}
			}
		}
	}

	window.onload = function() {
		// 获取文本框，给它的失去焦点事件注册监听
		var userEle = document.getElementById("inp1");
		var text = 0;
		userEle.onfocus = function() {//给按钮的点击事件注册监听
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("GET", "<c:url value='../ajax.do'/>", true);
			xmlHttp.send(null);//GET请求没有请求体，但也要给出null，不然FireFox可能会不能发送！
			xmlHttp.onreadystatechange = function() {//当xmlHttp的状态发生变化时执行
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) { // 获取服务器的响应结束
					var span = document.getElementById("sp");
					span.innerHTML = "";
					var span1 = document.getElementById("sp1");
					span1.innerHTML = "";
				}
			};
		};

		userEle.onblur = function() {
			check2();
			//sendpost();
			/* if (text == 0) {
				span.innerHTML = "";
			} */
		}

		var pwd = document.getElementById("inp5");
		var pwd2 = document.getElementById("inp2");

		pwd2.onblur = function() {

			checkpwd();
		}

		pwd2.onfocus = function() {//给按钮的点击事件注册监听
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("GET", "<c:url value='../ajax.do'/>", true);
			xmlHttp.send(null);//GET请求没有请求体，但也要给出null，不然FireFox可能会不能发送！
			xmlHttp.onreadystatechange = function() {//当xmlHttp的状态发生变化时执行
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) { // 获取服务器的响应结束
					var span = document.getElementById("sp");
					span.innerHTML = "";
				}
			};
		};

		pwd.onblur = function() {

			checkpwd();
		}

		pwd.onfocus = function() {//给按钮的点击事件注册监听
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("GET", "<c:url value='../ajax.do'/>", true);
			xmlHttp.send(null);//GET请求没有请求体，但也要给出null，不然FireFox可能会不能发送！
			xmlHttp.onreadystatechange = function() {//当xmlHttp的状态发生变化时执行
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) { // 获取服务器的响应结束
					var span = document.getElementById("sp");
					span.innerHTML = "";
				}
			};
		};

	}
	function check3() {
		var userEle = document.getElementById("inp1");
		var _reg = /^[a-zA-Z_0-9]+$/;
		if (_reg.test(userEle.value)) {
			sendpost();
		} else {
			var sp = document.getElementById("sp1");
			sp.innerText = "用户名只能由字母数字下划线组成";
		}
	}

	function check2() {
		if (!document.f1.username.value.match(/^\S+$/)) {
			ss = "用户名不能为空";
			flag = 1;
			spf();
		} else {
			check3();
		}
		flag = 0;
	}

	function checkpwd() {
		if (document.f1.pwd.value == "" || document.f1.pwd2.value == "") {
			ss = "用户密码不能为空";
			stats = false;
			flag = 1;
			spf();
		} else {
			var password = document.getElementById("inp2");
			var password2 = document.getElementById("inp5");
			if (document.f1.pwd.value != document.f1.pwd2.value) {
				var sp = document.getElementById("sp");
				sp.innerText = "两次输入的密码不一致";
			} else {
				var sp = document.getElementById("sp");
				sp.innerText = "";
			}
		}
	}

	/* if (document.f1.verifycode.value == "") {
	ss = "验证码不能为空";
	stats = false;
	flag = 1;
	spf();
	} else if (document.f1.phone.value == "") {
	ss = "联系电话不能为空";
	stats = false;
	flag = 1;
	spf();
	} else if (document.f1.company.value == "") {
	ss = "公司名不能为空";
	stats = false;
	flag = 1;
	spf();
	}
	setTimeout(xiaoshi, 1000);
	setTimeout(xiaoshi2, 2000);
	return stats;  */

	function spf() {
		if (flag == 1) {
			var sp = document.getElementById("sp");
			sp.innerText = ss;
		}
		/* if(flag==0){
			sp.innerText = "<script>document.write(ss)</"+"script> ";
			alert(sp.innerText);
		}  */
	}

	function sendpost() {
		//1.得到异步对象
		var xmlHttp = createXMLHttpRequest();
		//2.打开连接
		xmlHttp.open("POST", "<c:url value='../ajax.do'/>", true);
		//3.设置请求头：Content-Type
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		var userEle = document.getElementById("inp1");
		//4.发送请求，给出请求体
		xmlHttp.send("username=" + userEle.value);
		//5.给xmlHttp的onreadystatechange事件注册监听
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {//双重判断
				//获取服务器的响应，判断是否为1
				// 是：获取span，添加内容：“用户名已被注册”
				text = xmlHttp.responseText;
				var span = document.getElementById("sp");
				if (text == "1") {
					//得到span元素
					span.innerHTML = "用户名已被注册！";
					//ssetTimeout(toTheZero, 1000);
				}
			}
		};
	}

	function changeImg() {
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
		//替换之前的图片
	}
	//时间戳   
	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
	/* 	function chgUrl(url) {
	 var timestamp = (new Date()).valueOf();
	 url = url.substring(0, 17);
	 if ((url.indexOf("&") >= 0)) {
	 url = url + "×tamp=" + timestamp;
	 } else {
	 url = url + "?timestamp=" + timestamp;
	 }
	 return url;
	 } */
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		if (url.indexOf("?timestamp=") > 0) {
			url = url.substring(0, url.indexOf("?timestamp="));
		}
		url = url + "?timestamp=" + timestamp;
		console.log(url);
		return url;
	}
</script>
<!-- 必填格子不能为空 -->
<script type="text/javascript">
	/* // var sb=document.getElementById("error"); */
	var ss = "&nbsp;&nbsp;&nbsp;&nbsp;";
	var flag = 0;
	/* //两个问题 
	//当 用户名密码输入正确 不执行该提示功能
	//当用户密码不合法时提醒，且重新输入后就刷新页面 
	//不合法     空格输入  密码太短  输入框为空    密码验证时后发现为错误 */
	function one() { /*  当离开输入框会弹出来一个提示 */
		if (!document.f1.username.value.match(/^\S+$/)) {
			ss = "用户名不能为空";
			alert(ss);
			/* document.f1.username.focus(); */
		}
	}

	function two() {
		if (document.f1.pwd.value == "") {
			ss = "用户密码不能为空";
			alert(ss);
			/*  document.f1.pwd.focus();  */
		}
	}

	function check() {
		var info = "";
		var stats = true;
		spf();
		if (!document.f1.username.value.match(/^\S+$/)) {
			ss = "用户名不能为空";
			flag = 1;
			stats = false;
			spf();
		} else if (document.f1.pwd.value == "") {
			ss = "用户密码不能为空";
			stats = false;
			flag = 1;
			spf();
		} else if (document.f1.verifycode.value == "") {
			ss = "验证码不能为空";
			stats = false;
			flag = 1;
			spf();
		} else if (document.f1.phone.value == "") {
			ss = "联系电话不能为空";
			stats = false;
			flag = 1;
			spf();
		} else if (document.f1.company.value == "") {
			ss = "公司名不能为空";
			stats = false;
			flag = 1;
			spf();
		}
		setTimeout(xiaoshi, 1000);
		setTimeout(xiaoshi2, 2000);
		return stats;
		flag = 0;
	}

	function spf() {
		if (flag == 1) {
			var sp = document.getElementById("sp");
			sp.innerText = ss;
		}
		/* if(flag==0){
			sp.innerText = "<script>document.write(ss)</"+"script> ";
			alert(sp.innerText);
		}  */
	}

	function xiaoshi()

	{
		var sp = document.getElementById("sp");
		sp.innerText = "请重新输入";
	}
	function xiaoshi2()

	{
		var sp = document.getElementById("sp");
		sp.innerText = "";
	}
</script>

<script type="text/javascript">
	//var username = document.getElementById("inp1");

	//var phone = document.getElementById("inp4");
	//var company = document.getElementById("inp6");
	/* 
	 function onblur(){
	 var _reg = /^[a-zA-Z_0-9]+$/;
	 var username = document.getElementById("inp1").value;
	 if(_reg.test(username))
	 {
	 alert("用户合法");
	 }
	 else
	 {
	 alert("用户名不合法");
	 }} */
</script>


<!-- 页面头 -->
<nav class="navbar navbar-default">
	<div>
		<!-- Brand and toggle get grouped for better mobile display -->
		<div style="margin-left: 50" class="navbar-header">
			<a class="navbar-brand" href="#">WebLogo</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" style="margin-right: 50"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
				<li><a href="#">English</a></li>
				<li><a href="#">AboutUs</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- //固定页脚的style样式 -->
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#container {
	min-height: 90%;
	height: auto !important;
	height: 100%;
	margin: 0 auto -60px; /*margin-bottom的负值等于footer高度*/
}

.push, #footer {
	height: 60px;
	clear: both;
}
/*==========其他div效果==========*/
#footer {
	background: #fff;
}
</style>

</head>
<body>
	<div id="container">
		<div class="page-header">
			<h1 style="margin-left: 100">
				酒店投放系统 <small>注册页面</small>
			</h1>
		</div>
		<div style="margin-left: 450; margin-top: 30">
			<form name="f1" action="register.do" method="post"
				style="margin-left: 50px" onsubmit="return check()"
				class="navbar-form navbar-left">
				<span id="sp"> <script>
					document.write(ss)
				</script></span>
				<span id="sp1"> <script>
					
				</script></span><br /> <span id="errorSpan"></span>
				<div class="form-group">
					<div class="col-sm-10">
						<input id="inp1" type="text" class="form-control"
							style="width: 300" name="username" placeholder="输入你的用户名">
					</div>
				</div>
				<br /> <br />
				<div class="form-group">
					<div class="col-sm-10">
						<input id="inp2" type="password" class="form-control"
							style="width: 300" name="pwd" placeholder="登录密码">
					</div>
				</div>
				<br /> <br />
				<div class="form-group">
					<div class="col-sm-10">
						<input id="inp5" type="password" class="form-control"
							style="width: 300" name="pwd2" placeholder="请再输一次密码">
					</div>
				</div>
				<br /> <br /> <span><div class="form-group">
						<div class="col-sm-10">
							<input id="index_code" class="form-control" style="width: 170"
								type="text" placeholder="输入右图显示的数字或字母" name="verifycode">
						</div>${status}${sessionScope.abc}
					</div></span> <span>
					<div class="form-group">
						<div class="col-sm-10">
							<img id="imgObj" alt="验证码" onclick="changeImg()" src="${ctx }/code.do" />
						</div>
					</div>
				</span> <br /> <br />
				<div class="form-group">
					<div class="col-sm-10">
						<input id="inp4" type="text" class="form-control"
							style="IME-MODE: disabled; width: 300" name="phone"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							placeholder="联系电话" maxlength="11">
						<!-- <input 
						style="IME-MODE: disabled; WIDTH: 60px; HEIGHT: 15px"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							maxlength="5" size="11" name="amount" type="text" /> -->

					</div>
				</div>
				<br /> <br />
				<div class="form-group">
					<div class="col-sm-10">
						<input id="inp6" type="text" class="form-control"
							style="width: 300" name="company" placeholder="所在公司">
					</div>
				</div>
				<br /> <br />
				<div class="form-group">
					<div class="col-sm-10">
						<textarea type="text" style="resize: none;" rows="5" cols="50"
							name="remark" maxlength="150"
							placeholder="用几个关键字去描述所在公司，可用、隔开。此项为选填项，可不填"></textarea>
					</div>
				</div>
				<br /> <br />
				<div class="form-group">
					<div class="col-sm-10">
						<button type="submit" style="width: 300" class="btn btn-success">提交信息</button>
					</div>
				</div>
			</form>
		</div>
		<br /> <br />
	</div>
	<div id="footer" align="center">
		<hr width="1000">
		版权所有 © 512，感谢开源技术。
	</div>

</body>
</html>