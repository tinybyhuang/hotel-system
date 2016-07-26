<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${ctx }/product/returnUser.do">酒店投放系统</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${ctx }/sale/showListSaleRule.do">分销管理</a></li>
				<li><a href="${ctx }/product/hotels.do">产品管理</a></li>
				<li><a href="${ctx }/order/manageOrder.do">订单管理</a></li>
				<li><a href="#">日志管理</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${user.username }<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">用户信息</a></li>
						<li><a href="#">修改密码</a></li>
						<li><a href="${ctx }/logout.do">退出系统</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>