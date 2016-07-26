<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<title>修改加幅规则页面</title>
</head>
<body>
		<form action="updateIncreaseRule.do" method="post"  class= "form-horizontal">
<div>
<table class="table table-hover" class="col-md-12">
					<thead>
						<tr>
							<th>id</th>
							<th>销售规则id</th>
							<th>加幅类型</th>
							<th> 加幅额度</th>
								<th>加幅Id</th>
									<th>供应商Id</th>
										<th>加幅类型</th>
											
						</tr>
					</thead>
					<tbody>
				
						<c:forEach items="${increase}" var="items">
							<tr class="success" >
								<td ><textarea readonly="readonly" name="id" >${items.id}</textarea></td>
								<td ><textarea readonly="readonly"  name="saleRuleId"  id="saleRuleId">${items.saleRuleId}</textarea></td>
								<td ><textarea name="increaseType">${items.increaseType}</textarea></td>
								<td ><textarea name="increseAmount">${items.increaseAmount}</textarea></td>
								<td ><textarea name="scopeId">${items.scopeId}</textarea></td>
								<td ><textarea name= "privoderId">${items.privoderId}</textarea></td>
								<td ><textarea name="scopeType">${items.scopeType}</textarea></td>
								
								<td><button id= "deleteIncreaseRule" type="button"  class="btn btn-primary" style="width: 80px;" name="deleteIncreaseRule">删&nbsp;除</button> </td>
							<td><button  type="submit"  class="btn btn-primary" style="width: 80px;" >修&nbsp;改</button> </td>
							</tr>
							
						</c:forEach>



					</tbody>
				</table>
	
</div>
</form>
<div class="container-fluid">
<form action="showIncreaseRule.do" method="post"  class= "form-horizontal" >
<div class="form-group">
			<label for="SaleRuleId" class="col-sm-5 control-label">销售规则id</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="SaleRuleId"
						name="SaleRuleId" placeholder="请输入销售规则id">	
						
				</div>
				</div>
				<div class="col-sm-offset-5 col-sm-7">
				<button type="submit" class="btn btn-primary" style="width: 80px;">查&nbsp;询</button> 
				<a href="test.do"><button type="button" class="btn btn-primary" style="width: 80px;">完&nbsp;成</button></a>
</div>
</form>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script>

$("#deleteIncreaseRule").click(function(){
	var deleteIncreaseRule = $("#saleRuleId").val();
	
	$.post("deleteIncreaseRule.do",{"deleteIncreaseRule":deleteIncreaseRule},function(){
		alert("success");
	});
});
</script>
</html>