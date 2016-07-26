<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common/head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateHotelRemark.do" method="post">
<table class="table table-hover table-bordered">
<thead><tr><th>酒店Id</th><th>酒店</th><th>备注</th><th>操作</th></tr></thead>
<tbody><tr><td>${Hotel.providerHotelId }</td><td>${Hotel.hotelName }</td><td><input type="hidden"
													name="hotelId" value="${Hotel.providerHotelId}"><input type="hidden"
													name="providerId" value="${Hotel.providerId}"><input type="text" name="remark" placeholder=""></td><td><button type="submit" class="btn btn-primary">保&nbsp;存</button></td></tr></tbody>




</table>
</form>
<form action ="filterData.do" method ="get">
<button type="submit" class="btn btn-primary">完&nbsp;成</button></form>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
</html>