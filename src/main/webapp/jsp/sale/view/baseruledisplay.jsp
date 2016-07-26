<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<link rel="stylesheet" href="${ctx}/css/bootstrap-datetimepicker.min.css" type="text/css">
<title>销售规则展示</title>
</head>
<body>
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<div class="container">
	
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="showBaseRule.do?searchId=${baseRule.saleRuleId}">基本设置</a></li>
		<li role="presentation"><a href="showListPublishRule.do?searchId=${baseRule.saleRuleId}">发布设置</a></li>
		<li role="presentation"><a href="${ctx}/sale/hotelRecords.do?searchId=${baseRule.saleRuleId}">加幅设置</a></li>
		<li role="presentation"><a href="filterData.do?searchId=${baseRule.saleRuleId}">过滤设置</a></li>
	</ul>
	
	<form action="updateBaseRule.do" method="post" onsubmit = "return check()">
	<input type ="hidden" id="baseId" name="baseId" value= "${baseRule.id}"> 
	<div class="col-md-4 col-md-offset-3">
		<table class="table table-bordered table-condensed">
			<thead>

			</thead>
			<tbody>

				<tr>
					<td>加幅类型</td>
					
					<td><select class="form-control" style="width:45%" name="increaseType">  
    
    <option value="差价"<c:if test="${baseRule.increaseType == '差价'}">selected</c:if>>差价</option>  
    <option value="百分比"<c:if test="${baseRule.increaseType == '百分比'}">selected</c:if>>百分比</option>  </select></td>
				</tr>
				<tr>
					<td>加幅额度</td>
					
					<td><input type="text" class="form-control"  id ="increaseAmount" style="width:45%" name="increaseAmount" value="${baseRule.increaseAmount}"></td>
				</tr>
				<tr>
					<td>最低价格</td>
					<td><input type="text" id="lowerPrice"  class="form-control" style="width:45%" name="lowerPrice" value="${baseRule.lowerPrice}"></td>
				</tr>
				<tr>
					<td>安全价格</td>
					<td><input type="text"  id="safePrice"  class="form-control" style="width:45%"  name="safePrice" value="${baseRule.safePrice}"></td>
				</tr>
				<tr>
					<td>扣房量</td>
					<td><input type="text"  id="roomDetain" class="form-control"  style="width:45%" name="roomDetain" value="${baseRule.roomDetain}"></td>
				</tr>
				<tr>
					<td>销售时间</td>
					<td><input type="text"   class="datepicker form-control" id="presentSale" name="presentSale" style="width: 45%;"  placeholder=<fmt:formatDate type="time" 
            value="${baseRule.presentSale}"/> ></td>
				</tr>
				<tr>
					<td>酒店描述</td>
					<td><input type="text" id="hotelInstruction" class="form-control" style="width:45%" name="hotelInstruction" value="${baseRule.hotelInstruction}"></td>
				</tr>
				<tr>
					<td>房型说明</td>
					<td><input type="text" id="roomInstruction" class="form-control"  style="width:45%" name="roomInstruction" value="${baseRule.roomInstruction}"></td>
				</tr>
			</tbody>
		</table>
		<div class="form-group">
				<div class="col-sm-offset-3 col-sm-7">
		
					<button type="submit" class="btn btn-primary" style="width: 80px;">保&nbsp;存</button> 
				
				</div>
			</div>
			
		
	</div>
	</form>
	</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
function check(){
	var flo = /^(-?\d+)(\.\d+)?$/;
	var inte = /^[0-9]*[1-9][0-9]*$/;
	var increaseAmount = $("#increaseAmount").val();
	var lowerPrice = $("#lowerPrice").val();
	var safePrice = $("#safePrice").val();
	var roomDetain = $("#roomDetain").val();
	var lowerPrice = $("#lowerPrice").val();
if(flo.test(increaseAmount)){
	
}else{
	alert("加幅额度输入不正确");
	return false;
}
if(inte.test(lowerPrice)){
	
}else{
	alert("最低价格输入不正确");
	return false;
}
if(inte.test(safePrice)){
	
}else{
	alert("安全价格输入不正确");
	return false;
}
if(inte.test(roomDetain)){
	
}else{
	alert("扣房量输入不正确");
	return false;
}
return true;
}
$(function(){
	 $('.datepicker').datetimepicker({
		    format:  'hh:ii',
		    autoclose: true,
		    startView: 1 ,
		    todayBtn: true,
		  
		    language:'zh-CN'
		});
	
	
	

});

 

</script> 

</html>