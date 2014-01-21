package com.xfxmcy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author CY
 * @Date   14-08
 * @description  a note material extends material
 * @version 0.0.1-SNAPSHOT
 */
@Entity
public class NoteMaterial extends Material {
	
	private static final long serialVersionUID = 1L;
	@Column(columnDefinition = "TEXT")
	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	private String mcontent;
}
