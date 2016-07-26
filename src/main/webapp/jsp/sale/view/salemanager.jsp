<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分销管理</title>
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">

</head>
<body>
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<div class="row">
					<form method ="post" action="updateSaleRule.do" >
					<input type="hidden"  name="Id" id="Id" value="${saleRule.id }">
										<div class="col-xs-8 col-sm-8">
				
						<div class="table-responsive">

							<table class="table table-bordered ">
								<thead>
									<tr>
										<th style="width: 10%">平台</th>

										<th style="width: 10%">状态</th>
										<th style="width: 10%">设置</th>
										<th style="width: 10%">修改时间</th>
									</tr>
								</thead>
								<tbody>



									<tr class="success">
										<td>	<select name="marketId" class="form-control">
				<option value="${saleRule.marketId}">${saleRule.marketName}</option>
				<option value ="1">携程</option>
				<option value="2">去哪儿</option>
				<option value="3">龙腾</option>
			</select>
										<td>
			
				<div class="col-sm-10">
				<select name="status" class="form-control">
				<option value="${saleRule.status}">${saleRule.status}</option>
				<option value ="开店">开店</option>
				<option value="关店">关店</option>
				
				
				
				
				</select>
				
				
				</div></td>
										<td><a href="showBaseRule.do">基本设置</a>
										<br><a href="showIncreaseRule.do">加幅设置</a><br>
										<a href="showSaleRule.do">销售设置</a><br>
										<a href="filterData.do">过滤设置</a><br>
										<a href="showListPublishRule.do">发布设置</a></td>
										<td><fmt:formatDate type="both"
												value="${saleRule.modified}" /></td>

									</tr>




								</tbody>
							</table>
						
								<div class="col-sm-offset-5 col-sm-7">
									<button type="submit" class="btn btn-primary"
										style="width: 80px;" >保&nbsp;存</button>
										<button type="button"class="btn btn-primary" style="width: 80px;"  id="insertSaleRule">增&nbsp;加</button> 
									<button type="button" id="deleteSaleRule"  class="btn btn-primary"
										style="width: 80px;">删&nbsp;除</button>
										

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>





	
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript">
$("#insertSaleRule").click(function(){

	window.open("showSaleRule.do");
	
});



$("#deleteSaleRule").click(function(){
	var deleteSaleRule = $("#saleId").val();
	$.post("deleteSaleRule.do",{"deleteId":deleteSaleRule},window.location.reload());
	
	
	
	
	
});

</script>
</html>