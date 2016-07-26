<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<link rel="stylesheet" href="${ctx}/css/bootstrap-datetimepicker.min.css" type="text/css">
<title>修改记录页面</title>
</head>
<body>


<form action="updateBaseRule.do" method="post"  class= "form-horizontal">
<div>
<table class="table table-hover" class="col-md-12">
					<thead>
						<tr>
							<th>id</th>
							<th>销售规则id</th>
							<th>加幅类型</th>
							<th> 加幅额度</th>
								<th>最低价格</th>
									<th>安全价格</th>
										<th>扣房量</th>
											<th>销售时间</th>
												<th>酒店描述 </th>
												<th>房型说明 </th>
						</tr>
					</thead>
					<tbody>
				
						<c:forEach items="${lists}" var="items">
							<tr class="success" >
								<td ><textarea readonly="readonly" name="id" >${items.id}</textarea></td>
								<td ><textarea readonly="readonly" name="saleRuleId" id="saleRuleId">${items.saleRuleId}</textarea></td>
								<td ><textarea name="increaseType">${items.increaseType}</textarea></td>
								<td ><textarea name="increaseAmount">${items.increaseAmount}</textarea></td>
								<td ><textarea name="lowerPrice">${items.lowerPrice}</textarea></td>
								<td ><textarea name= "safePrice">${items.safePrice}</textarea></td>
								<td ><textarea name="roomDetain">${items.roomDetain}</textarea></td>
								<td ><textarea name="presentSale">${items.presentSale}</textarea></td>
								<td ><textarea name="hotelInstruction">${items.hotelInstruction}</textarea></td>
								 <td ><textarea name= "roomInstruction">${items.roomInstruction}</textarea></td>
								<td><button id= "deleteBaseRule" type="button"  class="btn btn-primary" style="width: 80px;" name="deleteBaseRule">删&nbsp;除</button> </td>
							<td><button  type="submit"  class="btn btn-primary" style="width: 80px;" >修&nbsp;改</button> </td>
							</tr>
							
						</c:forEach>



					</tbody>
				</table>
	
</div>
</form>
<div class="container-fluid">
<form action="getBaseRule.do" method="post"  class= "form-horizontal" >
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

</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script>
$("#deleteBaseRule").click(function(){
	 var deleteBaseRule = $("#saleRuleId" ).val();
	
	$.post("deleteBaseRule.do", {"deleteBaseRule":deleteBaseRule},window.location.reload());

	
});




</script>
</html>