var ss = "&nbsp;&nbsp;&nbsp;&nbsp;";
    var sp1="&nbsp;&nbsp;&nbsp;&nbsp;";
	var flag = 0;
	function checkLoginForm() {
		var info = "";
		var states = true;
		vaf();
		if (!document.lgf.username.value.match(/^\S+$/)) {
			//alert("sss");
			ss = "用户名不能为空";
			flag = 1;
			states = false;
			vaf();
		} else if (document.lgf.pwd.value == "") {
			ss = "用户密码不能为空";
			flag = 1;
			states = false;
			vaf();
		} else if (document.lgf.verifycode.value == "") {
			ss = "验证码不能为空";
			flag = 1;
			states = false;
			vaf();
		}

		return states;
		flag = 0;
	}
	function vaf() {
		if (flag == 1) {
			var ww = document.getElementById("ww");
			ww.innerText = ss;
			setTimeout(lost2,1000);
			setTimeout(lost3,2100);
		}

	}
	function c(){
		var a = document.getElementById("txtUserNo");
		var _reg=/^[a-zA-Z_0-9]+$/;
		if (_reg.test(a.value)){
			sendpost();
		}else{
			var sp = document.getElementById("sp1");
			sp.innerText="用户名只能由字母数字下划线组成";
			setTimeout(lost,1000);
			setTimeout(lost1,2100);
		}	
	}
	function lost(){
		var sp= document.getElementById("sp1");
		sp.innerText="请重新输入";
	}
	function lost1(){
		var sp= document.getElementById("sp1");
		sp.innerText="";
	}
	function lost2(){
		var sp= document.getElementById("ss");
		sp.innerText="请重新输入";
	}
	function lost3(){
		var sp= document.getElementById("ss");
		sp.innerText="";
	}
	
	function changeImg() {
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	//时间戳   
	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		url = url.substring(0, 17);
		if ((url.indexOf("&") >= 0)) {
			url = url + "×tamp=" + timestamp;
		} else {
			url = url + "?timestamp=" + timestamp;
		}
		return url;
	}