<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<title>过滤设置</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp"></jsp:include>
	
	
<!-- Modal 酒店备注 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">酒店备注</h4>
      </div>
      <div class="modal-body">
      <label>当前酒店备注为</label>
       <input type="text"   name="remark" id="remark" class="form-control"> 
       <input type="hidden"  name="hotelId" id="providerHotelId" >
       <input type="hidden"  name="providerId" id="providerId">
      <button type="button" class="btn btn-success"id="updateRemark" data-dismiss="modal">修改酒店备注</button>
    <button type="button" class="btn btn-success"id="deleteRemark" data-dismiss="modal">删除备注</button>
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="remove">关闭</button>
        
      </div>
    </div>
  </div>
</div>
<div class="container">

<ul class="nav nav-tabs">
		<li role="presentation" ><a href="showBaseRule.do?searchId=${searchId}">基本设置</a></li>
		<li role="presentation"><a href="showListPublishRule.do?searchId=${searchId}">发布设置</a></li>
		<li role="presentation"><a href="${ctx}/sale/hotelRecords.do?searchId=${searchId}">加幅设置</a></li>
		<li role="presentation" class="active"><a href="filterData.do?searchId=${searchId}">过滤设置</a></li>
	</ul>

	<div class="form-group col-sm-12">
	<h3>酒店过滤</h3>
	<form action= "filterData.do" >
	<div class="form-group col-sm-6">
	<input type="hidden" value="${searchId}" name="searchId">		
			<label for="city" class="col-sm-6 control-label">请选择酒店所在城市</label>
				<div class="col-sm-10">
					<select class="form-control" id="cityId" name="cityId">
						<option value="">城市</option>
						<c:forEach items="${cities}" var="items">
						
							<option value="${items.id}" <c:if test="${items.id==city.id}">selected</c:if>
									>${items.cityName}</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-primary" >
查找
</button>
	<c:choose>
							<c:when test="${city.id !=null && filterCity == 'filter'}">
								<button type="button" class="btn btn-primary btn-cancelcity" value="${city.id}">取消

过滤</button>
							</c:when>
							<c:when test="${city.id !=null && filterCity == null}">
								<button  class="btn btn-success" id = "filtercity" type="button">城市过滤</button>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
				</div>
			</div>
			</form>
			</div>
	<table class="table table-data table-hover" data-current-page="${page.pageNo}"
			data-total-pages="${page.totalPages}">
		<thead>
			<tr>
				<!-- <th>供应商id</th>
				<th>供应酒店id</th>
				<th >城市id</th> -->
				<th><span class="glyphicon glyphicon-home"></span>酒店名称</th>
				<th><span class="glyphicon glyphicon-star-empty"></span>星级</th>
				<th><span class="glyphicon glyphicon-phone-alt"></span>联系电话</th>
				<th><span class="glyphicon glyphicon-map-marker"></span>酒店地址</th>
				<th>操作</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${page.results}" var="items">
				<tr id ="${items.hotel.providerHotelId}">
					<%-- <td>${items.providerId}</td>
					<td>${items.providerHotelId}</td>
					<td>${items.cityId}</td> --%>
					<td title="${items.hotel.hotelName}" class="filt" value="${items.hotel.cityId}">${fn:substring(items.hotel.hotelName,0,12)}</td>
					<td>${items.hotel.hotelStar}</td>
					<td>${items.hotel.hotelPhone}</td>
					<td title="${items.hotel.hotelAddress}">${fn:substring(items.hotel.hotelAddress,0,8)}</td>

					<td class="status">
						<c:choose>
							<c:when test="${items.status == 'filt'}">
								 	<button type="button" class="btn btn-primary btn-cancelhotel" value="${items.hotel.providerHotelId}">取消过滤</button>
								 							
							</c:when>
							
							<c:otherwise>
							<button type="button" class="btn btn-success  btn-hotelFilter" id 

= "hotelFilter" value="${items.hotel.providerHotelId}" providerValue="${items.hotel.providerId}">酒店过滤</button> 
							</c:otherwise>
						</c:choose>
<%-- 							<button type="button" class="btn btn-success  btn-hotelFilter" id 

= "hotelFilter" value="${items.providerHotelId}" providerValue="${items.providerId}">酒店过滤</button> --%>
						<button type="button" class="btn btn-primary btn-hotelRemark" data-toggle="modal" data-target="#myModal" value="${items.hotel.providerHotelId}" providerIdValue="${items.hotel.providerId}"  >
  酒店备注
</button>							
</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class= "col-sm-8 col-sm-offset-3">
		<ul id="example" ></ul>
		</div>
		</div>
		</div>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/jsp/product/js/template.js"></script>
<script type="text/javascript"
	src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script type='text/javascript'>
	$(function() {
		var options = {
			currentPage : $(".table-data").data("current-page"),
			totalPages : $(".table-data").data("total-pages"),
			numberOfPages : 10,
			bootstrapMajorVersion : 3,
			alignment : 'center',
			itemTexts : function(type, page, current) {
				switch (type) {
				case "first":
					return "首页";
				case "prev":
					return "上一页";
				case "next":
					return "下一页";
				case "last":
					return "尾页";
				case "page":
					return page;
				}
			},
			onPageClicked : function(e, originalEvent, type, page) {
				
				location.href  =  ctx+'/sale/filterData.do?searchId=${searchId}&cityId=${city.id}&pageNo='+page;	
			}
		}
		$('#example').bootstrapPaginator(options)
		$('#bp-example-size-alignment').bootstrapPaginator("showFirst");
		$('#bp-example-size-alignment').bootstrapPaginator("showPrevious");
		$('#bp-example-size-alignment').bootstrapPaginator("showNext");
		$('#bp-example-size-alignment').bootstrapPaginator("showLast");
	});
</script>

	<script type="text/javascript">
	$('#updateRemark').click(function(){
		var hotelId = $('#providerHotelId').val();
		var remark = $('#remark').val();
		var saleRuleId = ${searchId};
		var providerId = $('#providerId').val();
		$.post("updateHotelRemark.do",{"hotelId":hotelId,"remark":remark,"providerId":providerId,"saleRuleId":saleRuleId},function(msg){
			$('#mark').attr("autocomplete","off");
		});
	});
</script>
<script type="text/javascript">
$('.btn-hotelRemark').click(function(){
	var hotelId = $(this).val();
	var saleRuleId = ${searchId};
	$('#providerHotelId').attr("value",hotelId);
	$("#remark").prop("value",null);
	var providerId = $(this).attr("providerIdValue");
	$('#providerId').attr("value",providerId);
/*打开模态框，传入remark数据*/
$.post((ctx+'/sale/showHotelRemark.do'),{"hotelId":hotelId,"providerId":providerId,"saleRuleId":saleRuleId},function(msg){
	var hotelRemark = msg; 
	$('#remark').prop("value",hotelRemark);
          });
});
</script>
<script type ="text/javascript">
var searchId = ${searchId};
$('.btn-hotelFilter').click(function(){
	var hotelId = $(this).val();
	var providerId = $(this).attr("providerValue");
	$.post(ctx+'/sale/insertFilterHotel.do',
			{
		   "providerId":providerId,
		   "providerHotelId":hotelId,
		    "searchId":searchId},
			function(msg){
				if (msg==true){
					window.location.reload();
				 }
          	});
});
$(".btn-cancelhotel").click(function(){
	var hotelId = $(this).val();
   $.post((ctx+'/sale/deleteHotelFilterRule.do'),{"hotelId":hotelId,"searchId":searchId},function(msg){
	  if (msg == true){
		  window.location.reload();
	  }else{
		  alert("操作失败");
	  }
   });
});
$("#filtercity").click(function(){
	var cityId = $("#cityId").val();
	$.post((ctx+'/sale/insertFilterCity.do'),{
		"cityId":cityId,
		"searchId":searchId
		},function(msg){
		 if (msg == true){
			 location.href  =  ctx+'/sale/filterData.do?searchId=${searchId}&cityId='+cityId;
		 }else{
			 alert("操作失败");
		 }
		});
});
$(".btn-cancelcity").click(function(){
	var cityId = $(this).val();
	$.post((ctx+'/sale/deleteCityFilterRule.do'),{"cityId":cityId,"searchId":searchId},function(msg){
		if (msg == true){
				  window.location.reload();
			  }else{
				  alert("操作失败");
			  }	
		});
});
$("#deleteRemark").click(function(){
  var providerId = $("#providerId").val();
  var providerHotelId = $("#providerHotelId").val();
  var saleRuleId = ${searchId};
	$.post((ctx+'/sale/deleteHotelRemark.do'),
			{"providerId":providerId,"hotelId":providerHotelId,"saleRuleId":saleRuleId},
			function(msg){
				if (msg == true){
					window.location.reload();
				}else{
					  alert("操作失败");}
			});
});
</script>
<script type="text/javascript">

$(function(){
	var hotelIdList = eval('${hotelIdList}');
	var showHotelIdList =eval('${showHotelIdList}');
	var filterCityHotelIdList = eval('${filterCityHotelIdList}');
	var success = "success";
	var active = "active";
	var danger = "danger";
	for(var i=0;i<=showHotelIdList.length;i++){
		var select = showHotelIdList[i];
		if($(hotelIdList).size() != 0){
			$.each(hotelIdList,function(){
				if(this==select){
			document.getElementById(select).setAttribute("class", danger);
				}	
			});
		}
		if($(filterCityHotelIdList).size() != 0){
			$.each(filterCityHotelIdList,function(){
				if(this==select){
					document.getElementById(select).setAttribute("class",success);
				}
			});	
		}
	}
	
	
	
	
})






</script>
</html>