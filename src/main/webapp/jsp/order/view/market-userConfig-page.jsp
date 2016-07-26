<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平台用户配置</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>
	<!-- right -->
	<jsp:include page="/common/navbar.jsp"></jsp:include>

	<div class="modal fade " id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog " role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改平台用户配置</h4>
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
							value="2"> <input id="configId" name="configId"
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


	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a
				href="${ctx }/userConfig/showProviderUserConfig.do">供应商用户配置</a></li>
			<li role="presentation" class="active"><a
				href="${ctx }/userConfig/showMarketUserConfig.do">平台用户配置</a></li>
		</ul>
		<div class="panel panel-success">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<h1>平台配置</h1>
			</div>
			<div class="panel-body">
				<div class="col-sm-12">
					<form class="form-horizontal row" id="marketForm"
						action="${ctx }/userConfig/addMarketUserConfig.do" method="post"
						onsubmit="submitFuction();return false;">
						<div class="col-sm-12">
							<label for="marketId" class="col-sm-1 control-label">平台</label>
							<div class="col-sm-4">
								<select id="marketId" name="marketId" class="form-control">
									<option value=""
										<c:if test="${configMarketIdList.size()!=3}">hidden</c:if>>暂无平台可选</option>
									<option value="3"
										<c:choose>
									<c:when test="${fn:contains(configMarketIdList,3)}">hidden</c:when>
									<c:otherwise>
									selected
									</c:otherwise>
							     	</c:choose>>淘宝</option>
									<option value="2"
										<c:choose>
									<c:when test="${fn:contains(configMarketIdList,2)}">hidden</c:when>
									<c:otherwise>
									selected
									</c:otherwise>
							     	</c:choose>>去哪儿</option>
									<option value="1"
										<c:choose>
									<c:when test="${fn:contains(configMarketIdList,1)}">hidden</c:when>
									<c:otherwise>
									selected
									</c:otherwise>
							     	</c:choose>>携程</option>
								</select>
							</div>
						</div>
						<div class="col-sm-12">
							<label for="userNo" class="col-sm-1 control-label">用户名</label>
							<div class="col-sm-4">
								<input id="userNo" name="userNo" type="text"
									class="form-control">
							</div>
						</div>
						<div class="col-sm-12">
							<label for="userPwd" class="col-sm-1 control-label">密码</label>
							<div class="col-sm-4">
								<input id="userPwd" name="userPwd" type="password"
									class="form-control">
							</div>
						</div>
						<div class="col-sm-12">
							<div class="col-sm-1"></div>
							<div class="col-sm-4">
								<button type="submit" class="btn btn-success" id="marketButton">添加配置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- Table -->
			<c:choose>
				<c:when test="${marketUserConfigList.size()==0 }">
					  暂无平台用户配置
					  </c:when>
				<c:otherwise>
					<table class="table table-striped">
						<tr>
							<th style="width: 10%">平台</th>
							<th style="width: 10%">用户名</th>
							<th style="width: 10%">用户密码</th>
							<th style="width: 10%">创建时间</th>
							<th style="width: 10%">修改时间</th>
							<th style="width: 10%">修改配置</th>
							<th style="width: 10%">删除配置</th>
						</tr>
						<c:forEach items="${marketUserConfigList}" var="userConfig">
							<tr>
								<td><c:if test="${userConfig.configId =='1'}">携程</c:if> <c:if
										test="${userConfig.configId =='2'}">去哪儿</c:if> <c:if
										test="${userConfig.configId =='3'}">淘宝</c:if></td>
								<td>${userConfig.userNo }</td>
								<td>${userConfig.userPwd }</td>
								<td><fmt:formatDate value="${userConfig.created }"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${userConfig.modified }"
										pattern="yyyy-MM-dd HH:mm" /></td>
								<td><button data-toggle="modal" href="#myModal"
										class="btn btn-primary btn-market"
										value="${userConfig.configId}" type="button">修改配置</button></td>
								<td><a
									href="${ctx }/userConfig/deleteMarketUserConfig.do?marketId=${userConfig.configId}"><button
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
		if ($("#marketId").val() == "") {
			$("#marketId").attr("disabled", "disabled");
			$("#userNo").attr("disabled", "disabled");
			$("#userPwd").attr("disabled", "disabled");
			$("#marketButton").attr("disabled", "disabled");
		}
	})

	$(function() {
		if ($("#marketId").val() != "") {
			console.log($("#userNo").prop("value"));
			$("#userNo").prop("value", "");
			$("#userPwd").prop("value", "");
		}
	})

	function submitFuction() {
		var _reg = /^[a-zA-Z_0-9]+$/;
		if ($("#marketId").val() == "") {
			alert("操作失败");
		} else if ($("#marketId").val() != "") {
			if ($("#userNo").val().trim().length == 0) {
				alert("用户名不能为空");
			} else if ($("#userPwd").val().trim().length == 0) {
				alert("用户密码不能为空");
			} else if (_reg.test($("#userNo").val())) {
				$("#marketForm").submit();
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

	$(".btn-market").click(function() {
		var configId = $(this).val();

		$("#configId").attr("value", configId);
		$.post("findUserConfig.do", {
			"configId" : configId,
			"configType" : 2
		}, function(msg) {
			var marketUserConfig  =  eval("("+msg+")");
			 $("#originalUserNO").attr("value",marketUserConfig.userNo); 
			 $("#originalUserPWD").attr("value",marketUserConfig.userPwd);
		})
	})
	
</script>
</html>