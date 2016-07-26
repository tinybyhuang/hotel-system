<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<link rel="stylesheet" href="${ctx}/css/bootstrap-datetimepicker.min.css" type="text/css">
<title>发布规则设置</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp"></jsp:include>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">发布设置修改</h4>
      </div>
      <div class="modal-body">
       <table class="table table-hover table-bordered">
				<thead>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>发布状态</th>
				</thead>
				<tbody>
				<tr>
				<td  >
				<input type = "hidden" name="id" id="updateId">
				<input type="text" class="datepicker form-control" id="showBeginDate" readonly="readonly"
						name="beginDate"   ></td>
						<td><input type="text" class="datepicker form-control" id="showEndDate" readonly="readonly"
						name="endDate"   >
						</td>
						<td><select style='width: 150px; z-index: -1' 
							name="status" class="form-control" id="showStatus">
								<option value="上架" id ="up">
									上架</option>
								<option value="下架" id = "down">下架</option>
						</select></td>
				</tbody>
				</table>
				
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary"  id = "btn-update">保&nbsp;存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        
      </div>
    </div>
  </div>
</div>

<div class="container">
	<ul class="nav nav-tabs">
		<li role="presentation" ><a href="showBaseRule.do?searchId=${searchId}">基本设置</a></li>
		<li role="presentation" class="active"><a href="showListPublishRule.do?searchId=${searchId}">发布设置</a></li>
		<li role="presentation"><a href="${ctx}/sale/hotelRecords.do?searchId=${searchId}">加幅设置</a></li>
		<li role="presentation"><a href="filterData.do?searchId=${searchId}">过滤设置</a></li>
	</ul>
				<div class="col-md-6 col-md-offset-3">
				<label>请输入发布规则</label>
				<form action="insertPublishRule.do?searchId=${searchId}" method="post" >
				<table class="table table-hover table-bordered">
				
				<thead>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>发布状态</th>
				
				</thead>
				<tbody>
				
				<tr>
				<td  ><input type="text" class="datepicker form-control" id="beginDate"
						name="beginDate"  style="width: 50% "  readonly="readonly"></td>
						<td><input type="text" class="datepicker form-control" id="endDate"
						name="endDate" style="width: 50%;"  readonly="readonly">
						</td>
						<td>
						<select style='width:150px;z-index:-1' id="publish-status" name="status"  class="form-control">  
  <option value="下架" >下架</option>  
    <option value="上架" > 上架 </option>
    

</select>  </td>
						
</tr>
				</tbody>
				</table>
				<div>
				<button id="create-btn" type="button" class="btn btn-primary" style="width: 80px;">添&nbsp;加</button> </form>
				</div>
				<div>	
				<table class="table table-hover table-bordered">
				
				<thead>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>发布状态</th>
				<th>操作</th>
				</thead>
				<tbody>
				<c:forEach items="${showList}" var="items">
				<tr>
				<td id="begin" value="<fmt:formatDate type="date" 
            value="${items.publishRule.beginDate}"/>" ><fmt:formatDate type="date" 
            value="${items.publishRule.beginDate}"/> </td>
					<td>	<fmt:formatDate type="date"
            value="${items.publishRule.endDate}"/> 
						</td>
						<td>
						${items.publishRule.status}  </td>
						<td><form action = "updatePublishRule.do" method ="get">
						<button type="button" data-toggle="modal" href="#myModal"  begindate = "${items.beginDate}" enddate = "${items.endDate}" status = "${items.publishRule.status}" class="btn btn-primary btn-update" name="publishRuleId" value="${items.publishRule.id}" style="width: 80px;">修&nbsp;改</button>
						 </form>
						  <form action= "deletePublishRule.do?searchId=${searchId}" method="post">
						<button type="submit" name="deleteId"  value="${items.publishRule.id}"class="btn btn-primary" style="width: 80px;" >删&nbsp;除</button></form></td>
</tr></c:forEach>
				</tbody>
				</table></div>
	</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">

 	$(function(){
 		var today = new Date();
 		$('#beginDate').datetimepicker({
 		    format: 'yyyy-mm-dd',
 		    autoclose: true,
 		    startView: 2 ,
 		    todayBtn: true,
 		    startDate:today,
 		   
 		    language:'zh-CN',
 		   minView: 'month',
 		    viewSelect:2
 		});
 		$('#showBeginDate').datetimepicker({
 		    format: 'yyyy-mm-dd',
 		    autoclose: true,
 		    startView: 2 ,
 		    todayBtn: true,
 		    startDate:today,
 		   
 		    language:'zh-CN',
 		   minView: 'month',
 		    viewSelect:2
 		});
 		$('#showEndDate').datetimepicker({
 		    format: 'yyyy-mm-dd',
 		    autoclose: true,
 		    startView: 2 ,
 		    todayBtn: false,
 		   
 		    language:'zh-CN',
 		   minView: 'month',
 		    viewSelect:2
 		});
 		$('#endDate').datetimepicker({
 		    format: 'yyyy-mm-dd',
 		    autoclose: true,
 		    startView: 2 ,
 		    todayBtn: false,
 		   
 		    language:'zh-CN',
 		   minView: 'month',
 		    viewSelect:2
 		});
 		
 		$("#create-btn").click(function(){
 			var beginDate=$("#beginDate").val();  
 			var endDate=$("#endDate").val(); 
 			var status = $("#publish-status").val();
 			var d1 = new Date(beginDate.replace(/\-/g, "\/"));  
 			var d2 = new Date(endDate.replace(/\-/g, "\/"));  
 			var saleRuleId =${searchId};
 			if(beginDate!=""&&endDate!=""&&d1 >=d2 )  {
 			 	 alert("开始时间不能大于或等于结束时间！");  
 			  	 return false;  
 			}else if( beginDate ==null || endDate ==null || beginDate =="" || endDate ==""){
 				  alert("输入不能为空");  
 				  return false;  
 			}else if(beginDate!=""&&endDate!=""){
 			 	 $.post(ctx+'/sale/matchListPublishRule.do',{
 			 		 "beginDate":beginDate,
 			 		 "endDate":endDate,
 			 		 "saleRuleId":saleRuleId,
 			 		 "status" : status
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

 	$(".btn-update").click(function(){
 		var id = $(this).val();
 		var begin = $(this).attr("beginDate");
 		var end = $(this).attr("endDate");
 		var status = $(this).attr("status");
 		$("#showBeginDate").attr("value",begin);
 		$("#showEndDate").attr("value",end);
 		$("#updateId").attr("value",id);
 		if(status == "上架"){
 			$("#up").attr("selected","selected");
 		}else if(status == "下架"){
 			$("#down").attr("selected","selected");
 		}
 	});
 	
 	 $("#btn-update").click(function(){
 		 var id = $("#updateId").val();
 		 var beginDate=$("#showBeginDate").val();  
 			var endDate=$("#showEndDate").val(); 
 			var status = $("#showStatus").val();
 				var d1 = new Date(beginDate.replace(/\-/g, "\/"));  
 				var d2 = new Date(endDate.replace(/\-/g, "\/"));  
 				var saleRuleId = ${searchId};
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
 	
 </script>
<script>


</script>
 
</html>