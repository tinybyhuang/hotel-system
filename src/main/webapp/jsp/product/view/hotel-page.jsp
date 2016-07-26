<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品管理分页测试</title>
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/jsp/product/css/clean.css">
</head>
<body>
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>产品管理</h1>
		<hr />
		<!-- **** -->
		<form id="search-form" method="post" class="form-horizontal row"
			action="${ctx }/product/hotels.do">
			<div class="form-group col-sm-3">
				<label for="city" class="col-sm-2 control-label">City</label>
				<div class="col-sm-10">
					<select class="form-control" id="city" name="city">
						<option value="">选择城市</option>

						<c:forEach items="${citys }" var="city">
							<option value="${city.id }">${city.cityName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group col-sm-3">
				<label for="hotelName" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="hotelName"
						name="hotelName" placeholder="输入酒店名查询">
				</div>
			</div>
			<div class="form-group col-sm-3">
				<label for="star" class="col-sm-2 control-label">Star</label>
				<div class="col-sm-10">
					<select class="form-control" id="star" name="star">
						<option value="">选择星级</option>
						<option value="1星级">One</option>
						<option value="2星级">Two</option>
						<option value="3星级">Three</option>
						<option value="4星级">Four</option>
						<option value="5星级">Fifth</option>
					</select>
				</div>
			</div>
			<div class="form-group col-sm-3">
				<button class="btn btn-success" type="submit" style="width: 45%">查询</button>
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
										<td style="width: 10%">
											<%-- <button id="btn-price" type="button"
												class="btn btn-success btn-showall"
												value="${hotelVO.hotel.providerHotelId }">显示全部房型房价</button> --%>
											<button style="width: 80%" id="btn-sale" type="button"
												class="btn btn-success btn-js">酒店上下架</button>
										</td>
									</tr>
								</table>
							</div>
							<!-- Table,show the room detail -->
							<table id="pricetable" class="table">
								<thead>
									<tr>
										<!-- 第一行 -->
										<td>
											<ul>
												<li class="col-md-12" style="list-style-type: none;">
													<div class="col-md-4" style="font-weight: bold">酒店内房型</div>
													<div class="col-md-4" style="font-weight: bold">相应床型</div>
													<div class="col-md-4" style="font-weight: bold">操作</div>
												</li>
											</ul>
										</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${hotelVO.rooms }" var="room">
										<tr id="Fathertr">
											<!-- 第二行 -->
											<td>
												<ul id="Brotherul">
													<li class="col-md-12" style="list-style-type: none;">
														<div class="col-md-4">${room.roomName }</div>
														<div class="col-md-4">
															<c:if test="${room.roomBedType =='1'}">单人床</c:if>
															<c:if test="${room.roomBedType =='2'}">双床</c:if>
															<c:if test="${room.roomBedType =='3'}">大床</c:if>
															<c:if test="${room.roomBedType =='4'}">园床</c:if>
															<c:if test="${room.roomBedType =='5'}">大/双床</c:if>
															<c:if test="${room.roomBedType =='6'}">三人床</c:if>
														</div>
														<div class="col-md-4">
															<button id="btn-price" type="button"
																class="  btn btn-success btn-showsingle"
																value="${room.providerRoomId }">显示该房型两周内房价</button>
															<button id="btn-sale" type="button"
																class="   btn btn-success btn-js">该房型上下架</button>
														</div>
													</li>
													<li id="${room.providerRoomId}"
														value="${ room.providerRoomId}" class="col-md-12"
														style="list-style-type: none; width: 100%;"></li>
												</ul>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- Table,show the room detail -->
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
<script src="${ctx }/jsp/product/js/jquery.columns.min.js"></script>
<script type="text/javascript" src="${ctx }/jsp/product/js/template.js"></script>

<!-- art template模版编写 -->
<script id="show" type="text/html">
<h1>{{title}}</h1>
<ul>
    <li style="text-align:center;width:20%;list-style-type:none;float:left;border:solid 1px;">{{Fword}}<br/>{{Sword}}<br/>{{Tword}}<br/></li>
    {{each list as value i}}
        <li style="text-align:center;width:20%;list-style-type:none;float:left;border:solid 1px;"> {{value.recordNO}} <br/>  {{value.saleDate}} <br/> {{value.salePrice}} <br/> </li>
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
				f.action = f.action + '?pageNo=' + page;
				f.submit();
			}
		}
		$('#example').bootstrapPaginator(options)
		$('#bp-example-size-alignment').bootstrapPaginator("showFirst");
		$('#bp-example-size-alignment').bootstrapPaginator("showPrevious");
		$('#bp-example-size-alignment').bootstrapPaginator("showNext");
		$('#bp-example-size-alignment').bootstrapPaginator("showLast");
	});

	/* 显示全部房价按键 */
	$(".btn-showall").click(function() {
		$.post("allRoomDetail.do", {
			"providerHotelId" : $(this).val()
		}, function(msg) {
			if (msg != null) {
				$.each(eval("(" + msg + ")"), function(index, item) { //遍历返回的json
					//alert(item.roomName);
				});
				alert(msg);
			}
		});
		alert($(this).val()); //弹出值
	});

	/* 单个按键显示 */
	$(".btn-showsingle").click(function() {
		var id = $(this).val();
		var html = "";
		alert(document.getElementById(id).innerHTML.toString().length);
		if (document.getElementById(id).innerHTML.toString().length != 0) {
			//判断内容是否为0，如果不为0，那就给它加内容

			document.getElementById(id).innerHTML = "";
		} else {
			$.post("roomDetail.do", {
				"providerRoomId" : $(this).val()
			}, function(msg) {
				if (msg != null) {
					var lista = eval("(" + msg + ")"); //解析json为一个list
					var data = {
						title : '酒店价格表(两周内)',
						Fword : '记录编号',
						Sword : '销售日期',
						Tword : '销售价钱',
						list : lista
					};
					html = template('show', data);

					document.getElementById(id).innerHTML = html;
				}
			});
		}
	});

	/* 弹出一个table显示回传的json */
	function showTable(msg) {
		$(".tableShow").empty();
		$(".tableShow").append('<th  id="columns"></th>');
		var list = eval("(" + msg + ")");
		$('#columns').columns({
			data : list
		});
	}
</script>






</html>