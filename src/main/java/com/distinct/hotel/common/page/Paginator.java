package com.distinct.hotel.common.page;

/**
 * 分页器，根据pageNo,pageSize,totalRecord用于页面上分页显示多项内容，计算页码和当前页的偏移量，方便页面分页使用.
 * 
 * @author wchuang
 */
public class Paginator implements java.io.Serializable {

	private static final long serialVersionUID = 6089482156906595931L;

	private static final int DEFAULT_SLIDERS_COUNT = 7;

	/**
	 * 分页大小
	 */
	private int pageSize;

	/**
	 * 页数
	 */
	private int pageNo;

	/**
	 * 总记录数
	 */
	private int totalRecord;

	public Paginator(int pageNo, int pageSize, int totalRecord) {
		super();
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.pageNo = computePageNo(pageNo);
	}

	/**
	 * 取得当前页。
	 */
	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 取得总项数。
	 * 
	 * @return 总项数
	 */
	public int getTotalRecords() {
		return totalRecord;
	}

	/**
	 * 是否是首页（第一页），第一页页码为1
	 * 
	 * @return 首页标识
	 */
	public boolean isFirstPage() {
		return pageNo <= 1;
	}

	/**
	 * 是否是最后一页
	 * 
	 * @return 末页标识
	 */
	public boolean isLastPage() {
		return pageNo >= getTotalPages();
	}

	public int getPrePage() {
		if (isHasPrePage()) {
			return pageNo - 1;
		}
		else {
			return pageNo;
		}
	}

	public int getNextPage() {
		if (isHasNextPage()) {
			return pageNo + 1;
		}
		else {
			return pageNo;
		}
	}

	/**
	 * 判断指定页码是否被禁止，也就是说指定页码超出了范围或等于当前页码。
	 * 
	 * @param pageNo
	 *            页码
	 * @return boolean 是否为禁止的页码
	 */
	public boolean isDisabledPage(int pageNo) {
		return ((pageNo < 1) || (pageNo > getTotalPages()) || (pageNo == this.pageNo));
	}

	/**
	 * 是否有上一页
	 * 
	 * @return 上一页标识
	 */
	public boolean isHasPrePage() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 是否有下一页
	 * 
	 * @return 下一页标识
	 */
	public boolean isHasNextPage() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * 开始行，可以用于oracle分页使用 (1-based)。
	 */
	public int getStartRow() {
		if (getPageSize() <= 0 || totalRecord <= 0)
			return 0;
		return pageNo > 0 ? (pageNo - 1) * getPageSize() + 1 : 0;
	}

	/**
	 * 结束行，可以用于oracle分页使用 (1-based)。
	 */
	public int getEndRow() {
		return pageNo > 0 ? Math.min(pageSize * pageNo, getTotalRecords()) : 0;
	}

	/**
	 * offset，计数从0开始，可以用于mysql分页使用(0-based)
	 */
	public int getOffset() {
		return pageNo > 0 ? (pageNo - 1) * getPageSize() : 0;
	}

	/**
	 * 得到 总页数
	 * 
	 * @return
	 */
	public int getTotalPages() {
		if (totalRecord <= 0) {
			return 0;
		}
		if (pageSize <= 0) {
			return 0;
		}

		int count = totalRecord / pageSize;
		if (totalRecord % pageSize > 0) {
			count++;
		}
		return count;
	}

	protected int computePageNo(int pageNo) {
		return computePageNumber(pageNo, pageSize, totalRecord);
	}

	/**
	 * 页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位。
	 * 
	 * @return
	 */
	public Integer[] getSlider() {
		return slider(DEFAULT_SLIDERS_COUNT);
	}

	/**
	 * 页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位。 注意:不可以使用 getSlider(1)方法名称，因为在JSP中会与
	 * getSlider()方法冲突，报exception
	 * 
	 * @return
	 */
	public Integer[] slider(int slidersCount) {
		return generateLinkPageNumbers(getPageNo(), (int) getTotalPages(),
				slidersCount);
	}

	private static int computeLastPageNumber(int totalItems, int pageSize) {
		if (pageSize <= 0)
			return 1;
		int result = (int) (totalItems % pageSize == 0 ? totalItems / pageSize
				: totalItems / pageSize + 1);
		if (result <= 1)
			result = 1;
		return result;
	}

	private static int computePageNumber(int pageNo, int pageSize,
			int totalItems) {
		if (pageNo <= 1) {
			return 1;
		}
		if (Integer.MAX_VALUE == pageNo
				|| pageNo > computeLastPageNumber(totalItems, pageSize)) { // last
																			// page
			return computeLastPageNumber(totalItems, pageSize);
		}
		return pageNo;
	}

	private static Integer[] generateLinkPageNumbers(int currentPageNumber,
			int lastPageNumber, int count) {
		int avg = count / 2;

		int startPageNumber = currentPageNumber - avg;
		if (startPageNumber <= 0) {
			startPageNumber = 1;
		}

		int endPageNumber = startPageNumber + count - 1;
		if (endPageNumber > lastPageNumber) {
			endPageNumber = lastPageNumber;
		}

		if (endPageNumber - startPageNumber < count) {
			startPageNumber = endPageNumber - count;
			if (startPageNumber <= 0) {
				startPageNumber = 1;
			}
		}

		java.util.List<Integer> result = new java.util.ArrayList<Integer>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			result.add(new Integer(i));
		}
		return result.toArray(new Integer[result.size()]);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Paginator");
		sb.append("{pageNo=").append(pageNo);
		sb.append(", pageSize=").append(pageSize);
		sb.append(", totalRecord=").append(totalRecord);
		sb.append('}');
		return sb.toString();
	}
}
