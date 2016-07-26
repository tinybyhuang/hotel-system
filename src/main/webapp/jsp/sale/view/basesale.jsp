<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 -->
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<link rel="stylesheet" href="${ctx}/css/bootstrap-datetimepicker.min.css" type="text/css">
<title>基本设置</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp"></jsp:include>
<div class="container-fluid">
<form class="form-horizontal" method ="post" action="${ctx }/sale/saveBaseSaleRule.do" style="width: 50%; margin: 0 auto;" >
<<!-- div class="form-group">
			<label for="saleRuleId" class="col-sm-4 control-label">请输入销售规则id</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="saleRuleId"
						name="saleRuleId" placeholder="请输入销售规则id">	
				</div>
				</div> -->
<div class="form-group">
			<label for="safePrice" class="col-sm-4 control-label">请设置安全价格</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="safePrice"
						name="safePrice" placeholder="安全价格">	
				</div>
				</div>
				<div class="form-group">
			<label for="lowerPrice" class="col-sm-4 control-label">请设置最低价格</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="lowerPrice"
						name="lowerPrice" placeholder="最低价格">	
				</div>
				</div>
				<div class="form-group">
			<label for="roomDetain" class="col-sm-4 control-label">请设置扣房量</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="roomDetain"
						name="roomDetain" placeholder="扣房量">	
				</div>
				</div>
				
				
				<div class="form-group">
			<label for="presentSale" class="col-sm-4 control-label">请设置当天销售时间</label>
				<div class="col-sm-8">
					<input type="text" class="datepicker form-control" id="presentSale"
						name="presentSale" placeholder="销售时间">
				</div>
				</div>
				<div class="form-group">
			<label for="increaseType" class="col-sm-4 control-label">基本加幅类型</label>
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
			<label for="hotelInstruction" class="col-sm-4 control-label">酒店描述</label>
				<div class="col-sm-8">
					<textarea class="form-control" id="hotelInstruction"
						name="hotelInstruction" placeholder="酒店描述" row="4"></textarea>	
				</div>
				</div>
				<div class="form-group">
			<label for="roomInstruction" class="col-sm-4 control-label">房型说明</label>
				<div class="col-sm-8">
					<textarea class="form-control" id="roomInstruction"
						name="roomInstruction" placeholder="房型说明" row="4"></textarea>	
				</div>
				</div>
				<div class="form-group">
				<div class="col-sm-offset-5 col-sm-7">
					<button type="submit" class="btn btn-primary" style="width: 80px;">保&nbsp;存</button> 
			
				</div>
			</div>
			</form>
			

</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
$(function() {
 $('.datepicker').datetimepicker({
	    format: 'hh:ii',
	    autoclose: true,
	    startView: 1 ,
	    todayBtn: true,
	    language:'zh-CN'
	});
 
	
 $("#saleRuleId").change(function(){
	 var saleRuleId = $(this).val();
	 var chk = /^[0-9]+$/;
	 if (chk.test(saleRuleId)){
		 $.post("checkSaleRuleID.do",{"saleRuleId" :saleRuleId},function(msg){
			 
			 alert(msg);
		 });
	 }else{
		 alert("输入用户Id格式不对");
	 }	 
 });	 
 });
$("#saleRuleId").blur(function(){
	var self =$(this);
	var rule =$("#saleRuleId").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	
});
$("#safePrice").blur(function(){
	var self =$(this);
	var rule =$(".form-control").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	
});
$("#lowerPrice").blur(function(){
	var self =$(this);
	var rule =$(".form-control").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	
});
$("#roomDetain").blur(function(){
	var self =$(this);
	var rule =$(".form-control").val();
	if(rule.trim().length == 0 ){
		self.parent().addClass("has-error");
	} else {
		self.parent().removeClass("has-error");
	}	
});
$("#presentSale").blur(function(){
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