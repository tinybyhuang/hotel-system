<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<title>基本加幅设置</title>
</head>
<body>
<form class="form-horizontal" method ="post" action="saveIncreaseRule.do" style="width: 50%; margin: 0 auto;" >
 <div class="form-group">
			<label for="saleRuleId" class="col-sm-4 control-label">请输入销售规则id</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="saleRuleId"
						name="saleRuleId" placeholder="销售规则id">	
				</div>
				</div>
<div class="form-group">
			<label for="privoderId" class="col-sm-4 control-label">请输入供应商id</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="privoderId"
						name="privoderId" placeholder="供应商id">	
				</div>
				</div>
				
		<div class="form-group">
			<label for="scopeId" class="col-sm-4 control-label">请输入加幅id</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="scopeId"
						name="scopeId" placeholder="加幅id">	
				</div>
				</div>
				
				<div class="form-group">
			<label for="scopeType" class="col-sm-4 control-label">请选择加幅类型</label>
				<div class="col-sm-8">
				<div class="radio">
  <label>
    <input type="radio" name="scopeType" id="scopeType" value="  城市" checked>
   城市
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="scopeType" id="scopeType" value=" 酒店">
  酒店
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="scopeType" id="scopeType" value=" 房型">
房型
  </label>
</div>
			
				</div>
				
				
								<div class="form-group">
			<label for="increaseType" class="col-sm-4 control-label">请设置基本加幅类型</label>
				<div class="col-sm-8">
				<div class="radio">
  <label>
    <input type="radio" name="increaseType" id="increaseType" value="差价" checked>
   差价
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="increaseType" id="increaseType" value="百分比">
   百分比
  </label>
</div>
			
				</div>
				
				<div class="form-group">
			<label for="increaseAmount" class="col-sm-4 control-label">请设置加幅额度</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="increaseAmount"
						name="increaseAmount" placeholder="加幅额度">	
				</div>
				</div>
				
		
		<div class="form-group">
				<div class="col-sm-offset-5 col-sm-7">
				
					<button type="submit" class="btn btn-primary" style="width: 80px;">保&nbsp;存</button> 

				</div>
			</div>
			</form>
	
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script>
$("#saleRuleId").blur(function(){
	var self =$(this);
	var rule =$(".form-control").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	

});
$("#privoderId").blur(function(){
	var self =$(this);
	var rule =$(".form-control").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	

});
$("#scopeId").blur(function(){
	var self =$(this);
	var rule =$(".form-control").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	

});
$("#increaseAmount").blur(function(){
	var self =$(this);
	var rule =$(".form-control").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	

});









</script>

</html>