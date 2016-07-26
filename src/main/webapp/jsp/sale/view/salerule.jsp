<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="${ctx}/css/default.css" type="text/css">
<title>销售规则设置页面</title>
</head>
<body>
<div class="container-fluid">
<form class="form-horizontal" method ="post" action="insertSaleRule.do" style="width: 50%; margin: 0 auto;" >
<div class="form-group">
			<label for="marketId" class="col-sm-4 control-label">请输入平台id</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="marketId"
						name="marketId" placeholder="平台id">	
				</div>
				</div>
				<div class="form-group">
			<label for="status" class="col-sm-4 control-label">请选择当前状态</label>
				<div class="col-sm-8">
				<div class="radio">
  <label>
    <input type="radio" name="status" id="status" value="关店" checked>
 关店
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="status" id="status" value=" 开店">
  开店
  </label>
</div>
</form>
<div class="col-sm-offset-5 col-sm-7">
				<button type="submit" class="btn btn-primary" style="width: 80px;">保&nbsp;存</button> 
</div>







</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
</html>