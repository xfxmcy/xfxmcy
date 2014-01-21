package com.xfxmcy.page.pojo;

import java.util.List;
import java.util.Map;



/**
 * @author CY
 * @Date   26-08
 * @description  entity for ctrl treeGrid
 * @version 0.0.1-SNAPSHOT
 */
public class TreeGridNode implements java.io.Serializable {
	public TreeGridNode() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String parentId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String _parentId) {
		this.parentId = _parentId;
	}
	
	
}
