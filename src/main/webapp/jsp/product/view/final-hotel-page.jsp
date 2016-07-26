<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品管理分页测试</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>产品管理</h1>
		<hr />
		<!-- 模态框 -->
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">选择你需要的内容</h4>
					</div>
					<div class="modal-body">
						<form id="priceform" action="setDetailIncreaseRules.do"
							onsubmit="getReturnJson();return false;">
							<div class="col-sm-8">
								<label style="width: 48%" class="col-sm-4 control-label">选择加幅类型:</label>
								<select style="width: 45%" name="increaseType"
									class="form-control col-sm-8">
									<option value="无详细加幅">选择加幅类型</option>
									<option value="差价">差价</option>
									<option value="百分比">百分比</option>
								</select>
							</div>
							<div class="col-sm-4">
								<label style="width: 40%" class="col-sm-3 control-label">数值:</label>
								<input name="increaseAmount" class="form-control col-sm-9"
									style="width: 50%">
							</div>
							<br />
							<div class="col-sm-12">
								<label style="width: 20%" class="col-sm-2 control-label">上下架:</label>
								<select name="status" class="form-control col-sm-10"
									style="width: 30%">
									<option selected="selected" value="上架">上架</option>
									<option value="下架">下架</option>
								</select>
							</div>
							<br /> <input id="inp1" name="roomID" style="display: none">
							<input id="inp2" name="saleDate" style="display: none">
							<button type="submit" class="btn btn-primary" style="width: 30%">提交</button>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!--   根据回传的值显示 -->
		<!-- **** -->
		<form id="search-form" method="post" class="form-horizontal row"
			action="${ctx }/product/hotels.do">
			<div class="form-group col-sm-3">
				<label for="city" class="col-sm-2 control-label">City</label>
				<div class="col-sm-10">
					<select class="form-control" id="city" name="city">
						<option value="">全部城市</option>
						<c:forEach items="${citys }" var="city">
							<option value="${city.id }"
								<c:if test="${city.id==searchDetail.city  }">selected</c:if>>${city.cityName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group col-sm-3">
				<label for="hotelName" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="hotelName"
						name="hotelName" placeholder="输入酒店名查询"
						value="${searchDetail.hotelName }">
				</div>
			</div>

			<div class="form-group col-sm-3">
				<label for="star" class="col-sm-2 control-label">Star</label>
				<div class="col-sm-10">
					<select class="form-control" id="star" name="star">
						<option value="">全部星级</option>
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
			<div class="form-group col-sm-3">
				<button style="width: 50%" class="btn btn-success" type="submit">查找</button>
			</div>
		</form>
		<!-- *** -->
		<!-- show the hotel detail-->
		<table class="table" data-current-page="${page.pageNo}"
			data-total-pages="${page.totalPages }">
			<c:forEach items="${page.results }" var="hotelVO">
				<tr>
					<td>
						<div class="panel panel-primary">
							<!-- Default panel contents -->
							<div class="panel-heading">${hotelVO.hotel.hotelName }</div>
							<div class="panel-body">
								<table>
									<tr>
										<td style="width: 10%">${hotelVO.hotel.hotelAddress }</td>
										<td style="width: 10%">${hotelVO.hotel.hotelPhone }</td>
										<td style="width: 10%">${hotelVO.hotel.hotelStar }</td>

										<!--   四个单元格 -->
										<!-- <td style="width: 10%"></td> -->
									</tr>
									<!-- 第一行 -->
								</table>
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
									<!-- <tr>
										<th style="width: 100%" colspan="3"></th>
										合并单元格
									</tr> -->
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
												<button id="" type="button" style="width: 30%"
													class="btn btn-success  btn-showsingle" name="${room.id }"
													value="${room.providerRoomId }">查询房价</button>
												<select class="btn btn-success  btn-forRoomId "  name="roomStatus"  valueForRoomId="${room.providerRoomId}">
												<option    value="" >该房型上下架</option>
												<option     value="全部上架">全部上架</option>
												<option  class="btn-danger"   value="全部下架">全部下架</option>
												</select>	
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

	<ul id="example"></ul>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script src="${ctx }/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript" src="${ctx }/jsp/product/js/template.js"></script>
<!-- art template模版编写 -->
<script id="show" type="text/html">
<h1>{{title}}</h1>
<ul>
    <li style="text-align:center;width:20%;list-style-type:none;float:left;border:solid 1px;">{{wordOne}}<br/>{{wordTwo}}<br/>{{wordThr}}<br/>{{wordExtra}}<br/>{{wordFour}}<br/>{{wordFive}}<br/>{{wordSix}}<br/>{{wordSev}}<br/></li>
    {{each list as value i}}
        <li   data-toggle="modal" href="#myModal"  name="{{value.saleDate}}"    class="btn-show"   style="text-align:center;width:20%;list-style-type:none;float:left;border:solid 1px;"> {{value.recordNO}} <br/>  {{value.saleDate}} <br/> {{value.salePrice}} <br/> {{value.showPrice}} <br/> {{value.increaseStatus}} <br/>{{value.increaseType}} <br/>{{value.increaseAmount}} <br/>{{value.saleStatus}} <br/>  </li>
    {{/each}}
</ul>
</script>

<script type='text/javascript'>
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

	
	//单个房型全部上下架实现
	/* .btn-forRoomId */
	$(".btn-forRoomId").change(function() {
		$.post("allSaleStatus.do", {
			"roomStatus" : $(this).val(),
			"roomId" :   $(this).attr("valueForRoomId")   
		//把参数传过去
		}, function(msg) {
			var lista = eval("(" + msg + ")"); //解析json为一个list
			var data = {
				title : '酒店价格表(两周内,含当日)',
				wordOne : '记录编号',
				wordTwo : '销售日期',
				wordThr : '销售价钱',
				wordExtra : '价格构成',
				wordFour : '是否加幅',
				wordFive : '加幅类型',
				wordSix : '加幅数值',
				wordSev : '销售状态',
				list : lista
			};
			html = template('show', data);
			document.getElementById(id).innerHTML = html;
			/* 内部按键的操作 */
			$(".btn-show").click(function() {
				/* 在点击的同时传数值过去那个模态框 */
				var input1 = document.getElementById("inp1");
				var input2 = document.getElementById("inp2");
				input1.setAttribute("value", id);
				input2.setAttribute("value", $(this).attr("name")); //记录数
			});
		});
	});

	var html = "";
	var id = "";
	/* 单个按键显示 */
	$(".btn-showsingle")
			.click(
					function() {
						id = $(this).val();
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
							$
									.post(
											"roomDetail.do",
											{
												"providerRoomId" : $(this)
														.val()
											},
											function(msg) { //按键弹出拿来的原生的数据
												if (msg != null) {
													var lista = eval("(" + msg
															+ ")"); //解析json为一个list
													var data = {
														title : '酒店价格表(两周内,含当日)',
														wordOne : '记录编号',
														wordTwo : '销售日期',
														wordThr : '销售价钱',
														wordExtra : '价格构成',
														wordFour : '是否加幅',
														wordFive : '加幅类型',
														wordSix : '加幅数值',
														wordSev : '销售状态',
														list : lista
													};
													html = template('show',
															data);
													document.getElementById(id).innerHTML = html;
													/* 内部按键的操作 */
													$(".btn-show")
															.click(
																	function() {
																		/* 在点击的同时传数值过去那个模态框 */
																		var input1 = document
																				.getElementById("inp1");
																		var input2 = document
																				.getElementById("inp2");
																		input1
																				.setAttribute(
																						"value",
																						id);
																		input2
																				.setAttribute(
																						"value",
																						$(
																								this)
																								.attr(
																										"name")); //记录数
																	});
												}
											});
						}
					});

	function getReturnJson() {
		var form = $("#priceform");
		var url = form.attr("action");
		var fdata = form.serialize();
		$.post(url, fdata, function(msg) {
			//$('#myModal').modal('hide');
			var lista = eval("(" + msg + ")"); //解析json为一个list
			var data = {
				title : '酒店价格表(两周内,含当日)',
				wordOne : '记录编号',
				wordTwo : '销售日期',
				wordThr : '销售价钱',
				wordExtra : '价格构成',
				wordFour : '是否加幅',
				wordFive : '加幅类型',
				wordSix : '加幅数值',
				wordSev : '销售状态',
				list : lista
			};
			html = template('show', data);
			document.getElementById(id).innerHTML = html;
			/* 内部按键的操作 */
			$(".btn-show").click(function() {
				/* 在点击的同时传数值过去那个模态框 */
				var input1 = document.getElementById("inp1");
				var input2 = document.getElementById("inp2");
				input1.setAttribute("value", id);
				input2.setAttribute("value", $(this).attr("name")); //记录数
			});
		}, 'json');
	}
</script>


</html>