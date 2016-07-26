<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<title>登录页面</title>
<jsp:include page="common/head.jsp"></jsp:include>
</head>
<body>

	<div class="container">

		<div class="col-sm-4"></div>
		<div class="col-sm-8" style="margin-top: 100px">
			<h1>酒店投放系统登录</h1>
		</div>


		<div style="margin-top: 200px">
			<form name="lgf" id="form1" action="login.do" method="post"
				onsubmit="return checkLoginForm()">
				<span id="ww"> <script>
					document.write("&nbsp;&nbsp;&nbsp;&nbsp;")
				</script>
				</span> <span id="sp1"> <script>
					document.write("&nbsp;&nbsp;&nbsp;&nbsp;")
				</script>
				</span>
				<div class="col-sm-12">
					<div class="col-sm-3"></div>
					<label class="control-label col-sm-1" style="float: left;">用户名：</label>
					<div class="col-sm-6">
						<input style="width: 60%" name="username" type="text"
							class="form-control" placeholder="用户名" id="txtUserNo"
							maxlength="10" onBlur="c()">
					</div>
				</div>
				<div class="col-sm-12" style="margin-top:10px">
					<div class="col-sm-3"></div>
					<label style="float: left;" class="control-label col-sm-1">密码：</label>
					<div class="col-sm-6">
						<input style="width: 60%" name="pwd" class="form-control "
							type="password" placeholder="密码" id="txtPsw" maxlength="20"
							onblur="check2()">
					</div>
				</div>
				<!-- <div class="col-sm-12" style="margin-top:10px">
				<div class="col-sm-3"></div>
				<label style="float: left;" class="control-label col-sm-1">验证码：</label>
				<div class="col-sm-2">
					<input name="verifycode" class="form-control " style="width: 100%"
						type="text" placeholder="验证码" id="txtCode" maxlength="5">
				</div>
				<div class="col-sm-2">
					<img id="imgObj" src="code.do" alt="验证码" onclick="changeImg()">
				</div>
			</div> -->
				<div class="col-sm-12" style="margin-top:10px">
					<div class="col-sm-4"></div>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-success " style="width: 100%"
							id="btnLogin">登录</button>
					</div>
					<div class="col-sm-2">
						<a href="/basicinfo/ForgotPwd.html">忘记密码？</a>
					</div>
				</div>
				<div class="col-sm-12" style="margin-top:10px">
					<div class="col-sm-4"></div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-primary " style="width: 100%"
							onclick="window.location = '/basicinfo/Registered.html';">立即注册</button>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script src="${ctx}/js/login.js"></script>
</html>