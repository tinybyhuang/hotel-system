<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<title>加幅规则展示页面</title>
</head>
<body>
<jsp:include page="/common/navbar.jsp"></jsp:include>
	<ul class="nav nav-tabs">
		<li role="presentation" ><a href="showBaseRule.do?searchId=${searchId}">基本设置</a></li>
		<li role="presentation"><a href="showListPublishRule.do?searchId=${searchId}">发布设置</a></li>
		<li role="presentation" class="active"><a href="showIncreaseRule.do?searchId=${searchId}">加幅设置</a></li>
		<li role="presentation"><a href="filterData.do?searchId=${searchId}">过滤设置</a></li>
	</ul>
	<div>
	<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
    
      			<div id ="cityList">
      </div>
      
      
      </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="close">Close</button>
        <button type="button" class="btn btn-primary" id="selectValue">Save changes</button>
      </div>
    </div>
  </div>
</div>
<form action = "updateIncreaseRule.do" method ="post">

<div class ="col-sm-8"><table class="table table-hover table-bordered">
<thead>
							<th> 类型</th>
								<th>加幅Id</th>
									<th>供应商Id</th>
										<th>加幅类型</th>
										<th> 加幅额度</th>
										</thead>
										<tbody>
										<c:forEach items="${increaseRule}" var="items">
										<tr>
									<td >
									<select class="form-control"  name="scopeType"  id="scopeType">  
   
   
    <option value="酒店"<c:if test = "${items.scopeType=='酒店'}">selected</c:if>>酒店</option>
    <option value="城市" <c:if test = "${items.scopeType=='城市'}">selected</c:if>>城市</option>  
    <option value="房型"<c:if test = "${items.scopeType=='房型'}">selected</c:if>>房型</option>
  </select><!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button></td>
											<td ><input type ="text" 	class="form-control"   name="scopeId" id="scopeId"  placeholder="${items.scopeId}" data-toggle="modal" data-target="#myModal"></td>
												<td ><input type ="text" 	class="form-control"  name="providerId"  value ="${items.providerId}"  placeholder=".."></td>
											<td ><select class="form-control"  name="increaseType">  
   
    <option value="差价"<c:if test = "${items.increaseType=='差价'} ">selected</c:if>>差价</option>  
    <option value="百分比"<c:if test = "${items.increaseType=='百分比'} ">selected</c:if>>百分比</option>  </select>
    </td>
												<td ><input type ="text" 	class="form-control"  name="increaseAmount" value ="${items.increaseAmount}" placeholder=".."></td>
											</c:forEach>								
										</tbody>
										
</table>
<div class="form-group">
				<div class="col-sm-offset-3 col-sm-7">
		
					<button type="submit" class="btn btn-primary" style="width: 80px;">修&nbsp;改</button> 
				<!-- <button type="button" class="btn btn-primary" style="width: 80px;" id="deleteIncreaseRule">删&nbsp;除</button>  -->
				</div>
</form>	
<form action="showListSaleRule.do" method="get">
			<button type="submit" class="btn btn-primary" style="width: 80px;">完&nbsp;成</button> </form>
			<!-- <div id ="cityList">
			</div> --><div id ="hotelList">
			</div><div id ="roomList">
			</div>
			<div id="hotelList">
			<table id="table" data-current-page="${hotelList.pageNo}"
			data-total-pages="${hotelList.totalPages }">
			<thead><th>酒店id</th><th>酒店名称</th>
			<c:forEach items="${hotelList.results}" var="hotel">
			<tbody>
			
			<tr><td>${hotel.providerHotelId }</td><td>${hotel.hotelName}</td></tr>
		</tbody>
				</c:forEach>
			</table>
			<ul id="example"></ul>
			
			</div>
				
</div>

</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/jsp/product/js/template.js"></script>
<script  type="text/javascript"src="${ctx}/js/bootstrap-paginator.min.js"></script>
<script type='text/javascript'>
	$(function() {
		var options = {
			currentPage : $('#table').data("current-page"),
			totalPages : $('#table').data("total-pages"),
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
				location.href  =  ctx+'/sale/showIncreaseRule.do?searchId=${searchId}&pageNo='+page;
			}
		}
		$('#example').bootstrapPaginator(options)
		$('#bp-example-size-alignment').bootstrapPaginator("showFirst");
		$('#bp-example-size-alignment').bootstrapPaginator("showPrevious");
		$('#bp-example-size-alignment').bootstrapPaginator("showNext");
		$('#bp-example-size-alignment').bootstrapPaginator("showLast");
	});
	</script>
<script type ="text/javascript">
$("#deleteIncreaseRule").click(function(){
	var deleteIncreaseRuleId =$("#increaseRuleId").val();
	$.post("deleteIncreaseRule.do",{"deleteIncreaseRuleId":deleteIncreaseRuleId},window.open("showIncreaserule.do"));
});
</script>
<script id="city" type="text/html">
<table>
<tbody  id="cityShow">
<tr>
    {{each list as value i}}
       	<input id="mytable" type="checkbox" name="cityId" id="selectId"
									value="{{value.id }}" > {{value.cityName}}
 

    {{/each}}
<tr/>
</tbody>
</table>


</script>
<script  type='text/javascript'>
$(function(){
	var select = $('#scopeType').val();
if (select == "城市"){
	$.post("getAllCities.do",{},function(msg){
		if (msg != null){
			
			var cityList = eval("("+msg+")");
		
			var data ={list: cityList
				};

			var html = template('city',data);
			document.getElementById('cityList').innerHTML = html;
			$('selectValue').click(function(){
				var scopeTypeValue = $('selectId').val();
				$('scopeId').attr("value",scopeTypeValue);
			});
			
		}
	});
	}});
$('#scopeType').blur(function(){var select = $('#scopeType').val();
if (select == "城市"){
	$.post("getAllCities.do",{},function(msg){
		if (msg != null){
			
			var cityList = eval("("+msg+")");
		
			var data ={list: cityList
				};

			var html = template('city',data);
			document.getElementById('cityList').innerHTML = html;
			$('selectValue').click(function(){
				var scopeTypeValue = $('selectId').val();
				$('scopeId').attr("value",scopeTypeValue);
			});
			
		}
	});
	}});
$('#close').click(function(){
	var deleCity = document.getElementById("cityShow")
	var citytr = deleCity.getElementsByTagName("tr")[1];
deleCity.removeChild(citytr);
	
	
	
	
	
});





</script>

</html>