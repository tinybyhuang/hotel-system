<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商用户配置</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>

	<div class="modal fade " id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog " role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改供应商用户配置</h4>
				</div>
				<form id="modalForm"
						action="${ctx }/userConfig/updateUserConfig.do" method="post"
						onsubmit="modalFormSubmitFuction();return false;">
					<div class="modal-body" >
						    <label for="originalUserNO" style="width: 20%;float:left"
								class=" control-label ">原用户名:</label> <input  disabled
								class="form-control " id="originalUserNO" style="width: 60%">
						
							<label for="originalUserPWD" style="width: 20%;float:left"  
								class=" control-label ">原用户密码:</label> <input disabled
								 class="form-control " id="originalUserPWD"
								style="width: 60%">
						
							<label for="userNO" style="width: 20%;float:left"
								class=" control-label ">新用户名:</label> <input name="userNo"
								class="form-control " id="userNO" style="width: 60%">
						
							<label for="userPWD" style="width: 20%;float:left"
								class=" control-label ">用户密码:</label> <input
								name="userPwd" class="form-control " id="userPWD"
								style="width: 60%">

						<!-- 详细加幅设置需要的房型id、平台id、供应商id、加幅日期 -->
						<input id="configType" name="configType" style="display: none"
							value="1"> <input id="configId" name="configId"
							style="display: none">
				</div>
				<div class="modal-footer">
			    	<button type="submit" class="btn btn-primary " style="">提交</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 模态框 -->




	<!-- 导航条 -->
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a
				href="${ctx }/userConfig/showProviderUserConfig.do">供应商用户配置</a></li>
			<li role="presentation"><a
				href="${ctx }/userConfig/showMarketUserConfig.do">平台用户配置</a></li>
		</ul>
		<!-- 面板 -->
		<div class="panel panel-info">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<h1>供应商配置</h1>
			</div>
			<div class="panel-body">
				<div class="col-sm-12">
					<form class="form-horizontal row"
						action="${ctx }/userConfig/addProviderUserConfig.do"
						id="providerForm" method="post"
						onsubmit="submitFuction();return false;">
						<div class="col-sm-12">
							<label for="providerId" class="col-sm-1 control-label">供应商</label>
							<div class="col-sm-4">
								<select id="providerId" name="providerId" class="form-control">
									<option value=""
										<c:if test="${configProviderIdList.size()!=2}">hidden</c:if>>暂无供应商可选</option>
									<option value="2"
										<c:choose>
									<c:when test="${fn:contains(configProviderIdList,2)}">hidden</c:when>
									<c:otherwise>
									selected
									</c:otherwise>
							     	</c:choose>>龙腾</option>
									<option value="1"
										<c:choose>
									<c:when test="${fn:contains(configProviderIdList,1)}">hidden</c:when>
									<c:otherwise>
									selected
									</c:otherwise>
								</c:choose>>捷旅</option>
								</select>
							</div>
						</div>
						<div class="col-sm-12">
							<label for="userNo" class="col-sm-1 control-label">用户名</label>
							<div class="col-sm-4">
								<input id="userNo" name="userNo" class="form-control">
							</div>
						</div>
						<div class="col-sm-12">
							<label for="userPwd" class="col-sm-1 control-label">密码</label>
							<div class="col-sm-4">
								<input id="userPwd" name="userPwd" class="form-control">
							</div>
						</div>
						<div class="col-sm-12">
							<div class="col-sm-1"></div>
							<div class="col-sm-4">
								<button type="submit" class="btn btn-success"
									id="providerButton">添加配置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- Table -->
			<c:choose>
				<c:when test="${providerUserConfigList.size()==0 }">
					<h3>暂无供应商用户配置</h3>
				</c:when>
				<c:otherwise>
					<table class="table table-striped">
						<tr>
							<th style="width: 10%">供应商</th>
							<th style="width: 10%">用户名</th>
							<th style="width: 10%">用户密码</th>
							<th style="width: 10%">创建时间</th>
							<th style="width: 10%">修改时间</th>
							<th style="width: 10%">修改配置</th>
							<th style="width: 10%">删除配置</th>
						</tr>
						<c:forEach items="${providerUserConfigList}" var="userConfig">
							<tr>
								<td><c:if test="${userConfig.configId =='1'}">捷旅</c:if> <c:if
										test="${userConfig.configId =='2'}">龙腾</c:if></td>
								<td>${userConfig.userNo }</td>
								<td>${userConfig.userPwd }</td>
								<td><fmt:formatDate value="${userConfig.created }"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${userConfig.modified }"
										pattern="yyyy-MM-dd HH:mm" /></td>
								<td><button data-toggle="modal" href="#myModal"
										value="${userConfig.configId}"
										class="btn btn-primary btn-provider" type="button">修改配置</button></td>
								<td><a
									href="${ctx }/userConfig/deleteProviderUserConfig.do?providerId=${userConfig.configId}"><button
											class="btn btn-primary" type="button">删除配置</button></a></td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script>
	$(function() {
		if ($("#providerId").val() == "") {
			$("#providerId").attr("disabled", "disabled");
			$("#userNo").attr("disabled", "disabled");
			$("#userPwd").attr("disabled", "disabled");
			$("#providerButton").attr("disabled", "disabled");
		}
	})

	function submitFuction() {
		var _reg = /^[a-zA-Z_0-9]+$/;
		if ($("#providerId").val() == "") {
			alert("操作失败");
		} else if ($("#providerId").val() != "") {
			if ($("#userNo").val().trim().length == 0) {
				alert("用户名不能为空");
			} else if ($("#userPwd").val().trim().length == 0) {
				alert("用户密码不能为空");
			} else if (_reg.test($("#userNo").val())) {
				$("#providerForm").submit();
			} else
				alert("用户名只能由字母数字下划线组成");
		}
	}

	function modalFormSubmitFuction() {
		var _reg = /^[a-zA-Z_0-9]+$/;
		if ($("#configId").val() == "") {
			return false;
		} else if ($("#configId").val() != "") {
			if ($("#userNO").val().trim().length == 0) {
				alert("用户名不能为空");
			} else if ($("#userPWD").val().trim().length == 0) {
				alert("用户密码不能为空");
			} else if (_reg.test($("#userNO").val())) {
				$("#modalForm").submit();
			} else
				alert("用户名只能由字母数字下划线组成");
		}
	}


	$(".btn-provider").click(function() {
		var configId = $(this).val();
		$("#configId").attr("value", configId);
		$.post("findUserConfig.do", {
			"configId" : configId,
			"configType" : 1
		}, function(msg) {
			var providerUserConfig  =  eval("("+msg+")");
			 $("#originalUserNO").attr("value",providerUserConfig.userNo); 
			 $("#originalUserPWD").attr("value",providerUserConfig.userPwd);
		})
	})
</script>
</html>