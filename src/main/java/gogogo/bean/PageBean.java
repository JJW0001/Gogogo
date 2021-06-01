package gogogo.bean;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
public class PageBean {
	/**
	 * 当前页数
	 */
	private long curPage;
	/**
	 * //总页数
	 */
	private long totalPages;
	/**
	 * //总行数
	 */
	private long totalRows;
	/**
	 * //每页显示行数
	 */
	private long pageSize;
	/**
	 * //每页显示的数据
	 */
	private List<Map<String, Object>> data;


	public long getCurPage() {
		// 当前行数大于总数
		if (curPage > getTotalPages()) {
			curPage = getTotalPages();
		}
		//当前行数小于1
		else if(curPage<1){
			curPage=1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}

	public long getTotalPages() {
		if(totalRows%pageSize==0){
			totalPages=totalRows/pageSize;
		}else{
			totalPages=totalRows/pageSize+1;
		}
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data=data;
	}
}
