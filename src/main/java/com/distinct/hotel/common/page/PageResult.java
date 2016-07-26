package com.distinct.hotel.common.page;
import java.io.Serializable;
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
public class PageResult<E> implements Serializable {

	private static final long serialVersionUID = 1L;

	private PageList<E> pageList;


	public PageResult(PageList<E> pageList) {
		this.pageList = pageList;
	}

	public int getTotalRecords() {
		return pageList.getPaginator().getTotalRecords();

	}

	public int getTotalPages() {
		return pageList.getPaginator().getTotalPages();

	}

	public int getPageNo() {
		return pageList.getPaginator().getPageNo();

	}

	public int getPageSize() {
		return pageList.getPaginator().getPageSize();

	}

	public int getStartRow() {
		return pageList.getPaginator().getStartRow();

	}

	public int getEndRow() {
		return pageList.getPaginator().getEndRow();

	}

	public int getOffset() {
		return pageList.getPaginator().getOffset();

	}

	public int getPrePage() {
		return pageList.getPaginator().getPrePage();

	}

	public int getNextPage() {
		return pageList.getPaginator().getNextPage();

	}

	public boolean isFirstPage() {
		return pageList.getPaginator().isFirstPage();

	}

	public boolean isHasNextPage() {
		return pageList.getPaginator().isHasNextPage();

	}

	public boolean isHasPrePage() {
		return pageList.getPaginator().isHasPrePage();

	}

	public boolean isLastPage() {
		return pageList.getPaginator().isLastPage();

	}

	public Integer[] getSlider() {
		return pageList.getPaginator().getSlider();

	}

	@SuppressWarnings("rawtypes")
	public Collection getResults() {
		return this.pageList;
	}

}
