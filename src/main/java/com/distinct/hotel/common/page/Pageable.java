package com.distinct.hotel.common.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wchuang
 *
 */
public class Pageable {

	/**
	 * 分页大小
	 */
	private int pageNo = 1;
	private int pageSize = 20;
	private String sort;

	private Map<String, String> orderExprs = new HashMap<String, String>();

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void addOrderExpr(String property, String expr) {
		this.orderExprs.put(property, expr);
	}

	public PageBounds toPageBounds() {
		List<Order> orders = Order.formString(sort);
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			if (orderExprs.get(order.getProperty()) != null) {
				orders.set(i,
						new Order(order.getProperty(), order.getDirection(),
								orderExprs.get(order.getProperty())));
			}
		}
		return new PageBounds(pageNo, pageSize, orders);
	}

}
