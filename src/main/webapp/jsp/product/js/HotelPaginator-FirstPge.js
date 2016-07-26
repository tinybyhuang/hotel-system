$(document)
		.ready(
				function() {
					var msg = "${list}";
					if (msg != null) {
						$("#list").empty();
						$
								.each(eval("(" + msg + ")"),
										function(index, item) { // 遍历json数据
											$("#list")
													.append(
															'<table   class="table  table-striped  table-condensed">');
											$("#list").append('<thead>');
											$("#list").append('<tr>');
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
											$("#list").append('</tr>');
											$("#list").append('</thead>');
											$("#list").append('<tbody>');
											$("#list").append('<tr>');
											$("#list").append(
													'<td>' + item.id + '</td>');
											$("#list").append(
													'<td>' + item.providerId
															+ '</td>');
											$("#list")
													.append(
															'<td>'
																	+ item.providerHotelId
																	+ '</td>');
											$("#list").append(
													'<td>' + item.cityId
															+ '</td>');
											$("#list").append(
													'<td>' + item.hotelName
															+ '</td>');
											$("#list").append(
													'<td>' + item.hotelPhone
															+ '</td>');
											$("#list").append(
													'<td>' + item.hotelAddress
															+ '</td>');
											$("#list").append(
													'<td>' + item.hotelWebsite
															+ '</td>');
											$("#list")
													.append(
															'<td>'
																	+ item.hotelLongitude
																	+ '</td>');
											$("#list").append(
													'<td>' + item.hotelLatitude
															+ '</td>');
											$("#list")
													.append(
															'<td>'
																	+ item.hotelIntroduction
																	+ '</td>');
											$("#list").append(
													'<td>' + item.hotelStar
															+ '</td>');
											$("#list").append(
													'<td>' + item.created
															+ '</td>');
											$("#list").append('</tr>');
											$("#list").append('</tbody>');
											$("#list").append('</table>');
										});
					}
				});