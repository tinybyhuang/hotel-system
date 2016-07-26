<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<link rel="stylesheet" href="${ctx}/css/bootstrap-datetimepicker.min.css" type="text/css">
<title>发布规则修改页面</title>
</head>
<body>
<div>
	<div class="col-md-6 col-md-offset-3">
				
				<table class="table table-hover table-bordered">
				<thead>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>发布状态</th>
				</thead>
				<tbody>
				<tr>
				<td  ><input type="text" class="datepicker form-control" id="beginDate" readonly="readonly"
						name="beginDate"  style="width: 50% " value="<fmt:formatDate type="date" 
            value="${publishRule.beginDate}"/> "></td>
						<td><input type="text" class="datepicker form-control" id="endDate" readonly="readonly"
						name="endDate" style="width: 50%;"  value="<fmt:formatDate type="date"
            value="${publishRule.endDate}"/> ">
						</td>
						<td><select style='width: 150px; z-index: -1' 
							name="status" class="form-control" id="publish-status">
								<option value="上架"
								<c:if test="${publishRule.status=='上架'}">selected</c:if>>
									上架</option>
								<option value="下架"
									<c:if test = "${publishRule.status=='下架'}">selected
									</c:if>>下架</option>
						</select></td>
				</tbody>
				</table>
				
				<button type="button" class="btn btn-primary" style="width: 80px;" id = "btn-update">保&nbsp;存</button> 
	</div><div class="col-sm-offset-4 col-sm-7">
			<a href="showListPublishRule.do?searchId=${publishRule.saleRuleId}">
			<button type="button" class="btn btn-primary" style="width: 80px;">返&nbsp;回</button> </a>
	</div></div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
$(function(){
	var today = new Date();
 $('.datepicker').datetimepicker({
	    format: 'yyyy-mm-dd',
	    autoclose: true,
	    startView: 2 ,
	    todayBtn: true,
	    minView: 'month',
	    startDate:today,
	    language:'zh-CN'
	});
 $("#btn-update").click(function(){
	 var id = ${publishRule.id};
	 var beginDate=$("#beginDate").val();  
		var endDate=$("#endDate").val(); 
		var status = $("#publish-status").val();
			var d1 = new Date(beginDate.replace(/\-/g, "\/"));  
			var d2 = new Date(endDate.replace(/\-/g, "\/"));  
			var saleRuleId = ${publishRule.saleRuleId};
			if(beginDate!=""&&endDate!=""&&d1 >=d2 )  {
			 	 alert("开始时间不能大于或等于结束时间！");  
			  	 return false;  
			}else if( beginDate ==null || endDate ==null || beginDate =="" || endDate ==""){
				  alert("输入不能为空");  
				  return false;  
			}else if(beginDate!=""&&endDate!=""){
			 	 $.post(ctx+'/sale/updatePublishRule.do',{
			 		 "beginDate":beginDate,
			 		 "endDate":endDate,
			 		 "saleRuleId":saleRuleId,
			 		 "status" : status,
			 		 "id" : id
			 		 },function(msg){
				 if (msg == false){
					 alert("时间段有重复，请重新输入");
					 return false;
				 }else{
					 window.location.reload();
				 }
				  
			  	});
			 }
			 return false;
	 
 });
});
 </script>
</html>