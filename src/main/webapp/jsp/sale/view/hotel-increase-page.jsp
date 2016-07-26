<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加幅设置</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<div class="container">
		<ul class="nav nav-tabs">
		<li role="presentation" ><a href="showBaseRule.do?searchId=${searchId}">基本设置</a></li>
		<li role="presentation"><a href="showListPublishRule.do?searchId=${searchId}">发布设置</a></li>
		<li role="presentation" class="active"><a href="${ctx}/sale/hotelRecords.do?searchId=${searchId}">加幅设置</a></li>
		<li role="presentation"><a href="filterData.do?searchId=${searchId}">过滤设置</a></li>
	</ul>
        <hr /> 
		
		<!-- 模态框 -->
		<!-- 小模态框 -->
		<!-- Modal -->
		<div class="modal fade " id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog " role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">加幅设置</h4>
					</div>
					<form id="priceform"
							action="${ctx }/sale/setIncreaseRule.do"  method="post"
							onsubmit="getReturnJson();return false;">
					<div class="modal-body">
							<label  class=" control-label" style="width: 20%;float:left">加幅记录:</label>
							<div id="showIncreaseRule"></div>
							
								<label style="width: 20%;float:left" class="control-label">加幅类型:</label>
								<select style="width: 50%" name="increaseType"
									class="form-control ">
									<!-- <option value="无详细加幅">无加幅</option> -->
									<option value="差价">差价</option>
									<option value="百分比">百分比</option>
								</select>
								
								<label style="width: 20%;float:left" class=" control-label">数值:</label>
								<input name="increaseAmount" class="form-control "
								id="increaseAmount"   	style="width: 50%">
							
							<!-- 详细加幅设置需要的房型id、平台id、供应商id、加幅日期 -->
							<input id="roomID" name="roomId" style="display:none">
							<input id="cityID" name="cityId" style="display:none">
							<input id="marketID" name="marketId" style="display:none">
							<input id="providerID" name="providerId" style="display:none">
						    <input id="hotelID" name="hotelId" style="display:none">
						
					</div>
					<div class="modal-footer">
			    		<button type="submit" class="btn btn-primary">提交</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 模态框 -->

		<!--   选择查找,根据回传的值显示     start -->
		<!-- 条件查找表单 -->
		<form id="search-form" method="post" class="form-horizontal row col-sm-12"  
			action="${ctx }/sale/hotelRecords.do?searchId=${searchId}">
			<div class="col-sm-12">
				<div class="col-sm-3">
					<label for="marketId" class="col-sm-4 control-label">平台</label>
					<div class="col-sm-8">
						<select class="form-control" id="marketId" name="marketId">
							<!-- <option value="">选择平台</option> -->
							<c:forEach items="${marketId }" var="market">
								<option value="${ market}"
									<c:if test="${defaultMarket==market }">selected</c:if>
									<c:if test="${searchDetail.marketId==market }">selected</c:if>>
									<c:if test="${ market=='1'}">携程</c:if>
									<c:if test="${ market=='2'}">去哪儿</c:if>
									<c:if test="${ market=='3'}">淘宝</c:if>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-sm-3">
					<label for="providerId" class="col-sm-5 control-label">供应商</label>
					<div class="col-sm-7">
						<select class="form-control" id="providerId" name="providerId">
							<!-- <option value="">选择供应商</option> -->
							<option value="1"
								<c:if test="${searchDetail.providerId=='1' }">selected</c:if>>携旅</option>
							<option value="2"
								<c:if test="${searchDetail.providerId=='2' }">selected</c:if>>龙腾</option>
						</select>
					</div>
				</div>
				<div class="col-sm-3">
					<label for="hotelName" class="col-sm-5 control-label">酒店名</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="hotelName"
							name="hotelName" placeholder="输入酒店名查询"
							value="${searchDetail.hotelName }">
					</div>
				</div>
				<div class="col-sm-3">
					<!-- <label for="button" class="col-sm-4 control-label">search</label> -->
					<div class="col-sm-12">
						<button style="width: 100%" class="btn btn-success" type="submit">查找</button>
					</div>
				</div>
			</div>

			<div class="col-sm-12">
				<div class="col-sm-3">
					<label for="star" class="col-sm-4 control-label">星级</label>
					<div class="col-sm-8">
						<select class="form-control" id="star" name="star">
							<option value="">星级</option>
							<option value="1星级"
								<c:if test="${searchDetail.star=='1星级' }">selected</c:if>>One</option>
							<option value="2星级"
								<c:if test="${searchDetail.star=='2星级' }">selected</c:if>>Two</option>
							<option value="3星级"
								<c:if test="${searchDetail.star=='3星级' }">selected</c:if>>Three</option>
							<option value="4星级"
								<c:if test="${searchDetail.star=='4星级' }">selected</c:if>>Four</option>
							<option value="5星级"
								<c:if test="${searchDetail.star=='5星级' }">selected</c:if>>Fifth</option>
						</select>
					</div>
				</div>
				
				

				<div class="col-sm-3">
					<label for="city" class="col-sm-4 control-label">城市</label>
					<div class="col-sm-8">
						<select class="form-control" id="city" name="city" >
							<option value="">城市</option>
							<c:forEach items="${citys }" var="city">
								<option value="${city.id }"   class="option-color"
									<c:if test="${city.id==searchDetail.city  }">selected</c:if>
									>${city.cityName }
								</option>
							</c:forEach>
						</select>
					</div>

				</div>

				<div class="col-sm-4">
					<label for="button" class="col-sm-4 control-label"></label>
					<div class="col-sm-8">
						<c:choose>
							<c:when test="${searchDetail.city!=null}">
								<button style="width: 70%" type="button"
									class="btn btn-primary btn-setCityIncrease" data-toggle="modal"
									value="${searchDetail.city}" href="#myModal" value="">设置城市加幅</button>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

			</div>
		</form>
		<!-- *** -->
		<!--   选择查找,根据回传的值显示    end -->

		<!-- show the hotel detail-->
		<table class="table" data-current-page="${page.pageNo}"
			data-total-pages="${page.totalPages }">
				<%-- <c:if test="${cityNIncreaseRuleVOList.size()!=0 }">
						<c:forEach items="${cityNIncreaseRuleVOList }"
							var="cityNIncreaseRuleVO">
							<tr>
							    <td class="col-sm-12">
							        <div class="col-sm-3">城市名称:${cityNIncreaseRuleVO.city.cityName } </div>
									<div class="col-sm-3">加幅类型:${cityNIncreaseRuleVO.increaseRule.increaseType } </div>
									<div class="col-sm-3">加幅数量:${cityNIncreaseRuleVO.increaseRule.increaseAmount } </div>
						            <div class="col-sm-3">  
						            <button type="button"  data-toggle="modal" href="#myModal"  
						             class="btn btn-primary btn-updateCityIncrease"  style="height:30px"
						             value="${cityNIncreaseRuleVO.city.id }"
						             >
						                                 修改该城市加幅设置</button>
						            </div>
						       </td>
						   </tr>
						</c:forEach>
				</c:if> --%>

				<%-- <c:if test="${cityNIncreaseRuleVOList.size()==0 }">
					<tr>
						<td>暂无城市加幅</td>
					</tr>
				</c:if> --%>

			<c:forEach items="${page.results }" var="hotelVO">
				<tr>
					<td>
						<div class="panel panel-info">
							<!-- Default panel contents -->
							<div class="panel-heading">
								<table>
									<tr class="col-sm-12">
										<td class="col-sm-3"><span
											class="glyphicon glyphicon-home"></span>${hotelVO.hotel.hotelName }</td>
										<td class="col-sm-3"><span
											class="glyphicon glyphicon-map-marker"></span>${hotelVO.hotel.hotelAddress }</td>
										<td class="col-sm-1"><span
											class="glyphicon glyphicon-star-empty"></span>${hotelVO.hotel.hotelStar }</td>
										<td class="col-sm-2">
											<button data-toggle="modal" href="#myModal" type="button"
												class="btn btn-primary  btn-setHotelIncrease"  value="${hotelVO.hotel.providerHotelId}"
												style="width: 100%">设置酒店加幅</button>
										</td>
										<td class="col-sm-3"><c:if
												test="${hotelVO.hotelIncreaseRule==null}">暂无酒店加幅</c:if> <c:if
												test="${hotelVO.hotelIncreaseRule!=null}">加幅类型:${hotelVO.hotelIncreaseRule.increaseType } 加幅数值:${hotelVO.hotelIncreaseRule.increaseAmount }</c:if>
										</td>
									</tr>
									<!-- 第一行 -->
								</table>
							</div>
							<div class="panel-body">
								<!-- panel-body -->
							</div>
							<!-- Table,show the room detail -->
							<table id="" class="table">
								<thead>
									<tr>
										<th class="col-sm-3">酒店内房型</th>
										<th class="col-sm-3">相应床型</th>
										<th class="col-sm-2">操作</th>
										<th class="col-sm-4">加幅显示</th>
									</tr>
								</thead>
								<c:forEach items="${hotelVO.rooms }" var="room">
									<tbody id="${room.id }">
										<tr>
											<td>${room.roomName }</td>
											<td><c:if test="${room.roomBedType =='1'}">单人床</c:if> <c:if
													test="${room.roomBedType =='2'}">双床</c:if> <c:if
													test="${room.roomBedType =='3'}">大床</c:if> <c:if
													test="${room.roomBedType =='4'}">园床</c:if> <c:if
													test="${room.roomBedType =='5'}">大/双床</c:if> <c:if
													test="${room.roomBedType =='6'}">三人床</c:if></td>
											<td>
												<button type="button" style="width: 80%" data-toggle="modal"
													href="#myModal" value="${room.providerRoomId }"
													valueOfCityId="${hotelVO.hotel.cityId }"
													class="btn btn-primary btn-setRoomIncrease">设置房型加幅</button>
											</td>
											<td>
											    <%-- <c:if
													test="${hotelVO.roomIncreaseRuleMap.size()!=0}">
													<c:forEach items="${hotelVO.roomIncreaseRuleMap}" var="i">
													    <c:if test="${i.key == room.providerRoomId}">
																	加幅类型:${i.value.increaseType}
																           加幅数值:${i.value.increaseAmount}
													    </c:if>
													 	<c:if test="${i.key != room.providerRoomId}">
													                      暂无房型加幅
													    </c:if>  
													</c:forEach>
												</c:if> --%>
												<%-- <c:if test="${fn:contains(hotelVO.roomIncreaseRuleMap.keySet(),room.providerRoomId)}">
													<c:forEach items="${hotelVO.roomIncreaseRuleMap}" var="i">
													    <c:if test="${i.key == room.providerRoomId}">
																	加幅类型:${i.value.increaseType}
																           加幅数值:${i.value.increaseAmount}
													    </c:if>
													    </c:forEach>
												</c:if>  --%> 
												<c:choose>
													<c:when
														test="${fn:contains(hotelVO.roomIncreaseRuleMap.keySet(),room.providerRoomId)}">
														<c:forEach items="${hotelVO.roomIncreaseRuleMap}" var="i">
															<c:if test="${i.key == room.providerRoomId}">
																	加幅类型:${i.value.increaseType}
																           加幅数值:${i.value.increaseAmount}
													    </c:if>
														</c:forEach>
													</c:when>
													<c:otherwise>  暂无房型加幅
														   </c:otherwise>
												</c:choose> <%-- <!-- 当这个数据都没有时，就会用到 -->
												<c:if test="${hotelVO.roomIncreaseRuleMap.size()==0}">
													暂无房型加幅
												</c:if> --%> 
												</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
							<!-- 两周酒店价格 -->
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 分页插件对象 -->
	<ul id="example"></ul>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script src="${ctx }/js/bootstrap-paginator.min.js"></script>
<script type='text/javascript'>
//分页插件
$(function() {
		var options = {
			currentPage : $(".table").data("current-page"),
			totalPages : $(".table").data("total-pages"),
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
				var f = document.getElementById("search-form");
				f.action = f.action + '?pageNo=' + page; /* //结合表单的提交请求一起 */
				f.submit();
			}
		}
		$('#example').bootstrapPaginator(options)
		$('#bp-example-size-alignment').bootstrapPaginator("showFirst");
		$('#bp-example-size-alignment').bootstrapPaginator("showPrevious");
		$('#bp-example-size-alignment').bootstrapPaginator("showNext");
		$('#bp-example-size-alignment').bootstrapPaginator("showLast");
	});




$("#city").click(function(){
	
	/* 变为数组 */
	var increaseCityList = eval('${increaseCityList}');
	var allCityList =eval('${allCityList}'); 
	console.log(allCityList);
	for (var i=0;i<increaseCityList.length;i++){
		var cityId =  increaseCityList[i];
		var index =   allCityList.indexOf(cityId);
	    var option =      document.getElementById("city").options[index]; 
	   option.setAttribute("style", "background-color:#E0FFFF");
	 }
	
})
	


$(".btn-setRoomIncrease").click(function(){
	var cityId = document.getElementById("cityID");
	var roomId = document.getElementById("roomID");
	var hotelId = document.getElementById("hotelID");
	var marketId = document.getElementById("marketID");
	var providerId = document.getElementById("providerID");
	
	roomId.setAttribute("value", $(this).val());
	marketId.setAttribute("value", $("#marketId").val());
	providerId.setAttribute("value", $("#providerId").val());
	hotelId.setAttribute("value", "");
	cityId.setAttribute("value", "");
	
	$.post("findIncreaseRule.do",
			{
		"cityId" : 0,
		"hotelId" : 0,
		"roomId" : $(this).val(),
			    "marketId" : $('#marketId').val(),
		     	"providerId" : $('#providerId').val() ,
			},
			function(msg){
				console.log(msg);
				if(msg!="数据为空"){
					var IncreaseRule = eval("(" + msg + ")");
					console.log(IncreaseRule.increaseType);
				  var   IncreaseRuleHtml  =  '<ul>'  + '加幅类型 :' +IncreaseRule.increaseType +'&nbsp;'+ '加幅数值：' +IncreaseRule.increaseAmount+'</ul>' ;
					document.getElementById("showIncreaseRule").innerHTML = IncreaseRuleHtml;
				}
				else if(msg=="数据为空"){
					document.getElementById("showIncreaseRule").innerHTML = '<ul>暂无加幅设置</ul>';
				}
	});
	
	
}); 

$(".btn-setHotelIncrease").click(function(){
	var cityId = document.getElementById("cityID");
	var roomId = document.getElementById("roomID");
	var hotelId = document.getElementById("hotelID");
	var marketId = document.getElementById("marketID");
	var providerId = document.getElementById("providerID");
	
	hotelId.setAttribute("value", $(this).val());
	marketId.setAttribute("value", $("#marketId").val());
	providerId.setAttribute("value", $("#providerId").val());
	roomId.setAttribute("value", "");
	cityId.setAttribute("value", "");
	
	
	$.post("findIncreaseRule.do",
			{
		"cityId" : 0,
		"hotelId" : $(this).val(),
		"roomId" : 0,
			    "marketId" : $('#marketId').val(),
		     	"providerId" : $('#providerId').val() ,
			},
			function(msg){
				console.log(msg);
				if(msg!="数据为空"){
					var IncreaseRule = eval("(" + msg + ")");
					console.log(IncreaseRule.increaseType);
				  var   IncreaseRuleHtml  =  '<ul>'  + '加幅类型 :' +IncreaseRule.increaseType +'&nbsp;'+ '加幅数值：' +IncreaseRule.increaseAmount+'</ul>' ;
					document.getElementById("showIncreaseRule").innerHTML = IncreaseRuleHtml;
				}
				else if(msg=="数据为空"){
					document.getElementById("showIncreaseRule").innerHTML = '<ul>暂无加幅设置</ul>';
				}
	});
	
}); 

$(".btn-setCityIncrease").click(function(){
	var cityId = document.getElementById("cityID");
	var marketId = document.getElementById("marketID");
	var providerId = document.getElementById("providerID");
	var roomId = document.getElementById("roomID");
	var hotelId = document.getElementById("hotelID");
	cityId.setAttribute("value", $("#city").val());
	marketId.setAttribute("value", $("#marketId").val());
	providerId.setAttribute("value", $("#providerId").val());
	roomId.setAttribute("value", "");
	hotelId.setAttribute("value", "");
	
	console.log($("#city").val());
	
	if($("#city").val()=='' && $("#city").val()==null){
		alert("请选择城市");
	}
	else{
	$.post("findIncreaseRule.do",
			{
				"cityId" : $("#city").val(),
				"hotelId" : 0,
				"roomId" : 0,
			    "marketId" : $('#marketId').val(),
		     	"providerId" : $('#providerId').val() ,
			},
			function(msg){
				console.log(msg);
				if(msg!="数据为空"){
					var IncreaseRule = eval("(" + msg + ")");
					console.log(IncreaseRule.increaseType);
				  var   IncreaseRuleHtml  =  '<ul>'  + '加幅类型 :' +IncreaseRule.increaseType +'&nbsp;'+ '加幅数值：' +IncreaseRule.increaseAmount+'</ul>' ;
					document.getElementById("showIncreaseRule").innerHTML = IncreaseRuleHtml;
				}
				else if(msg=="数据为空"){
					document.getElementById("showIncreaseRule").innerHTML = '<ul>暂无加幅设置</ul>';
				}
	});
	}
	
}); 

$(".btn-updateCityIncrease").click(function(){
	var cityId = document.getElementById("cityID");
	var roomId = document.getElementById("roomID");
	var hotelId = document.getElementById("hotelID");
	var marketId = document.getElementById("marketID");
	var providerId = document.getElementById("providerID");
	
	cityId.setAttribute("value", $(this).val());
	marketId.setAttribute("value", $("#marketId").val());
	providerId.setAttribute("value", $("#providerId").val());
	roomId.setAttribute("value", "");
	hotelId.setAttribute("value", "");
}); 



		// 提交请求返回
		function getReturnJson() {
			var form = $("#priceform");
			var url = form.attr("action");
			var fdata = form.serialize();
			var _reg =  /^\d+(\.\d+)?$/;
			if($("#increaseAmount").val()=="" 
					|| $("#increaseAmount").val()==null)
			alert("加幅数值不能为空");
			else if(!_reg.test($("#increaseAmount").val())){
				alert("加幅数值只能是整数或者小数");
			}
			else if(_reg.test($("#increaseAmount").val())){
			$.post(
					url,
					fdata,
					function(msg) {
						$("#myModal").modal('hide');
						alert(msg);
						if(msg=="操作成功")
								var form = document.getElementById("search-form");
						        form.submit();
								}, 
					'json'
			     );
			}
	     }

	
</script>

</html>