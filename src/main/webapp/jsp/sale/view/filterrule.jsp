<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css"><title>Insert title here</title>
</head>
<body>

	<div class="col-sm-12">
			<table class="table table-hover table-bordered">
				
				<thead>
					<th>过滤类型</th>

					<th>过滤Id</th>
					<th>供应商Id</th>
<th></th>
				</thead>
				<tbody>
				<c:forEach items="${filterRuleList}"  var="items">
					<tr>
			<%-- 		<td><input type="text" class="form-control"
							name="filterType" value="${items.filterType}"
							placeholder=""></td> 
						<td><input type="text" class="form-control" name="filterId"
							value="${items.filterId }" placeholder=""></td>
						<td><input type="text" class="form-control"
							name="providerId" value="${items.providerId }"
							placeholder=""></td> --%>
							 <td>${items.filterType }</td>
							<td>${items.filterId }</td>
							<td>${items.providerId }</td> 
							<form action="deleteFilterRule.do" method="post"><td><input type="hidden" value="${items.id}"  name="deleteFilterRuleId">	<button type="submit" class="btn btn-primary" style="width: 80px;"
				>删&nbsp;除</button></form>
							</c:forEach>
				</tbody>
			</table>
			
			<div class="col-sm-offset-4 col-sm-7">
			<form action="showSaleRule.do" method="get">
			<button type="submit" class="btn btn-primary" style="width: 80px;">完&nbsp;成</button> </form>
	</div>
</div>

	


	
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
</html>