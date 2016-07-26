<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平台设置</title>
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">

</head>
<body>
<jsp:include page="/common/navbar.jsp"></jsp:include>
<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<div class="row">
				
				
										<div class="col-xs-8 col-sm-8">
				
						<div class="table-responsive">

							<table class="table table-bordered ">
								<thead>
							
										<th style="width: 10%">平台</th>

										<th style="width: 10%">状态</th>
										<th style="width: 10%">操作</th>
								
							
								</thead>
								<tbody>
<c:forEach items="${saleRule}" var="items">


									<tr>
										<td>
						${items.marketName}</td>			<td>${items.status}
			
		
				<td><a href="showBaseRule.do?searchId=${items.id}"><button type="button" class="btn btn-primary"
										style="width: 80px;" >设&nbsp;置

</button></a><br><br>
										<form action="updateSaleRule.do" 

method="post">
										<input type ="hidden" name="status" 

value="开店">
										<input type ="hidden" name="marketId" 

value="${items.marketId}">
										<button type="submit" class="btn btn-success"
										style="width: 80px;" >开&nbsp;店

</button></form>
										<form action="updateSaleRule.do" 

method="post">
										<input type ="hidden" name="status" 

value="关店">
										<input type ="hidden" name="marketId" 

value="${items.marketId}">
										<button  type="submit" class="btn btn-defult"
										style="width: 80px;" >关&nbsp;店

</button></form></td>

								

									</tr>



</c:forEach>
								</tbody>
							</table>
						
								
						</div>
					</div>
				</div>
			</div>



</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>









</html>
