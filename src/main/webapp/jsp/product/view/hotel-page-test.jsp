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
		<!-- **** -->
		<form id="search-form" method="post" class="form-horizontal row"
			action="${ctx }/product/hotels.do">
			<div class="form-group col-sm-3">
				<label for="city" class="col-sm-2 control-label">City</label>
				<div class="col-sm-10">
					<select class="form-control" id="city" name="city">
						<option value="">选择</option>
						<c:forEach items="${citys }" var="city">
							<option value="${city.id }">${city.cityName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group col-sm-3">
				<label for="city" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="hotelName"
						name="hotelName" placeholder="HotelName">
				</div>
			</div>
			<div class="form-group col-sm-3">
				<label for="city" class="col-sm-2 control-label">Star</label>
				<div class="col-sm-10">
					<select class="form-control" id="star" name="star">
						<option value="">选择</option>
						<option value="1星级">One</option>
						<option value="2星级">Two</option>
						<option value="3星级">Three</option>
						<option value="4星级">Four</option>
						<option value="5星级">Fifth</option>
					</select>
				</div>
			</div>
			<div class="form-group col-sm-3">
				<button class="btn btn-success" type="submit">Search</button>
			</div>
		</form>
		<!-- *** -->
		<!-- show the hotel detail-->
		<table class="table" data-current-page="${page.pageNo}"
			data-total-pages="${page.totalPages }">
			<tr>
				<!-- <th>主键</th> -->
				<!-- <th>酒店名</th> -->
			</tr>
			<c:forEach items="${page.results }" var="hotelVO">
				<tr>
					<td>
						<div class="panel panel-primary">
							<!-- Default panel contents -->
							<div class="panel-heading">
								<%-- <div class="ss">${hotelVO.hotel.providerHotelId }</div> --%>${hotelVO.hotel.hotelName }</div>
							<div class="panel-body">
								<table>
									<tr>
										<td style="width: 10%">${hotelVO.hotel.hotelAddress }</td>
										<td style="width: 10%">${hotelVO.hotel.hotelPhone }</td>
										<td style="width: 10%">${hotelVO.hotel.hotelStar }</td>
										<td style="width: 10%">
											<%-- <form action="roomDetail.do" method="post">
												<div class="hide">
													<input name="providerHotelId" value="${hotel.providerHotelId }" />
												</div>
												<button id="btn-price	" type="submit"
													class="btn btn-success ">显示一周内房价</button>
											</form> --%> <!-- onclick="javasript:window.open('')" -->
											<button id="btn-price" type="button" class="btn btn-success "
												value="${hotelVO.hotel.providerHotelId }">显示一周内房价</button>
											<button id="btn-sale" type="button" class="btn btn-success ">上下架</button>
										</td>
										<!-- <td style="width: 10%"></td> -->
									</tr>
								</table>
							</div>

							<!-- Table,show the room detail -->

							<table id="pricetable" class="table ">
								<thead>
									<tr>
										<th>酒店内房型</th>
										<th>相应床型</th>
										<th></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${hotelVO.rooms }" var="room">
										<tr>
											<td>${room.roomName }</td>


											<td><c:if test="${room.roomBedType =='1'}">单人床</c:if> <c:if
													test="${room.roomBedType =='2'}">双床</c:if> <c:if
													test="${room.roomBedType =='3'}">大床</c:if> <c:if
													test="${room.roomBedType =='4'}">园床</c:if> <c:if
													test="${room.roomBedType =='5'}">大/双床</c:if> <c:if
													test="${room.roomBedType =='6'}">三人床</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- 两周酒店价格 -->
							<div>
								<h1>两周酒店价格</h1>
								<table class="table">

									<tbody>


										<c:forEach items="${hotelVO.roomPriceMap }" var="roomPrice">
											<tr>
												<td style="width: 10%">${roomPrice.key.roomName}</td>

												<c:forEach items="${roomPrice.value}" var="salePrice">
													<td style="width: 90%"><fmt:formatDate
															value="${salePrice.saleDate}" pattern="yyyy-MM-dd" /></td>
												</c:forEach>
												<%-- <fmt:formatDate value=" ${salePrice.saleDate}" pattern="yyyy-MM-dd"/> --%>
											</tr>

											<tr>
												<td style="width: 10%"></td>

												<c:forEach items="${roomPrice.value}" var="salePrice">
													<td style="width: 90%">￥${salePrice.salePrice}</td>
												</c:forEach>
											</tr>


										</c:forEach>


									</tbody>



								</table>
							</div>


						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<!-- 按钮触发模态框 -->
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
					</div>
					<div class="modal-body">
						<table>
							<!-- 酒店价格表 -->
							<tr>
								<th>aaa</th>
							</tr>
							<tr>
								<td>${hotelVO.hotel.providerHotelId }</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary">提交更改</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

	</div>



	<!-- <div id="example"></div> -->
	<ul id="example"></ul>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script src="${ctx }/js/bootstrap-paginator.min.js"></script>
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

	$(document).ready(function() {

		$(".hide").hide();

	})

	$(".btn").click(function() {

		$.post("roomDetail.do", {
			"providerHotelId" : $(this).val()
		}, function(msg) {

			  if (msg != null) {
                  $.each(eval("(" + msg + ")"), function (index, item) { //遍历返回的json
                	  alert( item.roomName);
                  });

			alert(msg);
			  }
		});
		
		alert($(this).val()); //弹出值

	});

	/* $(".btn").click(function() {
		var hotelId = 2083684;
		$.post("roomDetail.do", {
			"providerHotelId" : hotelId
		}, function(msg) {
			alert('${rooms}');
		});
	}); */

	/* 	$.confrim({
	 title: 'Confirm!',
	 content: 'Confirm! Confirm! Confirm!',
	 confirm: function(){
	 //alert('the user clicked confirm');
	 },
	 cancel: function(){
	 alert('the user clicked cancel')
	 }
	 });
	 */
</script>

<!-- art template例子 -->
<script id="test" type="text/html">
<h1>{{title}}</h1>
<ul>
    {{each list as value i}}
        <li style="list-style-type:none;"> {{i + 1}} ：{{value}}</li>
    {{/each}}
</ul>
</script>
<script type="text/javascript">
	var data = {
		title : '酒店价格表',
		list : [ '文艺', '博客', '摄影', '电影', '民谣', '旅行', '吉他' ]
	};
	var html = template('test', data);
	alert(html);
	document.getElementById("content").innerHTML = html;
</script>

<script id="table" type="text/html">
<h1>{{title}}</h1>
     
    {{each list as value i}}
   <<td style="width:30%">{{value.recordNO}} <br/>  {{value.saleDate}} <br/> {{value.salePrice}}</td>
    {{/each}}

</script>
<script type="text/javascript">
/* var ul =	document.getElementById('Brotherul');
				var 	li  = document.createElement("li");
				  li.setAttribute("id", id);
				  li.setAttribute("class", "col-md-12");
				  li.setAttribute("style", "list-style-type: none; width: 100%;border:solid red 1px");
				  ul.appendChild(li); */
				  </script>
<script>
var flag = 0;
	var btn = 0;
	/* 单个按键显示 */
	$(".btn-showsingle").click(function() {
		var id = $(this).val();
		var html = "";
		alert(document.getElementById(id).innerHTML.toString().length);
		//alert(btn);
		if (id != btn) {
			flag = 0;
			btn = 0;
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
					flag++;
					if (flag == 0) {
						document.getElementById(id).innerHTML = "";
					} else if (flag == 1) {
						document.getElementById(id).innerHTML = html;
						btn = id;
						//alert(btn);
					} else if (flag == 2) {
						document.getElementById(id).innerHTML = "";
						flag = 0;
					}

				}
			});
		} else if(id==btn){

			//alert(btn);
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
					flag++;
					
					
					
					if( document.getElementById(id).innerHTML.toString().length!=0)
					alert(ss.length);
					if (flag == 0) {
						document.getElementById(id).innerHTML = "";
					} else if (flag == 1) {
						document.getElementById(id).innerHTML = html;
						btn = id;
					} else if (flag == 2) {
						document.getElementById(id).innerHTML = "";
						flag = 0;
					}

				}
			});
		}
	});

</script>

</html>