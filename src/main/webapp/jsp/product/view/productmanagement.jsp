<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平台主页</title>
<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx }/css/bootstrap.min.css">

</head>
<body>
	<!-- pagehead -->
	<jsp:include page="/common/navbar.jsp"></jsp:include>
	<!-- pagecontent -->
	<div class="container">

		<h1>分销管理</h1>
		<hr />

		<div id="showprovider ">

			<table class="table  table-striped  table-condensed">
				<thead>
					<tr>
						<th style="width: 30%">#</th>
						<th style="width: 30%">平台</th>
						<th style="width: 30%">操作</th>
						<th style="width: 30%"><a href="${ctx}/sale/hotelRecords.do">
						<button type="button" class="btn btn-primary">加幅设置</button></a></th>
					</tr>
				</thead>


				<tbody>
					<tr>
						<td>1</td>
						<td><img alt="去哪儿" style="height: 20px"
							src="${ctx }/jsp/product/images/qunaer.png">去哪儿</td>
						<td><a class="btn btn-success"
							href="${ctx}/product/hotels.do">设置</a>
							<button type="button" class="btn btn-info">开/关店</button></td>
					<td></td>
					</tr>
					<tr>
						<td>2</td>
						<td><img alt="携程" style="height: 20px"
							src="${ctx }/jsp/product/images/xiecheng.jpg">携程</td>
						<td><button type="button" class="btn btn-primary">设置</button>
							<button type="button" class="btn btn-info">开/关店</button></td>
							<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td><img alt="阿里旅行" style="height: 20px; width: 20"
							src="${ctx }/jsp/product/images/alilvxing.png">阿里旅游</td>
						<td><button type="button" class="btn btn-primary">设置</button>
							<button type="button" class="btn btn-info">开/关店</button></td>
					<td></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
	<!-- container -->
</body>
</html>