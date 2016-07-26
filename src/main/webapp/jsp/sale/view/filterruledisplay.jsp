<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<title>过滤规则展示页面</title>
</head>
<body>
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="#">基本设置</a></li>
		<li role="presentation"><a href="#">发布设置</a></li>
		<li role="presentation"><a href="#">加幅设置</a></li>
		<li role="presentation" class="active"><a href="#">过滤设置</a></li>
	</ul>
	<form action="updateFilterRule.do" method="post">
	<input type="hidden" id="filterRuleId" name="filterRuleId" value="${filterRule.id}">
		<div class="col-sm-8">
			<table class="table table-hover table-bordered">
				
				<thead>
					<th>过滤类型</th>

					<th>过滤Id</th>
					<th>供应商Id</th>

				</thead>
				<tbody>
					<tr>
						<td><select style='width:150px;z-index:-1' id="aa" name="filterType"  class="form-control">  
    <option value="${filterRule.filterType}">${filterRule.filterType}</option>  
    <option value="城市过滤">城市过滤</option>  
    <option value="酒店过滤">酒店过滤</option></select></td>
						<td><input type="text" class="form-control" name="filterId"
							value="${filterRule.filterId}" ></td>
						<td><input type="text" class="form-control"
							name="providerId" value="${filterRule.providerId}"
							></td>
				</tbody>
			</table>
			<button type="submit" class="btn btn-primary" style="width: 80px;">修&nbsp;改</button>
			
	</form>
	<form>
	<input type="hidden" id="filterRuleId" name="filterRuleId" value="${filterRule.id }">
	<button type="button" class="btn btn-primary" style="width: 80px;"
				id="deleteFilterRule">删&nbsp;除</button></form>

	</div>
	
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$("#deleteFilterRule").click(function() {
		var deleteFilterRuleId =$("#filterRuleId").val();
		$.post("deleteFilterRule.do", {"deleteFilterRuleId" :deleteFilterRuleId}, window.open("showFilterRule.do"));

	}); 
</script>
</html>