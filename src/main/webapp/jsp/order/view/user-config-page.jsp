<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户配置demo</title>
<jsp:include page="/common/head.jsp"></jsp:include>
</head>
<body>
	<form>
		<div class="col-sm-12">
			<div class="col-sm-12">
				<label for="configType" class="control-label col-sm-4">配置类型</label>
				<div class="col-sm-8">
					<select class="form-control" name="configType" id="configType">
						<option value="">选择配置类型</option>
						<option value="1">平台</option>
						<option value="2">供应商</option>
					</select>
				</div>
			</div>
			<div class="col-sm-12">
				<label  for="configID"  class="control-label col-sm-4">配置选择</label>
				<div class="col-sm-8">
					<select class="form-control" id="configId" name="configId">
						<option    value="请选择配置类型" id="defaultConfigId">请选择配置类型</option>
						<optgroup id="marketGroup">
							<option value="1">携程</option>
							<option value="2">去哪儿</option>
							<option value="3">淘宝</option>
						</optgroup>
						<optgroup id="providerGroup">
						    <option value="1">捷旅</option>
							<option value="2">龙腾</option>
						</optgroup>
					</select>
				</div>
			</div>
		</div>
	</form>
</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	
	if($("#configType").val()==""||$("#configType").val()==null){
		 document.getElementById("configId").setAttribute("disabled","disabled" ); 
		/* 选择固定对象 */
		 document.getElementById("defaultConfigId").setAttribute("selected","selected" );
	}
})
	$("#configType").change(function() {
			 if($("#configType").val()==""){
				 document.getElementById("configId").setAttribute("disabled","disabled" ); 
				 document.getElementById("defaultConfigId").setAttribute("selected","selected" );
				 document.getElementById("defaultConfigId").removeAttribute("hidden");
				 document.getElementById("marketGroup") .setAttribute("hidden", "hidden");
				 document.getElementById("providerGroup") .setAttribute("hidden", "hidden");
			 }
		else if ($("#configType").val() == 1) {
			/* show marketDeatil */
			     document.getElementById("configId").removeAttribute("disabled");
				 document.getElementById("defaultConfigId").removeAttribute("selected");
				 document.getElementById("defaultConfigId").setAttribute("hidden", "hidden");
				 document.getElementById("marketGroup").removeAttribute("hidden");
				 document.getElementById("providerGroup") .setAttribute("hidden", "hidden");
		} else if ($("#configType").val() == 2) {
				/* show providerDeatil */
				 document.getElementById("configId").removeAttribute("disabled");
				 document.getElementById("defaultConfigId").removeAttribute("selected");
				 document.getElementById("defaultConfigId").setAttribute("hidden", "hidden");
				 document.getElementById("providerGroup").removeAttribute("hidden");
				 document.getElementById("marketGroup") .setAttribute("hidden", "hidden");	
		}
		});
</script>
</html>