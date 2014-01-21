package com.xfxmcy.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author CY
 * @Date   09-06	
 * @description  the entity for  person to participate  xfxmcy System
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person  implements Serializable  {
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	private String pid;    //person Id  子增长
	private String pname;   //person 姓名
	private String pemail;  //person email
	private Date pbirthday; //person 生日
	private String paccount;//person 账号
	private String ppwd;	//person 密码	
	private String pqq;		//person qq
	private String pmobilephone; //person 手机号  
	
	@Id
	@Column(length = 40)
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Column(length = 10)
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Column(length = 20)
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	@Temporal(TemporalType.DATE)
	public Date getPbirthday() {
		return pbirthday;
	}
	public void setPbirthday(Date pbirthday) {
		this.pbirthday = pbirthday;
	}
	@Column(length = 30 , unique = true ,  nullable =false)
	public String getPaccount() {
		return paccount;
	}
	public void setPaccount(String paccount) {
		this.paccount = paccount;
	}
	@Column(length = 40 , nullable =false)
	public String getPpwd() {
		return ppwd;
	}
	public void setPpwd(String ppwd) {
		this.ppwd = ppwd;
	}
	@Column(length = 15)
	public String getPqq() {
		return pqq;
	}
	public void setPqq(String pqq) {
		this.pqq = pqq;
	}
	@Column(length = 11)
	public String getPmobilephone() {
		return pmobilephone;
	}
	public void setPmobilephone(String pmobilephone) {
		this.pmobilephone = pmobilephone;
	}
	
	
}
