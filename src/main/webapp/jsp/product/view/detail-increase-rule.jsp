<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细加幅览表</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>
	<h1>详细加幅</h1>
	<table class="table" data-current-page="${page.pageNo}"
		data-total-pages="${page.totalPages }">
		<tr>
			<th style="width: 10%">记录编码</th>
			<th style="width: 10%">增幅类型</th>
			<th style="width: 10%">增幅数值</th>
			<th style="width: 10%">操作</th>
		</tr>
		<c:forEach items="${detailIncreaseRule.results}" var="detailir">
			<tr>
				<td>${detailir.id}</td>
				<td>${detailir.increaseType}</td>
				<td>

					<form action="" method="post">

						<input style="width: 20%" class=" col-md-5  form-control"
							placeholder="${detailir.increaseAmount}" /><span class=" col-md-1"></span><input type="submit"
							class=" col-md-6  btn btn-success" value="输入数值更改">
					</form>
				</td>
				<td>
				<button  class="btn btn-success">
				应用到酒店数据
				</button>
				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script src="${ctx }/js/bootstrap-paginator.min.js"></script>
</html>