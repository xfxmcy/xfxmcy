package com.xfxmcy.page.pojo;

import java.util.Date;

/**
 * @author CY
 * @Date   27-07
 * @description  Floks on pageSearch
 * @version 0.0.1-SNAPSHOT
 */
public class Folks {

	private String classify;
	private String pname;
	private String   prebirthday;
	private String endbirthday;
	
	public Folks() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Folks(String classify, String pname, String prebirthday,
			String endbirthday) {
		super();
		this.classify = classify;
		this.pname = pname;
		this.prebirthday = prebirthday;
		this.endbirthday = endbirthday;
	}



	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrebirthday() {
		return prebirthday;
	}
	public void setPrebirthday(String prebirthday) {
		this.prebirthday = prebirthday;
	}
	public String getEndbirthday() {
		return endbirthday;
	}
	public void setEndbirthday(String endbirthday) {
		this.endbirthday = endbirthday;
	}
	
	
	
}
