<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品管理-设置-携程</title>
<jsp:include page="/common/head.jsp"></jsp:include>
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- pagehead -->
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<!-- pagecontent -->
	<div class="container">
		<h1>酒店数据总览</h1>
		<hr />

		<div id="showdata">

			<table class="table  table-striped  table-condensed">
				<thead>
					<tr>
						<th style="width: 2%">id</th>
						<th style="width: 9%">供应商名称</th>
						<th style="width: 3%">酒店id</th>
						<th style="width: 5%">城市</th>
						<th style="width: 12%">酒店名称</th>
						<th style="width: 6%">酒店电话</th>
						<th style="width: 12%">酒店地址</th>
						<th style="width: 7%">酒店主页</th>
						<th style="width: 7%">酒店经度</th>
						<th style="width: 7%">酒店纬度</th>
						<th style="width: 7%">酒店介绍</th>
						<th style="width: 7%">酒店星级</th>
						<th style="width: 16%">载入时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.id}</td>
							<td><c:if test="${item.providerId=='1'}">携程</c:if>
								<c:if test="${item.providerId=='2'}">去哪儿</c:if></td>
							<td>${item.providerHotelId}</td>
							<td><c:if test="${item.cityId=='1'}">北京</c:if></td>
							<td>${item.hotelName}</td>
							<td>${item.hotelPhone}</td>
							<td title="${item.hotelAddress}">${item.hotelAddress}</td>
							<td>${item.hotelWebsite}</td>
							<td>${item.hotelLongitude}</td>
							<td>${item.hotelLatitude}</td>
							<td>${item.hotelIntroduction}</td>
							<td title="${item.hotelIntroduction}">${item.hotelIntroduction}</td>
							<td>${item.hotelStar}</td>
							<td>${item.created}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="list"></div>

		<div class="col-sm-6">
			<div id="paginator"></div>
		</div>
		<br />
		<div class="col-sm-6">
			每页显示<input placeholder="15" style="width: 30" />条数据
		</div>
	</div>
	<!-- container -->
</body>
<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${ctx }/js/bootstrap-paginator.min.js"></script>

<script type="text/javascript">
	$(function() {
		var options = {
			currentPage : "${currentPage}",//当前页
			totalPages : "${totalPage}",//总页数
			numberofPages : 5,//显示的页数
			itemTexts : function(type, page, current) { //修改显示文字
				switch (type) {
				case "first":
					return "第一页";
				case "prev":
					return "上一页";
				case "next":
					return "下一页";
				case "last":
					return "最后一页";
				case "page":
					return page;
				}
			},
			onPageClicked : function(event, originalEvent, type, page) { //异步换页
				window.location.href = ctx + '/showPartOfHotel.do?page=' + page;
			}
		};
		$("#paginator").bootstrapPaginator(options);
	});
</script>



</html>