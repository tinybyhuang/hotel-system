$(function() {
	var options = {
		currentPage : 1,// 当前页
		totalPages : "${totalPage}",// 总页数
		numberofPages : 5,// 显示的页数
		itemTexts : function(type, page, current) { // 修改显示文字
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
		onPageClicked : function(event, originalEvent, type, page) { // 异步换页
			$
					.post(
							"showPartOfHotel.do",
							{
								page : page
							},
							function(msg) {
								if (msg != null) {
									var hotels = eval("(" + msg + ")");
									$("#list").empty();
									$
											.each(
													hotels,
													function(index, item) { // 遍历
														$("#list")
																.append(
																		'<table id="data_table"  class="table  table-striped  table-condensed">');
														$("#list").append(
																'<thead>');
														$("#list").append(
																'<tr>');
														$("#list")
																.append(
																		'<th style="width: 2%" >Id</th>');
														$("#list")
																.append(
																		'<th style="width: 9%" >供应商名称</th>');
														$("#list")
																.append(
																		'<th style="width: 3%" >酒店id</th>');
														$("#list")
																.append(
																		'<th style="width: 5%" >城市</th>');
														$("#list")
																.append(
																		'<th style="width: 12%" >酒店名称</th>');
														$("#list")
																.append(
																		'<th style="width: 6%" >酒店电话</th>');
														$("#list")
																.append(
																		'<th style="width: 12%" >酒店地址</th>');
														$("#list")
																.append(
																		'<th style="width: 7%" >酒店主页</th>');
														$("#list")
																.append(
																		'<th style="width: 7%" >酒店经度</th>');
														$("#list")
																.append(
																		'<th style="width: 7%" >酒店纬度</th>');
														$("#list")
																.append(
																		'<th style="width: 7%" >酒店介绍</th>');
														$("#list")
																.append(
																		'<th style="width: 7%" >酒店星级</th>');
														$("#list")
																.append(
																		'<th style="width: 16%" >载入时间</th>');
														$("#list").append(
																'</tr>');
														$("#list").append(
																'</thead>');
														$("#list").append(
																'<tbody>');
														$("#list").append(
																'<tr>');
														$("#list")
																.append(
																		'<td>'
																				+ item.id
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.providerId
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.providerHotelId
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.cityId
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelName
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelPhone
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelAddress
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelWebsite
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelLongitude
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelLatitude
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelIntroduction
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.hotelStar
																				+ '</td>');
														$("#list")
																.append(
																		'<td>'
																				+ item.created
																				+ '</td>');
														$("#list").append(
																'</tr>');
														$("#list").append(
																'</tbody>');
														$("#list").append(
																'</table>');
													});
								}
							});
		}
	};
	$("#paginator").bootstrapPaginator(options);
});