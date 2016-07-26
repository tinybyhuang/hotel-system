<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>插件测试</title>
<jsp:include page="/common/head.jsp"></jsp:include>
 <link href="${ctx }/jsp/product/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
	 <div class="container">
		<form action="" class="form-horizontal" role="form">
			<fieldset>
				<legend>Test</legend>
				<div class="form-group">
					<label for="dtp_input1" class="col-md-2 control-label">DateTime
						Picking</label>
					<div class="input-group date form_datetime col-md-5"
						data-date="1979-09-16T05:25:07Z"
						data-date-format="dd MM yyyy - HH:ii p"
						data-link-field="dtp_input1">
						<input class="form-control" size="16" type="text" value=""
							readonly> <span class="input-group-addon"><span
							class="glyphicon glyphicon-remove"></span></span> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-th"></span></span>
					</div>
					<input type="hidden" id="dtp_input1" value="" /><br />
				</div>
				<div class="form-group">
					<label for="dtp_input2" class="col-md-2 control-label">Date
						Picking</label>
					<div class="input-group date form_date col-md-5" data-date="2010-10-10"
						data-date-format="dd MM yyyy" data-link-field="dtp_input2"
						data-link-format="yyyy-mm-dd">
						<input class="form-control" size="16" type="text" value=""
							readonly> <span class="input-group-addon"><span
							class="glyphicon glyphicon-remove"></span></span> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-th"></span></span>
					</div>
					<input type="hidden" id="dtp_input2" value="" /><br />
				</div>
				<div class="form-group">
					<label for="dtp_input3" class="col-md-2 control-label">Time
						Picking</label>
					<div class="input-group date form_time col-md-5" data-date="2010-10-10"
						data-date-format="dd MM yyyy - HH:mm:ss" data-link-field="dtp_input3"
						data-link-format="dd MM yyyy - HH:mm:ss">
						<input class="form-control" size="16" type="text" value=""
							readonly> <span class="input-group-addon"><span
							class="glyphicon glyphicon-remove"></span></span> <span
							class="input-group-addon"><span
							class="glyphicon glyphicon-time"></span></span>
					</div>
					<input type="hidden" id="dtp_input3" value="" /><br />
				</div>
			</fieldset>
		</form>
	</div> 

<!-- 	<div id="datetimepicker"></div> -->



</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script type="text/javascript"
	src="${ctx }/jsp/product/js/bootstrap-datetimepicker.min.js"></script>
<%-- <script type="text/javascript"
	src="${ctx }/jsp/product/js/bootstrap-datetimepicker.fr.js"></script> --%>
<script type="text/javascript">
	$('#datetimepicker').datetimepicker();

	$('.form_datetime').datetimepicker({
		// language:  'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1
	});
	$('.form_date').datetimepicker({
		language : 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
	$('.form_time').datetimepicker({
		language : 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 1,
		minView : 0,
		maxView : 1,
		forceParse : 0
	});
</script>


</html>