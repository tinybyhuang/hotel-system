<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap.css" rel="stylesheet"> 
<title>房价表</title>
</head>
<body>

	<!--  该酒店一周内的所有房型房价      
                                该酒店每一个单独的房型的房价 -->
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
				<c:forEach items="${rooms}" var="item">
					<tr>
					 	<td>${item.salePrice}</td>
						<td>${item.saleDate}</td>
						 <td>${item.roomName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div id="content">
	
	
	
	</div>
	


<div class="container">
<h2>Example of creating Modals with Twitter Bootstrap</h2>
<div id="example" class="modal hide fade in" style="display: none; ">
<div class="modal-header">
<a class="close" data-dismiss="modal">×</a>
<h3>This is a Modal Heading</h3>
</div>
<div class="modal-body">
<h4>Text in a modal</h4>
<p>You can add some text here.</p>		        
</div>
<div class="modal-footer">
<a href="#" class="btn btn-success">Call to action</a>
<a href="#" class="btn" data-dismiss="modal">Close</a>
</div>
</div>
<p><a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Launch demo modal</a></p>
</div>





</body>
<jsp:include page="/common/footer.jsp"></jsp:include>
<script type="text/javascript" src="${ctx }/jsp/product/js/bootstrap-modal.js"></script>
<script type="text/javascript" src="${ctx }/jsp/product/js/template.js"></script>
<script id="test" type="text/html">
<h1>{{title}}</h1>
<ul>
    {{each list as value i}}
        <li>索引 {{i + 1}} ：{{value}}</li>
    {{/each}}
</ul>
</script>
<script type="text/javascript">
var data = {
	    title: '酒店价格表',
	    list: ['文艺', '博客', '摄影', '电影', '民谣', '旅行', '吉他']
	};
	var html = template('test', data);
	document.getElementById("content").innerHTML = html;

</script>
</html>