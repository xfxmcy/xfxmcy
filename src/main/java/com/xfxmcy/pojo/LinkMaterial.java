package com.xfxmcy.pojo;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author CY
 * @Date   14-08
 * @description  a link material extends material
 * @version 0.0.1-SNAPSHOT
 */
@Entity
public class LinkMaterial extends Material {
	
	
	public LinkMaterial(String parentId) {
		super.setMid(parentId);
	}
	public LinkMaterial() {
		// TODO Auto-generated constructor stub
	}
	public String getLinkStr() {
		return linkStr;
	}
	public void setLinkStr(String linkStr) {
		this.linkStr = linkStr;
	}
	private static final long serialVersionUID = 1L;
	private String linkStr;
	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this,ToStringStyle.SIMPLE_STYLE);
	}
}
