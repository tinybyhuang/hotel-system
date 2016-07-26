<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<title>发布规则</title>
</head>
<body>
	<table class="table table-hover table-bordered">
		<thead>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>发布状态</th>

		</thead>
		<tbody>
			<c:forEach items="${publishRuleList}" var="items">
				<tr>
					<td><input type="text" class="datepicker form-control"
						id="beginDate" name="beginDate" style="width: 50%"
						placeholder="<fmt:formatDate type="date" 
            value="${items.beginDate}"/> "></td>
					<td><input type="text" class="datepicker form-control"
						id="endDate" name="endDate" style="width: 50%;"
						placeholder="<fmt:formatDate type="date"
            value="${items.endDate}"/> ">
					</td>
					<td><select style='width: 150px; z-index: -1' id="aa"
						name="status" class="form-control">
							<option value="${items.status}">${items.status}</option>
							<option value="上架">上架</option>
							<option value="下架">下架</option>

					</select></td>
<form action="deletePublishRule.do" method="post"><td><input type="hidden"  name= "deleteId" id="publishId" value="${items.id}">	<button type="submit" class="btn btn-primary" style="width: 80px;">删&nbsp;除</button> </td></form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-sm-offset-4 col-sm-7">
			<form action="showListSaleRule.do" method="get">
			<button type="submit" class="btn btn-primary" style="width: 80px;">完&nbsp;成</button> </form>
	</div>

















</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">

 $('.datepicker').datetimepicker({
	    format: 'yyyy-mm-dd',
	    autoclose: true,
	    startView: 2 ,
	    todayBtn: true,
	    language:'zh-CN',
	   minView: 'month',
	    viewSelect:2
	});
 </script>
</html>