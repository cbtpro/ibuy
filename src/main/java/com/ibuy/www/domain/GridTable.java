package com.ibuy.www.domain;

import java.util.List;

public class GridTable {

    //共多少页
    private int total;
    //当前第几页
    private int page;
    //共多少条记录
    private long reords;
    //数据列表
    private List<?> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public long getReords() {
		return reords;
	}
	public void setReords(long reords) {
		this.reords = reords;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
