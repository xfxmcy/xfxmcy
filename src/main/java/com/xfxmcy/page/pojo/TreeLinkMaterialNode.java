package com.xfxmcy.page.pojo;

import java.util.Date;
import java.util.Set;

import com.xfxmcy.pojo.Material;

/**
 * @author CY
 * @Date   14-08
 * @description entity to ctrl linkTreeMaterial 
 * @version 0.0.1-SNAPSHOT
 */
public class TreeLinkMaterialNode  extends TreeGridNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TreeLinkMaterialNode() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeLinkMaterialNode(String linkStr, String mdescription,
			String mtitle, Date persistDate) {
		super();
		this.linkStr = linkStr;
		this.mdescription = mdescription;
		this.mtitle = mtitle;
		this.persistDate = persistDate;
	}

	private String linkStr;
	public String getLinkStr() {
		return linkStr;
	}
	public void setLinkStr(String linkStr) {
		this.linkStr = linkStr;
	}
	public String getMdescription() {
		return mdescription;
	}
	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	
	
	public Date getPersistDate() {
		return persistDate;
	}
	public void setPersistDate(Date persistDate) {
		this.persistDate = persistDate;
	}
	private String mdescription;	//说明	
	private String mtitle;			//标题
	private Date persistDate;		//添加时间
	
}
