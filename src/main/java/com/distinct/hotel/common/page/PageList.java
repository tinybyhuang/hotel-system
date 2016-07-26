/*
 * Copyright (c) 2014，the original authors or Shenzhen Stock Exchange 
 *
 *      http://www.distinct.com/
 *
 * Statement: This document's code after sufficiently has not permitted does not have 
 * any way dissemination and the change, once discovered violates the stipulation, will
 * receive the criminal sanction.
 * Email: lyhnclg@163.com　
 */

package com.distinct.hotel.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * 包含“分页”信息的List
 * 
 * <p>
 * 要得到总页数请使用 toPaginator().getTotalPages();
 * </p>
 * 
 */
public class PageList<E> extends ArrayList<E> implements Serializable {

	private static final long serialVersionUID = 1412759446332294208L;

	private Paginator paginator;

	public PageList() {
	}

	public PageList(Collection<? extends E> c) {
		super(c);
	}

	public PageList(Collection<? extends E> c, Paginator p) {
		super(c);
		this.paginator = p;
	}

	public PageList(Paginator p) {
		this.paginator = p;
	}

	/**
	 * 得到分页器，通过Paginator可以得到总页数等值
	 * 
	 * @return
	 */
	public Paginator getPaginator() {
		return paginator;
	}

	public void setPage(Paginator paginator) {
		this.paginator = paginator;
	}

}
