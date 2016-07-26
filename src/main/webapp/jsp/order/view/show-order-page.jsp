<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
<!-- bootstrp-css表载入    contextPath = ctx -->
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>
	<!-- 导航条 -->
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<!--   订单的操作 -->
	<!--  a order show here -->
	<!-- order -->


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
					<h4 class="modal-title" id="myModalLabel">日期与房间数量</h4>
				</div>
				<div class="modal-body">
					<div id="showRoomPriceData"></div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态框 -->






	<div class="container">
		<div class="col-sm-12">
			<div class="col-sm-10">
				<div style="font-size: 40px">订单管理</div>
			</div>
			<div class="col-sm-2">
				<div style="font-size: 20px; align: bottom; margin-top: 25px">
					<a href="${ctx }/userConfig/showProviderUserConfig.do">用户配置</a>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<hr>
		</div>

		<!--  按条件查找表单数据 -->
		<form action="${ctx }/order/manageOrder.do" method="post"
			id="searchForm" class="form-horizontal row">
			<div class="col-sm-12">
				<!-- 平台 -->
				<div class="col-sm-3">
					<label for="marketId" class="col-sm-3 control-label">平台</label>
					<div class="col-sm-9">
						<select class="form-control" name="marketId" id="marketId">
							<c:forEach items="${marketIdList}" var="market">
								<option value="${market}"
									<c:if test="${market==search.marketId}">selected</c:if>>
									<c:if test="${market=='1'}">携程</c:if>
									<c:if test="${market=='2'}">去哪儿</c:if>
									<c:if test="${market=='3'}">淘宝</c:if>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<!-- 酒店名 -->
				<div class="col-sm-3">
					<label for="marketId" class="col-sm-4 control-label">酒店名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="hotelName"
							name="hotelName" placeholder="输入酒店名查询"
							value="${search.hotelName}">
					</div>
				</div>
				<!-- 房型名 -->
				<div class="col-sm-3">
					<label for="marketId" class="col-sm-4 control-label">房型名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="roomName"
							name="roomName" placeholder="输入房型名查询" value="${search.roomName}">
					</div>
				</div>
				<div class="col-sm-3">
					<button style="width: 100%" class="btn btn-primary" type="submit">查找</button>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="col-sm-3">
					<label for="providerId" class="col-sm-4 control-label">供应商</label>
					<div class="col-sm-8">
						<select class="form-control" name="providerId" id="providerId">
							<option value="1"
								<c:if test="${search.providerId=='1'}">selected</c:if>>携旅</option>
							<option value="2"
								<c:if test="${search.providerId=='2'}">selected</c:if>>龙腾</option>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<label for="marketStatus" class="col-sm-4 control-label">平台订单状态</label>
					<div class="col-sm-8">
						<select class="form-control" name="marketStatus" id="marketStatus">
							<option value="">全部订单</option>
							<option value="待安排房间"
								<c:if test="${search.marketStatus=='待安排房间'}">selected</c:if>>待安排房间</option>
							<option value="待付款"
								<c:if test="${search.marketStatus=='待付款'}">selected</c:if>>待付款</option>
							<option value="新单"
								<c:if test="${search.marketStatus=='新单'}">selected</c:if>>新单</option>
							<option value="确认"
								<c:if test="${search.marketStatus=='确认'}">selected</c:if>>确认</option>
							<option value="取消"
								<c:if test="${search.marketStatus=='取消'}">selected</c:if>>取消</option>
						</select>
					</div>
				</div>
			</div>
		</form>

		<table class="table" data-current-page="${orderList.pageNo }"
			data-total-pages="${orderList.totalPages }">
			<c:forEach items="${orderList.results }" var="order">
				<tr>
					<td>
						<div class="panel panel-success">
							<div class="panel-heading col-sm-12">
								<div class="col-sm-3">
									<h4>订单号:${order.marketOrderNo }</h4>
								</div>
								<div class="col-sm-3">
									<h4>酒店名:${order.hotelName }</h4>
								</div>
								<div class="col-sm-3">
									<h4>订单状态(平台):${order.marketStatus}</h4>
								</div>
								<div class="col-sm-3">
									<button class="btn btn-primary btn-findRoomPrice "
										data-toggle="modal" value="${order.roomId}"
										beginDateValue="${order.beginDate}"
										endDateValue="${order.endDate}" href="#myModal"
										style="width: 70%">查看房量</button>
								</div>
							</div>
							<div class="panel-body ">
								<table class="table ">

									<tr>
										<td>房型名:${order.roomName }</td>
										<td>预定人:${order.bookUser}</td>
										<td>预定数量:${order.bookAmout}</td>
										<td><c:choose>
												<%-- <c:when test="${fn:contains(completeOrderIdList, order.id)}"> --%>
												<c:when test="${order.providerStatus=='确认' }">
													<button class="btn btn-primary btn-arrangeRoom"
														style="width: 100%" orderMarketId="${order.marketId}"
														marketOrderNo="${order.marketOrderNo}">安排房间</button>
												</c:when>

												<c:otherwise>
													<button class="btn btn-success btn-bookingOrder"
														style="width: 100%" orderRoomId="${order.roomId}"
														orderProviderId="${order.providerId}"
														orderHotelId="${order.hotelId }"
														orderBookUser="${order.bookUser}"
														orderBookAmount="${order.bookAmout}"
														orderBookPhone="${order.bookPhone}"
														orderBeginDate="${order.beginDate}"
														orderEndDate="${order.endDate}" orderDays="${order.days}"
														orderRemark="${order.state}" orderId="${order.id}">下单
													</button>
												</c:otherwise>
											</c:choose></td>
									</tr>
									<tr>
										<td>入住时间:<fmt:formatDate value="${order.beginDate}"
												pattern="yyyy-MM-dd" /></td>
										<td>离店时间:<fmt:formatDate value="${order.endDate}"
												pattern="yyyy-MM-dd" /></td>
										<td>平台支付金额:${order.marketAmount}</td>
										<td><button class="btn btn-warning btn-cancel"
												style="width: 100%" value="${order.marketOrderNo }"
												providerId="${order.providerId }"
												marketId="${order.marketId }">取消订单</button></td>
									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 分页插件 -->
	<ul id="example" style="margin-left: 10%"></ul>

</body>
<!-- 导入 jquery.js bootstrp.js -->
<jsp:include page="/common/footer.jsp"></jsp:include>
<!-- 导入 分页js文件 -->
<script src="${ctx }/js/bootstrap-paginator.min.js"></script>
<script src="${ctx }/jsp/product/js/template.js"></script>
<script type="text/html" id="analysisRoomPriceData">
<ul>
    {{each list as value}}
     <li class="form-control" style="list-style-type:none">
{{wordOne}}   {{value.saleDate}}    {{wordTwo}}     {{wordThree}}    {{value.roomAmount}}

     </li>
    {{/each}}
</ul>
</script>
<script type='text/javascript'>
	$(function() {
		var options = {
			currentPage : $(".table").data("current-page"), //获取.table class修饰的表格获取current-page  total-pages数据 
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
				//跳转到一个条件寻找的controller里面
				var f = document.getElementById("searchForm");
				f.action = f.action + '?pageNo=' + page; /* //结合表单的提交请求一起 */
				f.submit();
				/* location.href = ctx + '/order/manageOrder.do?pageNo=' + page; */
				/* href只能发get请求 */
				/* 此处可能会用$.post()   ajax请求访问后台 */
			}
		}
		$('#example').bootstrapPaginator(options)
		$('#bp-example-size-alignment').bootstrapPaginator("showFirst");
		$('#bp-example-size-alignment').bootstrapPaginator("showPrevious");
		$('#bp-example-size-alignment').bootstrapPaginator("showNext");
		$('#bp-example-size-alignment').bootstrapPaginator("showLast");
	});

	$(".btn-findRoomPrice").click(function() {
		var roomId = $(this).val();
		var beginDate = $(this).attr("beginDateValue");
		var endDate = $(this).attr("endDateValue");
		$.post("findRoomPrice.do", {
			"roomId" : roomId,
			"beginDate" : beginDate,
			"endDate" : endDate
		}, function(msg) {
			if (msg != null) {
				var list = eval("(" + msg + ")");
				var data = {
					wordOne : '销售日期:',
					wordTwo : '',
					wordThree : '当日房间数量:',
					list : list
				}
				var html = template("analysisRoomPriceData", data);
				document.getElementById("showRoomPriceData").innerHTML = html;
			}
		})
	})

	//判断是否有已经下单的订单，有就背景色改变为 success
	//判断是否能下单，如果不能把原因写在旁边

	$(".btn-bookingOrder").click(function() {
		var page = $(".table").data("current-page");
		$.post("bookingOrder.do", {
			"hotelId" : $(this).attr("orderHotelId"),
			"roomId" : $(this).attr("orderRoomId"),
			"providerId" : $(this).attr("orderProviderId"),
			"bookUser" : $(this).attr("orderBookUser"),
			"bookAmount" : $(this).attr("orderBookAmount"),
			"bookPhone" : $(this).attr("orderBookPhone"),
			"beginDate" : $(this).attr("orderBeginDate"),
			"endDate" : $(this).attr("orderEndDate"),
			"days" : $(this).attr("orderDays"),
			"remark" : $(this).attr("orderRemark"),
			"orderId" : $(this).attr("orderId")
		}, function(msg) {
			if (msg == "下单成功") {
				alert(msg);
				window.location.reload()
			} else {
				alert(msg + ",下单失败");
				console.log(msg);
			}
		})
	});

	$(".btn-cancel").click(function() {
		var providerId = $(this).attr("providerId");
		var marketId = $(this).attr("marketId");
		var marketOrderNo = $(this).val();
		$.post("cancelmmOrder.do", {
			"providerId" : providerId,
			"marketId" : marketId,
			"marketOrderNo" : marketOrderNo
		}, function(msg) {
			console.log(msg);
			alert(msg);
		});
	});

	$(".btn-arrangeRoom").click(function() {
		$.post("arrangeRoom.do", {
			"marketId" : $(this).attr("orderMarketId"),
			"OrderNo" : $(this).attr("marketOrderNo")
		}, function(msg) {
			if (msg == "已确认订单") {
				alert(msg);
			} else {
				alert(msg + ",发送失败");
				console.log(msg);
			}
		})
	})
</script>
</html>