<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品管理</title>
<jsp:include page="/common/head.jsp"></jsp:include>
<link href="${ctx }/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">
</head>
<body>
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>产品管理</h1>
<!-- <hr /> -->
		<!-- 模态框a -->
		<!-- 小模态框 -->
		<!-- Modal -->
		<div class="modal fade " id="myaModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog " role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">详细加幅设置</h4>
					</div>
					
					<form id="priceform"   
							action="${ctx }/product/setDetailIncreaseRules.do"
							onsubmit="getReturnJson();return false;">
					
					<div class="modal-body">
					
					<label style="width:20%;float:left" class="control-label">详细加幅记录:</label>
					<div id="showDetailIncreaseRule"></div>

								<label style="width:20%;float:left" class=" control-label">加幅类型:</label>
								<select style="width: 40%" name="increaseType"
									class="form-control ">
									<!-- <option value="无详细加幅">无加幅</option> -->
									<option value="差价">差价</option>
									<option value="百分比">百分比</option>
								</select>
							
								<label style="width:20%;float:left" class=" control-label">数值:</label>
								<input name="increaseAmount" class="form-control "
								  id="increaseAmount"   	style="width: 40%">
								  
							<%-- 	<div class="col-sm-12">
								<label style="width: 45%" class="col-sm-4 control-label">销售规则:</label>
								<select style="width: 40%" name="saleRuleId"
									class="form-control col-sm-8">
									<option value="">请选择</option>
									 <c:forEach items="${saleRuleList }" var="saleRule">
										<option value="${saleRule.id }"><c:if test="${saleRule.marketId=='1'}">携程:</c:if><c:if test="${saleRule.marketId=='3'}">淘宝:</c:if><c:if test="${saleRule.marketId=='2'}">去哪儿:</c:if> ${saleRule.status}  </option>
									</c:forEach> 
								</select>
							</div> --%>
							
							<!-- 详细加幅设置需要的房型id、平台id、供应商id、加幅日期 -->
							<input id="roomIDInpForIncreaseRule" name="roomID" style="display: none">
							<input id="saleDateInp" name="saleDate" style="display: none">
							<input id="marketIdIDInpForIncreaseRule" name="marketID" style="display: none">
							<input id="providerIDInpForIncreaseRule" name="providerID" style="display: none">
						    <input id="hotelIDInpForIncreaseRule" name="hotelId" style="display: none">
						    <input id="cityIDInpForIncreaseRule" name="cityId" style="display: none">
						
					</div>
					<div class="modal-footer">
				        <button type="submit" class="btn btn-primary " >提交</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 模态框a -->

		<!-- 模态框b -->
		<!-- 大模态框 -->
		<!-- Modal -->
		<div class="modal fade " id="mybModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog " role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">上下架设置</h4>
					</div>
					<form id="statusform" action="${ctx }/product/setSaleStatus.do"
							onsubmit="getReturnMsg();return false;">
					<div class="modal-body">
					<label style="width:20%;" class=" control-label">详细上下架记录:</label>
					<div id="showSaleStatus"></div>
				
								<label style="width:20%;float:left" class="control-label">上下架:</label>
								<select name="status" class="form-control"
									style="width: 50%">
									<option selected="selected" value="上架">上架</option>
									<option value="下架">下架</option>
								</select>

							<!-- Time Picking start-->
							<div class="form-group">
								<label for="startTime" style="width:20%;float:left"
									class="control-label">选择开始时间:</label>
								<div class="input-group date form_time"      data-date="" 
									data-date-format=""
									data-link-field="startTime"
									data-link-format="">
									<input  style=""    class="form-control form-showDate" size="6" type="text"  id="dateStartTime" 
										readonly>  <span class="input-group-addon"><span
										class="glyphicon glyphicon-remove"></span></span> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-time"></span></span>
								</div>
								<input style="display:none" id="startTime" name="startTime"  />
							</div>
							<!-- Time Picking end-->
							<!-- Time Picking start-->
							<div class="form-group">
								<label for="endTime" style="width:20%;float:left"
									class="control-label">选择结束时间:</label>
								<div class="input-group date form_time"   data-date=""
									data-date-format=""
									data-link-field="endTime"
									data-link-format="">
									<input     class="form-control  form-showDate" size="6" type="text"   id="dateEndTime" 
										readonly>  <span class="input-group-addon"><span
										class="glyphicon glyphicon-remove"></span></span>  <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-time"></span></span>
								</div>
								<input style="display:none" id="endTime" name="endTime" />
							</div>
							<!-- Time Picking end-->
							<!-- 上下架设置需要的房型id、平台id、供应商id -->
							<input id="roomIDInpForStatus" name="roomID" style="display: none">
							<input id="marketIdIDInpForStatus" name="marketID" style="display: none">
							<input id="providerIDInpForStatus" name="providerID" style="display: none">
							<input id="hotelIDInpForStatus" name="hotelId" style="display: none">
							<input id="cityIDInpForStatus" name="cityId" style="display: none">
						
					</div>
					<div class="modal-footer">
					<button type="submit" class="btn btn-primary" >提交</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 模态框b -->

		<!--   选择查找,根据回传的值显示start -->
		<!-- **** -->
		<form id="search-form" method="post"
			class="form-horizontal row col-sm-12"
			action="${ctx }/product/hotels.do">
			<div class="col-sm-12">
				<div class="col-sm-4">
					<label for="marketId" class="col-sm-3 control-label">平台</label>
					<div class="col-sm-9">
						<select class="form-control  " id="marketId" name="marketId">
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
				<div class="col-sm-4">
					<label for="providerId" class="col-sm-4 control-label">供应商</label>
					<div class="col-sm-8">
						<select class="form-control " id="providerId" name="providerId">
							<!-- <option value="">选择供应商</option> -->
							<option value="1"
								<c:if test="${searchDetail.providerId=='1' }">selected</c:if>>携旅</option>
							<option value="2"
								<c:if test="${searchDetail.providerId=='2' }">selected</c:if>>龙腾</option>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<label for="city" class="col-sm-3 control-label">城市</label>
					<div class="col-sm-9">
						<select class="form-control " id="city" name="city">

							<option value="">选择城市</option>
							<c:forEach items="${citys }" var="city">
								<option value="${city.id }"
									<c:if test="${city.id==searchDetail.city  }">selected</c:if>>${city.cityName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				
				<div class="col-sm-4">

					<label for="star" class="col-sm-3 control-label">星级</label>
					<div class="col-sm-9">
						<select class="form-control " id="star" name="star">
							<option value="">输入星级</option>
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
				<div class="col-sm-4">
					<label for="hotelName" class="col-sm-4 control-label">酒店名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control col-sm-7" id="hotelName"
							name="hotelName" placeholder="输入酒店名查询"
							value="${searchDetail.hotelName }">
					</div>
				</div>
				<div class="col-sm-4">
					<label for="button" class="col-sm-3 control-label"></label>
					<div class="col-sm-9">
						<button style="width: 100%" class="btn btn-primary " type="submit">查找</button>
					</div>
				</div>
			</div>
		</form>
		<!-- *** -->
		<!--   选择查找,根据回传的值显示end -->


		<!-- show the hotel detail-->
		<table class="table" data-current-page="${page.pageNo}"
			data-total-pages="${page.totalPages }">
			<c:forEach items="${page.results }" var="hotelVO">
				<tr>
					<td>
						<div class="panel panel-info">
							<!-- Default panel contents -->
							<div class="panel-heading">
								<table>
									<tr>
										<td style="width: 10%"><span
											class="glyphicon glyphicon-home"></span>${hotelVO.hotel.hotelName }</td>
										<td style="width: 10%"><span
											class="glyphicon glyphicon-map-marker"></span>${hotelVO.hotel.hotelAddress }</td>
										<td style="width: 10%"><span
											class="glyphicon glyphicon-phone"></span>${hotelVO.hotel.hotelPhone }</td>
										<td style="width: 10%"><span
											class="glyphicon glyphicon-star-empty"></span>${hotelVO.hotel.hotelStar }</td>
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
										<th style="width: 30%">酒店内房型</th>
										<th style="width: 30%">相应床型</th>
										<th style="width: 40%">操作</th>
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
												<button type="button" style="width: 30%"
													class="btn btn-primary  btn-showsingle" name="${room.id }"
													valueOfHotelId="${hotelVO.hotel.providerHotelId}"
													valueOfCityId="${hotelVO.hotel.cityId }"
													value="${room.providerRoomId }">查询房价</button>
												<button type="button" style="width: 30%" data-toggle="modal"
													href="#mybModal" value="${room.providerRoomId }"
													valueOfHotelId="${hotelVO.hotel.providerHotelId}"
													valueOfCityId="${hotelVO.hotel.cityId }"
													class="btn btn-success btn-status">上下架设置</button>
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
<script type="text/javascript" src="${ctx }/jsp/product/js/template.js"></script>
<script type="text/javascript"
	src="${ctx }/js/bootstrap-datetimepicker.min.js"></script>
	<!-- 日期插件汉化 -->
<script type="text/javascript"
	src="${ctx }/js/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- art template模版编写 -->
<script id="show" type="text/html">
<h1>{{title}}</h1>
<ul>
    <li style="text-align:center;width:20%;list-style-type:none;float:left;border:solid 1px;">{{wordTwo}}<br/>{{wordThr}}<br/>{{wordExtra}}<br/>{{wordFour}}<br/>{{wordFive}}<br/>{{wordSix}}<br/>{{wordSev}}<br/></li>
    {{each list as value i}}
         {{if value.salePrice != 0.0}}
        <li  data-toggle="modal" href="#myaModal"     dateValue="{{value.saleDate}}"    class="btn-show"      style="text-align:center;width:20%;list-style-type:none;float:left;border:solid 1px;">  {{value.saleDate}} <br/> {{value.salePrice}} <br/> {{value.showPrice}} <br/> {{value.increaseStatus}} <br/>{{value.increaseType}} <br/>{{value.increaseAmount}} <br/>{{value.saleStatus}} <br/></li>
         {{else}}
        <li style="text-align:center;width:20%;list-style-type:none;float:left;border:solid 1px;">{{value.saleDate}} <br/>{{wordNine}}<br/><br/><br/><br/><br/><br/></li>
         {{/if}}
    {{/each}}
</ul>
</script>

<script id="analysisSaleStatus" type="text/html">

<ul>
    {{each list as value i}}
        <li class="form-control"  style="list-style-type:none;border:solid 1px;">   {{date}}   {{value.saleDate}} {{status}}  {{value.saleStatus}}  </li>
    {{/each}}
</ul>
</script>


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



	$(".btn-status").click(function() {
		var roomId = document.getElementById("roomIDInpForStatus");
		var marketIdForStatus = document.getElementById("marketIdIDInpForStatus");
		var providerIdForStatus = document.getElementById("providerIDInpForStatus");
		var hotelIdForStatus = document.getElementById("hotelIDInpForStatus");
		var cityIdForStatus = document.getElementById("cityIDInpForStatus");
		roomId.setAttribute("value", $(this).val());
		marketIdForStatus.setAttribute("value",$('#marketId').val() );
		providerIdForStatus.setAttribute("value",$('#providerId').val() );
		hotelIdForStatus.setAttribute("value",$(this).attr("valueOfHotelId"));
		cityIdForStatus.setAttribute("value", $(this).attr("valueOfCityId"))
		$.post("findSaleStatus.do",
				{
				    "roomId" : $(this).val(),
				    "marketId" : $('#marketId').val(),
				    "providerId" : $('#providerId').val() 
		        },function(msg){
		        	if(msg!="数据为空"){
		        		var saleStatuslist = eval("(" + msg + ")"); //解析json为一个list
		        			var data = {
		        				date : '销售日期:'	,
		        				status : '销售状态:'	,
								list : saleStatuslist
							};
							var saleStatusHtml = template('analysisSaleStatus',data);
							document.getElementById("showSaleStatus").innerHTML = saleStatusHtml;
		        	}else if(msg=="数据为空"){
		        		document.getElementById("showSaleStatus").innerHTML = '<ul>暂无详细上下架记录</ul>';
		        	}
					});
	});



	var html = "";
	var id = "";
	var hotelId = "";
	var cityId = ""
	/* 查看房价/单个按键显示 */
	$(".btn-showsingle").click(function() {
						id = $(this).val();
						var  marketId = $('#marketId').val();
						var providerId = $('#providerId').val();
					    hotelId = $(this).attr("valueOfHotelId");
						cityId = $(this).attr("valueOfCityId");
						var tbodyId = $(this).attr("name"); //获取name属性的值
						var tr = document.createElement("tr");
						/* 找到当前的tbody，向里面加一行  */
						var tbody = document.getElementById(tbodyId);
						tr.innerHTML = '<td style="width: 100%" colspan="3"><ul><li  style="list-style-type: none;"></li> </ul></td>';
						/* 往li添加id */
						tbody.appendChild(tr);
						var td = tr.getElementsByTagName("td")[0];
						var ul = td.getElementsByTagName("ul")[0];
						var li = ul.getElementsByTagName("li")[0];
						li.setAttribute("id", id);
						if (document.getElementById(id).innerHTML.toString().length != 0) {
							//判断内容是否为0，如果不为0，那就给它加内容
							document.getElementById(id).innerHTML = "";
							var lasttr = tbody.getElementsByTagName("tr")[1]; //删除原先生成的tr
							var secondtr = tbody.getElementsByTagName("tr")[2]; //删除新生成的tr
							tbody.removeChild(lasttr);
							tbody.removeChild(secondtr);
						} else {
							$.post("roomDetail.do",
											{
												"providerRoomId" : $(this)
														.val(),
												"marketId" : marketId,
												"providerId" : providerId,
												"hotelId"   :  $(this).attr("valueOfHotelId"),
												"cityId"   :   $(this).attr("valueOfCityId")
											},
											function(msg) { //按键弹出拿来的原生的数据
												if (msg != null) {
													var lista = eval("(" + msg
															+ ")"); //解析json为一个list
													var data = {
														title : '酒店价格表(两周内,含当日)',
														/* wordOne : '记录编号', */
														wordTwo : '销售日期',
														wordThr : '销售价钱',
														wordExtra : '价格构成',
														wordFour : '是否加幅',
														wordFive : '加幅类型',
														wordSix : '加幅数值',
														wordSev : '销售状态',
														wordNine : '本日不销售',
														list : lista
													};
													html = template('show',data);
													document.getElementById(id).innerHTML = html;
													/* 内部按键的操作 */
													$(".btn-show").click( function() {
																		/* 在点击的同时传数值过去那个模态框 */
																		var roomIDForIncreaseRule = document.getElementById("roomIDInpForIncreaseRule");
																		var saleDateInp = document.getElementById("saleDateInp");
																		var marketIdForIncreaseRule = document.getElementById("marketIdIDInpForIncreaseRule");
																		var providerIdForIncreaseRule = document.getElementById("providerIDInpForIncreaseRule");
																		var hotelIdForIncreaseRule = document.getElementById("hotelIDInpForIncreaseRule");
																		var cityIdForIncreaseRule = document.getElementById("cityIDInpForIncreaseRule");
																		roomIDForIncreaseRule.setAttribute("value",id);
																		saleDateInp.setAttribute("value",$(this).attr("dateValue"));
																		marketIdForIncreaseRule.setAttribute("value",$('#marketId').val());
																		providerIdForIncreaseRule.setAttribute("value",$('#providerId').val());
																		hotelIdForIncreaseRule.setAttribute("value", hotelId);
																		cityIdForIncreaseRule.setAttribute("value", cityId);
																	//异步请求
																		$.post("findDetailIncreaseRule.do",
																				{
																					"roomId" : id,
																				    "marketId" : $('#marketId').val(),
																			     	"providerId" : $('#providerId').val() ,
																	                "saleDate" : $(this).attr("dateValue")	
																				},
																				function(msg){
																					if(msg!="数据为空"){
																						var detailIncreaseRule = eval("(" + msg + ")");
																						console.log(detailIncreaseRule.increaseType);
																					  var   detailIncreaseRuleHtml  =  '<ul>'  + '加幅类型 :' +detailIncreaseRule.increaseType +'&nbsp;'+ '加幅数值：' +detailIncreaseRule.increaseAmount+'</ul>' ;
																						document.getElementById("showDetailIncreaseRule").innerHTML = detailIncreaseRuleHtml;
																					}
																					else if(msg=="数据为空"){
																						document.getElementById("showDetailIncreaseRule").innerHTML = '<ul>暂无详细加幅记录</ul>';
																					}
																		});
													});
												}
											});
						}
					});

	//设置详细加幅返回
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
							$('#myaModal').modal('hide');
							$('#mybModal').modal('hide');
							alert("操作成功");
							var lista = eval("(" + msg + ")"); //解析json为一个list
							var data = {
								title : '酒店价格表(两周内,含当日)',
								/* wordOne : '记录编号', */
								wordTwo : '销售日期',
								wordThr : '销售价钱',
								wordExtra : '价格构成',
								wordFour : '是否加幅',
								wordFive : '加幅类型',
								wordSix : '加幅数值',
								wordSev : '销售状态',
								wordNine : '本日不销售',
								list : lista
							};
							html = template('show', data);
							document.getElementById(id).innerHTML = html;
							/* 内部按键的操作 */
							$(".btn-show").click(function() {
												/* 在点击的同时传数值过去那个模态框 */
												var roomIDForIncreaseRule = document.getElementById("roomIDInpForIncreaseRule");
												var saleDateInp = document.getElementById("saleDateInp");
												var marketIdForIncreaseRule = document.getElementById("marketIdIDInpForIncreaseRule");
												var providerIdForIncreaseRule = document.getElementById("providerIDInpForIncreaseRule");
												var hotelIdForIncreaseRule = document.getElementById("hotelIDInpForIncreaseRule");
												var cityIdForIncreaseRule = document.getElementById("cityIDInpForIncreaseRule");
												roomIDForIncreaseRule.setAttribute("value",id);
												saleDateInp.setAttribute("value",$(this).attr("dateValue"));
												marketIdForIncreaseRule.setAttribute("value",$('#marketId').val());
												providerIdForIncreaseRule.setAttribute("value",$('#providerId').val());
												hotelIdForIncreaseRule.setAttribute("value", hotelId);
												cityIdForIncreaseRule.setAttribute("value", cityId);
												//异步请求
												$.post("findDetailIncreaseRule.do",
														{
															"roomId" : id,
														    "marketId" : $('#marketId').val(),
													     	"providerId" : $('#providerId').val() ,
											                "saleDate" : $(this).attr("dateValue")	
														},
														function(msg){
															if(msg!="数据为空"){
																var detailIncreaseRule = eval("(" + msg + ")");
																console.log(detailIncreaseRule.increaseType);
															  var   detailIncreaseRuleHtml  =  '<ul>'  + '加幅类型 :' +detailIncreaseRule.increaseType +'&nbsp;'+ '加幅数值：' +detailIncreaseRule.increaseAmount+'</ul>' ;
																document.getElementById("showDetailIncreaseRule").innerHTML = detailIncreaseRuleHtml;
															}
															else if(msg=="数据为空"){
																document.getElementById("showDetailIncreaseRule").innerHTML = '<ul>暂无详细加幅记录</ul>';
															}
												});			
							});
						}, 'json');
		}
	}

	//设置上下架状态返回
	function getReturnMsg() {
		var form = $("#statusform");
		var url = form.attr("action");
		var fdata = form.serialize();
	    if ($("#dateStartTime").val() != ""
				&& $("#dateEndTime").val() != ""
				&& new Date($("#dateStartTime").val().replace(/\-/g, "\/")) >= new Date(
						$("#dateEndTime").val().replace(/\-/g, "\/"))) {
			alert("开始日期不能大于或者等于结束日期");
		} else if($("#dateStartTime").val() ==null 
				|| $("#dateEndTime").val() ==null 
				|| $("#dateStartTime").val() =="" 
				|| $("#dateEndTime").val() ==""){
			alert("日期不能为空");
		}
	    
	    
	  /*   开始日期需要大于或者等于today */
	    
	    
		else if($("#dateStartTime").val() != ""
			&& $("#dateEndTime").val() != "")
		{
			$.post(
							url,
							fdata,
							function(msg) {
								$('#myaModal').modal('hide');
								$('#mybModal').modal('hide');
								alert("操作成功");
								var lista = eval("(" + msg + ")"); //解析json为一个list
								var data = {
									title : '酒店价格表(两周内,含当日)',
									/* wordOne : '记录编号', */
									wordTwo : '销售日期',
									wordThr : '销售价钱',
									wordExtra : '价格构成',
									wordFour : '是否加幅',
									wordFive : '加幅类型',
									wordSix : '加幅数值',
									wordSev : '销售状态',
									wordNine : '本日不销售',
									list : lista
								};
								html = template('show', data);
								document.getElementById(id).innerHTML = html;
								/* 内部按键的操作 */
								$(".btn-show").click(
												function() {
													/* 在点击的同时传数值过去那个模态框 */
													var roomIDForIncreaseRule = document.getElementById("roomIDInpForIncreaseRule");
													var saleDateInp = document.getElementById("saleDateInp");
													var marketIdForIncreaseRule = document.getElementById("marketIdIDInpForIncreaseRule");
													var providerIdForIncreaseRule = document.getElementById("providerIDInpForIncreaseRule");
													var hotelIdForIncreaseRule = document.getElementById("hotelIDInpForIncreaseRule");
													var cityIdForIncreaseRule = document.getElementById("cityIDInpForIncreaseRule");
													roomIDForIncreaseRule.setAttribute("value", id);
													saleDateInp.setAttribute("value",$(this).attr("dateValue"));
													marketIdForIncreaseRule.setAttribute("value",$('#marketId').val());
													providerIdForIncreaseRule.setAttribute("value",$('#providerId').val());
													hotelIdForIncreaseRule.setAttribute("value",hotelId);
													cityIdForIncreaseRule.setAttribute("value",cityId);
													//异步请求
													$.post("findDetailIncreaseRule.do",
															{
																"roomId" : id,
															    "marketId" : $('#marketId').val(),
														     	"providerId" : $('#providerId').val() ,
												                "saleDate" : $(this).attr("dateValue")		
															},
															function(msg){
																if(msg!="数据为空"){
																	var detailIncreaseRule = eval("(" + msg + ")");
																	console.log(detailIncreaseRule.increaseType);
																  var   detailIncreaseRuleHtml  =  '<ul>'  + '加幅类型 :' +detailIncreaseRule.increaseType +'&nbsp;'+ '加幅数值：' +detailIncreaseRule.increaseAmount+'</ul>' ;
																	document.getElementById("showDetailIncreaseRule").innerHTML = detailIncreaseRuleHtml;
																}
																else if(msg=="数据为空"){
																	document.getElementById("showDetailIncreaseRule").innerHTML = '<ul>暂无详细加幅记录</ul>';
																}
													});
												});
							}, 'json');
		}
	}
</script>

<script type="text/javascript">
$('.form_time').datetimepicker({
	language : 'zh-CN',
	autoclose : 1,
	format : "yyyy-mm-dd",
	minView : "month",
	maxView : "decade",
	/* 日期选择只能从今天开始 */
	startDate : new Date(),
	todayBtn : 1
});
</script>

</html>