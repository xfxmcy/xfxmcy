package com.xfxmcy.util;

import java.util.List;

/**
 * @author CY
 * @Date   23-07	
 * @description  pojo	for datagrid
 * @version		 0.0.1-SNAPSHOT
 */


public class XfxmcyDataGrid {
	
	private Long total;
	
	private List rows;
	
	public XfxmcyDataGrid() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public XfxmcyDataGrid(Long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	
	
}
