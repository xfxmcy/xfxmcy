package com.xfxmcy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author CY
 * @Date   14-08
 * @description  a document material extends material
 * @version 0.0.1-SNAPSHOT
 */
@Entity
public class DocumentMaterial extends Material {
	public DocumentMaterial() {
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;
	@Column(length = 50)
	private String mfileName;
	
	public String getMfileName() {
		return mfileName;
	}

	public void setMfileName(String mfileName) {
		this.mfileName = mfileName;
	}
	
}
